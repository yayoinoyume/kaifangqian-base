<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <a-form  :model="dataForm" name="basic" :labelCol="{ style: 'width: 100px' }"
          aut="off" ref="dataFormRef" >
          
          <a-form-item label="模板名称" name="templateName"
              :rules="[{ required: true, message: '请输入模板名称' }]">
            <a-input v-model:value="dataForm.templateName"  size="middle" placeholder="请输入模板名称" class="input-width" />
          </a-form-item>
          <!-- <a-form-item label="业务类型" name="businessType"
              :rules="[{ required: true, message: '请选择业务类型' }]">
            <a-select v-model:value="dataForm.businessType" :options="businessType" placeholder="请选择业务类型">
            </a-select>
          </a-form-item> -->
          <a-form-item label="模板说明" name="note"
              :rules="[{ required: true, message: '请输入模板说明' }]">
            <a-textarea  v-model:value="dataForm.note" size="middle" :autosize="{ minRows: 3, maxRows: 3 }" :rows="3"  class="input-width" />
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
  import {saveFolder} from "../api"
  import {templateEdit,getTemplateInfo} from "../api"
   // import {businessType} from "../../doc/data"
  export default defineComponent({
    name: 'AddTemplateModal',
    components:{
      BasicModal,
      BasicTree,
      BasicTable
    },
    setup(_,{emit}){
      const isUpdate = ref(true);
      const record = {};
      const { createMessage: msg } = useMessage();
      const getTitle = ref('编辑模板');
      const dataFormRef = ref();
      const treeData = ref([]);
      const SHOW_PARENT = TreeSelect.SHOW_PARENT;
      const dataForm = ref({
          templateName:"",
          templateId: "",
          businessType: "",
          note: "",
      });
      const fieldNames ={children:'children', label:'name', value: 'key' }
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:600,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        treeData.value = data.treeData;
        console.log(treeData.value);
        if(dataFormRef.value){
          dataFormRef.value.resetFields();
        }
        dataForm.value.templateId = data.record.id;
        await buildTemplateInfo(data.record.id);
      });
      async function buildTemplateInfo(templateId){
         const result = await getTemplateInfo({templateId:templateId});
         dataForm.value.templateName = result.templateVo.templateName;
         dataForm.value.businessType = result.templateVo.businessType;
         dataForm.value.note = result.templateVo.note;
      }
      
      async function handleSubmit(){
        
        const result = await templateEdit(dataForm.value);
        if(result.code == 200){
          message.success("保存成功");
          emit("success")
          closeModal();
        }
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
