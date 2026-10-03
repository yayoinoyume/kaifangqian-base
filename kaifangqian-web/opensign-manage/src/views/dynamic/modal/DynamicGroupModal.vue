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
  import { defineComponent,ref,unref,computed, reactive } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { Icon } from '/@/components/Icon';
  import { createArticleGroupFormSchema } from '../data';
  import { addArticleGroup, editArticleGroup } from '/@/api/article';
  import { PlusOutlined } from '@ant-design/icons-vue';
  import { useMessage } from '/@/hooks/web/useMessage';

  export default defineComponent({
    name: 'DynamicGroupModal',
    components:{
      BasicModal,
      BasicForm,
      PlusOutlined,
      Icon,
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const recordId = ref('');
      const { createMessage: msg } = useMessage();
      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 100,
        schemas: createArticleGroupFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        resetFields();
        setModalProps({ 
          confirmLoading: false,
          width:500,
          height:80,
          minHeight:80,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        recordId.value = data?.record?.recordId;
        // setFieldsValue({
        //     ...data.record,
        //   })
      });

  
      const getTitle = computed(() => (!unref(isUpdate) ? '新增分类' : '编辑分类'));

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          // TODO custom api
          let result = reactive({});
          if(!unref(isUpdate)){
             result = await addArticleGroup({...values})
          }else{
            result = await editArticleGroup({
              ...values,
              id:unref(recordId),
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
     

      return { 
          registerModal,
          getTitle,
          registerForm,
          handleSubmit
      
      };
    }
  })
</script>
<style lang="less">
 
</style>
