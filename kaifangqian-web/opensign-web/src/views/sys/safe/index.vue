<!--
  @description 资助审批电子签章系统
-->

<template>
  <Card>
      <Tabs :class="prefixCls">
        <TabPane key="operation" tab="密码规则设置">
            <Password />
        </TabPane>
        <TabPane key="abnormal" tab="访问规则设置">
            <Access />
        </TabPane>
        <TabPane key="IP" tab="IP限制">
            <IPLimit />
        </TabPane>
        <TabPane key="security" tab="敏感操作保护设置">
          <Sensitive />
        </TabPane>
      </Tabs>
  </Card>
</template>
<script lang='ts'>
  import { defineComponent } from 'vue';
  import { Tabs,Card } from 'ant-design-vue';
  import { useDesign } from '/@/hooks/web/useDesign';

  import Password from './Password.vue';
  import Access from './Access.vue';
  import IPLimit from './IPLimit.vue';
  import Sensitive from './Sensitive.vue';
  export default defineComponent({
    name: '安全配置',
    components:{
      Tabs, TabPane: Tabs.TabPane,Password,Access,Sensitive,Card,IPLimit
    },
    setup(){
      const { prefixCls } = useDesign('sys-logs');
      return {
        prefixCls
      }
    }
  })
</script>
<style lang="less">
//   .resrun-basic-table-form-container .ant-form{  
//     border-bottom: 1px solid #f0f2ff;
//  }
 .ant-input-number{
    width:220px;
 }

</style>