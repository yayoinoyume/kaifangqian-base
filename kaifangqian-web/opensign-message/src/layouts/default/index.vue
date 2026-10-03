<!--
  @description 资助审批电子签章系统
-->

<template>
  <Layout :class="prefixCls">
    <LayoutHeader headerName="消息中心"></LayoutHeader>
    <LayoutContent />    
  </Layout>
</template>

<script lang="ts">
  import { defineComponent} from 'vue';
  import { Layout } from 'ant-design-vue';
  import LayoutContent from './content/index.vue';
  import LayoutHeader  from '../header/index.vue'

  import { useDesign } from '/@/hooks/web/useDesign';

  export default defineComponent({
    name: 'DefaultLayout',
    components: {
      LayoutContent,
      Layout,
      LayoutHeader
    },
    setup() {
      const { prefixCls } = useDesign('default-layout');      
      return {
        prefixCls,
     
      };
    },
  });
</script>
<style lang="less">
  @prefix-cls: ~'@{namespace}-default-layout';

  .@{prefix-cls} {
    display: flex;
    width: 100%;
    min-height: 100%;
    background-color: @content-bg;
    flex-direction: column;
    height:100%!important;

    > .ant-layout {
      min-height: 100%;
    }

    &-main {
      width: 100%;
      // margin-left: 1px;
      background-color: @content-bg;
    }
  }
</style>
