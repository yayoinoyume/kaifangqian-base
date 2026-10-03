<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="选择签名">
      <BasicTable @register="registerTable">
       
        <!-- <template #isDefault="{record}">
          {{record.isDefault === 1?'是':'否'}}
        </template> -->
        <template #annexId="{record}">
          <div class="preview-img">
            <img :src="record.image"/>
          </div>
        </template>
        <template #action="{ record }">
          <!-- <a-button type="link" size="small" @click="setSignDefault(record.sealId)">设为默认</a-button> -->
          <a-button type="link" size="small" @click="seslectSignature(record)">选择</a-button>
        </template>
      </BasicTable>
      <template #footer>
      	<div>
      		<a-button @click="closeModal">关闭</a-button>
      	</div>
      </template>
    </BasicModal>
  </div>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import { BasicTable, useTable} from '/@/components/Table';
  import {registerColumns,registerSearchFormSchema} from "../data"
  import {useRouter} from "vue-router";
  import { getImgBase64} from '/@/api/sys/upload'; 
  
  import { BasicModal, useModalInner } from '/@/components/Modal';
  
  import {signList} from "../api"
  
  export default defineComponent({
    name:'SignatureTable',
    components: { 
       BasicTable,BasicModal
    },
    setup(_,{emit}) {
      const router = useRouter();
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:900,
          //cancelText:'关闭' ,
          centered:true,
          canFullscreen:false
        });
        // reload();
      });
      
      const [registerTable,{reload}] = useTable({
        title: '',
        api: signList,
        columns:registerColumns,
        fetchSetting:{
          listField:'records'
        },
        immediate:true,
        useSearchForm: false,
        isTriggerSelect:false,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: false,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
        afterFetch:beforeFetch
      })
      async function beforeFetch(params){
       for(var i = 0;i<params.length ;i++){
         const result = await getImgBase64({imgId:params[i].annexId});
         params[i].image = result.image;
       }
      }
      async function seslectSignature(row){
        closeModal();
        emit("success",{sealId:row.sealId,image:row.image});
      }
      return{
        registerTable,seslectSignature,registerModal,closeModal
      }
    }
  })
</script>

<style lang="less" scoped>
  
  .preview-img img{
    height: 80px;
    padding: 8px;
    // border: 1px solid #ededed;
  }
  

</style>
