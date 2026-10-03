<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <a-form  :model="dataForm" name="basic" :labelCol="{ style: 'width: 100px' }"
          aut="off" ref="dataFormRef" >
          <a-form-item label="目标文件夹" name="targetFolderId">
            <a-tree-select
                v-model:value="dataForm.targetFolderId"
                style="width: 100%"
                :tree-data="treeData"
                :field-names = "fieldNames"
                allow-clear
                :show-checked-strategy="SHOW_PARENT"
                placeholder="请选择要移动的文件夹"
                tree-node-filter-prop="label"
              />
          </a-form-item>
        </a-form>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref } from 'vue';
  import { BasicTree,TreeItem } from '/@/components/Tree/index';
  import { BasicTable, useTable} from '/@/components/Table';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { getAuthGroup,setOrgAuthData } from '/@/api/auth/group';
  import { useMessage } from '/@/hooks/web/useMessage'; 
  import { TreeSelect,message } from 'ant-design-vue';
  import {templateFolderMove,templateFolderJoin} from "../api"
  export default defineComponent({
    name: 'AddTemplateModal',
    components:{
      BasicModal,
      BasicTree,
      BasicTable
    },
    setup(_,{emit}){
      const isUpdate = ref(true);
      const getTitle = ref('移动模板');
      const dataFormRef = ref();
      const treeData = ref([]);
      const record = ref({})
      const SHOW_PARENT = TreeSelect.SHOW_PARENT;
      const dataForm = ref({
          targetFolderId:null,
          ids:[] as any,
      });
      const fieldNames ={children:'children', label:'name', value: 'key' }
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:600,
          height:200,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        treeData.value = data.treeData;
        record.value = data.record;
        dataForm.value.ids.push(data.record.id);
        if(dataFormRef.value){
          dataFormRef.value.resetFields();
        }
      });
      
      
      async function handleSubmit(){
        try {
          //spinning.value = true;
          const values = await dataFormRef.value.validateFields();
          const response = await templateFolderMove(dataForm.value);
         if(response.code == 200){
            message.success("模板移动成功！");
            //router.push("/template/manage")
            emit("success")
            closeModal();
          }
        } catch (errorInfo) {
          console.log('Failed:', errorInfo);
          message.warning("有必填参数未填");
        }
        // const result = await saveFolder(dataForm.value);
        // if(result.code == 200){
        //   message.success("保存成功");
        //   emit("success")
        //   closeModal();
        // }
      }
      

      return {
        registerModal,
        handleSubmit,treeData,SHOW_PARENT,
        getTitle,dataForm,dataFormRef,fieldNames
      }
    },
  })
</script>
<style>
 
</style>
