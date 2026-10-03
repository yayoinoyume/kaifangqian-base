<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="orgianize-box">
    <Tabs @change="handleTabChange" v-model:value="activeTab">
      <TabPane key="user" tab="成员" forceRender>
          <User @changePanelShow="changePanelShow" v-if="activeTab==='user'"/>
      </TabPane>
      <TabPane key="dept" tab="部门" >
          <Dept  v-if="activeTab==='dept'"/>
      </TabPane>
    </Tabs>
  </div>
</template>

<script lang="ts">
  import { defineComponent, ref,  onMounted } from 'vue';
  import {Tabs, Divider } from 'ant-design-vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import Dept from './Dept.vue'
  import User from './User.vue'
  import { usePermission } from '/@/hooks/web/usePermission';

  export default defineComponent({
    name:'Organize',
    components: {  Tabs, TabPane: Tabs.TabPane, Divider, Dept, User},
    setup() {
      const { prefixCls } = useDesign('organize');
      // const currentEditKeyRef = ref('');
      const organizeName = ref('运营部');
      const activeTab = ref('user');
      const { hasPermission } = usePermission();
      const basicTree = ref(null)
      const panelShow = ref(true)
    

      onMounted(()=>{
        console.log(basicTree.value,'----------iiii--')
      })
      function changePanelShow(val){
          panelShow.value = val;
      }
      function handleTabChange(val){
        
        activeTab.value = val;
      }

     
      return { 
        hasPermission,
        prefixCls,
        changePanelShow,
        organizeName,
        panelShow,
        activeTab,
        handleTabChange
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
  .ant-tabs-nav{
    margin:0;
    background-color: #fff;
    padding:0 15px;
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
</style>
