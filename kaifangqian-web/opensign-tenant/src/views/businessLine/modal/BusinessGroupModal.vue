<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" wrapClassName="business-line-modal">
    <BasicForm @register="registerForm">
      <template #parentFolderId="{model,field}">
        <a-tree-select
            v-model:value="model[field]"
            show-search
            style="width: 100%"
            :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
            placeholder="请选择"
            allow-clear
            tree-default-expand-all
            :tree-data="treeData"
            tree-node-filter-prop="label"
            :fieldNames="{label:'name',value:'id'}"
          >
          </a-tree-select>
      </template>
    </BasicForm>
  </BasicModal>
</template>
<script lang="ts">
  import { defineComponent, ref, computed, unref } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import {lineGroupCreateFormSchema} from '../data';
  import { getBusinessLineGroupList, createBusinessGroup } from '/@/api/businessLine';

  export default defineComponent({
    name: 'BusinessGroupModal',
    components: { 
      BasicModal, 
      BasicForm
    },
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const isUpdate = ref(true);
      const rowId = ref('');
      const treeData:any = ref([]);
    

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:500,
          // minHeight:120
        });
        isUpdate.value = !!data?.isUpdate;
        rowId.value = data?.record.id;
        if(unref(isUpdate)){
          
          setFieldsValue({
            ...data.record
          })
        }else{  
          resetFields()
        }
        let result = await getBusinessLineGroupList({})
        if(result){
          treeData.value = result;
        }
      

      });
      const [registerForm, { setFieldsValue, resetFields, validate }] = useForm({
        labelWidth: 50,
        schemas: lineGroupCreateFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const getTitle = computed(() => (!unref(isUpdate) ? '分组创建' : '分组编辑'));

      async function handleSubmit() {
        try {
          let data = await validate();
          let result = await createBusinessGroup({...data,id:rowId.value})
          if(result){
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
        handleSubmit,
        registerForm,
        treeData 
      };
    },
  });
</script>
