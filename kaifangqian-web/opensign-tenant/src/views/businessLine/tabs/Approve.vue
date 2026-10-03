<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container">
    审批设置
  </div>
</template>

<script lang="ts">
import {ref, defineComponent, computed} from "vue"
export default defineComponent({
  name:"Approve",
  props:{
    lineFormData:{
      type:Object
    }
  },
  setup(props,) {
    const approveForm = computed(()=>props.lineFormData);

    
    function getFormData(){
      return approveForm.value
    }
    return {
      getFormData  
    }
  }
})
</script>

<style lang="less" scoped>
</style>
