<!--
  @description 资助审批电子签章系统
-->

<script lang="ts">
  import { defineComponent, toRefs, ref, unref } from 'vue';
  import { createAppProviderContext } from './useAppContext';
  import { createBreakpointListen } from '/@/hooks/event/useBreakpoint';
  import { prefixCls } from '/@/settings/designSetting';
  import { useAppStore } from '/@/store/modules/app';
  import { MenuModeEnum, MenuTypeEnum } from '/@/enums/menuEnum';
  import {isMobileAgent} from '/@/utils';

  const props = {
    /**
     * class style prefix
     */
    prefixCls: { type: String, default: prefixCls },
  };

  export default defineComponent({
    name: 'AppProvider',
    inheritAttrs: false,
    props,
    setup(props, { slots }) {
      const isMobile = ref(false);
      const isSetState = ref(false);

      const appStore = useAppStore();
 
      // Monitor screen breakpoint information changes
      createBreakpointListen(() => {
      // createBreakpointListen(({ screenMap, sizeEnum, width }) => {
        // const lgWidth = screenMap.get(sizeEnum.LG);
        // if (lgWidth) {
        //   isMobile.value = width.value - 1 < lgWidth;
        // }
        isMobile.value =  isMobileAgent();
        handleRestoreState();
      });

      const { prefixCls } = toRefs(props);

      // Inject variables into the global
      createAppProviderContext({ prefixCls, isMobile });

      /**
       * Used to maintain the state before the window changes
       */
      function handleRestoreState() {
        if (unref(isMobile)) {
          if (!unref(isSetState)) {
            isSetState.value = true;
            const {
              menuSetting: {
                type: menuType,
                mode: menuMode,
                collapsed: menuCollapsed,
                split: menuSplit,
              },
            } = appStore.getProjectConfig;
            appStore.setProjectConfig({
              menuSetting: {
                type: MenuTypeEnum.MIX_SIDEBAR,
                mode: MenuModeEnum.INLINE,
                split: false,
              },
            });
            appStore.setBeforeMiniInfo({ menuMode, menuCollapsed, menuType, menuSplit });
          }
        } else {
          if (unref(isSetState)) {
            isSetState.value = false;
            // const { menuMode, menuCollapsed, menuType, menuSplit } = appStore.getBeforeMiniInfo;
            const {
              menuSetting: {
                type: menuType,
                mode: menuMode,
                collapsed: menuCollapsed,
                split: menuSplit,
              },
            } = appStore.getProjectConfig;
            console.log("menuType",menuType);
            appStore.setProjectConfig({
              menuSetting: {
                type: menuType,
                mode: menuMode,
                collapsed: menuCollapsed,
                split: menuSplit,
              },
            });
          } else {
            isSetState.value = true;
            appStore.setProjectConfig({
              menuSetting: {
                type: MenuTypeEnum.TOP_MENU,
                mode: MenuModeEnum.HORIZONTAL,
                collapsed: false,
                split: true,
              },
            });
          }
        }
        console.log("isMobile",isMobile.value);
      }
      return () => slots.default?.();
    },
  });
</script>
