<!--
  @description 资助审批电子签章系统
-->

<template>
    <BasicTable @register="registerTable">
       <template #logContent="{ record }">
          <span>{{ record.moduleName + '-' + record.methodName}}</span>
      </template>
       <template #warningType="{ text }">
          <span>{{ text == '1'?'越权':(text===2?'高频访问':'拦截')}}</span>
      </template>
       <template #warningLevel="{ text }">
          <span>{{ text == '1'?'预警':'告警'}}</span>
      </template>
    </BasicTable>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { securityColumns,securitySearchFormSchema } from './log';
  import { getSysWarninglog,getSysWarninglogInfo } from '/@/api/sys/log';

  export default defineComponent({
    name:'Security',
    components: { BasicTable, TableAction },
    setup() {
      const [registerTable] = useTable({
        api: getSysWarninglog,
        title: '',
        columns: securityColumns,
        rowKey: 'id',
        fetchSetting:{
          listField:'records'
        },
        canResize: false,
        useSearchForm: true,
        showIndexColumn: false,
        formConfig: {
          labelWidth: 100,
          schemas: securitySearchFormSchema,
        },
        striped:false,
        expandRowByClick: false,
      });
      async function handleRowChange(isExpand,record){
          console.log(isExpand,record, '--ssss-')
          if(!isExpand && !record.info) return;
          let result = await getSysWarninglogInfo({id:record.id});
          if(result){
             record.info = result;
          }
      }

     
      return {
        registerTable,
        handleRowChange
      }
    }
  });
</script>
<style lang="less" scoped>
:deep(.ant-select-dropdown){
  top:-140px!important;
}
</style>
