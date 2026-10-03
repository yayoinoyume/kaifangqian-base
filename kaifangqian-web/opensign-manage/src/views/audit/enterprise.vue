<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container">
    <BasicTable @register="registerTable">
        <template #authStatus="{record}">
          <div>
              <a-tag :color="loadCertificationStatus(record.authStatus)">{{ loadCertificationMixText(record) }}</a-tag>
          </div>
        </template>
        <template #authType="{record}">
         <span>{{ loadCertificationAuthType(record.authType) }}</span>
        </template>
        <template #realItem="{record}">
         <span>{{ loadCertificationRealItemType(record.realItem) }}</span>
        </template>
        <template #action="{record}">
          <a-button type="link" size="small" @click="handleSee(record)">查看</a-button>
          <a-button type="link" size="small" @click="handleApprove(record)" :disabled="record.authStatus !==1"> 审核</a-button>
        </template>
    </BasicTable>
    <CheckModal @register="registerModal" @success="handleCheck"/>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue"
import { BasicTable,useTable } from '/@/components/Table';
import Icon from "/@/components/Icon";
import { tableColumn, tableSearchFormSchema } from './data';
import { useMessage } from '/@/hooks/web/useMessage';
import { useModal } from '/@/components/Modal';
import CheckModal  from './modal/CheckModal.vue';
import { getEnterpriseAuditList } from '/@/api/audit';
import dayjs from 'dayjs';
import { loadCertificationStatus, loadCertificationText, loadCertificationMixText, loadCertificationAuthType, loadCertificationRealItemType } from '/@/utils/StatusToName'


export default defineComponent({
  name:"AuditEnterprise",
  components:{
    Icon,
    BasicTable,
    CheckModal
  },
  setup() {


    const [registerModal, { openModal,closeModal }] = useModal(); 
    const { createMessage:msg,  } = useMessage();

    const [registerTable,{reload}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getEnterpriseAuditList,
        columns:tableColumn,
        immediate:true,
        fetchSetting:{
          listField:'records'
        },
        formConfig: {
          labelWidth: 80,
          schemas: tableSearchFormSchema,
        },
        dataSource:[],
        rowKey:'id',
        useSearchForm: true,
        showIndexColumn: false,
        canResize: false,
        isTriggerSelect:false,
        striped:false,
        bordered:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        pagination:true,
        beforeFetch:handleBeforeFetch
    }); 
    function handleBeforeFetch(params){
      if(params.applyTime){
        params.startTime = dayjs(params.applyTime[0]).startOf('date').format('YYYY-MM-DD HH:mm:ss');
        params.endTime = params.applyTime[1];
        params.applyTime = undefined;
      }
    }

    function handleSee(row){ 
      openModal(true,{
        isUpdate:false,
        record:{
          ...row
        }
      })
    }
    function handleApprove(row){ 
      openModal(true,{
        isUpdate:true,
        record:{
          ...row
        }
      })
     
    }
    function handleCheck(){
      reload();
      closeModal();
    }

    
    return {
      registerTable,
      handleSee,
      handleApprove,
      registerModal,
      loadCertificationStatus, loadCertificationText, loadCertificationAuthType,loadCertificationRealItemType,
      handleCheck,
      loadCertificationMixText
    }
  }
})
</script>

<style lang="less" scoped>
</style>
