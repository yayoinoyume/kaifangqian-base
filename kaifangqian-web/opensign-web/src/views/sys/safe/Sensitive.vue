<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicTable @register="registerTable"  :rowSelection="{ type: 'checkbox', selectedRowKeys: checkedKeys, onChange: onSelectChange }"> 
          <template #toolbar>
            <!-- <a-button type="primary" @click="handleAdd">添加</a-button> -->
            <a-button type="danger" @click="handleDeleteBatch">批量删除</a-button>
          </template>
          <template #action="{ record, column }">
            <TableAction :actions="createActions(record, column)" />
          </template>
          <template #sensitiveFlag="{record}">
            <span>{{record.sensitiveFlag?'开启':'关闭'}}</span>
          </template>
          <template #validateMethods="{record}">
            <span>{{record.sensitiveType?(record.sensitiveType === 'password'?'密码校验':'短信校验'):''}}</span>
          </template>
          <template #customTitle>
            <Tooltip placement="topLeft" title="当状态为开启，进行该操作时需要进行二次身份校验">
              <span>状态<Icon icon="ant-design:question-circle-outlined"/></span>
            </Tooltip>
          </template>
      </BasicTable>
    <SensitiveModal @register="registerSensitiveModal" @success="handleSuccess"/>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref} from 'vue';
  import {    
    BasicTable,
    useTable,
    TableAction,
    BasicColumn,
    ActionItem,
    EditRecordRow  } from '/@/components/Table';
  import { sensitiveColumn,searchFormSchema } from './data';
  import { useModal } from '/@/components/Modal';
  import {getSensitiveList,deleteSensitive} from '/@/api/sys/safe';
  import { useMessage } from '/@/hooks/web/useMessage';
  import SensitiveModal from './modal/SensitiveModal.vue';
  import Icon from '/@/components/Icon';
  import { Tooltip } from 'ant-design-vue';



  export default defineComponent({
    name: 'Sensitive',
    components:{
      BasicTable,TableAction,SensitiveModal,Icon,Tooltip
    },
    setup(){
      const checkedKeys = ref<Array<string | number>>([]);
      const { createMessage: msg } = useMessage();
      const [registerSensitiveModal, { openModal,closeModal }] = useModal();
      const [registerTable,{reload}] = useTable({
          title: '',
          titleHelpMessage: [],
          api: getSensitiveList,
          // rowSelection:{
          //   type: 'checkbox',
          // },
          isTriggerSelect:false,
          fetchSetting:{
            listField:'records'          
          },
          rowKey:'id',
          columns:sensitiveColumn,
          useSearchForm: true,
          showIndexColumn: true,
          canResize: false,
          striped:false,
          showTableSetting: false,
          formConfig: {
            labelWidth: 120,
            schemas:searchFormSchema
          },
          tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
          actionColumn: {
            width: 160,
            title: '操作',
            dataIndex: 'action',
            slots: { customRender: 'action' },
          },
      });
      function handleEdit(record: EditRecordRow) {
        openModal(true,{
          isUpdate:true,
          record:{
            ...record
          }
        })
      }

      async function handleDelete(record: EditRecordRow) {
        let result = await deleteSensitive({ids:[record.id].join(',')});
        if(result){
          msg.success('删除成功');
          reload();
        }
      }
      async function handleDeleteBatch(){
        console.log(unref(checkedKeys))
        if(!unref(checkedKeys).length){
          msg.warning('请勾选要删除的项目');
          return; 
        }
        let result = await deleteSensitive({ids:unref(checkedKeys).join(',')});
        if(result){
          msg.success('删除成功');
          reload();
        };
      }
      function createActions(record: EditRecordRow, column: BasicColumn): ActionItem[] {
        return [
            {
              label: '配置',
              // disabled: currentEditKeyRef.value ? currentEditKeyRef.value !== record.key : false,
              onClick: handleEdit.bind(null, record),
            },
            {
              label: '删除',
              popConfirm: {
                title: '是否确认删除',
                confirm: handleDelete.bind(null, record),
              },
              // onClick: handleDelete.bind(null, record),
            }
          ];
      }
      function handleAdd(){
        openModal(true,{
          isUpdata:false
        })
      }
      function handleSuccess(){
        closeModal();
        reload()
      }
      function onSelectChange(selectedRowKeys: (string | number)[]) {
        console.log(selectedRowKeys);

        checkedKeys.value = selectedRowKeys;
      }
      return {
        registerTable,
        createActions,
        registerSensitiveModal,
        handleSuccess,
        handleAdd,
        onSelectChange,
        checkedKeys,
        handleDeleteBatch
      }
    }
  })
</script>
<style>
 
</style>
