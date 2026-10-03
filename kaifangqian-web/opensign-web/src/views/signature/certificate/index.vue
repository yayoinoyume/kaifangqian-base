<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicTable @register="registerTable">
  <!--  <template #toolbar>
      <div style="text-align: right;width: 100%;">
        <a-button type="primary" @click="sealApply">用印申请</a-button>
        <a-button type="info">导出列表</a-button>
      </div>
    </template> -->
    <!-- <template #status="{ record }">
      <a-tag :color="getDocStat(record.status).color">{{getDocStat(record.status).label}}</a-tag>
    </template> -->
    <template #action="{ record }">
      <!-- 查看 ｜撤回｜作废｜下载文档｜下载审批单｜删除 -->
      <a-button type="link" size="small">查看</a-button>
      
    </template>
  </BasicTable>
  <!-- <AppAuthFormModal  @register="registerModal" @success="handleSuccess"></AppAuthFormModal> -->
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import { BasicTable, useTable} from '/@/components/Table';
  import {registerColumns,registerSearchFormSchema} from "./data"
  import { message } from 'ant-design-vue';
  import { useModal } from '/@/components/Modal';
  // import {getDocList} from "/@/api/signature/doc"
  
  // import {getDocStat} from "./common/DocStatus";
  import {useRouter} from "vue-router";
  
  
  export default defineComponent({
    name:'App',
    components: { 
       BasicTable
    },
    setup() {
      const router = useRouter();
      const [registerTable,{reload}] = useTable({
        title: '',
        //api: getDocList,
        columns:registerColumns,
        fetchSetting:{
          listField:'records'
        },
        formConfig: {
          labelWidth: 120,
          schemas:registerSearchFormSchema,
        },
        immediate:true,
        useSearchForm: true,
        isTriggerSelect:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: true,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
        beforeFetch:beforeFetch
      })
      function beforeFetch(params){
        if(params.recordTime){
          params.beginTime = params.recordTime[0];
          params.endTime = params.recordTime[1];
          params.recordTime = undefined;
        }
      }
      const [registerModal, { openModal,closeModal }] = useModal();
      function handleShowInfo(data){
          openModal(true,{
            isUpdate:true,
            record:{
              ...data,
              view:true
            }
          })
      }
      function handleRecord(data){
        openModal(true,{
          isUpdate:true,
          record:{
            ...data,
          }
        })
      }
      function enableDisableApp(flag,id){
        
      }
      function handleSuccess(){
        reload();
      }
      function handleAdd(){
        openModal(true,{
          isUpdate:false,
        })
      }
      function sealApply(){
        router.push("/seals/apply/process");
      }
      return{
        registerTable,handleShowInfo,handleRecord,handleAdd,
        enableDisableApp,registerModal,handleSuccess,
        sealApply
      }
    }
  })
  
  
</script>

<style>
</style>
