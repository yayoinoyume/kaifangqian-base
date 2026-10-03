<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicDrawer
    v-bind="$attrs"
    @register="registerDrawer"
    showFooter
    :title="getTitle"
    width="100%"
    @ok="handleSubmit"
    >
    <template #title>
      <div class="drawer-header">
        <div @click="handleBack" class="back-area">
          <Icon icon="ant-design:left-outlined" :size="20"/>
          <span class="drawer-btn">返回</span>
        </div>
        <span class="account-title">账号信息</span>
      </div>
    </template>
    <UserCenter />
  </BasicDrawer>
</template>
<script lang="ts">
  import { defineComponent,computed} from 'vue';
  import { BasicDrawer, useDrawerInner } from '/@/components/Drawer';
  import UserCenter from '/@/views/sys/user/UserInfo.vue';
  import Icon from '/@/components/Icon';
  
 
  export default defineComponent({
    name: 'UserInfo',
    components: {
      BasicDrawer,
      UserCenter,
      Icon
    },
    setup(_, { emit }) {
      const [registerDrawer, { setDrawerProps, closeDrawer }] = useDrawerInner(async (data) => {
        setDrawerProps({ 
          confirmLoading: false,
          closable:false
        });
      
      });
      const getTitle = computed(() => ('账号信息'));
      function handleSubmit(){
        closeDrawer();
      }
      function handleBack(){
        closeDrawer();
      }
    
      return {
        registerDrawer,
        getTitle,
        handleSubmit,
        handleBack

      }
    }
  });
</script>
<style lang="less" scoped>
.drawer-header{
  display: flex;
  align-items: center;
  cursor: pointer;
  .drawer-btn{
    font-size: 14px;
    margin-right:10px;
    font-weight: 600;
  }
  .account-title{
    font-size: 14px;
  }
  .back-area{
    display: flex;
    align-items: center;
  }
}
</style>