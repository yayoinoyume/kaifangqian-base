<!--
  @description 资助审批电子签章系统
-->

<template>
    <BasicDrawer
    v-bind="$attrs"
    @register="registerDrawer"
    showFooter
    :title="getTitle"
    width="60%"
    @ok="handleSubmit"
    >
      <Tabs>
        <TabPane key="1" tab="基本信息">
            <BasicForm @register="registerForm" >
              <template #logo="{model,field}" key="logo">
                
              </template>
            </BasicForm>
        </TabPane>
        <TabPane key="3" tab="版本管理">
            <BasicTable @register="registerTable" :rowSelection="{ type: 'checkbox',selectedRowKeys: checkedKeys, onChange: onSelectChange }"> 
                <template #toolbar>
                  <a-button type="primary" @click="handleAddVersion">添加版本</a-button>
                </template>
                <template #action="{ record }">
                  <a-button type="link" size="small" @click="handleEdit(record)">编辑</a-button>
                  <a-button type="link" size="small"  @click="handleDelete(record)">删除</a-button>
                </template>
            </BasicTable>
        </TabPane>
      </Tabs>
  </BasicDrawer>
  <VersionDrawer @register="registerVersionDrawer"/>
</template>

<script lang="ts">
import {reactive, ref,computed,unref} from "vue";
import { BasicDrawer, useDrawerInner } from '/@/components/Drawer';
import { BasicForm, useForm } from '/@/components/Form/index';
import { BasicTable,useTable   } from '/@/components/Table';
import { useDrawer } from '/@/components/Drawer';
import { Tabs } from 'ant-design-vue';
import { formSchema, appVersionColumns } from '../data';
import { addApp, updateApp, getAppInfo, getAppVersionList } from '/@/api/backstage';
import VersionDrawer from './VersionDrawer.vue';

export default{
  name:"App",
  components:{
    Tabs,  
    TabPane: Tabs.TabPane,
    BasicDrawer,
    BasicForm,
    BasicTable,
    VersionDrawer
  },
  setup(_,{emit}) {

      const checkedKeys = ref<Array<string | number>>([]);
      const recordId = ref();
      const isUpdate = ref(false);
      const getTitle = computed(() => (!unref(isUpdate) ? '添加应用' : '编辑应用'));


      const [registerForm, { resetFields, setFieldsValue, validate }] = useForm({
        labelWidth: 100,
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: { lg: 24, md: 24 },
      });
      const [registerDrawer, { setDrawerProps, closeDrawer }] = useDrawerInner(async (data) => {
        resetFields();
        recordId.value = data.record?.id;
        isUpdate.value = data.isUpdate;
        if(unref(recordId)){
          let result = await getAppInfo({id:unref(recordId)});
          if(result){
            setFieldsValue({
              ...result
            })
          }
        }
      })

      const [registerTable,{reload}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getAppVersionList,
        columns:appVersionColumns,
        useSearchForm: false,
        showIndexColumn: false,
        showTableSetting: false,
        canResize: false,
        immediate:false,
        striped:false,
        tableSetting: { fullScreen: false ,redo:false},
      });

      const [registerVersionDrawer, { openDrawer }] = useDrawer();

      function handleAddVersion(){
        openDrawer(true,{
          idUpdate:false,
          record:{
            appId:unref(recordId)
          }
        })
      }

      function handleEdit(record){

      }
      function handleDelete(record){

      }
      function onSelectChange(){

      }
      async function handleSubmit() {
        try {
          const values = await validate();
          setDrawerProps({ confirmLoading: true });
          let result = reactive({});
          if(unref(isUpdate)){
            result = await addApp({
              ...values,
              id:unref(recordId)
            })
          }else{
            result = await updateApp(values);
          }
          if(result){
            closeDrawer();
            emit('success');
          }
         
        } finally {
          setDrawerProps({ confirmLoading: false });
        }
      }


    return {
      registerForm,
      handleSubmit,
      registerTable,
      handleAddVersion,
      handleEdit,
      handleDelete,
      checkedKeys,
      registerDrawer,
      getTitle,
      onSelectChange,
      registerVersionDrawer


    }
  }
}
</script>

<style lang="less" scoped>
</style>
