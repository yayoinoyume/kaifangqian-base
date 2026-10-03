<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="mico-container">
    这是企业管理后台公共表单组件
    <!-- <component :is="Auth"></component> -->
    <Auth />
  </div>
</template>

<script lang="ts">
import {ref,defineComponent, defineAsyncComponent} from "vue";
import Auth from '/@/views/auth/authPloy.vue'

// const Auth = defineAsyncComponent(() =>
//   import('/@/views/auth/authPloy.vue')
// )
export default defineComponent({
  name:"App",
  components:{
    Auth
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
</style>
