<!--
  @description 资助审批电子签章系统
-->

<template>
  <span :class="[getfooterClass,getCollapsed?'unfold':'fold']" @click="toggleCollapsed">
    <MenuUnfoldOutlined v-if="getCollapsed" /> <MenuFoldOutlined v-else />
  </span>
</template>
<script lang="ts">
  import { defineComponent ,computed} from 'vue';
  import { MenuUnfoldOutlined, MenuFoldOutlined } from '@ant-design/icons-vue';
  import { useMenuSetting } from '/@/hooks/setting/useMenuSetting';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { propTypes } from '/@/utils/propTypes';

  export default defineComponent({
    name: 'HeaderTrigger',
    components: { MenuUnfoldOutlined, MenuFoldOutlined },
    props: {
      theme: propTypes.oneOf(['light', 'dark']),
    },
    setup(props) {
      const { getCollapsed, toggleCollapsed } = useMenuSetting();
      const { prefixCls } = useDesign('layout-menu-footer-trigger');
      // const collapsedClass =  getCollapsed?'unfold':'fold' 
      let getfooterClass = computed(() => [
          prefixCls,
          props.theme,
        ]);
      return { getCollapsed, toggleCollapsed, prefixCls,getfooterClass };
    },
  });
</script>
<style lang="less">
@prefix-cls: ~'@{namespace}-layout-menu-footer-trigger';

 .@{prefix-cls}{
    position: absolute;
    bottom: 0px;
    // width: 100%;
    height: 32px;
    cursor: pointer;
    padding-left: 16px;
    display: flex;
    align-items: center;
    & svg{
      font-size:20px;
    }
    &.light{
      color: #262626;
      // background: #ffffff;
      // border-top: 1px solid #e4e4e4;
        & .anticon {
          background: rgba(243, 243, 243, 1);
          padding:6px;
          border-radius: 2px;
        }
    }
    &.dark{
      color: #fff;
       & .anticon {
          background: rgba(75, 75, 75, 1);
          padding:6px;
          border-radius: 2px;
        }
    }
    &.unfold{
      padding-left: 8px;
      // justify-content: center;
    }
    &.fold{
      justify-content: normal;
      background: #f4f4f4;
      width: 100%;
      padding: 0px 16px;
      border-top: 1px solid #eee;
      height: 45px;
      z-index: 99;
    }
}

</style>
