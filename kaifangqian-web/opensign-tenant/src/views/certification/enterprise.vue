<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="ent-container" style="padding:24px;">
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
import {ref,defineComponent} from "vue"
import { BasicTable,useTable } from '/@/components/Table';
import Icon from "/@/components/Icon";
import { certicifateColumn, certificateEntSearchFormSchema } from './data';
import { getEnterpriseCerList } from '/@/api/certification';
import { loadCerStatus, loadCerAlgorithmType, loadCerType} from './transform'


export default defineComponent({
  name:"PersonalCertificate",
  components:{
    Icon,
    BasicTable
  },
  setup() {
    const [registerTable,{}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getEnterpriseCerList,
        columns:certicifateColumn,
        immediate:true,
        fetchSetting:{
          listField:'records'
        },
        // formConfig: {
        //   labelWidth: 80,
        //   schemas: certificateEntSearchFormSchema,
        // },
        rowKey:'id',
        useSearchForm: false,
        showIndexColumn: false,
        canResize: false,
        isTriggerSelect:false,
        striped:false,
        bordered:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        pagination:true,
    }); 
   
    return {
      registerTable,
      loadCerStatus, loadCerAlgorithmType, loadCerType

    }
  }
})
</script>

<style lang="less" scoped>
</style>
