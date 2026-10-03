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
  import { createAuthGroupFormSchema } from '../data';
  import { addAuth,editAuth,getAuthGroupInfo } from '/@/api/auth/group';
  import { PlusOutlined } from '@ant-design/icons-vue';
  import { useMessage } from '/@/hooks/web/useMessage';

  export default defineComponent({
    name: 'GroupModal',
    components:{
      BasicModal,
      BasicForm,
      PlusOutlined,
      Icon
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const recordId = ref('');
      const { createMessage: msg } = useMessage();
      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 100,
        schemas: createAuthGroupFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        resetFields();
        setModalProps({ 
          confirmLoading: false,
          width:800,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          recordId.value = data.record.id;
          let result = await getAuthGroupInfo({id:recordId.value })
          setFieldsValue({
            ...result,
          });
        }else{
           recordId.value = '';
        }
      });

  
      const getTitle = computed(() => (!unref(isUpdate) ? '新增权限组分类' : '编辑权限组分类'));

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
<style>
 
</style>
