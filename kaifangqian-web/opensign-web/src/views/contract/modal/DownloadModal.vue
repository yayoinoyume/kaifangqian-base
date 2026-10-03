<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
       <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit" :destroyOnClose="true" wrapClassName="download-modal">
          <a-checkbox
            v-model:checked="state.checkAll"
            :indeterminate="state.indeterminate"
            @change="onCheckAllChange"
          >
            全部文件
          </a-checkbox>
          <a-divider />
          <a-checkbox-group v-model:value="state.checkedList">
            <template v-for="(item,index) in fileList" :key="index">
            <a-checkbox :value="item.id" >{{item.name}}</a-checkbox>
            </template>
          </a-checkbox-group>
        </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed, reactive ,watch } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { handleRuDownload } from '/@/utils';



  export default defineComponent({
    name: 'DownloadModal',
    components:{
      BasicModal,
    },
    setup(_, { emit }){

      const isUpdate = ref(true);
      const signRuId = ref('');

      const fileList:any = ref([]);
      const allKeys = ref([])

      const state = reactive({
        indeterminate: false,
        checkAll: false,
        checkedList: [],
      });

      const onCheckAllChange = (e: any) => {
          // state.checkedList = e.target.checked? allKeys.value:[]
          Object.assign(state, {
            checkedList: e.target.checked ? allKeys.value : [],
            indeterminate: false,
          });
      };

      watch(
        ()=>state.checkedList,
        ()=>{
          state.checkAll = state.checkedList.length === allKeys.value.length;
        }
      )
     
      const { createMessage: msg } = useMessage();
     

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:600,
          cancelText:'关闭',
          // showOkBtn:false, 
        });
        signRuId.value = data.record?.signRuId;
        fileList.value = data.record?.fileList;
        allKeys.value = []
        state.checkedList =  [];
        fileList.value.map(v=>{
          allKeys.value.push(v.id)
        })
        
      });
      const getTitle = computed(() => (!unref(isUpdate) ? '文件下载' : '文件下载'));

      async function handleSubmit() {
        if(state.checkedList.length>0){
          try {
            handleRuDownload({signRuId:signRuId.value,ruDocIdList:state.checkedList.join(',')})
              closeModal();
              emit('success');
          } finally {
            setModalProps({ confirmLoading: false });
          }
        }else{
          msg.warning("请至少选择一个文件再下载");
        }
        
      }
      return { 
        registerModal, 
        getTitle, 
        handleSubmit,
        onCheckAllChange,
        fileList,
        state
      };
    }
  })
</script>
<style lang="less" scoped>
.download-modal{
  .ant-divider-horizontal{
    margin:10px 0 25px;
  }
  .ant-checkbox-wrapper{
    margin-left:0;
    display:flex;
  }
}

  
</style>
