<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="app-market">
    <BasicModal v-bind="$attrs" @register="registerModal" title="应用中心" @ok="handleSubmit" :footer="null">
      <div class="app-market-list">
        <div class="app-item" v-for="item in appList">
          <div class="app-info" >
            <div class="app-icon">
              <img :src="(item.appIcon as string)" alt="" v-if="item.appIcon">
              <img  src="../../../../assets/images/app-icon.png" alt="" v-else>
            </div>
              <div style="flex:1">
                <div class="app-header">
                  <div class="app-header-left">
                    <p class="app-name">{{ item.appName }}</p>
                    <div v-if="!item.containsFlag">
                      <a-tag color="#93c2e3" v-if="item.appVersionVOS&&item.appVersionVOS.length==1">{{item.appVersionVOS&& item.appVersionVOS[0].versionName }}</a-tag>
                      <a-select v-else v-model:value="item.versionId" size="small" :disabled="item.containsFlag">
                        <a-select-option v-for="(versionItem,index) in item.appVersionVOS" :value="versionItem.id" :key="index">{{ versionItem.versionName }}</a-select-option>
                      </a-select>
                    </div>
                     
                  </div>
                  <a-button size="small" type="primary" v-if="!item.containsFlag" @click="handleDownload(item)" :loading="item.loading">{{ item?.loading?'安装中':'安装应用' }}</a-button>
                  <a-button size="small" type="primary" disabled v-if="item.containsFlag">已安装</a-button>
                  
                </div>
                <p class="app-desc">{{ item.appDesc }}</p>
              </div>
          </div>
        </div>
      </div>
    </BasicModal>
  </div>
</template>

<script lang="ts">
import {ref} from "vue";
import { BasicModal,useModalInner } from '/@/components/Modal';
import { getTenantApps,addPersonalTenantAppVersion } from '/@/api/tenant';
import { useMessage } from '/@/hooks/web/useMessage';

interface VersionItem {
  id:string;
  versionName:string;
  versionDesc:string; 
}
interface AppItem {
   appVersionVOS:VersionItem[];
   loading:boolean;
   appName:string;
   versionId:string;
   containsFlag:boolean;
   appDesc:string;
   appIcon:string;
}

export default{
  name:"AppMarket",
  components:{
    BasicModal
  },
  setup(_,{emit}) {
   const appList = ref(<AppItem[]>[]);
  const { createMessage: msg } = useMessage();

   const [registerModal, { setModalProps }] = useModalInner(async (data) => {
      setModalProps({ confirmLoading: false,width:900,canFullscreen:false, closable:true,maskClosable:false,centered:false });
      let result = await  getTenantApps({});
      console.log(result,'请求结果');
      if(result){
        appList.value = result;
        appList.value.map(item=>{
          item.loading = false;
          if(item.containsFlag){
            item.versionId = item.id;
          }else{
            item.versionId = '';
          }
        })
      }
   })

   function handleSubmit(){
    emit('success')
   }
   async function handleDownload(item){
    if(!item.appVersionVOS){
      msg.warning('该应用暂无可安装版本');
      return;
    }
    if(item.appVersionVOS.length>1 && !item.versionId){
      msg.warning('请选择安装版本');
      return;
    }
    
    item.loading = true;
    let versionId:string[] = [];
    if(item.appVersionVOS.length>1){
      versionId = [item.versionId]
    }else{
      versionId = [item.appVersionVOS[0].id]
    }
    let params = {
      outVersionIds:versionId,
    }
    let result = await addPersonalTenantAppVersion(params);
    if(result){
      setTimeout(()=>{
        item.loading = false;
        item.containsFlag = true;
      },2000);
      msg.success('安装成功');
      emit('success');
    }
    
   }
    return {
      appList,
      registerModal,
      handleDownload,
      handleSubmit
    }
  }
} 
</script>

<style lang="less" scoped>
.app-market-list{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  .app-item{
    width: 48%;
    border: 1px solid #d4d4d4;
    border-radius: 4px;
    padding: 10px 15px;
    box-sizing: border-box;
    margin-bottom: 20px;
    cursor: pointer;
    .app-info{
      align-items: inherit;
      .app-avatar{
        margin-top:5px;
      }
      .app-name{
        margin:0 10px 0 0;
      }
      .app-header{
        margin-bottom: 10px;
      }
      .app-header-left{
        display: flex;
        align-items: center;
        justify-content: space-between;
      }
      .app-desc{
        max-height: 60px;
      }
    }
    &:hover{
      border-color: #127fd2;
      color: #127fd2;
      font-weight: 600;
      box-shadow: 0px 0px 5px #c8c8c8;
    }
  }
  .app-item:nth-child(odd){
    margin-right: 20px;
  }
  .ant-select{
    width:130px;
  }
}
</style>
