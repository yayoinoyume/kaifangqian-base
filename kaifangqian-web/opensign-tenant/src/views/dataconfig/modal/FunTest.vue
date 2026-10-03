<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" title="功能测试" @ok="handleSubmit">
      
          测试 功能
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { tableFormSchema } from '../data'


  export default defineComponent({
    name: 'DictModal',
    components:{
      BasicModal,
      BasicForm,
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const rowId = ref('');
      const tinymceValue = ref();

      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 100,
        schemas: tableFormSchema,
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
          rowId.value = data.record.id;
          setFieldsValue({
            ...data.record,
          });
        }
      });

      const getTitle = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          // TODO custom api
          console.log(values);
          closeModal();
          emit('success', { isUpdate: unref(isUpdate), values: { ...values, id: rowId.value } });
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
