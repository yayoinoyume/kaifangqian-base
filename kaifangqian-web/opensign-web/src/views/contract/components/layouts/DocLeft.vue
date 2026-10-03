<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="doc-layout-side-container">
    <p class="layout-side-title">
      <span> {{ title }} </span>
      <slot name="icon"></slot>
    </p>
    <Scrollbar width="100%" height="100%" >
      <div class="side-left-content">
      <slot></slot>
      </div>
    </Scrollbar>
  </div> 
</template>

<script lang="ts">
import {ref,defineComponent} from "vue";
import { Scrollbar } from '/@/components/Scrollbar';
import { Icon } from '/@/components/Icon';
export default defineComponent({
  name:"DocLeft",
  components:{
    Scrollbar,
    Icon
  },
  props:{
    title:{
      type:String,
    },
    tip:{
      type:String,
      default:"可指定各个签署方在文件上签署的位置,拖拽签署方下面对应的签署控件到文档正文区域"
    }
  },
  setup() {
    const data = ref('') 
    return {
         data  
    }
  }
})
</script>

<style lang="less" scoped>
.doc-layout-side-container{
  width:350px;
  min-height:calc(100vh - 63px);
  border-right: 1px solid #eee;
  padding:20px 25px 40px 25px;
  position: relative;
}
</style>
