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
<script lang='ts'>
  import { defineComponent,ref,unref,computed } from 'vue';
  import { BasicForm, useForm } from '/@/components/Form';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { tableFormSchema } from '../data';
  import { updateSensitive, addSensitive} from '/@/api/sys/safe';

  export default defineComponent({
    name: 'SensitiveModal',
    components:{
      BasicModal,
      BasicForm
    },
    setup(_,{emit}){
      const isUpdate = ref(true);
      const recordId = ref('');
      const recordInfo = ref();
      const { createMessage: msg } = useMessage();

      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        resetFields()
        setModalProps({ 
          confirmLoading: false,
          width:800,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          recordId.value = data.record.id;
          recordInfo.value = data.record;
          setFieldsValue({
            ...data.record,
            sensitiveType:data.record.sensitiveType==='phone'?1:0
          });
        }
      });

      const getTitle = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));


      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 100,
        schemas: tableFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });
    
      async function handleSubmit(){
        try {
          const values = await validate();

          setModalProps({ confirmLoading: true });
          let result;
          if(!unref(isUpdate)){
              result = await addSensitive({...unref(recordInfo),...values,sensitiveType:values.sensitiveType===0?'password':'phone'});
          }else{
              result = await updateSensitive({...unref(recordInfo),...values,sensitiveType:values.sensitiveType===0?'password':'phone'});
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
        registerForm
      }
    },
  })
</script>
<style>
 
</style>
