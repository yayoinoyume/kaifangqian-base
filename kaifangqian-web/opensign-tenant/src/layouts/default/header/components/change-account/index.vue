<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="account-scope">
    <!-- <Dropdown placement="bottomLeft" :overlayClassName="`${prefixCls}-dropdown-overlay`" style="top:63px" :trigger="['click']" :getPopupContainer="getPopupContainer"> -->
      <span class="drop-title">{{ storeUserInfo.loginTenantName }}</span>
       <!-- <template #overlay>
          <div class="account-panel">
            <div class="account-list">
                <div :class="['account-panel-item',item.useFlag?'':'no-use']" v-for="item in accountList">
                    <p class="account-header">
                      <span>{{item.tenantName}}</span>
                      <a-tag color="red" v-if="!item.useFlag">已停用</a-tag>
                    </p>
                    <Menu @click="handleMenuClick(item,depart)" v-for="depart in item.departs">
                        <MenuItem :key="depart.departId"  :text="depart.departName" >
                          <a-tag color="blue" v-if="depart.selectFlag">当前登录</a-tag>
                        </MenuItem>
                      <MenuDivider />
                    </Menu>
                </div>
              </div>
              <div class="join-container">
                <div class="join-enter" @click.stop="handleJoinEnterprise">
                  <Icon icon="ant-design:usergroup-add-outlined" :size="18"/>
                  <span>加入已有企业</span>
                </div>
                <div class="join-enter" v-if="!storeUserInfo.personalTenantFlag" @click.stop="handleOpenPersonalTenant">
                    <Icon icon="ant-design:user-add-outlined"  :size="18"/>
                    <span>开通个人空间</span>
                  </div>
              </div>
              
          </div>
        </template> -->
      <!-- </Dropdown> -->
  </div>
  <Invitation @register="registerModal" @success="handleSuccess"/>
</template>

<script lang="ts">
import type { TenantDepartList } from '/#/store';
import {ref,onMounted,computed} from "vue";
import Invitation from "./Invitation.vue";
import { useModal } from '/@/components/Modal';
import { useUserStore } from '/@/store/modules/user';
import { Dropdown, Menu } from 'ant-design-vue';
import { useDesign } from '/@/hooks/web/useDesign';
import { createAsyncComponent } from '/@/utils/factory/createAsyncComponent';
import { getPopupContainer } from '/@/utils';
import Icon from '/@/components/Icon/index';
import { getMyTenantDeparts } from '/@/api/sys/user'; 
import { openPersonalTenant } from '/@/api/tenant'
import { useMessage } from '/@/hooks/web/useMessage';

export default{
  name:"ChangeAccount",
  components:{
    Invitation,
    Dropdown,
    Menu,
    MenuItem: createAsyncComponent(() => import("../user-dropdown/DropMenuItem.vue")),
    MenuDivider: Menu.Divider,
    Icon
    
  },
  setup() {
   const accountScope = ref('');
   const personalTenantFlag = ref(false);
   const { prefixCls } = useDesign('header-account');
   const isOpenPersonalScope = ref(false);
   const accountList = ref(<TenantDepartList[]>[]);
   const { createMessage: msg, notification } = useMessage();



   const [registerModal,{openModal}] = useModal();
   const userStore = useUserStore();
   const storeUserInfo =  computed(() => userStore.getUserInfo);
 
   function handleAccountChange(){
    openModal(true,{
      isUpdate:false,
      record:{

      }
    })
   }
   onMounted(()=>{
    fetch()
   })
   async function fetch(){
    let result = await getMyTenantDeparts();
    if(result){
      accountList.value = result;
    }
   } 
   function handleJoinEnterprise(){
    openModal(true,{
      isUpdate:false,
      record:{

      }
    })
   }
   function handleSuccess(){
    fetch();
   }
  //  async function handleMenuClick(tenant,depart){
  //       console.log(tenant,depart,'点击信息')
  //       let result = await updateTenantDepart({departId:depart.departId});
  //       if(result){
  //           afterCangeTenant()
  //       }
  //  }
   async function handleMenuClick(tenant,depart){
    console.log(tenant,depart,'点击信息');
    let params = {
        departId:depart.departId
      }
      const userInfo = await userStore.selectTenant(params);
      if(userInfo){
            notification.success({
              message: '切换成功',
              duration: 3,
            });
            location.reload();
        }
   }
   async function handleOpenPersonalTenant(){
    let result = await openPersonalTenant({});
    if(result.code===200){
      msg.success('开通成功');
      const userInfo = userStore.getUserInfoAction();
      console.log(userInfo,'跟新后的信息')

    }
   }
    return {
      prefixCls,
      storeUserInfo,
      handleMenuClick,
      accountScope,
      handleOpenPersonalTenant,
      personalTenantFlag,
      registerModal,
      accountList,
      handleAccountChange,
      getPopupContainer,
      isOpenPersonalScope,
      handleJoinEnterprise,
      handleSuccess
    }
  }
}
</script>

<style lang="less" scoped>
  @prefix-cls: ~'@{namespace}-header-account-dropdown';
.account-scope{
  margin-right: 50px;
  cursor: pointer;
  .drop-title{
    height:100%;
    display: inline-block;
    user-select: none;
  }
  :deep(.ant-dropdown-content){
    border:1px solid #ddd;
    background-color: #fff;
    height: 400px;
    overflow: auto;
    padding-bottom: 80px;
  }
  .account-header{
     margin-bottom: 0;
      font-size: 14px;
      background-color: #f4f4f4;
      padding: 8px 10px;
    }
    .ant-menu > .ant-menu-item-divider{
      margin:0;
    }
    .account-list{
      overflow: auto;
      padding-bottom: 70px;
      max-height: 400px;
      .no-use{
        pointer-events: none;
      }
    }
    .account-panel-item{
      width: 300px;
    }
   
    :deep(.ant-menu-item-only-child){
      padding-left:20px!important;
      margin:0;
      
    }
    :deep(.items-center){
      display: flex;
      justify-content: space-between;
    }
    .join-container{
      background-color: #fff;
      position: absolute;
      bottom:0;
      width:97%;
      .join-enter{
        margin: 10px;
        border: 1px solid #ddd;
        padding: 10px 10px;
        border-radius: 10px;
        display: flex;
        align-items: center;
        .app-iconify{
          background-color: #f4f4f4;
          width: 30px;
          height: 30px;
          display: flex;
          justify-content: center;
          align-items: center;
          border-radius: 5px;
          margin-right: 10px;
        }
        &:hover{
          color: #127fd2;
          border-color: #127fd2;
        }
      }
    }
  
      &--dropdown-overlay{
        .ant-dropdown{
          background-color: #fff;
        }
        .ant-dropdown-menu-item {
            min-width: 250px;
          }
      }
}

</style>
