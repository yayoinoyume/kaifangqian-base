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
              <div class="sign-label-box"><span class="sign-label-title">发起方：</span><span class="sign-label-name">{{ item.signerName}}</span></div>
              <a-tag v-if="item.writeStatus>-1" class="write-status" :color="loadSignColor(item.writeStatus)">{{ loadWriteStatus(item.writeStatus) }}</a-tag>
            </div>
          </div>
          <div v-if="item.signerType==2">
              <div class="signer-name receive-type">
                <span class="sender-line"></span>
                <div class="sign-label-box"><span class="sign-label-title">接收方{{ index }}：</span><span class="sign-label-name">{{ item.signerName}}</span></div>
                <a-tag v-if="item.writeStatus>-1" class="write-status" :color="loadSignColor(item.writeStatus)">{{ loadWriteStatus(item.writeStatus) }}</a-tag>
              </div>
              <div class="signer-info">
                <a-badge status="default" />
                <span class="operater-name"> {{item.signerName}} </span>
                <span> {{item.signerExternalValue }} </span>
              </div>
          </div>
          <div v-if="item.signerType==3" >
            <div class="signer-name sender-type">
              <span class="sender-line" style="background-color:#48b931"></span>
              <div class="sign-label-box"><span class="sign-label-title">接收方{{ index }}：</span><span class="sign-label-name">{{ item.signerName}}</span></div>

              <a-tag v-if="item.writeStatus>-1" class="write-status" :color="loadSignColor(item.writeStatus)">{{ loadWriteStatus(item.writeStatus) }}</a-tag>
            </div>
           <!-- <div v-for="(sendItem,sendIndex) in item.senderList"  :key="sendIndex" class="signer-control-info">
              <div class="signer-head">
                <div>
                  <a-badge status="default" />
                  <span class="operater-name">{{ (sendItem.senderType==1?'经办人签字':'组织签章') +'  —  '  +'['+sendItem.senderName + ']' }}</span>
                </div>
                <a-tag v-if="sendItem.writeStatus>-1" class="write-status" :color="loadSignColor(sendItem.writeStatus)">{{ loadWriteStatus(sendItem.writeStatus) }}</a-tag>
              </div>
            </div> -->
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
        signerWriteList.value.map(v=>{
          if(v.signerType==3){
            v.senderList = v.senderList.sort((a, b) => a.signerOrder - b.signerOrder);
          }
        })
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
.signer-head{
  .operater-name{
    font-size:12px;
    color:rgba(0, 0, 0, 0.85);
    font-weight:400;
    margin-left:5px;
  }
}
.sign-label-box{
  display:flex;
  align-items:center;
  .sign-label-name{
    width:200px;
    overflow:hidden;
    text-overflow:ellipsis;
    display:inline-block;
    white-space:nowrap;
  }
  .sign-label-title{
    width:70px;
    display:inline-block;
    white-space:nowrap;
  }
}

</style>
