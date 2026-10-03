<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
       <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" :destroyOnClose="true">
        <BasicForm @register="registerForm" >
            <template #parentId="{ model, field }">
              <!-- <div style="flex:1"> -->
                <a-tree-select 
                      v-model:value="model[field]"
                      placeholder="请选择"
                      allow-clear
                      :fieldNames="{children:'children', label:'name', value: 'id' }"
                      tree-default-expand-all
                      :tree-data="state.treeData"
                      :disabled="parentIdDisabled"
                    >
                    </a-tree-select>
              <!-- </div> -->
            </template>
        </BasicForm>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed,reactive } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form';
  import { tableFormSchema } from '../data'
  import { addDictItem, editDictItem,getDictTreeItems } from '/@/api/dict'
  import { useMessage } from '/@/hooks/web/useMessage';


  export default defineComponent({
    name: 'DictModal',
    components:{
      BasicModal,
      BasicForm,
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const parentIdDisabled = ref(false);
      const rowId = ref('');
      const tinymceValue = ref();
      const state = reactive({
        dictId:null,
        treeData:[]
      })


      const { createMessage: msg } = useMessage();
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
        state.dictId = data?.dictId;
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          parentIdDisabled.value = data.record.parentId?false:true;
          rowId.value = data.record.id;
          setFieldsValue({
            ...data.record,
            status:data.record.status==1?true:false
          });
        }else{
            rowId.value = '';
            parentIdDisabled.value = false;
        }
        getDictItemsTreeData(state.dictId)
      });
      async function getDictItemsTreeData(dictId){
            let result = await getDictTreeItems({dictId});
            if(result){
                  state.treeData = result;
            }
        }

      const getTitle = computed(() => (!unref(isUpdate) ? '新增字典项' : '编辑字典项'));

      async function handleSubmit() {
        try {
          const values = await validate();
          setModalProps({ confirmLoading: true });
          let result;
          let params = {
              ...values,
              status:values.status?1:0,
              dictId:state.dictId,
              id:rowId.value
          }
          if(!unref(isUpdate)){
              result = await addDictItem(params);
          }else{
              result = await editDictItem(params);
          }
          if(result){
            msg.success('保存成功');
            closeModal();
            emit('success', { isUpdate: unref(isUpdate), values: { ...values, id: rowId.value } });
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      function handleTinymceChange(value: string) {
        console.log(value);
      }

      return { parentIdDisabled,registerModal, registerForm, getTitle, handleSubmit,tinymceValue,handleTinymceChange,state };
    }
  })
</script>
<style>
 
</style>
