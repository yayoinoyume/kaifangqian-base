<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="实例日志" @ok="handleSubmit">
      <div class="action">
        <a-button type="primary">下载</a-button>
      </div>
      <div class="log-detail">
        <span>{{instanceState.info}}</span>
        <!-- <a-list item-layout="vertical" size="small" :pagination="pagination" :data-source="instanceState.list">
         <template #renderItem="{ item }">
            <span>{{item}}</span>
         </template>
        </a-list> -->
      </div>
    </BasicModal>
  </div>
</template>
<script lang='ts'>

import { defineComponent, reactive,computed } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { getInstanceLog } from '/@/api/task';
import { useUserStore } from '/@/store/modules/user';

export default defineComponent({
  name: 'LogModal',
  components:{
    BasicModal
  },
  setup(){

    const instanceState = reactive({info:{},instanceId:''});
    const pagination = {
      onChange: (page: number) => {
        getLogList(page)
      },
      pageSize: 3,
    };
    const userStore = useUserStore();
    const appId =  userStore.getUserInfo.jobAppId;
    const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭' 
        });
        if(!data.record.instanceId) return; 
        instanceState.instanceId = data.record.instanceId;
        getLogList()
       
    });

    async function getLogList(page=0){
      if(!instanceState.instanceId) return;
       let resultInfo = await getInstanceLog({instanceId:instanceState.instanceId,index:page,appId:appId})
        if(resultInfo){
            instanceState.info = resultInfo.data;

        }
    }

      function handleSubmit(){
          closeModal()
      }

      return {
        registerModal,
        handleSubmit,
        instanceState,
        pagination
      }
  }
})
</script>
<style lang="less" scoped>
.action{
  text-align: right;
  margin-bottom: 15px;
}
</style>
