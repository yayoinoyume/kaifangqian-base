<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="bpms-container">
    <div id="bpms-paas"></div>
    <micro-app name='app-bpms' url='http://localhost:8904/' baseroute='/app-bpms' keep-alive :data='microAppData'  @datachange='handleDataChange' @mounted='mounted' @created="created"></micro-app>
  </div>
</template>

<script lang="ts">
  import { defineComponent,ref,unref,computed,reactive } from 'vue'
  import microApp from '@micro-zoe/micro-app';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { getToken } from '/@/utils/auth';
  import { useUserStore } from '/@/store/modules/user';



export default defineComponent({
  name:"MicroBpms",
  setup(_, ){
     
      const { createMessage: msg } = useMessage();
      const userStore = useUserStore();
      const microAppData = reactive({data:{
          token:getToken()
        }});

      function handleDataChange (e) {
      console.log('来自子应用的数据：', e.detail.data)
      }
      function mounted(){
        // microApp.setData('app-boot', { token: '/bpmns/application/ini' })
        const permissionInfo = userStore.getPermissionInfo;
        console.log(permissionInfo,'路由信息micro')
        microApp.setData('app-bpms', {permission: permissionInfo})
    
      }
      function created(){
        console.log('开始发送token')
        const token = getToken();
        microApp.setData('app-bpms', {token });
        msg.success('发送成功');
      }
   
      return { 
          handleDataChange,
          mounted,
          microAppData,
          created
      
      };
    }
})
</script>

<style lang="less" scoped>
</style>
