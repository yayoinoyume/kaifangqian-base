<!--
  @description 资助审批电子签章系统
-->

<template>
  <Card>
      <Tabs :class="prefixCls" v-model:value="activeTab" @change="handleTabChange">
        <TabPane key="operation" tab="操作日志">
            <Operation  v-if="activeTab === 'operation'"/>
        </TabPane>
        <TabPane key="abnormal" tab="异常日志">
            <Abnormal  v-if="activeTab === 'abnormal'"/>
        </TabPane>
        <TabPane key="security" tab="安全预警日志">
          <Security  v-if="activeTab === 'security'" />
        </TabPane>
      </Tabs>
  </Card>
</template>
<script lang='ts'>
  import { defineComponent, ref } from 'vue';
  import { Tabs,Card } from 'ant-design-vue';
  import { useDesign } from '/@/hooks/web/useDesign';

  import Operation from './Operation.vue';
  import Abnormal from './Abnormal.vue';
  import Security from './Security.vue';
  export default defineComponent({
    name: 'index',
    components:{
      Tabs, TabPane: Tabs.TabPane,Operation,Abnormal,Security,Card
    },
    setup(){
      const { prefixCls } = useDesign('sys-logs');
      const activeTab = ref('operation');
      function handleTabChange(val){
        activeTab.value = val;
      }
      return {
        prefixCls,
        activeTab,
        handleTabChange
      }
    }
  })
</script>
<style lang="less">
//   .resrun-basic-table-form-container .ant-form{  
//     border-bottom: 1px solid #f0f2ff;
//  }

</style>