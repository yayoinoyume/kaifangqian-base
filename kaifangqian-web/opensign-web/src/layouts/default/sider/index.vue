<!--
  @description 资助审批电子签章系统
-->

<template>
  <Drawer
    v-if="getIsMobile"
    placement="left"
    :class="prefixCls"
    :width="getMenuWidth"
    :getContainer="null"
    :visible="!getCollapsed"
    @close="handleClose"
  >
    <Sider />
  </Drawer>
  <MixSider v-else-if="getIsMixSidebar" />
  <AppSider />
  <!-- <Sider v-else /> -->
</template>
<script lang="ts">
  import { defineComponent, computed } from 'vue';

  import Sider from './LayoutSider.vue';
  import AppSider from './AppSider.vue';
  import MixSider from './MixSider.vue';
  import { Drawer } from 'ant-design-vue';

  import { useAppInject } from '/@/hooks/web/useAppInject';
  import { useMenuSetting } from '/@/hooks/setting/useMenuSetting';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { useAppStore } from '/@/store/modules/app';

  export default defineComponent({
    name: 'SiderWrapper',
    components: { Sider, Drawer, MixSider, AppSider },
    setup() {
      const { prefixCls } = useDesign('layout-sider-wrapper');
      const { getIsMobile } = useAppInject();
      const appStore = useAppStore();
      const { setMenuSetting, getCollapsed, getMenuWidth, getIsMixSidebar } = useMenuSetting();
      const isAppSidebar = computed(() => appStore.getMenuSetting.collapsed);
      // console.log(getIsMixSidebar, getIsMobile, isAppSidebar, '侧边菜单---');
      function handleClose() {
        setMenuSetting({
          collapsed: true,
        });
      }
      return {
        prefixCls,
        getIsMobile,
        getCollapsed,
        isAppSidebar,
        handleClose,
        getMenuWidth,
        getIsMixSidebar,
      };
    },
  });
</script>
<style lang="less">
  @prefix-cls: ~'@{namespace}-layout-sider-wrapper';

  .@{prefix-cls} {
    .ant-drawer-body {
      height: 100vh;
      padding: 0;
    }

    .ant-drawer-header-no-title {
      display: none;
    }
  }
</style>
