<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="sign-enter-container">
    <a-button type="primary"  shape="round" class="sign-enter" @click="handleSelectLine">
      <template #icon>
        <Icon icon="ant-design:plus-outlined"/>
      </template>
      发起签署
    </a-button>
    <BusinessLineModal @register="registerModal" @success="handleStart"/>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import BusinessLineModal from '/@/layouts/default/header/components/sign/modal/BusinessLineModal.vue';

import { getBusinessLine } from '/@/api/contract';

import { Icon } from '/@/components/Icon';

import { useModal } from '/@/components/Modal';

import { useMessage } from '/@/hooks/web/useMessage';



export default defineComponent({
  name:"SignEnter",
  components:{
    Icon,
    BusinessLineModal
  },
  setup() {


    const [registerModal,{openModal,closeModal}] = useModal();
    const { createMessage: msg } = useMessage();


   async  function handleSelectLine(){
      let result = await getBusinessLine({});
      if(result.length>1){
        openModal(true,{
          isUpdate:false,
          record:{
            list: result
          }
        })
      }else if(result.length==1){  
        window.open(import.meta.env.VITE_PUBLIC_PATH + '#/contract/start?__full__&signReId=' + result[0].id)
      }else if(result.length==0){
        msg.warning('您暂无发起权限，请联系企业管理员')
      }

     
    }

    function handleStart(val){
      closeModal()
      window.open(import.meta.env.VITE_PUBLIC_PATH+'#/contract/start?__full__&signReId=' + val)
    }

    return {
      registerModal,
      handleSelectLine,
      handleStart
    }
  }
})
</script>

<style lang="less" scoped>
</style>
