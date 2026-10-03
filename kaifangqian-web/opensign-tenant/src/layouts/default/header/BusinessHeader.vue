<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="business-header-container" :class="`${prefixCls}`">
    <div :class="`${prefixCls}-back`">
      <Icon icon="ant-design:left-outlined"/>
      <span>返回</span>
    </div>
    <div :class="`${prefixCls}-title`">{{  getBusinessTitle}}</div>
    <div :class="`${prefixCls}-actions`">
      <a-button type="primary">保存</a-button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useHeaderSetting } from '/@/hooks/setting/useHeaderSetting';
import { useDesign } from '/@/hooks/web/useDesign';
// import { useAppStore } from '/@/store/modules/app';
import { Icon } from '/@/components/Icon';
export default defineComponent({
  name:"BusinessHeader",
  components:{
    Icon
  },
  setup() {
    const { prefixCls } = useDesign('layout-business-header');
    const { getBusinessTitle } = useHeaderSetting();
    console.log(getBusinessTitle)


    return {
      prefixCls,
      getBusinessTitle
    }
  }
})
</script>

<style lang="less" scoped>
 @prefix-cls: ~'@{namespace}-layout-business-header';

 .@{prefix-cls}{
  display: flex;
  align-items: center;
  justify-content: space-between;
  height:62px;
  border-bottom:1px solid #f0f0f0;
  padding:0 20px;
  position: fixed;
  width: 100%;
  background: #fff;
  z-index: 999;
  &-back{
    display: flex;
    align-items: center;
    cursor: pointer;
  }
  &-title{
    font-size: 18px;
    font-weight: 600;
  }
 }



</style>
