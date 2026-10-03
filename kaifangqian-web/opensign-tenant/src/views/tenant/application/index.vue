<!--
  @description 资助审批电子签章系统
-->

<template>
  <div style="padding:24px;"> 
    <BasicTable @register="registerTable">
        <template #appName="{ record }">
            <div class="app-info">
              <div class="app-avatar">
                <img  src="@/assets/images/app-icon.png" alt=""  v-if="!record.appIcon" /> 
                <img  :src="record.appIcon" alt="" v-else />
              </div>
              <div>
                <p class="app-name">{{ record.appName }}</p>
                <p class="app-desc">{{ record.appDesc }}</p>
              </div>
            </div>
        </template>
        <template #appType="{ record }">
          <a-tag color="#feead2" v-if="record.status==0">待启用</a-tag>
          <a-tag   v-else :color="loadTypeColor(item)" v-for="item in [record.useful]" :key="item" style="margin:0 2px;color:#333">{{ loadAppType(item) }}</a-tag>
        </template>
        <template #action="{ record }">
          <a-button type="link" @click="handleConfig(record)" size="small">配置</a-button>
          
           <a-popconfirm
              title="停用后企业内所有成员均无法访问该应用,是否继续停用该应用？"
              ok-text="停用"
              cancel-text="取消"
              @confirm="handleAppStatus(record)"
              :disabled="record.defaultFlag" 
            v-if="record.status===1">
              <a-button type="link" size="small" :disabled="record.defaultFlag" danger >停用</a-button>
            </a-popconfirm>
            <a-popconfirm
               title="是否启用该应用？"
               ok-text="启用"
               cancel-text="取消"
               @confirm="handleAppStatus(record)"
               :disabled="record.defaultFlag" 
             v-else>
               <a-button type="link" size="small" :disabled="record.defaultFlag" >启用</a-button>
             </a-popconfirm>
            
          
        </template>
    </BasicTable>
    <AppConfig @register="registerModal" @success="handleSuccess"/>
  </div>
   
</template>

<script lang="ts">
  import { defineComponent, onMounted } from 'vue';
  import { BasicTable, useTable, } from '/@/components/Table';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { useModal } from '/@/components/Modal';
  import AppConfig from './modal/ConfigModal.vue';
  import { usePermission } from '/@/hooks/web/usePermission';
  import { applicationColumn, appSearchFormSchema } from './data';
  import { getTenantApp, updateAppStatus } from '/@/api/tenant'
  import { message } from 'ant-design-vue';
  export default defineComponent({
    name:'Application',
    components: { 
       BasicTable,
       AppConfig
    },
    setup() {
      const { prefixCls } = useDesign('application');
      const { hasPermission } = usePermission();
      const [registerTable, { reload}] = useTable({
        title: '',
        api: getTenantApp,
        columns:applicationColumn,
        fetchSetting:{
          listField:'records'
        },
        formConfig: {
          labelWidth: 120,
          schemas:appSearchFormSchema,
        },
        immediate:true,
        useSearchForm: false,
        isTriggerSelect:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: false,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
      })

      const [registerModal, { openModal,closeModal }] = useModal();


      function handleConfig(record){
        openModal(true,{
          isUpdate:false,
          record:{
            ...record
          }
        })
      }
      function loadAuth(record){
        let text = record.auth;
        switch(text){
          case 0:
            return '待启用';
          case 1:
            return '全员可见';
          case 2:
            return '部分成员可见';
          default:
            return '';
        }
      }
      function loadTypeColor(status){
        switch(status){
          case true:
            return '#e1eaff';
          default:
            return '#ece1fe';
        }

      }
      function loadAppType(useful){
        console.log("useful:",useful);
        switch(useful){
          case true:
            return '全员可用';
          default:
            return '部分成员可用';
        }
      }
      function handleSuccess(){
        closeModal();
        reload();
      }
      async function handleAppStatus(row){
        
        
        let result = await updateAppStatus({id:row.id});
        if(result.code == 200){
          message.success('操作成功');
          reload();
        }
      }
  

      onMounted(()=>{
      })
      return { 
        handleAppStatus,
        loadAppType,
        handleSuccess,
        registerModal,
        loadTypeColor,
        loadAuth,
        hasPermission,
        prefixCls,
        handleConfig,
        registerTable
      }
    },
  });
</script>
<style lang="less" scoped>
 @prefix-cls: ~'@{namespace}-application';
</style>
