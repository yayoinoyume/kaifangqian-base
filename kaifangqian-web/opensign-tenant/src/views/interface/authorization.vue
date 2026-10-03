<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="ent-container" style="padding:24px;">
    <BasicTable @register="registerTable">
      <template #toolbar>
          <a-button type="primary" @click="handleAdd">新增凭证</a-button>
      </template>
      <template #certType="{record}">
          <div> 
              <!-- <span>{{ loadCerType(record.certType) }}</span> -->
          </div>
        </template>
        <template #algorithmType="{record}">
          <div> 
              <!-- <span>{{ loadCerAlgorithmType(record.algorithmType) }}</span> -->
          </div>
        </template>
        <template #certStatus="{record}">
          <div> 
            <!-- <a-tag :color="record.certStatus==1?'#87d068':'#f50'">{{ loadCerStatus(record.certStatus) }}</a-tag> -->
          </div>
        </template>
        <template #action="{record}">
          <a-button type="link">停用</a-button>
          <a-button type="link" @click="handleEdit(record)">编辑</a-button>
        </template>
        
    </BasicTable>
  </div>
  <AddAuthorizationModal @register="registerModal" @success="handleSuccess"></AddAuthorizationModal>
</template>

<script lang="ts">
  import {ref,defineComponent} from "vue"
  import { BasicTable,useTable } from '/@/components/Table';
  import Icon from "/@/components/Icon";
  import { authorizationColumn,authorizationFormSchema } from './data';
  import { developerManageList } from '/@/api/interface';
  import AddAuthorizationModal from "./modal/AddAuthorizationModal.vue"
  import { useModal } from '/@/components/Modal';
    
  export default defineComponent({
    name:"authorization",
    components:{
      Icon,
      BasicTable,AddAuthorizationModal
    },
    setup() {
      
      const [registerModal, { openModal }] = useModal();
      
      const [registerTable,{}] = useTable({
          title: '',
          titleHelpMessage: [],
          api: developerManageList,
          columns:authorizationColumn,
          immediate:true,
          fetchSetting:{
            listField:'records'
          },
          formConfig: {
            labelWidth: 80,
            schemas: authorizationFormSchema,
          },
          rowKey:'id',
          useSearchForm: true,
          showIndexColumn: false,
          canResize: false,
          isTriggerSelect:false,
          striped:false,
          bordered:false,
          showTableSetting: false,
          tableSetting: { fullScreen: false ,redo:true,setting:false,size:false,align:'right'},
          pagination:true,
      }); 
      function handleAdd(){
        openModal(true)
      }
      function handleEdit(item){
        openModal(true,{
          isUpdate:true,
          record:item
        })
      }
      function handleSuccess(){
        
      }
      return {
        registerTable,registerModal,handleSuccess,handleAdd,handleEdit
        // loadCerStatus, loadCerAlgorithmType, loadCerType

      }
    }
  })
</script>

<style lang="less" scoped>
</style>
