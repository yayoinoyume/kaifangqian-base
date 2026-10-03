<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container adjust-area">
        <a-button type="primary" @click="handleEdit">编辑</a-button>
        <p v-html="serveInfo.mediateContent"></p>
        <ServeModal @register="registerModal" @success="handleSuccess"></ServeModal>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent, onMounted } from "vue";
import ServeModal from './modal/ServeModal.vue';
import { BasicModal, useModal } from '/@/components/Modal';
import { getProtocolInfoByToken } from '/@/api/protocol';

export default defineComponent({
  name:"Serve",
  components:{
    BasicModal,
    ServeModal
  },
  setup() {
    const data = ref('');
    const serveInfo = ref({
      mediateContent:'',
      id:''
    }) 

    const [registerModal,{openModal}] = useModal();
    function handleEdit(){
      openModal(true,{
        isUpdate:true,
        record:{
          ...serveInfo.value
        }
      })
    }
    
    onMounted(()=>{
      fetch()
    })

    async function fetch(){
      let result = await getProtocolInfoByToken({type:'serve'});
      if(result){
        serveInfo.value = {
          mediateContent: result.value,
          id:result.id
        } 
      }
    }
    function handleSuccess(){
      fetch()
    }

    return {
         data,
         serveInfo,
         registerModal,
         handleEdit,
         handleSuccess 
    }
  }
})
</script>

<style lang="less" scoped>
.adjust-area{
  padding:20px 25px;
}
</style>
