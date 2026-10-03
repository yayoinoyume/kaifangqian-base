<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="sign-status-container">
      <ul>
        <li v-for="(item,index) in signerSignList" :key="index">
          <div v-if="item.signerType==1 && item.senderList && item.senderList.length>0">
            <div class="signer-name sender-type">
              <span class="sender-line"></span>
              <span>发起方：{{item.signerName}}</span>
            </div>
            <div v-for="(sendItem,sendIndex) in item.senderList"  :key="sendIndex" class="signer-control-info">
              <div class="signer-head">
                <div>
                  <a-badge status="default" />
                  <span>{{ sendItem.senderName +'  —  ' + '[' + (sendItem.senderSignType==1? '自动盖章': sendItem.senderUserName) + ']' }}</span>
                </div>
                <a-tag v-if="sendItem.senderType != 5" class="sign-status" :color="loadSignColor(sendItem.signStatus)">{{ loadSignStatus(sendItem.signStatus) }}</a-tag>
                <a-tag v-if="sendItem.senderType == 5" class="sign-status" :color="loadApprovalColor(sendItem.signStatus)">{{ loadApprovalStatus(sendItem.signStatus) }}</a-tag>
              </div>
            </div>
          </div>
          <div v-if="item.signerType==2">
            <div class="signer-name receive-type">
              <span class="sender-line"  style="background-color:#e48523"></span>
              <span>接收方{{ index }}：{{'个人'}}</span>
            </div>
            <div class="signer-info">
                <div>
                  <a-badge status="default" />
                  <span class="operater-name"> {{item.signerName }} </span>
                  <span> {{item.signerExternalValue  }} </span>
                </div>
                <a-tag class="sign-status" :color="loadSignColor(item.signStatus)">{{ loadSignStatus(item.signStatus) }}</a-tag>
              </div>
          </div>
          <div v-if="item.signerType==3">
            <div class="signer-name sender-type">
              <span class="sender-line" style="background-color:#48b931"></span>
              <span>接收方：{{item.signerName}}</span>
            </div>
            <div v-for="(sendItem,sendIndex) in item.senderList"  :key="sendIndex" class="signer-control-info">
              <div class="signer-head">
                <div>
                  <a-badge status="default" />
                  <!-- <span>{{ sendItem.senderName }}</span> -->
                  <span>{{ (sendItem.senderType==1?'经办人签字':'组织签章') +'  —  '  +'['+sendItem.senderName + ']'}}</span>
                </div>
                <a-tag class="sign-status" :color="loadSignColor(sendItem.signStatus)">{{ loadSignStatus(sendItem.signStatus) }}</a-tag>
              </div>
            </div>
          </div>
        </li>
      </ul>
  </div>
</template>

<script lang="ts">
import {ref, unref, defineComponent, onMounted} from "vue";
import { getOperator, getOperatorStatus } from '/@/api/contract';
import { useRouter } from 'vue-router';
import { loadSignStatus, loadSignColor,loadApprovalColor,loadApprovalStatus } from '../document/transform';

export default defineComponent({
  name:"SignStatus",
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
      const signerSignList:any = ref([]);

    onMounted(()=>{
      fetch()
    })
    async function fetch(){
      // let result = await getOperator({signRuId:signRuId});
      // if(result){
      //   let receiveList = result.filter(v=>v.signerType==2 && v.operateType==2).sort((a, b) => a.operateOrder - b.operateOrder);
      //   let senderList = result.filter(v=>v.signerType == 1 && v.operateType==2).sort((a, b) => a.operateOrder - b.operateOrder);
      //   let senderOrg =  result.filter(v=>v.signerType==1 && v.operateType == 1).sort((a, b) => a.operateOrder - b.operateOrder);
      //   if(senderOrg.length){
      //     senderOrg[0].senderList = senderList;
      //   }
      //   signerSignList.value = [
      //     ...senderOrg,
      //     ...receiveList
      //   ]
      // }
        let result = await getOperatorStatus({signRuId:signRuId});
        if(result){
          signerSignList.value = result.sort((a, b) => a.signerOrder - b.signerOrder);
          signerSignList.value.map(item=>{
            if(item.signerType==1){
              item.senderList =  item.senderList.sort((a, b) => a.senderOrder - b.senderOrder)
            }
          })
        }
    }

    return {
         signerSignList,
         loadSignColor,
         loadSignStatus,
         loadApprovalColor,
         loadApprovalStatus,
    }
  }
})
</script>

<style lang="less" scoped>
.sign-status-container{
  margin-bottom: 40px;
}


.signer-item{
  margin-bottom: 15px;
}
.signer-name{
  display: flex;
  .sign-status{
    margin-left:20px;
    padding:2px 15px;
  }
}

.sign-status{
    color: white;
  }
.sender-line{
    width:4px;
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
  margin:15px 2px;
  display: flex;
  justify-content: space-between;
  .operater-name{
    margin:0 20px 0 0px;
  }
}
.signer-head{
  font-size: 12px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin:15px 0;
  font-weight: 400;
  span{
    font-weight: 400;
    // color: white;
  }
}
</style>
