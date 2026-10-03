<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="const-box">
     <OperateRecord :templateId="templateId"/>
   <!-- <a-tabs @tabClick="tabClick" v-model:active-key="tabKey" :destroyInactiveTabPane="true">
      <a-tab-pane key="Operate" tab="操作记录" :force-render="true">
        <OperateRecord :templateId="templateId"/>
      </a-tab-pane>
      <a-tab-pane key="Approve" tab="审批记录" :force-render="true">
       <ApproveRecord :templateId="templateId"/>
      </a-tab-pane>
      <a-tab-pane key="Use" tab="引用记录" >
       <SealChangeRecord :sealId="currentSeal.sealId"/>
      </a-tab-pane>
    </a-tabs> -->
  </div>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref,createVNode,h,getCurrentInstance} from 'vue';
  // import {getDefProcess} from "/@/api/bpmns"
  // import {Process} from "/@/views/signature/data/ProcessConfig";
  // import {getDocStat} from "./common/DocStatus";
  // import {getTemplateList,templateDelete,getFolderList,
  //   folderDelete,updateTemplateStatus,downloadParam,templateChange} from "./api"
  
  import {useRouter} from "vue-router"
  
  import OperateRecord from "./record/OperateRecord.vue"
  // import ApproveRecord from "./record/ApproveRecord.vue"
  
  
  export default defineComponent({
    name:'record',
    components: { 
      OperateRecord
    },
    setup() {
      const router = useRouter();
      const tabKey = ref("Operate");
      const templateId = ref("");
      function tabClick(){
        
      }
      onMounted(()=>{
        const query = router.currentRoute.value.query;
        templateId.value = query.templateId
        // console.log("templateId.value：",templateId.value);
        // fetch();
        console.log("record onMounted：");
      })
      function fetch(){
        
      }
      return{
        tabKey,tabClick,templateId
      }
    }
  })
</script>

<style lang="less" scoped>
  
  .const-box{
    padding: 0 20px;
  }
</style>
