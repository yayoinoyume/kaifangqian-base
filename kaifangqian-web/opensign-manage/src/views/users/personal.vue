<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container">
    <BasicTable @register="registerTable">
        <template #authStatus="{record}">
            <div>
                <a-tag :color="loadCertificationStatus(record.authStatus)">{{ loadCertificationText(record.authStatus) }}</a-tag>
            </div>
          </template>
        <template #tenantStatus="{record}">
          <div>
             <span>{{ record.tenantStatus==1?'启用':'停用' }}</span>
          </div>
        </template>
        <template #action="{record}">
          <a-button type="link" size="small" @click="handleUpdate(record)"> {{ record.tenantStatus==1?'停用':'启用' }}</a-button>
        </template>
    </BasicTable>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue"
import { BasicTable,useTable } from '/@/components/Table';
import Icon from "/@/components/Icon";
import { personalColumn, personalSearchFormSchema } from './data';
import { useMessage } from '/@/hooks/web/useMessage';
import { getTenantList , updateTenantStatus} from '/@/api/tenant';
import { loadCertificationStatus,  loadCertificationText} from '/@/utils/StatusToName';
import dayjs from 'dayjs';


export default defineComponent({
  name:"Personal",
  components:{
    Icon,
    BasicTable
  },
  setup() {

    const { createMessage:msg, createConfirm } = useMessage();

    const [registerTable,{reload,setProps}] = useTable({
        title: '',
        titleHelpMessage: [],
        api: getTenantList,
        columns:personalColumn,
        immediate:true,
        fetchSetting:{
          listField:'records',
        },
        formConfig: {
          labelWidth: 80,
          schemas: personalSearchFormSchema,
        },
        searchInfo:{
          tenantType:2
        },
        rowKey:'id',
        useSearchForm: true,
        showIndexColumn: false,
        canResize: false,
        isTriggerSelect:false,
        striped:false,
        bordered:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        pagination:true,
        beforeFetch:handleBeforeFetch
    }); 
    function handleBeforeFetch(params){
      if(params.createTime){
        params.beginTime = dayjs(params.createTime[0]).startOf('date').format('YYYY-MM-DD HH:mm:ss');
        params.endTime = params.createTime[1];
        params.createTime = undefined;
      }
    }

    function handleUpdate(row){ 
      createConfirm({
        title: `是否${row.tenantStatus==1?'停用':'启用'}该租户`, 
        content: "点击确定按钮时，该对话框将在1秒后关闭",
        okText:'确定',
        iconType: 'warning',
        onOk() {
          setTenantStatus(row)
        },
      })
    }
    async function setTenantStatus(row){
      let result = await updateTenantStatus({id:row.id,tenantStatus:row.tenantStatus==1?2:1});
      if(result){
        reload();
        msg.success('操作成功')
      }
    }
    return {
      registerTable,
      handleUpdate,
      loadCertificationStatus,
      loadCertificationText

    }
  }
})
</script>

<style lang="less" scoped>
</style>
