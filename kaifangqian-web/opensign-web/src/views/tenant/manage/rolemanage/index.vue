<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="role-managge">
    <Role />
  </div>
</template>

<script lang="ts">
import {reactive} from "vue";
import Role from '/@/views/tenant/organize/Role.vue'
export default{
  name:"RoleManage",
  components:{
    Role
  },
  setup() {
   const data = reactive({

   })
  
    return {
    }
  }
}
</script>

<style lang="less" scoped>

</style>
