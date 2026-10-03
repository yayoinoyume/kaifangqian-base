/*
 * @description 资助审批电子签章系统
 */

import { watch, unref } from 'vue';
import { useI18n } from '/@/hooks/web/useI18n';
import { useTitle as usePageTitle } from '@vueuse/core';
import { useGlobSetting } from '/@/hooks/setting';
import { useRouter } from 'vue-router';
import { useLocaleStore } from '/@/store/modules/locale';

import { REDIRECT_NAME } from '/@/router/constant';

import { getWebTitle } from '/@/api/sys/user';


/**
 * Listening to page changes and dynamically changing site titles
 */
export function useTitle() {
  let { title } = useGlobSetting();
  const { t } = useI18n();
  const { currentRoute } = useRouter();
  const localeStore = useLocaleStore();

  const pageTitle = usePageTitle();

  getWebTitle({}).then(res => {
    if (res) {
        title = res
      }
  })

  watch(
    [() => currentRoute.value.path, () => localeStore.getLocale],
    () => {
      const route = unref(currentRoute);

      if (route.name === REDIRECT_NAME) {
        return;
      }

      const tTitle = t(route?.meta?.title as string);
      pageTitle.value = tTitle ? ` ${tTitle} - ${title} ` : `${title}`;
    },
    { immediate: true },
  );
}
