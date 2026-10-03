<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" :destroyOnClose="true" wrapClassName='sign-modal'>
      <Params @cancel="handelCancel"></Params>
    </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed  } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { useRouter } from 'vue-router';
  import Params from '@/views/contract/params/index.vue';


  export default defineComponent({
    name: 'ParamsModal',
    components:{
      BasicModal,
      Params
    },
    setup(_, { emit }){

      const isUpdate = ref(true);
      const signReId = ref('');
      const signRuId = ref('');
      const taskId = ref('');

      const router = useRouter();
      const { createMessage: msg } = useMessage();
     

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭',
          footer:null,
          defaultFullscreen:true,
        });
        signReId.value = data.record?.signReId;
        signRuId.value = data.record?.signRuId;
        taskId.value = data.record?.taskId;
        router.replace({
            query:{
              signReId:unref(signReId),
              signRuId:unref(signRuId),
              taskId:unref(taskId),
            }
          })
        
      });
     

      
      const getTitle = computed(() => (!unref(isUpdate) ? '填写文档参数' : '填写文档参数'));

      function handelCancel(){
        closeModal()
      }

      async function handleSubmit() {
        try {

            msg.success('保存成功');
            closeModal();
            emit('success', );
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      return { 
        registerModal, 
        getTitle, 
        handleSubmit,
        handelCancel
      };
    }
  })
</script>
<style lang="less" scoped>
  
</style>
