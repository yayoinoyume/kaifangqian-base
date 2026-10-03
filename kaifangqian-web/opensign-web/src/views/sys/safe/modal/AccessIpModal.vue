<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <a-alert type="info" show-icon>
         <template #message>
              <span>设置后用户可在一下IP环境中登录</span>
          </template>
        </a-alert>
        <BasicTable @register="registerTable" >
            <template #action="{ record, column, index }">
                <TableAction :actions="createActions(record, column, index)" />
            </template>
          </BasicTable>
         <a-button  type="dashed" @click="handleAdd">新增 </a-button>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed } from 'vue';
  import { BasicTable, useTable, EditRecordRow, BasicColumn, ActionItem, TableAction } from '/@/components/Table';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { accessIPColumns } from '../data';
  import { getIpList, addIpLimit, updateIpList} from '/@/api/sys/safe';

  export default defineComponent({
    name: 'AccessIpModal',
    components:{
      BasicTable,
      BasicModal,
      TableAction
    },
    setup(_,{emit}){
      const isUpdate = ref(true);
      const recordId = ref('');
      const recordInfo = ref();
      const ipType = ref('');

      const { createMessage: msg } = useMessage();
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        // setTableData([])
        setModalProps({ 
          confirmLoading: false,
          width:800,
          cancelText:'关闭' 
        });
        ipType.value = data.ipType
        setProps({
            searchInfo:{type:ipType.value}
        });
        reload();
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          recordId.value = data.record.id;
          recordInfo.value = data.record;
        }
      });

      const getTitle = computed(() => (!unref(isUpdate) ? 'IP限制' : 'IP限制'));


      const [registerTable, { reload,setProps,getDataSource,setTableData }] = useTable({
        columns: accessIPColumns,
        api:getIpList,
        showIndexColumn: true,
        dataSource: [],
        striped:false,
        immediate:false,
        size:'small',
        fetchSetting:{
          listField:'records'
        },
        actionColumn: {
          width: 160,
          title: '操作',
          dataIndex: 'action',
          slots: { customRender: 'action' },
        },
        pagination: false,
      });

      function handleDelete(record: EditRecordRow, index) {
        const data = getDataSource();
        data.splice(index,1)
      }
      function handleAdd() {
        const data = getDataSource();
        const addRow: EditRecordRow = {
          type: '',
          content: '',
          length: '',
          editable: true,
          isNew: true,
          key: `${Date.now()}`,
        };
        data.push(addRow);
      }


      function createActions(record: EditRecordRow, column: BasicColumn, index: number): ActionItem[] {
          return [
            {
              label: '删除',
              onClick: handleDelete.bind(null, record, index),
              // icon:'ant-design:minus-square-outlined'
            },
          ];
      }

    
      async function handleSubmit(){
        try {
          const tableData = await getDataSource();
          setModalProps({ confirmLoading: true });
          let result;
          if(!unref(isUpdate)){
              result = await addIpLimit({...unref(recordInfo),...values});
          }else{
              result = await updateIpList({...unref(recordInfo),...values});
          }
          if(result){
            msg.success('保存成功');
            closeModal();
            emit('success');
          }else{
            msg.warning(result.message)
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      return {
        registerModal,
        handleSubmit,
        getTitle,
        registerTable,
        createActions,
        handleAdd
      }
    },
  })
</script>
<style lang="less" scoped>
:deep(.ant-table-wrapper){
  border: 1px solid #e4e4e4;
  padding: 0;
  height: 300px;
  .ant-table-body{
    height:auto;
  }
}
.resrun-basic-table{
  margin-left:0;
  margin:5px 0;
}
 
</style>
