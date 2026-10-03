<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
       <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" :destroyOnClose="true">
        <BasicForm @register="registerForm" >
        </BasicForm>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { treeFormSchema } from '../data';
  import { addDictGroup,editDictGroup,getDictInfo } from '/@/api/dict';
  import { useMessage } from '/@/hooks/web/useMessage';


  export default defineComponent({
    name: 'DictTreeModal',
    components:{
      BasicModal,
      BasicForm,
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const rowId = ref('');
      const tinymceValue = ref();
      const treeType = ref('');
      const getTitle = ref('');
      const { createMessage: msg } = useMessage();

      const [registerForm, { setFieldsValue, resetFields, validate, updateSchema,clearValidate }] = useForm({
        labelWidth: 100,
        schemas: treeFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        resetFields();
        isUpdate.value = !!data?.isUpdate;
        setModalProps({ 
          confirmLoading: false,
          width:800,
          cancelText:'关闭' 
        });
        treeType.value = data.record.type;
        if(unref(treeType)==='group'){
          updateSchema([
            {field:'parentId',label:'所属上级'},
            {field:'dictName',label:'分类名称'},
            {field:'dictCode',label:'分类编码'},
          ])
          getTitle.value = !unref(isUpdate) ? '新增字典分类' : '编辑字典分类';
        }else{
           updateSchema([
            {field:'parentId',label:'所属分类',required:false},
            {field:'dictName',label:'字典名称'},
            {field:'dictCode',label:'字典编码'},
          ])
          getTitle.value = !unref(isUpdate) ? '新增字典' : '编辑字典';
        }
        if (unref(isUpdate)) {
          rowId.value = data.record.id;
          let result = await getDictInfo({id:data.record.id});
          if(result){
            setFieldsValue({
              ...result,
            });
          }
          clearValidate()
        }else{
           rowId.value = '';
        }
        if(data.detail){
          updateSchema([
              { field: 'parentId', componentProps: { disabled: false } },
              { field: 'dictName', componentProps: { disabled: true } },
              { field: 'dictCode', componentProps: { disabled: true } },
              { field: 'sortOrder', componentProps: { disabled: true } },
              { field: 'status',   componentProps: { disabled: true } },
              { field: 'description', componentProps: { disabled: true } },
          ]);
        }else{
            updateSchema([
              { field: 'parentId', componentProps: { disabled: false } },
              { field: 'dictName', componentProps: { disabled: false } },
              { field: 'dictCode', componentProps: { disabled: false } },
              { field: 'sortOrder', componentProps: { disabled: false } },
              { field: 'status',   componentProps: { disabled: false } },
              { field: 'description', componentProps: { disabled: false } },
          ]);
        }
      });

    

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          // TODO custom api
          console.log(values);
          let result;
          let params = {
            ...values,
            status:values.status?1:0,
            type:unref(treeType),
            id:unref(rowId)
          }
          if(!unref(isUpdate)){
              result = await addDictGroup(params);
          }else{
              result = await editDictGroup(params);
          }
          if(result){
            msg.success('保存成功');
            closeModal();
            emit('success', { isUpdate: unref(isUpdate), values: { ...values, id: rowId.value } });
          }
         
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      function handleTinymceChange(value: string) {
        console.log(value);
      }

      return { registerModal, registerForm, getTitle, handleSubmit,tinymceValue,handleTinymceChange };
    }
  })
</script>
<style>
 
</style>
