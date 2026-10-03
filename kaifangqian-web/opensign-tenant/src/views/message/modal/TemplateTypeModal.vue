<!--
  @description 资助审批电子签章系统
-->

<template>
    <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <BasicForm @register="registerForm" >
          
        </BasicForm>
      </BasicModal>
    </div>
  </template>
  <script lang="ts">
    import { defineComponent,ref, unref, computed } from 'vue';
    import { BasicModal, useModalInner } from '/@/components/Modal';
    import { BasicForm, useForm } from '/@/components/Form';
    import { templateTypeForm } from '../data';
    import { addTemplateType,editTemplateType } from '/@/api/message'; 
    import { useMessage } from '/@/hooks/web/useMessage';
  
    export default defineComponent({
      name:'TempalteTypeModal',
      components: { BasicForm, BasicModal},
      setup(_,{emit}) {
        const isUpdate = ref(true);
        const rowId = ref('');
        const { createMessage: msg } = useMessage();
        const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
          setModalProps({ confirmLoading: false,width:1200 });
          isUpdate.value = !!data?.isUpdate;
          if (unref(isUpdate)) {
            console.log(data.record,'回显数据。。。。')
            rowId.value = data.record.id;
            setFieldsValue({
              ...data.record,
            });
          }else{
            resetFields();
            rowId.value = '';
          }
            
        });
        const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
          labelWidth: 100,
          schemas: templateTypeForm,
          showActionButtonGroup: false,
          actionColOptions: {
            span: 23,
          },
        });
        const getTitle = computed(() => (unref(isUpdate) ? '编辑模板类型':'新增模板类型'));
        async function handleSubmit(){
          try {
            const values = await validate();
            setModalProps({ confirmLoading: true });
            // TODO custom api
            let result;
            if(!unref(isUpdate)){
                result =  await addTemplateType(values);
                msg.success('新增成功');
            }else{
                result = await editTemplateType({id:unref(rowId),...values});
                msg.success('编辑成功');
            }
            if(result){
              closeModal();
              emit('success', { isUpdate: unref(isUpdate), values: { ...values, id: rowId.value } });
            }
          } finally {
            setModalProps({ confirmLoading: false });
          }
          closeModal()
  
        }
  
        return {
          registerModal,
          registerForm,
          getTitle,
          handleSubmit
        };
      },
    });
  </script>
  <style lang="less" scoped>
  .detail-header{
    .detail-title{
      font-size: 18px;
      font-weight: 6000;
    }
  }
  </style>
  