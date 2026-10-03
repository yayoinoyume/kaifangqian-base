<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
         <div v-html="content"></div>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed, reactive } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { Icon } from '/@/components/Icon';
  import { addArticleAdd, editArticle, getArticleInfo } from '/@/api/article';
  import { PlusOutlined } from '@ant-design/icons-vue';
  import { useMessage } from '/@/hooks/web/useMessage';

  export default defineComponent({
    name: 'PreviewModal',
    components:{
      BasicModal,
      PlusOutlined,
      Icon,
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const recordId = ref('');
      const content = ref()
      const { createMessage: msg } = useMessage();
      

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        
        setModalProps({ 
          confirmLoading: false,
          width:1200,
          cancelText:'关闭' 
        });
        isUpdate.value = !!data?.isUpdate;
        recordId.value = data.record.id;

        let result = await getArticleInfo({id:recordId.value })
        if(result){
          content.value = result.content;
        }
          
      });

  
      const getTitle = computed(() => (!unref(isUpdate) ? '文章预览' : '文章预览'));

      async function handleSubmit() {
        try {
         
            emit('success');
            closeModal();
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }

      return { 
          registerModal,
          getTitle,
          handleSubmit,
          content
      
      };
    }
  })
</script>
<style>
 
</style>
