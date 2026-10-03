<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="实例详情" @ok="handleSubmit">
        <div class="detail-list">
            <p class="detail-item">
              <span class="title">任务实例 ID：</span>
              <span class="content">{{instanceState.info.instanceId}}</span>
            </p>
            <p class="detail-item">
              <span class="title">状态：</span>
              <span class="content">{{loadInstanceStatus(instanceState.info.status)}}</span>
            </p>
            <p class="detail-item">
              <span class="title">TaskTracker地址：</span>
              <span class="content">{{instanceState.info.taskTrackerAddress}}</span>
            </p>
            <p class="detail-item">
              <span class="title">预计执行时间：</span>
              <span class="content">{{formatToDateTime(instanceState.info.expectedTriggerTime)}}</span>
            </p>
            <p class="detail-item">
              <span class="title">开始时间：</span>
              <span class="content">{{formatToDateTime(instanceState.info.actualTriggerTime)}}</span>
            </p>
            <p class="detail-item">
              <span class="title">结束时间：</span>
              <span class="content">{{formatToDateTime(instanceState.info.finishedTime)}}</span>
            </p>
            <p class="detail-item">
              <span class="title">节点参数：</span>
              <span class="content">{{instanceState.info.jobParams}}</span>
            </p>
            <p class="detail-item">
              <span class="title">任务实例参数：</span>
              <span class="content">{{instanceState.info.instanceParams}}</span>
            </p>
            <p class="detail-item">
              <span class="title">任务结果：</span>
              <span class="content">{{instanceState.info.result}}</span>
            </p>

        </div>
    </BasicModal>
  </div>
</template>
<script lang='ts'>

import { defineComponent, reactive } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { getInstanceDetail } from '/@/api/task';
import { formatToDateTime } from '/@/utils/dateUtil'

export default defineComponent({
  name: 'DetailModal',
  components:{
    BasicModal
  },
  setup(){

    const instanceState = reactive({info:{
      instanceId:'',
      status:0,
      taskTrackerAddress:'',
      actualTriggerTime:'',
      expectedTriggerTime:'',
      finishedTime:'',
      jobParams:'',
      instanceParams:'',
      result:''

    }})

      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
          setModalProps({ 
            confirmLoading: false,
            width:1200,
            cancelText:'关闭' 
          });
          if(!data.record.instanceId) return; 
          let result = await getInstanceDetail({instanceId:data.record.instanceId})
          if(result){
              instanceState.info = {...result,instanceId:data.record.instanceId};
          }
      });

      function handleSubmit(){
          closeModal()
      }
      function loadInstanceStatus(status){
        switch(status){
          case 1:
            return '等待派发';
          case 2:
            return '等待Worker接收';
          case 3:
            return '运行中';
          case 4:
            return '失败';
          case 5:
            return '成功';
          case 9:
            return '取消';
          case 10:
            return '手动停止';
          default:
            return ''
        }
      }

      return {
        registerModal,
        handleSubmit,
        instanceState,
        loadInstanceStatus,
        formatToDateTime
      }
  }
})
</script>
<style lang="less" scoped>
.detail-item{
  .title{
    width:150px;
    display: inline-block;
  }

}
 
</style>
