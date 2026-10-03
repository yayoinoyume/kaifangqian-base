<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :class="prefixCls">
      <a-button type="primary" @click="handleCreate"> 新增 </a-button>
     
  </div>
</template>
<script lang='ts'>
import { defineComponent } from 'vue'
import { useDesign } from '/@/hooks/web/useDesign';
export default defineComponent({
  name: 'TableBtn',
  setup() {
      const { prefixCls } = useDesign('basic-table-btn');

      function handleCreate(){

      };


      return { prefixCls ,handleCreate};
    },
})
</script>
<style lang="less" scoped>
 
</style>
