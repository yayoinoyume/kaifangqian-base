<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <!-- <a-button  type="dashed" @click="handleAdd"> <template #icon><PlusOutlined /></template>新建 </a-button> -->
        <!-- <BasicTable @register="registerTable" style="height:auto">
           <template #action>
              <Icon icon="ant-design:plus-square-outlined" :size="24"  @click="handleAdd"/>
              <Icon icon="ant-design:minus-square-outlined" :size="24"  @click="handleAdd"/>
           </template>
        </BasicTable> -->
        <BasicForm @register="registerForm" >
        </BasicForm>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed,reactive } from 'vue'
  import { BasicTable, useTable, EditRecordRow, BasicColumn, ActionItem, TableAction } from '/@/components/Table';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { Icon } from '/@/components/Icon'
  import { createFormSchema,createGroupColumns } from '../data';
  import { PlusOutlined } from '@ant-design/icons-vue';
  import { addAuth,editAuth } from '/@/api/auth/group';
  import { useMessage } from '/@/hooks/web/useMessage';



  export default defineComponent({
    name: 'DictModal',
    components:{
      BasicTable,
      BasicModal,
      BasicForm,
      PlusOutlined,
      TableAction,
      Icon
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const recordId = ref('');
      const tinymceValue = ref();
      const { createMessage: msg } = useMessage();
      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 50,
        schemas: createFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        resetFields()
        setModalProps({ 
          confirmLoading: false,
          width:800,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          recordId.value = data.record.id;
          setFieldsValue({
            ...data.record,
          });
        }
      });

      const [registerTable, { getDataSource }] = useTable({
        columns: createGroupColumns,
        dataSource: [{
          type: '',
          content: '',
          length: '',
          editable: true,
          isNew: true,
          key: `${Date.now()}`,
        }],
        maxHeight:200,
        showIndexColumn: false,
        pagination: false,
        actionColumn: {
          width: 80,
          title: '#',
          dataIndex: 'action',
          slots: { customRender: 'action' },
        },
      });

      const getTitle = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          // TODO custom api
          let result = reactive({});
          if(!unref(isUpdate)){
             result = await addAuth(values)
          }else{
            result = await editAuth({
              ...values,
              id:unref(recordId)
            })
          }
          if(result){
            msg.success('操作成功')
            closeModal();
            emit('success');
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      function handleTinymceChange(value: string) {
        console.log(value);
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
      function createActions(record: EditRecordRow, column: BasicColumn): ActionItem[] {
        if (!record.editable) {
          return [
            {
              label: '编辑',
              onClick: handleAdd.bind(null, record),
            },
            {
              label: '删除',
            },
          ];
        }
        return [
          {
            label: '保存',
            onClick: handleAdd.bind(null, record, column),
          },
          {
            label: '取消',
            popConfirm: {
              title: '是否取消编辑',
              confirm: handleAdd.bind(null, record, column),
            },
          },
        ];
      }

      return { 
          registerModal,tinymceValue,handleTinymceChange,
          createActions,
          registerTable,
          registerForm,
          handleAdd,
          getTitle,
          handleSubmit
      
      };
    }
  })
</script>
<style>
 
</style>
