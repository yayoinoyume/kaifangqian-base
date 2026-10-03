<!--
  @description 资助审批电子签章系统
-->

/*
 * @Author: ningw 
 * @Date: 2022-06-28 18:22:10 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-12-20 15:03:38
 */
<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="切换身份" @ok="handleSubmit" :destroyOnClose="true" >
        <template #title>
          <div>
            <a-button type="text" >切换身份</a-button>
          </div>
        </template>
        <div class="account-list">
          <div v-for="(item,index) in accountList.list" :key="index" >
              <div :class="['account-item',item.id === loginDepartId?'active-depart':'']" @click="handleSubmit(item)">
                <span :key="index" >{{item.departName}}</span>
                <Icon icon="ant-design:arrow-right-outlined"/>
              </div>
          </div>
        </div>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent, reactive, computed } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { Icon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';
import { getUserDepartsList } from '/@/api/sys/user';
import { usePermissionStore } from '/@/store/modules/permission';

export default defineComponent({
  name: 'LoginSelectAccount',
  components:{
    BasicModal,
    // BasicForm,
    Icon
  },
  setup(_,{emit}){
      const userStore = useUserStore();
      const { notification, createMessage: msg, } = useMessage();
      const accountList = reactive({list:[]});
      const permissionStore = usePermissionStore();
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
          setModalProps({ confirmLoading: false,width:500,canFullscreen:false, closable:false,maskClosable:false,centered:true });
          getDepartList();

      });
      const loginDepartId =  computed(()=>userStore.getUserInfo.loginDepartId);
      async function getDepartList(){
        accountList.list =  [];
        let result = await getUserDepartsList();
        if(result){
          accountList.list = result;
        }
      }

      async function handleSubmit(item){
        if(item.id == loginDepartId){
          msg.warning('不可切换为已登录部门');
          return; 
        }
        // 获取表单信息
        // const formData = await validate()
        const formData = {
          orgCode:item.orgCode
        }
        permissionStore.setDynamicAddedRoute(false);
        const userInfo = await userStore.selectTenant(formData);
        if(userInfo){
            notification.success({
              message: '切换成功',
              // description: `${'切换成功'}: ${userInfo.username}`,
              duration: 3,
            });
            // location.reload();
            closeModal()
        }
      }
      function handleBack(){
        emit('success')
      }
    return {
      registerModal,
      // registerForm,
      handleSubmit,
      accountList,
      handleBack,
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
