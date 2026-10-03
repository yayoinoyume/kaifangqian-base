<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="doc-params-container">
    <template v-for="(docItem,docIndex) in documentList">
      <div class="doc-item"  :key="docIndex" v-if="hasWriteControl(docItem.activeControl)">
          <div class="doc-header">
            <SvgIcon name="doc-control" :size="24"></SvgIcon>
            <a-tooltip>
              <template #title>{{docItem.documentName }}</template>
                <span class="param-doc-name"> {{ docItem.documentName }}</span>
              </a-tooltip>
            <a-popover title="" trigger="hover" :getPopupContainer="(trigger: Element) => trigger.parentNode" placement="rightBottom">
              <template #content>
                <ul>
                  <li v-for="(item,index) in options" :value="item.id" :key="index" @click="handleSetWriterBatch(item,docItem)">{{'全部由'+ item.name + '填写' }}</li>
                </ul>
              </template>
              <SvgIcon name="batch-set" :size="24"  class="batch-set"></SvgIcon>
            </a-popover>
          </div>
          <div class="full-parameter-content">
            <ul>
              <template  v-if="hasWriteControl(docItem.activeControl)">
                <li v-for="(item,index) in docItem.activeControl" :key="index" class="writer-li">
                  <div v-if="((item.controlType=='line-text') || (item.controlType=='date') || (item.controlType=='number') ||  (item.controlType=='multiline-text')) || (item.controlType=='image') || (item.controlType=='radio') || (item.controlType=='image') || (item.controlType=='check-box') || (item.controlType=='dropdown-list')">
                    <div :class="['params-header',item.focus?'control-focus-header':'']">
                      <a-tooltip>
                        <template #title>点击后，定位到该参数所在文档位置</template>
                        <SvgIcon name="location"  v-if="!item.focus" :size="20" class="control-pos"  @click="handleControlPos(docItem,item)"></SvgIcon>
                        <SvgIcon name="location-focus" v-if="item.focus" :size="20" class="control-pos"  @click="handleControlPos(docItem,item)"></SvgIcon>
                      </a-tooltip>
                      <span class="params-name"> <SvgIcon v-if="item.isRequired == 1" name="required" :size="16" class="control-pos"></SvgIcon>{{ item.name }}</span>
                    </div>
                    <div :class="['params-body',item.focus?'control-focus-body':'']"> 
                      <div class="params-select">
                        <!-- <span>填写方：</span> -->
                        <!-- <a-select :allowClear="true" :disabled="(item.originType == 1 && item.signerId)?true:false" v-model:value="item.signerId" :options="options" :fieldNames="{label:'name',value:'id'}" @change="(e)=>handleWriteChange(e, item)"></a-select> -->
                        <a-select :allowClear="true" placeholder="请选择填写方" v-model:value="item.signerId" :options="options" :fieldNames="{label:'name',value:'id'}" @change="(e)=>handleWriteChange(e, item)"></a-select>
                      </div>
                    </div>
                  </div>
                </li>
              </template>
              <li v-else class="control-no">
                无参数
              </li>
            </ul>
          </div>
      </div>
    </template>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent,watch, onMounted} from "vue";
import {Icon,SvgIcon} from "/@/components/Icon";
export default defineComponent({
  name:"SetParamsWriter",
  components:{
    Icon,
    SvgIcon,
  },
  props:{
    controlList:{
      type:Object,
    },
    documentList:{
      type:Object,
    },
    signerList:{
      type:Object,
    },
    docId:{
      type:String,
    },
  },
  setup(props,{emit}) {
    const writeControl:any = ref([]);
    const options:any = ref([])
    const InitiatorId =  ref('');
    watch(
      ()=> props.documentList,
      (newList:[])=>{
        // console.log(newList, '文档信息改变')
      
      }
    )
    watch(
      ()=> props.documentList,
      (newList:[])=>{
        let allControls = newList.flatMap((v:any)=>v.activeControl);
        writeControl.value = allControls.filter(item=>(item.controlType=='line-text') || (item.controlType=='date') || (item.controlType=='number') ||  (item.controlType=='multiline-text')  ||  (item.controlType=='check-box') ||  (item.controlType=='radio') ||  (item.controlType=='dropdown-list') ||  (item.controlType=='image'));
        let writeSignerIds = writeControl.value.map((item:any)=>item.signerId);
        let diff = writeSignerIds.filter(v=>v == InitiatorId.value );
        emit('needInitiatorWrite',diff.length==0?false:true)

      },
      {deep:true}
    )
    watch(
      ()=> props.signerList,
      (newList:[])=>{
        options.value = [];
        newList.map((item:any,index)=>{
          //接收方
          if(item.signerType==2 || item.signerType==3){
            options.value.push({
              id:item.id,
              signerType:item.signerType,
              name:item.signerName || '',
              signerId:''
            })
          }else{
            // 发起方
            InitiatorId.value = item.id;
            options.value.push({
                id:item.id,
                signerType:item.signerType,
                name: '发起方',
                signerId:''
              })

          }
        })
      },
    )
    onMounted(()=>{
      // console.log(props.documentList,'子组件拿到的文档')
      // console.log(props.docId,'子组件拿到的文档id')
      // let docControl =  props.documentList&&props.documentList.find(v=>v.signRuDocId == props.docId);
      // console.log(docControl,'================')
      //   writeControl.value = docControl.filter((item:any) =>((item.controlType=='line-text') || (item.controlType=='date') || (item.controlType=='number') ||  (item.controlType=='multiline-text')))

    })


    function handleSetWriterBatch(row,docItem){
        docItem.activeControl.forEach(item=>{
          if(['date','line-text','multiline-text','number','image','dropdown-list','radio','check-box'].includes(item.controlType)){
            item.signerId = row.id;
          }
        })
    }
    function handleWriteChange(e,item){
      
    }
    function handleControlPos(doc,control){
      emit('scroll',doc,control)
    }
    function hasWriteControl(control){
      let matchControls = control.filter(item=>(item.controlType=='line-text') || (item.controlType=='date') || (item.controlType=='number') ||  (item.controlType=='multiline-text') || (item.controlType=='check-box') || (item.controlType=='radio') || (item.controlType=='dropdown-list') || (item.controlType=='image'))
      return matchControls.length
    }
    

    return {
      writeControl,
      options,
      handleWriteChange,
      handleControlPos,
      handleSetWriterBatch,
      InitiatorId,
      hasWriteControl 
    }
  }
})
</script>

<style lang="less" scoped>
.doc-item{
    box-shadow: 5px 5px 20px #0000001a;
    margin: 10px 5px 40px;
    padding: 10px 15px;
    .doc-header{
      display: flex;
      align-items: center;
      margin-bottom:10px;
      font-size: 14px;
      font-weight: 550;
      .param-doc-name{
        margin-left:10px;
        white-space: nowrap;
        display: inline-block;
        width:100%;
        overflow: hidden;
      }
      .batch-set{
        cursor: pointer;
      }
      :deep(.ant-popover-inner-content){
        width:250px;
        ul{
          margin-bottom: 0;
        }
        li{
          margin:2px 0;
          padding:2px 5px;
          cursor: pointer;
        }
        li:hover{
          color:#127fd2;
          background-color: rgba(139 190 231 / 40%);
        }
      }
    }
  }
.full-parameter-content{
  li{
    margin-bottom: 10px;
  }
  .params-header{
    display: flex;
    align-items: center;
    margin-bottom: 7px;
      .params-name{
      font-size: 12px;
      font-weight: 550;
    }
  }
  .params-body{
    background: #f9f9f9;
    padding:15px 10px;
    .params-select{
      display: flex;
      align-items: center;
      span{
        white-space: nowrap;
        // flex:1;
      }
      :deep(.ant-select){
        // width:100%;
        flex:1;
        overflow: hidden;
      }
    }
  }
}
.control-no{
  color:#999;
  text-align:center;
}
.full-parameter-content{
  .control-focus-header{
    color:#127fd2;
  }
  .control-focus-body{
    background-color: rgba(139 190 231 / 70%);
    border:1px solid #67a5d4;
  }
}

</style>
