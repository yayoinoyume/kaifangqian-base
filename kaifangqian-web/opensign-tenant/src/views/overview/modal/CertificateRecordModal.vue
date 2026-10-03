<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
     <BasicModal @register="registerModal" title="企业认证记录"> 
      <BasicTable @register="registerTable">
        <template #authStatus="{record}">
          <a-tag :color="loadCertificationStatus(record.authStatus)">{{ loadCertificationMixText(record) }}</a-tag>
        </template>
        <template #authType="{record}">
         <span>{{ loadCertificationAuthType(record.authType) }}</span>
        </template>
        <template #realItem="{record}">
         <span>{{ loadCertificationRealItemType(record.realItem) }}</span>
        </template>
        <template #action="{record}">
        <a-button type="link" @click="handleSee(record)">查看</a-button>
        </template>
        
      </BasicTable>
     </BasicModal>
  </div>
</template>

<script lang='ts'>
  import { defineComponent,ref, unref  } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useUserStore } from '/@/store/modules/user';
  import { BasicTable, useTable, } from '/@/components/Table';
  import { recordColumn } from '../data';
  import { getEnterpriseAuthLog } from '/@/api/sys/user'; 
  import { loadCertificationStatus,  loadCertificationAuthType,loadCertificationRealItemType } from '/@/utils/StatusToName'

  export default defineComponent({
    name: 'RecordCer',
    components:{
      BasicModal,
      BasicTable
    },
    setup(_, { emit }){
      const tenantId = ref('');

      const userStore = useUserStore();
      const userInfo =  userStore.getUserInfo;
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1400,
          cancelText:'关闭' 
        });
        tenantId.value = data.record.tenantId;
        console.log(tenantId,'租户oid')
        reload({
          //   searchInfo:{
          //   tenantId:unref(tenantId)
          // }
        })
      });
      const [registerTable,{ reload }] = useTable({
        title: '',
        titleHelpMessage: [],
        immediate:false,
        columns: recordColumn,
        api:getEnterpriseAuthLog,
        fetchSetting:{
          listField:'records'
        },
        rowKey:'id',
        useSearchForm: false,
        dataSource:[],
        showDragColumn:false,
        showIndexColumn: false,
        bordered: false,
        isTriggerSelect:false,
        showTableSetting: false,
        canResize: false,
        striped:false,
        tableSetting: { fullScreen: false ,redo:false,setting:false,size:false},
        beforeFetch:beforeFetch
      });
      function beforeFetch(params){
        params.tenantId = tenantId.value;
      }
      function handleSee(record){
        const token = userStore.getToken;
        let authInfo = userInfo.authInfo
        let appInfo = {
            token:token,
            appCode:authInfo.appCode,
            appId:authInfo.appId,
            departId:userInfo.loginDepartId,
            id:record.id
          }
          let paramsString = new URLSearchParams(appInfo).toString();
          window.open(authInfo.appAddress + '/#/enterprise/detail' + '?' + paramsString,'_self')
      }

      function loadCertificationMixText(record){
        if(record.authStatus==0 || !record.authStatus ){
          return '未认证'
        }else if(record.authStatus == 1 && (record.authType == 1 ||  record.authType == 3) && record.realItem == 1){
          return '认证审核中'
        }else if(record.authStatus == 1 && (record.authType == 1 ||  record.authType == 3) && record.realItem != 1){
          return '变更认证审核中'
        }else if(record.authStatus == 1 && record.authType == 2){
          return '变更认证审核中'
        }else if(record.authStatus == 2 && record.authType == 1){
          return '认证通过'
        }else if(record.authStatus == 2 && record.authType == 2){
          return '变更认证通过'
        }else if(record.authStatus == 2 && record.authType == 3){
          return '认证通过'
        }else if(record.authStatus == 3 && record.authType == 1){
          return '认证审核失败'
        }else if(record.authStatus == 3 && record.authType == 2){
          return '变更审核失败'
        }else if(record.authStatus == 3 && record.authType == 3){
          return '认证审核失败'
        }
      }

      return { 
        registerModal,
        registerTable,
        loadCertificationStatus,
        loadCertificationMixText,
        loadCertificationAuthType,
        handleSee,
        loadCertificationRealItemType,
      }
    }
  })

</script>
<style lang="less" scoped>
:deep(.ant-pagination){
  position: absolute;
}
 
</style>
