<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="app-password-init">
    <BasicModal v-bind="$attrs" @register="registerModal" title="初始化密码" @ok="handleSubmit" :footer="null">
        
    </BasicModal>
  </div>
</template>

<script lang="ts">

import {ref} from "vue";
import { BasicModal,useModalInner } from '/@/components/Modal';
import { Form, Input, Button, Checkbox ,Row, Col} from 'ant-design-vue';
import { useMessage } from '/@/hooks/web/useMessage';

interface VersionItem {
  id:string;
  versionName:string;
  versionDesc:string; 
}
interface AppItem {
   appVersionVOS:VersionItem[];
   loading:boolean;
   appName:string;
   versionId:string;
   containsFlag:boolean;
   appDesc:string;
   appIcon:string;
}

export default{
  name:"AppPassword",
  components:{
    BasicModal,
    Form,
    FormItem: Form.Item,
    Input,
    Button,
    Checkbox,
    Row,
    Col
  },
  setup(_,{emit}) {
   const appList = ref(<AppItem[]>[]);
  const { createMessage: msg } = useMessage();

   const [registerModal, { setModalProps }] = useModalInner(async (data) => {
      setModalProps({ confirmLoading: false,width:900,canFullscreen:false, closable:true,maskClosable:false,centered:false });
     
   })

   function handleSubmit(){
    msg.success('操作成功')
    emit('success')
   }
   
    return {
      appList,
      registerModal,
      handleSubmit
    }
  }
} 
</script>

<style lang="less" scoped>

</style>
