<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" @cancel="handleCancel">
      <BasicForm @register="registerForm">
        <template #content>
            <Tinymce v-model="tinymceValue" @change="handleTinymceChange" width="100%" :showImageUpload="false" />
        </template>
      </BasicForm>
    </BasicModal>
  </div>
</template>
<script lang='ts'>

import { defineComponent, ref,computed, unref} from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { useMessage } from '/@/hooks/web/useMessage';
import { BasicForm,useForm } from '/@/components/Form';
import { Tinymce } from '/@/components/Tinymce';
import { tinyFormSchema } from '../data';
import { setProtocol } from '/@/api/protocol';

export default defineComponent({
  name: 'PrivacyForm',
  components:{
    BasicModal,
    BasicForm,
    Tinymce
  },
  setup(_,{emit}){

    const recordId = ref('');
    const tinymceValue = ref('')
    
    
    const { createMessage: msg } = useMessage();
   
     
    const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭',
          maskClosable:false,
        });
        recordId.value = data?.record?.id;
        tinymceValue.value = data?.record?.mediateContent
    });

    const [registerForm, { }] = useForm({
        labelWidth: 100,
        schemas: tinyFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });
    const getTitle = computed(()=>('隐私政策'));
      async function handleOk(){
       
      }
      function handleTinymceChange(){
        
      }
      function handleCancel(){
        closeModal()
      }
      async function handleSubmit(){

        let params = {
          value:tinymceValue.value,
          id:unref(recordId),
          type:'privacy'
        }
        let result = await setProtocol(params)
        if(result){
          closeModal();
          emit('success')
          msg.success('操作成功')
        }
       
      }

    

      return {
        registerModal,
        handleSubmit,
        getTitle,
        handleOk,
        handleCancel,
        registerForm,
        tinymceValue,
        handleTinymceChange
      }
  }
})
</script>
<style lang="less" scoped>
</style>
