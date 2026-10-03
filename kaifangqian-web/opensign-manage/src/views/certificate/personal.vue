<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="per-container">
    <BasicTable @register="registerTable">
        <template #certType="{record}">
          <div> 
              <span>{{ loadCerType(record.certType) }}</span>
          </div>
        </template>
        <template #algorithmType="{record}">
          <div> 
              <span>{{ loadCerAlgorithmType(record.algorithmType) }}</span>
          </div>
        </template>
        <template #certStatus="{record}">
          <div> 
            <a-tag :color="record.certStatus==1?'#87d068':'#f50'">{{ loadCerStatus(record.certStatus) }}</a-tag>
          </div>
        </template>
        <template #cerRange="{record}">
          <div> 
              <span>{{ record.termOfValidityStartTime + '-' + record.termOfValidityEndTime }}</span>
          </div>
        </template>
    </BasicTable>
  </div>
</template>

<script lang="ts">
import { defineComponent} from "vue"
import { BasicTable,useTable } from '/@/components/Table';
import Icon from "/@/components/Icon";
import { certicifateColumn, certificateSearchFormSchema } from './data';
// import { useMessage } from '/@/hooks/web/useMessage';
import { getPersonaliseCerList } from '/@/api/certification';
import { loadCerStatus, loadCerAlgorithmType, loadCerType} from './transform'
import dayjs from 'dayjs';

export default defineComponent({
  name:"PersonalCertificate",
  components:{
    Icon,
    BasicTable
  },
  setup() {

    // const { createMessage:msg, createConfirm } = useMessage();

    const [registerTable,{ }] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getPersonaliseCerList,
        columns:certicifateColumn,
        immediate:true,
        fetchSetting:{
          listField:'records'
        },
        formConfig: {
          labelWidth: 80,
          schemas: certificateSearchFormSchema,
        },
        rowKey:'id',
        useSearchForm: true,
        showIndexColumn: true,
        canResize: false,
        isTriggerSelect:false,
        striped:false,
        bordered:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        pagination:true,
        beforeFetch:beforeFetch,

    }); 
    function beforeFetch(params){
        if(params.promulgateTime){
          const startOfDay = dayjs(params.promulgateTime[0]).startOf('day');
          const endOfDay = dayjs(params.promulgateTime[1]).endOf('day')
          params.issueTimeStartTime = startOfDay.format('YYYY-MM-DD HH:mm:ss');
          params.issueTimeEndTime = endOfDay.format('YYYY-MM-DD HH:mm:ss');
          params.promulgateTime = undefined;
        }
        if(params.invalidTime){
          const startOfDay = dayjs(params.invalidTime[0]).startOf('day');
          const endOfDay = dayjs(params.invalidTime[1]).endOf('day')
          params.termStartTime = startOfDay.format('YYYY-MM-DD HH:mm:ss');
          params.termEndTime = endOfDay.format('YYYY-MM-DD HH:mm:ss');
          params.invalidTime = undefined;
        }  
      }

   
    return {
      registerTable,
      loadCerStatus, loadCerAlgorithmType, loadCerType,


    }
  }
})
</script>

<style lang="less" scoped>
</style>
