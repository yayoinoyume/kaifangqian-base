<!--
  @description 资助审批电子签章系统
-->

/*
 * @Author: ningw 
 * @Date: 2022-06-28 18:22:10 
 * @Last Modified by: ningw
 * @Last Modified time: 2024-03-02 00:01:53
 */
<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="账号身份切换" @ok="handleSubmit" wrapClassName="change-account-modal" :closable="false">
      <div class="change-account-tip"> 
        <!-- <SvgIcon name="change-account" size="80" color="#8f8989"/> -->
       <p>检测到您已在其他页面中切换了账号身份，是否使用新身份办理业务</p>
      </div>
   
       <template #footer> 
          <a-button type="default" @click="handleTokenSwitch(true)">切换新身份</a-button>
          <a-button type="primary" @click="handleTokenSwitch(false)">保持当前身份</a-button>

       </template>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent, onMounted, onUnmounted } from 'vue'
import { BasicModal,useModal } from '/@/components/Modal';
import { Icon, SvgIcon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';
import { getToken } from '/@/utils/auth'; 
import { checkToken } from '/@/api/sys/user';
import { useRoute } from "vue-router";
import { isDevMode } from '/@/utils/env';

import { createLocalStorage } from '/@/utils/cache';
import {
  APP_LOCAL_CACHE_KEY,
} from '/@/enums/cacheEnum';

export default defineComponent({
  name: 'LoginSelectAccount',
  components:{
    BasicModal,
    // BasicForm,
    Icon,
    SvgIcon
  },
  setup(_,{emit}){

      const userStore = useUserStore();
      const ls = createLocalStorage();
      const localCache = ls.get(APP_LOCAL_CACHE_KEY);
      const [registerModal, { openModal,closeModal }] = useModal();
      const route = useRoute();
      console.log(localCache,'localCache---')

      onMounted(()=>{
        console.log('tab切换组件加载了')
        document.addEventListener("visibilitychange", function() {
          if (document.visibilityState === 'visible') {
            const localToken = isDevMode()?(localStorage.getItem('VUE_OPENSIGN_ADMIN__DEVELOPMENT__2.8.0__COMMON__LOCAL__KEY__')? 
              JSON.parse(localStorage.getItem('VUE_OPENSIGN_ADMIN__DEVELOPMENT__2.8.0__COMMON__LOCAL__KEY__') as string ).value.TOKEN__.value:''):
              localStorage.getItem('VUE_OPENSIGN_ADMIN__PRODUCTION__2.8.0__COMMON__LOCAL__KEY__')? 
              JSON.parse(localStorage.getItem('VUE_OPENSIGN_ADMIN__PRODUCTION__2.8.0__COMMON__LOCAL__KEY__') as string ).value.TOKEN__.value:'';
            const pageToken = userStore.getPageToken;
            console.log(localToken,'两个token',pageToken)
            // if(localToken !== pageToken){
            //   checkTenantInfoByToken(pageToken, localToken);
            // }else{
            //   checkTenantInfoByToken(pageToken, localToken);
            // }
            checkTenantInfoByToken(pageToken, localToken);
            // 页面处于活动状态
          } else {
            // 页面处于非活动状态
          }
        });

      })
      onUnmounted(()=>{
        console.log('组件卸载了')
        document.removeEventListener('visibilitychange',()=>{

        })
      })
      async function checkTenantInfoByToken(pageToken, localToken){
        let response = await checkToken({token:pageToken},localToken);
        if(response.data.code==500){
          userStore.logout(true);
          return
        }
        console.log(localToken,'新的token')
        userStore.setToken(localToken)
        if(response.data.result){
          // userStore.setPageToken(localToken);
        }else{
          openModal(true,{
            isUpdate:false
          })
        }
      }
      function handleSubmit(){
          emit('success');
          closeModal()
      }
      function handleLogOut(type){
        switch(type){
          case 0:
            closeModal;
            break;
          case 1:
            userStore.logout(true);
            break;
          case 2:
          userStore.logoutAll(true);
            break;

        }

      }
      function handleTokenSwitch(type){
        // const localToken = getToken() as string;
        const localToken = isDevMode()?(localStorage.getItem('VUE_OPENSIGN_ADMIN__DEVELOPMENT__2.8.0__COMMON__LOCAL__KEY__')? 
              JSON.parse(localStorage.getItem('VUE_OPENSIGN_ADMIN__DEVELOPMENT__2.8.0__COMMON__LOCAL__KEY__') as string ).value.TOKEN__.value:''):
              localStorage.getItem('VUE_OPENSIGN_ADMIN__PRODUCTION__2.8.0__COMMON__LOCAL__KEY__')? 
              JSON.parse(localStorage.getItem('VUE_OPENSIGN_ADMIN__PRODUCTION__2.8.0__COMMON__LOCAL__KEY__') as string ).value.TOKEN__.value:'';
        const pageToken:string = userStore.getPageToken;
        if(type){
          //本地缓存更新页面缓存token
          userStore.setPageToken(localToken);
        }else{
          //页面缓存更新本地缓存
          userStore.setToken(pageToken)
        }
        closeModal();
        window.location.reload();
      }
      function handleBack(){
        closeModal();
      }
    return {
      handleTokenSwitch,
      handleLogOut,
      registerModal,
      handleSubmit,
      handleBack
    }
  },
})
</script>
<style lang="less" scoped>
 .change-account-tip{
  text-align:center;
  p{
    margin-top:30px;
  }
 }
  
</style>
