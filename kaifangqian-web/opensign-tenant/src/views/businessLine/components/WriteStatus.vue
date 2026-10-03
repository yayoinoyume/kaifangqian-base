<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="sign-status-container">
      <ul>
        <li v-for="(item,index) in signerWriteList" class="signer-item">
          <div v-if="item.signerType==1" >
            <div class="signer-name sender-type">
              <span class="sender-line"></span>
              <span>发起方：{{item.signerName}}</span>
              <a-tag v-if="item.writeStatus>-1" class="write-status" :color="loadSignColor(item.writeStatus)">{{ loadWriteStatus(item.writeStatus) }}</a-tag>
            </div>
          </div>
          <div v-else >
              <div class="signer-name receive-type">
                <span class="sender-line"></span>
                <span>接收方{{ index }}：{{ item.signerName}}</span>
                <a-tag v-if="item.writeStatus>-1" class="write-status" :color="loadSignColor(item.writeStatus)">{{ loadWriteStatus(item.writeStatus) }}</a-tag>
              </div>
              <div class="signer-info">
                <a-badge status="default" />
                <span class="operater-name"> {{item.signerName}} </span>
                <span> {{item.signerExternalValue }} </span>
              </div>
          </div>
        </li>
      </ul>
  </div>
</template>

<script lang="ts">
import {ref, defineComponent, onMounted, unref} from "vue";
import { getOperator, getOperatorStatus } from '/@/api/contract';
import { useRouter } from 'vue-router';
import { loadWriteStatus, loadSignColor } from '../document/transform';
export default defineComponent({
  name:"WriteStatus",
  props:{
    signerList:{
      type:Object,
    },
  },
  setup() {
      const router = useRouter();
      const { currentRoute } = router;
      const route = unref(currentRoute);
      const signRuId = route.query.signRuId;
      const signerWriteList:any = ref([]);

    onMounted(()=>{
      fetch()
    })
    async function fetch(){
      let result = await getOperatorStatus({signRuId:signRuId});
      if(result){
        signerWriteList.value = result.sort((a, b) => a.signerOrder - b.signerOrder);
      }

    }

    return {
         signerWriteList,
         loadWriteStatus,
         loadSignColor 
    }
  }
})
</script>

<style lang="less" scoped>
.signer-item{
  margin-bottom: 15px;
}
.signer-name{
  display: flex;
  .write-status{
    margin-left:20px;
    padding:2px 15px;
  }
}
.sender-line{
    width:8px;
    height:20px;
    border-radius: 2px;
    margin-right:10px;
  }
.sender-type{
  font-weight: 550;
  .sender-line{
    background:#6ea9d7;
  }
}
.receive-type{
  font-weight: 550;
  .sender-line{
    background:#faa573;
  
  }
}
.signer-info{
  font-size: 12px;
  margin:10px 2px;
  .operater-name{
    margin:0 20px 0 5px;
  }
}
</style>
