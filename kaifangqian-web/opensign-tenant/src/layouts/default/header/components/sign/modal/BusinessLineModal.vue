<!--
  @description 资助审批电子签章系统
-->


<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" title="选择业务线" @ok="handleSubmit" :destroyOnClose="true" >
      <a-select
        style="width:100%"
        v-model:value="lineId"
        placeholder="请选择业务线"
        :options="options"
        :fieldNames="{label:'name',value:'id'}"
        @change="handleChange"
      ></a-select>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
import { defineComponent, computed, ref, unref } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { Icon } from '/@/components/Icon';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';
import { getBusinessLine } from '/@/api/contract';

export default defineComponent({
  name: 'BusinessLineModal',
  components:{
    BasicModal,
    Icon
  },
  setup(_,{emit}){
      const lineId = ref(undefined);
      const options = ref([
        {label:'测试业务线',value:1},
        {label:'测试业务线2',value:2},
      ]);
      const userStore = useUserStore();
      const { createMessage: msg, } = useMessage();
      const [registerModal, { setModalProps }] = useModalInner(async (data) => {
          setModalProps({ 
            confirmLoading: false,
            width:500,
            canFullscreen:false, 
            closable:false,
            maskClosable:false,
            centered:true,
            minHeight:70 
          });
          lineId.value = undefined;
          options.value = data.record?.list;

          // let result = await getBusinessLine({});
          // if(result){
          //   options.value = result.records;
          // }

      });
      const loginDepartId =  computed(()=>userStore.getUserInfo.loginDepartId);


      function handleSubmit(){         
          if(!unref(lineId)){
            msg.warning('请选择业务线');
            return
          }
          emit('success',unref(lineId))
      }

      function handleChange(){
        
      }
      return {
        registerModal,
        handleSubmit,
        loginDepartId,
        lineId,
        options,
        handleChange
      }
  },
})
</script>
<style lang="less" scoped>
</style>
