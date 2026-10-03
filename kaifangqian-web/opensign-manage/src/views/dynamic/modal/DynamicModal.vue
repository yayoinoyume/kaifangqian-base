<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
         <BasicForm @register="registerForm" >
          <template #content="{model,field}">
            <Tinymce v-model="model[field]" @change="handleTinymceChange" width="100%" :showImageUpload="false" />
        </template>
        </BasicForm>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed, reactive } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { Icon } from '/@/components/Icon';
  import { createArticleFormSchema } from '../data';
  import { addArticleAdd, editArticle, getArticleInfo } from '/@/api/article';
  import { PlusOutlined } from '@ant-design/icons-vue';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { Tinymce } from '/@/components/Tinymce';

  export default defineComponent({
    name: 'DynamicModal',
    components:{
      BasicModal,
      BasicForm,
      PlusOutlined,
      Icon,
      Tinymce
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const recordId = ref('');
      const recordInfo =ref();
      const tinymceValue = ref('')
      const { createMessage: msg } = useMessage();
      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 100,
        schemas: createArticleFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        resetFields();
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          recordId.value = data.record.id;
          let result = await getArticleInfo({id:recordId.value })
          recordInfo.value = result;
          setFieldsValue({
            ...result,
          });
        }else{
           recordId.value = '';
        }
      });

  
      const getTitle = computed(() => (!unref(isUpdate) ? '新增文章' : '编辑文章'));

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          let result = reactive({});
          if(!unref(isUpdate)){
             result = await addArticleAdd({...values,status:0})
          }else{
            result = await editArticle({
              ...unref(recordInfo),
              ...values,
            })
          }
          if(result){
            msg.success('操作成功');
            emit('success');
            closeModal();
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }

      function handleTinymceChange(){
        
      }
     

      return { 
          registerModal,
          getTitle,
          registerForm,
          handleTinymceChange,
          handleSubmit,
          tinymceValue
      
      };
    }
  })
</script>
<style>
 
</style>
