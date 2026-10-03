<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit"  wrapClassName="business-line-modal">
    <BasicForm @register="registerForm">
      <template #folderId="{model,field}">
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
  import {lineCreateFormSchema} from '../data';
  import { createBusinessLine, moveBusinessLine, getBusinessLineGroupList } from '/@/api/businessLine';
  // import { getPopupContainer } from '/@/utils';
  import { useRouter } from 'vue-router';
  export default defineComponent({
    name: 'BusinessModal',
    components: { 
      BasicModal, 
      BasicForm
    },
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const isUpdate = ref(true);
      const rowId = ref('');
      const treeData:any = ref([]);

      const router = useRouter();

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
     
        setModalProps({ 
          confirmLoading: false,
          width:500,
          zIndex:999,
          // minHeight:160,
          // getContainer: () => document.body.querySelector('.business-line-list') || document.body,
        });
        isUpdate.value = !!data?.isUpdate;
        rowId.value = data?.record.id;
        if(unref(isUpdate)){
          setFieldsValue({
            ...data.record
          })
        }else{
          setFieldsValue({
            name:'',
            folderId:''
          })
        }
        let result = await getBusinessLineGroupList({})
        if(result){
          treeData.value = result;
        }
        clearValidate()

      });
      const [registerForm, {setFieldsValue ,resetFields, validate, clearValidate }] = useForm({
        labelWidth: 50,
        schemas: lineCreateFormSchema,
        showActionButtonGroup: false,
        actionColOptions: {
          span: 23,
        },
      });

      const getTitle = computed(() => (!unref(isUpdate) ? '业务线创建' : '业务线迁移'));

      async function handleSubmit() {
        try {
          let data = await validate();
          let result = null;
          if(unref(isUpdate)){  
            result  = await moveBusinessLine({...data,signReId:unref(rowId)})
          }else{
            result  = await createBusinessLine({...data})
          }
         
          if(result){
            emit('success');
            closeModal();
            if(typeof result == 'string'){
              // window.open(import.meta.env.VITE_PUBLIC_PATH +'#/businessLine/config?__full__&signReId=' + result)
              router.push({
                path:"/businessLine/config",
                query:{
                  __full__:'',
                  signReId:result
                }
              })
            }
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
<style lang="less" scoped>



</style>
