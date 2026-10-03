<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="main-message">
    <Card size="small" title="消息">
        <template #extra>
          <span>查看更多</span>
        </template>
        <BasicTable @register="registerTable">
          <template #title="{record}">
            <p v-if="record.status===0" class="dot-title">
              <a-badge status="processing"></a-badge>
              <a-tooltip>
                <template #title>{{ record.title }}</template>
                <span class="msg-title">{{ record.title }}</span>
              </a-tooltip>
            </p>
            <a-tooltip>
                <template #title>{{ record.title }}</template>
                <span v-if="record.status!==0" class="msg-title no-dot">{{ record.title }}</span>
            </a-tooltip>
          </template>
        </BasicTable>
    </Card>
    <Card size="small" title="公告">
        <template #extra>
          <span>查看更多</span>
        </template>
        <BasicTable @register="registerTable">
          <template #title="{record}">
            <p v-if="record.status===0" class="dot-title">
              <a-badge status="processing"></a-badge>
              <a-tooltip>
                <template #title>{{ record.title }}</template>
                <span class="msg-title">{{ record.title }}</span>
              </a-tooltip>
            </p>
            <a-tooltip>
                <template #title>{{ record.title }}</template>
                <span v-if="record.status!==0" class="msg-title no-dot">{{ record.title }}</span>
            </a-tooltip>
          </template>
        </BasicTable>
    </Card>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue";
import { Card } from 'ant-design-vue';
import { BasicTable, useTable, } from '/@/components/Table';
import { msgColumns } from './data'
export default defineComponent({
  name:"Message",
  components:{
    Card,
    BasicTable
  },
  setup() {
    const data = ref('');
    const [registerTable] = useTable({
        title: '',
        // api: getCopyrightOwnerList,
        columns:msgColumns,
        dataSource:[
          {status: 0,title:'您的组织尚未完成实名认证ddddddddddddddddddd,',receiveTime:'2023-02-16',type:1 },
          {status: 1,title:'您的组织尚未完成实名认证,',receiveTime:'2023-02-16',type:2 },
          {status: 0,title:'您的组织尚未完成实名认证,',receiveTime:'2023-02-16',type:3 },
        ],
        fetchSetting:{
          listField:'records'
        },
        immediate:true,
        useSearchForm: false,
        
        isTriggerSelect:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: false,
        rowKey: 'id',
        striped: false,
        bordered: false,
        pagination:false
      })
    return {
      registerTable,
      data  
    }
  }
})
</script>

<style lang="less" scoped>
.main-message{
  display: flex;
  justify-content: space-between;
  .ant-card{
    width: 49.5%;
  }
  .msg-title{
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    width: 400px;
    display: inline-block;
  }
  
  .dot-title{
    display: flex;
    margin-bottom:0;
    :deep(.ant-badge-status-dot){
      width:11px;
      height:11px;
    }
  }
  .no-dot{
    margin-left:20px
  }

}
</style>
