<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="main-center">
    <div class="user-auth-title">
      <span>签名授权</span>
    </div>
    <div class="user-auth-alert">
      <a-alert type="info">
          <template #message>
            <h1>温馨提示</h1>
            <ul style="padding-left: 20px;">
              <li style="list-style: disc;">个人签名授权是指将本人的数字证书以及个人签名授权给企业的某类电子文件，用于快速完成自动签署，减少高频的人工签署动作。</li>
              <li style="list-style: disc;">授权完成后，在授权有效期内，被授权公司的某类电子文件可直接调用本人的数字证书以及个人签名自动签署文件，且代表本人真实的签署意愿。</li>
            </ul>
          </template>
        </a-alert>
    </div>
    <div class="user-auth-body">
      <Scrollbar style="height: 100%;" :native="true">
      <BasicTable @register="registerTable">
        <template #toolbar>
          <div style="text-align: right;width: 100%;">
            <a-tooltip v-if="tenantInfo.authStatus !== 2"> 
                <template #title>为确保签署安全，请完成个人实名认证后，再进行签名授权</template>
                <a-button type="primary" @click="handleAdd" disabled>添加授权</a-button>
            </a-tooltip>
            <a-button type="primary" @click="handleAdd" v-else>添加授权</a-button>
          </div>
        </template>
        <template #annexId="{record}">
          <div class="preview-img">
            <img :src="record.image"/>
          </div>
        </template>
        <template #authStatus="{record}">
          <a-tag color="green" v-if="record.authStatus == 1">有效</a-tag>
          <a-tag color="orange" v-if="record.authStatus == 0">无效</a-tag>
        </template>
        <template #action="{record}">
            <a-popconfirm
              title="是否删除该授权"
              ok-text="是"
              cancel-text="否"
              v-if="record.authStatus == 0"
              @confirm="deleteSealAuthClick(record)">
              <a-button type="link" size="small" @click="">删除</a-button>
            </a-popconfirm>
            
            <a-popconfirm
              title="是否取消该授权"
              ok-text="是"
              cancel-text="否"
              v-if="record.authStatus == 1"
              @confirm="cancleSealAuthClick(record)">
              <a-button type="link"  size="small">取消授权</a-button>
            </a-popconfirm>
        </template>
      </BasicTable>
      </Scrollbar>
    </div> 
    <AddSignatureAuthModal @register="registerModal" @success="reload"></AddSignatureAuthModal>
  </div>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import { Scrollbar } from '/@/components/Scrollbar';
  import { BasicTable, useTable} from '/@/components/Table';
  import {signatureAuthColumns} from "./data"
  
  import AddSignatureAuthModal from "./modal/AddSignatureAuthModal.vue";
  import { useModal } from '/@/components/Modal';
  import {getSealAuthList,cancleSealAuth,deleteSealAuth} from "./api/signatureAuth"
  import { getImgBase64} from '/@/api/sys/upload'; 
  import { message } from 'ant-design-vue';
  import { useUserStore } from '/@/store/modules/user';
  import { silentQueryApi, silentOpenApi } from '/@/api/yundun';
  import { useMessage } from '/@/hooks/web/useMessage';
  export default defineComponent({
    name:"MySignatureAuth",
    components:{
      BasicTable,AddSignatureAuthModal,
      Scrollbar,
    },
    setup() {
      const userStore = useUserStore();
      // const authStatus = userStore.getTenantInfo.authStatus;
      const tenantInfo = userStore.getTenantInfo;
      const [registerTable,{reload}] = useTable({
        title: '',
        api: getSealAuthList,
        columns:signatureAuthColumns,
        fetchSetting:{
          listField:'records'
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
        afterFetch:beforeFetch
      })
      const [registerModal, { openModal,closeModal }] = useModal();
      const {createConfirm,createSuccessModal} = useMessage();
      async function beforeFetch(params){
       for(var i = 0;i<params.length ;i++){
         const result = await getImgBase64({imgId:params[i].annexId});
         params[i].image = result.image;
       }
      }
      async function handleAdd(){
        const result = await silentQueryApi({});
        if(result.status === 0){ //未开通静默签署服务
            createConfirm({
              iconType: 'info',
              title: '温馨提示',
              content: '您暂未开通静默签署服务，开通服务并完成认证后，您的授权有效期内，允许在本系统中使用您本人的数字证书完成自动静默签署，无需进行签署意愿校验，静默签署时即代表本人的真实签署意愿，请确认是否继续开通服务？',
              okText: '去开通服务',
              cancelText: '取消',
              width: 500,
              async onOk() {
                const asyncPage = window.location.origin + '/#/user/centerInfo?index=3';
                const result = await silentOpenApi({ callbackPage: asyncPage });
                if (result.status === 0) {
                  window.open(result.openSignNoVerifyUrl, '_self');
                } else if (result.authStatus === 1) {
                  window.open(asyncPage, '_self');
                }
              }
            })
        }else{
          openModal(true,{});
        }

      }
      async function deleteSealAuthClick(row){
        const result:any = await deleteSealAuth({id:row.id});
        if(result.code == 200){
          reload();
          message.success("删除成功");
        }else{
          message.warning(result.msg);
        }
      }


      async function cancleSealAuthClick(row){
        const result:any = await cancleSealAuth({id:row.id});
        if(result.code == 200){
          reload();
          message.success("取消授权成功");
        }else{
          message.warning(result.msg);
        }
      }
      return{
        registerTable,handleAdd,registerModal,reload,cancleSealAuthClick,deleteSealAuthClick,
        tenantInfo,silentQueryApi
      }
    }
  })
</script>

<style lang="less" scoped>
  .main-center{
    width: 1286px;
    margin:0 auto;
    height: calc(100vh - 128px);
    .user-auth-title{
      height: 42px;
      font-size:16px;
      font-weight: 600;
      padding: 8px 12px;
      border: 1px solid #f0f0f0;
    }
    .user-auth-body{
      height: calc(100% - 42px - 121px);
      width: 100%;
      padding: 0px 12px;
    }
    .user-auth-alert{
      padding: 8px 12px;
    }
  }
  .preview-img img{
    height: 80px;
  }
  
  .preview-img img{
    // border: 1px solid #ededed;
    padding: 8px;
  }
  
</style>
