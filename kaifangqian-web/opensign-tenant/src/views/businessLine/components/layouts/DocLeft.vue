<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="doc-layout-side-container">
    <p class="layout-side-title">
     <span> {{ title }} </span>
     <a-tooltip>
      <template #title>通过拖拽每个签署方对应的控件到正文区域，即可为其设定专属签署位置。</template>
      <Icon icon="ant-design:question-circle-outlined" style="margin-left:10px;"/>
     </a-tooltip>
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
