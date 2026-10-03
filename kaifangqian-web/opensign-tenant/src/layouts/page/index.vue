<!--
  @description 资助审批电子签章系统
-->

<template>
    <div>
    <RouterView>
        <template #default="{ Component, route }">
          <transition
            :name="
              getTransitionName({
                route,
                openCache,
                enableTransition: getEnableTransition,
                cacheTabs: getCaches,
                def: getBasicTransition,
              })
            "
            mode="out-in"
            appear
          >
            <keep-alive v-if="openCache" :include="getCaches">

              <div>
                <component :is="Component" :key="route.fullPath" >
                </component>
              </div>
             
            </keep-alive>
            <component v-else :is="Component" :key="route.fullPath" />
          </transition>
        </template>
    </RouterView>
</div>
</template>

<script lang="ts">
  import { computed, defineComponent, unref } from 'vue';


  import { useRootSetting } from '/@/hooks/setting/useRootSetting';

  import { useTransitionSetting } from '/@/hooks/setting/useTransitionSetting';
  import { useMultipleTabSetting } from '/@/hooks/setting/useMultipleTabSetting';
  import { getTransitionName } from './transition';

  import { useMultipleTabStore } from '/@/store/modules/multipleTab';
  import { basicKeepAlive } from '/@/components/KeepAlive/index'

  export default defineComponent({
    name: 'PageLayout',
    components: { basicKeepAlive },
    setup() {
      const { getShowMultipleTab } = useMultipleTabSetting();
      const tabStore = useMultipleTabStore();

      const { getOpenKeepAlive, getCanEmbedIFramePage } = useRootSetting();

      const { getBasicTransition, getEnableTransition } = useTransitionSetting();

      const openCache = computed(() => unref(getOpenKeepAlive) && unref(getShowMultipleTab));

      const getCaches = computed((): string[] => {
        if (!unref(getOpenKeepAlive)) {
          return [];
        }
        return tabStore.getCachedTabList;
      });

      return {
        getTransitionName,
        openCache,
        getEnableTransition,
        getBasicTransition,
        getCaches,
        getCanEmbedIFramePage,
      };
    },
  });
</script>
