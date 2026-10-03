<!--
  @description 资助审批电子签章系统
-->

/*
 * @Author: ningw 
 * @Date: 2022-06-28 18:22:10 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-01-09 17:54:50
 */
<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="输入企业邀请码" @ok="handleSubmit" :destroyOnClose="true" >
       <p>企业邀请码（即团队码）是一个 8 位字母编码，可联系企业管理员获取</p>
       <a-input v-model:value="invitationCode"></a-input>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent, computed, ref,unref } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { Icon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';
import { jionTenant } from '/@/api/tenant';

export default defineComponent({
  name: 'Invitation',
  components:{
    BasicModal,
    Icon
  },
  setup(_,{emit}){
      const userStore = useUserStore();
      const { createMessage: msg, } = useMessage();
      const invitationCode = ref('');
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
         setModalProps({ confirmLoading: false,width:500,canFullscreen:false, closable:false,maskClosable:false,centered:true,minHeight:70 });

      });
      const loginDepartId =  computed(()=>userStore.getUserInfo.loginDepartId);
      async function handleSubmit(){
        let result = await jionTenant({invitationCode:unref(invitationCode)});
        if(result){
          msg.success('加入成功');
          closeModal();
          emit('success')
        }
        
      }
      return {
        invitationCode,
        registerModal,
        handleSubmit,
        loginDepartId
      }
  },
})
</script>
<style lang="less" scoped>
.login-title{
  font-size: 18px;
}
.account-list{
  overflow: auto;
    max-height: 250px;
    .account-item{
      padding: 15px 24px;
      font-size: 14px;
      border: 1px solid #f9f9f9;
      border-radius: 8px;
      cursor: pointer;
      background: #f9f9f9;
      display: flex;
      align-items: center;
      justify-content: space-between;
      margin-bottom: 15px;
      margin-right: 10px;
      &:active{
        box-shadow: inset -7px -6px 12px rgb(255 255 255 / 90%), inset 0px -1px 10px rgb(0 0 0 / 40%) 
      }
    }
    .active-depart{
      color: @primary-color;
    }
}
 
</style>
