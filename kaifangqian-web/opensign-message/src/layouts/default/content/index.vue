<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :class="[prefixCls, getLayoutContentMode, getMenuClass()]" v-loading="getOpenPageLoading && getPageLoading">
    <PageLayout />
  </div>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';
  import PageLayout from '/@/layouts/page/index.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { useRootSetting } from '/@/hooks/setting/useRootSetting';
  import { useTransitionSetting } from '/@/hooks/setting/useTransitionSetting';
  import { useContentViewHeight } from './useContentViewHeight';
  import { useMenuSetting } from '/@/hooks/setting/useMenuSetting';
  import { useHeaderSetting } from '/@/hooks/setting/useHeaderSetting';

  export default defineComponent({
    name: 'LayoutContent',
    components: { PageLayout },
    setup() {
      const { prefixCls } = useDesign('layout-content');
      const { getOpenPageLoading } = useTransitionSetting();
      const { getShowSidebar } = useMenuSetting();
      const { getShowFullHeaderRef } = useHeaderSetting();
      const { getLayoutContentMode, getPageLoading } = useRootSetting();
      useContentViewHeight();
      function getMenuClass(){
        let result = "";
        if(!getShowSidebar.value){
          if(!getShowFullHeaderRef.value){
            result = "menu-top0";
          }else{
            result= "no-menu-tab";
          }
        }
        return result;
      }
      
      return {
        prefixCls,
        getOpenPageLoading,
        getLayoutContentMode,
        getPageLoading,
        getShowSidebar,
        getShowFullHeaderRef,getMenuClass
      };
    },
  });
</script>
<style lang="less">
  @prefix-cls: ~'@{namespace}-layout-content';

  .@{prefix-cls} {
    position: relative;
    flex: 1 1 auto;
    min-height: 0;
    padding:24px;
    margin-top:@multiple-height;

    &.fixed {
      width: 1200px;
      margin: 0 auto;
    }

    &-loading {
      position: absolute;
      top: 200px;
      z-index: @page-loading-z-index;
    }
    &.no-menu-tab{
      margin-top:@header-height;
    }
    &.menu-top0{
      margin-top:0;
    }
  }
</style>
