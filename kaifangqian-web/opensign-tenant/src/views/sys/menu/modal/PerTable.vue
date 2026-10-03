<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
         <div class="resrun-tree-table">
              <BasicTable @register="registerTable" 
                :rowSelection="{ type: 'checkbox', selectedRowKeys: checkedKeys, onChange: onSelectChange }">
              </BasicTable>
         </div>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref } from 'vue';
  import { BasicTable, useTable} from '/@/components/Table';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { getAuthTable } from '/@/api/auth/group';
  import { tableColumns,searchTableFormSchema } from '../menu.data';
  import { useMessage } from '/@/hooks/web/useMessage';

  export default defineComponent({
    name: 'PerTable',
    components:{
      BasicModal,
      BasicTable
    },
    setup(_,{emit}){
      const isUpdate = ref(true);
      const getTitle = ref('权限表');
      const currentGroupId = ref('');
      const checkedKeys = ref<Array<string | number>>([]);
      const { createMessage: msg } = useMessage();
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        clearSelectedRowKeys()
      });

      const [registerTable,{ reload ,setProps,getSelectRows,clearSelectedRowKeys}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getAuthTable,
        columns: tableColumns,
        immediate:true,
        useSearchForm: true,
        rowKey:'id',
        showDragColumn:false,
        showIndexColumn: false,
        isTriggerSelect:false,
        fetchSetting:{
          listField:'records'
        },
        bordered: false,
        formConfig: {
          labelWidth: 50,
          schemas:searchTableFormSchema
        },
        canResize: false,
        striped:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
      });
      async function handleSubmit(){
        if(checkedKeys.value.length !== 1){
          msg.warning('只能选择一条数据')
        }
        let record = await getSelectRows();
        emit('success',record)

      }
      function onSelectChange(selectedRowKeys: (string | number)[]) {
        checkedKeys.value = selectedRowKeys;
      }
      function onTreeSelect(keys,e){
        if(keys.length){
          currentGroupId.value = keys[0];
          setProps({
            searchInfo:{parentId:unref(currentGroupId)}
          })
          reload();
        }
      }

      return {
        registerModal,
        handleSubmit,
        getTitle,
        onTreeSelect,
        registerTable,
        checkedKeys,
        onSelectChange
      }
    },
  })
</script>
<style lang="less" scoped>
 
</style>
