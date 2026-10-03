<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicTable @register="registerTable" >
      
     
    </BasicTable>
  </div>
</template>
<script lang='ts'>
import { defineComponent } from 'vue';
import { BasicTable, useTable, TableAction } from '/@/components/Table';
import { columns, searchFormSchema } from './data';
import { getTestAuthDataList } from '/@/api/test/auth'

export default defineComponent({
  name: 'Index',
  components: { BasicTable, TableAction },
  setup(){
    const [registerTable, { reload }] = useTable({
        title: '',
        api: getTestAuthDataList,
        columns,
        formConfig: {
          labelWidth: 120,
          schemas: searchFormSchema,
        },
        fetchSetting:{
          listField:'records'
        },
        showIndexColumn: true,
        rowKey:'id',
        useSearchForm: true,
        dataSource:[],
        showDragColumn:false,
        bordered: false,
        isTriggerSelect:false,
        showTableSetting: false,
        canResize: false,
        striped:false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
      });
    return {
      registerTable
    }

  }
 
})
</script>
<style>
 
</style>
