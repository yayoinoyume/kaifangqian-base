<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicModal
    width="800px"
    title="预览"
    class="upload-preview-modal"
    v-bind="$attrs"
    @register="registerModal"
    :showOkBtn="false"
  >
  <img :src="previewImgBase64" alt="">
  </BasicModal>
</template>
<script lang="ts">
  import { defineComponent, ref } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import {getImgBase64} from '/@/api/sys/upload';

  export default defineComponent({
    name:'Preview',
    components: { BasicModal },
    props: {

    },
    setup() {
      const previewImgBase64 = ref('');

      const [registerModal, {setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          defaultFullscreen:true,
          cancelText:'关闭',
          zIndex:1300,
          getContainer: () => document.body.querySelector('.register-form') || document.body,
        });
        if(data.imgId){
          let result = await getImgBase64({imgId:data?.imgId});
          if(result){
            previewImgBase64.value = result.image
          }
        }
      })
    
      return {
        registerModal,
        closeModal,
        previewImgBase64
      };
    },
  });
</script>
<style lang="less">
  .upload-preview-modal {
    .ant-upload-list {
      display: none;
    }

    .ant-table-wrapper .ant-spin-nested-loading {
      padding: 0;
    }
  }
</style>
