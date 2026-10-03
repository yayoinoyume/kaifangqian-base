<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicTable @register="registerTable" 
   >
      <template #application="{ record }">
          <div class="application-info">
              <img class="app-avatar" src="../../../assets/svg/illustration.svg" alt="">
              <div>
                <p class="app-name">{{ record.application }}</p>
                <p class="app-desc">{{ record.desc }}</p>
              </div>
          </div>
      </template>
      <template #auth="{ record }">
          <a-tag :color="loadAuthColor(record)">{{ loadAuth(record) }}</a-tag>
      </template>
      <template #action="{ record }">
        <a :href="'http://localhost:8401/#/tenant/appmanage?type=application&&applicationId='+ record.applicationId" target="_blank">配置</a>
        <!-- <a-button type="link" @click="handleConfig(record)" size="small">配置</a-button> -->
      </template>
    </BasicTable>
</template>

<script lang="ts">
  import { defineComponent, onMounted } from 'vue';
  import { BasicTable, useTable, } from '/@/components/Table';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { usePermission } from '/@/hooks/web/usePermission';
  import { applicationColumn, appSearchFormSchema } from './data';
  import { getApplication} from '/@/api/tenant';

  export default defineComponent({
    name:'Application',
    components: { 
       BasicTable
    },
    setup() {
      const { prefixCls } = useDesign('application');
      const { hasPermission } = usePermission();
      const [registerTable, { reload}] = useTable({
        title: '',
        // api: getApplication,
        columns:applicationColumn,
        fetchSetting:{
          listField:'records'
        },
        dataSource:[
          {  application:'公告',desc:'重要信息发送分段锁',auth:0, applicationId:'23333' },
          {  application:'疫情动态',desc:'真实传递疫情信息，实时追踪最新动态',auth:1,  applicationId:'777777777777' },
          {  application:'公告',desc:'地方大概个方式飞洒发士大夫',auth:2,  applicationId:'8888888888' },
        ],
        formConfig: {
          labelWidth: 120,
          schemas:appSearchFormSchema,
        },
        immediate:true,
        useSearchForm: true,
        isTriggerSelect:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: true,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
      })

      function handleConfig(record){
        console.log(record)
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
      function loadAuthColor(record){
       let status = record.auth;
        switch(status){
          case 0:
            return 'orange';
          case 1:
            return 'blue';
          case 2:
            return 'purple';
          default:
            return '';
        }

      }
    

      onMounted(()=>{
      })
      return { 
        loadAuthColor,
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
 .application-info{
   display: flex;
   align-items: center;
   .app-avatar{
    width:40px;
    height: 40px;
    display: inline-block;
    border-radius: 4px;
    background-color: #999;
    margin-right:15px;
   }
   .app-name{
    font-size: 14px;
    font-weight: 500;
    color: #000;
    margin-bottom: 5px;
   }
   .app-desc{
    font-size: 12px;
    font-weight: 400;
    color: #666;
    margin-bottom: 0px;
   }

 }
</style>
