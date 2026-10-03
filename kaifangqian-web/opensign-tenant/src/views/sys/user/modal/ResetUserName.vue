<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
           <Form  class="p-2 enter-x" :model="formData" :rules="getFormRules" ref="formRef" :labelCol="{span:3}">
              <FormItem name="mobile" class="enter-x" label="用户名">
                  <Input
                    size="large"
                    v-model:value="formData.username"
                    placeholder="用户名"
                    class="fix-auto-fill"
                  />
                </FormItem>
          </Form>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed,reactive } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { unBindEmail,bindEmail } from '/@/api/sys/user';
  import { Form, Input,Row, Col } from 'ant-design-vue';
  import { useFormRules } from '/@/views/sys/login/useLogin';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { updateUserRealname } from '/@/api/sys/user';


  export default defineComponent({
    name: 'AnnounceFormModal',
    components:{
      BasicModal,
      Form,
      FormItem:Form.Item,
      Input,
      Row, Col
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const { createMessage: msg } = useMessage();
      const formData = reactive({
        username:""
      })
    
      const { getFormRules } = useFormRules();
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ confirmLoading: false,width:550, });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          formData.username = data.record.username;
        }
         
      });
      const getTitle = computed(() => (unref(isUpdate) ? '修改用户名' : '修改用户名'));

      async function handleSubmit() {
        try {
          setModalProps({ confirmLoading: true });
          // TODO custom api
          let params = {
            realname:formData.username
          }
          let result = await updateUserRealname(params);
          if(result){
            closeModal();
            msg.success('操作成功');
            emit('success' );
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
     

      return { registerModal,formData,getFormRules, getTitle, handleSubmit};
    }
  })
</script>
<style >
 
</style>
