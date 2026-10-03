<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="orgianize-box">
    <Tabs @change="handleTabChange" v-model:activeKey="activeTab" :destroyInactiveTabPane="true">
      <TabPane key="user" tab="" forceRender v-if="routePath=='/organize/user'">
          <User @changePanelShow="changePanelShow" />
      </TabPane>
      <TabPane key="dept" tab="" forceRender v-if="routePath=='/organize/dept'">
          <Dept  v-if="activeTab==='dept'"/>
      </TabPane>
      <TabPane key="role" tab=""   forceRender v-if="routePath=='/organize/role'">
        <Role v-if="activeTab==='role'"/>   
      </TabPane>
    </Tabs>
  </div>
</template>

<script lang="ts">
  import { defineComponent, ref,  onMounted } from 'vue';
  import {Tabs, Divider } from 'ant-design-vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { useRouter } from 'vue-router';
  import Dept from './Dept.vue'
  import User from './User.vue'
  import Role from './Role.vue'
  import { usePermission } from '/@/hooks/web/usePermission';

  export default defineComponent({
    name:'Organize',
    components: {  Tabs, TabPane: Tabs.TabPane, Divider, Dept, User, Role},
    setup() {
      const { prefixCls } = useDesign('organize');
      const organizeName = ref('运营部');
      const activeTab = ref('user');

      const { hasPermission } = usePermission();
      const router = useRouter();
      const routePath = router.currentRoute.value.path;

    

      onMounted(()=>{
        if(routePath.indexOf('user')>0){
          setTimeout(()=>{
            handleTabChange('user')
          })
        }
        if(routePath.indexOf('dept')>0){
          setTimeout(()=>{
            handleTabChange('dept')
          })
        }
        if(routePath.indexOf('role')>0){
          setTimeout(()=>{
            handleTabChange('role')
          })
        }
      })
      function changePanelShow(val){
        console.log(val,'测试1111')
      }
      function handleTabChange(val){
        console.log(val,'3243434')
        activeTab.value = val;
      }

     
      return { 
        hasPermission,
        prefixCls,
        changePanelShow,
        organizeName,
        activeTab,
        handleTabChange,
        routePath
      }
    },
  });
</script>
<style lang="less" scoped>
 @prefix-cls: ~'@{namespace}-organize-home';
.@{prefix-cls} {
  &.panelHide{
    .ant-tabs-nav{
      margin-left:10px;
      transition: all 0.4s;
    }
  }
  &-custom-header{
    height: 71px;
    background: #fff;
    padding: 2px 15px;
    // margin-left: 10px;
    /* margin-bottom: 10px; */
    border-bottom: 1px solid #f6f6f6;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .ant-divider{
      color:#1890ff
    }
  }
  &-custom-title{
    font-size: 14px;
    font-weight: 600;
  }
  &-custom-btn a{
    font-size: 14px;
  }
 
}
.resrun-tree-table{
  display: flex;
  height:100%;
}
:deep(.ant-tabs-nav-wrap){
    padding: 0 20px;
    background-color: #fff;
  }
  .orgianize-box{
    :deep( .ant-tabs-nav){
      margin:0;
      background-color: #fff;
      padding:0 15px;
      display: none;
    }
  }
  
  // :deep(.ant-tabs-content-holder){
  //   padding:24px;
  // }
</style>
