<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="doc-layout-side-container">
    <p class="layout-side-title">{{ title }}</p>
    <Scrollbar width="100%" height="100%" >
      <div class="side-right-content">
        <slot></slot>
      </div>
    </Scrollbar>
  </div> 
</template>

<script lang="ts">
import {ref,defineComponent} from "vue";
import { Scrollbar } from '/@/components/Scrollbar';
export default defineComponent({
  name:"DocRight",
  components:{
    Scrollbar
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
  width:380px;
  border-left:1px solid #eee;
  min-height:calc(100vh - 63px);
  padding:20px 25px;

}
</style>
