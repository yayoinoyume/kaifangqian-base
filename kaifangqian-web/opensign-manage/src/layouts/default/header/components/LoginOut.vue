<!--
  @description 资助审批电子签章系统
-->

/*
 * @Author: ningw 
 * @Date: 2022-06-28 18:22:10 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-04-04 16:42:38
 */
<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="退出登录" @ok="handleSubmit">
       <p>是否确认退出系统</p>
       <template #footer>
          <div>
            <a-button @click="handleLogOut(0)">取消</a-button>
            <a-button type="primary" @click="handleLogOut(1)">退出当前应用</a-button>
            <a-button type="primary" @click="handleLogOut(2)">退出所有应用</a-button>
          </div>
       </template>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent,ref } from 'vue'
import { BasicModal,useModalInner } from '/@/components/Modal';
import { Icon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';

interface Dept {
  [propName: string]: string | number
}
export default defineComponent({
  name: 'LoginSelectAccount',
  components:{
    BasicModal,
    // BasicForm,
    Icon
  },
  setup(_,{emit}){
      const isUpdate = ref(true);

      const userStore = useUserStore();

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
          setModalProps({ confirmLoading: false,width:500,canFullscreen:false, closable:false,maskClosable:false,centered:true,height:100,minHeight:100 });
          isUpdate.value = !!data?.isUpdate;
         
        
      });
      function handleSubmit(){
          emit('success');
          closeModal()
      }
      function handleLogOut(type){
        switch(type){
          case 0:
            closeModal();
            break;
          case 1:
            userStore.logout(true);
            break;
          case 2:
          userStore.logoutAll(true);
            break;

        }

      }
      function handleBack(){
        closeModal();
      }
    return {
      handleLogOut,
      registerModal,
      handleSubmit,
      handleBack
    }
  },
})
</script>
<style lang="less" scoped>
 
</style>
