<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
       <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" :destroyOnClose="true">
        <BasicTable @register="registerTable">

        </BasicTable>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed  } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useMessage } from '/@/hooks/web/useMessage';
  import {  BasicTable,  useTable,  } from '/@/components/Table';
  import { getRecordList } from '/@/api/contract';
  import { recordColumns } from '../data'



  export default defineComponent({
    name: 'RecordModal',
    components:{
      BasicModal,
      BasicTable,
    },
    setup(_, { emit }){

      const isUpdate = ref(true);
      const signRuId = ref('');

      const checkedKeys = ref<Array<string | number>>([]);
     
      const { createMessage: msg } = useMessage();
     

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          // cancelText:'关闭',
          showCancelBtn:false,
          showOkBtn:false, 
          canFullscreen: false, 
        });
        signRuId.value = data.record?.signRuId;
        checkedKeys.value = [];
        
      });
      const [registerTable,{getSelectRows}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getRecordList,
        columns: recordColumns,
        isTreeTable: true,
        useSearchForm: false,
        showDragColumn:false,
        showIndexColumn: false,
        bordered: false,
        fetchSetting:{
          listField:'records'
        },
        isTriggerSelect:false,
        rowKey:'sealId',
        immediate:true,
        canResize: false,
        striped:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        beforeFetch:beforeFetch
       
      });
      function beforeFetch(params){
       params.signRuId = signRuId.value;
      }
      const getTitle = computed(() => (!unref(isUpdate) ? '操作记录' : '操作记录'));

      async function handleSubmit() {
        try {
          
            closeModal();
            emit('success');
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      return { 
        registerModal, 
        getTitle, 
        handleSubmit,
        registerTable,
        checkedKeys
      };
    }
  })
</script>
<style lang="less" scoped>
  
</style>
