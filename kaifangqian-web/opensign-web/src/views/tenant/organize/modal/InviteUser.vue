<!--
  @description 资助审批电子签章系统
-->

<template>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
        <template #title>
          <span class="modal-title">{{ getTitle }}</span>
          <span class="organize-name">{{ organizeName }}</span>
        </template>
        <div class="invite-content">
          <div class="invite-left block">
            <p class="block-title">
              企业邀请码
              <a-popover title="说明">
                <template #content>
                  <p>企业邀请码</p>
                </template>
                <ExclamationCircleOutlined />
              </a-popover>
            </p>
            <p class="block-desc">成员可输入企业邀请码加入企业</p>
            <a href="javascript:;">查看使用说明</a>
            <div class="block-code">
              {{  inviteCode }}
            </div>
            <a-button type="default" size="small" class="copy-btn" @click="handleCopy(inviteCode)">复制企业邀请码</a-button>
          </div>
          <div class="invite-right block">
              <p class="block-title">
                企业链接
              </p>
              <p class="block-desc">成员访问链接可申请加入企业</p>
              <div class="block-link">
                {{  inviteLink }}
              </div>
              <a-button type="default" size="small" class="copy-btn" @click="handleCopy(inviteLink)">复制企业邀请链接</a-button>
          </div>
         </div>
      </BasicModal>
</template>
<script lang='ts'>
  import { defineComponent,ref,reactive,unref } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { ExclamationCircleOutlined} from '@ant-design/icons-vue'
  import { useMessage } from '/@/hooks/web/useMessage'; 
  import { Form, Input, Row, Col } from 'ant-design-vue';
  import { useFormRules } from '/@/views/sys/login/useLogin';
  import { useCopyToClipboard } from '/@/hooks/web/useCopyToClipboard';
  

  export default defineComponent({
    name: 'InviteUser',
    components:{
      BasicModal,
      Form,
      Input,
      Row, Col,
      ExclamationCircleOutlined
    },
    setup(_,{}){
      const getTitle = ref('邀请成员加入');
      const departId = ref('');
      const organizeName = ref('');
      const inviteCode = ref('XHJK IOIU');
      const inviteLink = ref('');
      const slideCodeShow = ref(false);
      const { getFormRules } = useFormRules();
      const formData = reactive({
        name:'',
        phone:'',
        captcha:''
      })
      const { createMessage: msg ,createSuccessModal} = useMessage();
      const [registerModal, { setModalProps,closeModal }] = useModalInner(async (data) => {
        setModalProps({ 
          confirmLoading: false,
          width:800,
          canFullscreen:false,
          cancelText:'关闭' 
        });
        organizeName.value = data.record.organizeName;
        departId.value = data.record.currentDeptId;
       
      });
      async function handleSubmit(){
       
       

      }

      function handleCopy(value) {
        const { isSuccessRef } = useCopyToClipboard(
          value
        );
        unref(isSuccessRef) &&
          createSuccessModal({
            title: '复制成功'
          });
      }
      function sendCodeApi(){
      return new Promise((resolve)=>{
          if(!formData.phone){
            msg.warning('请输入手机号');
            return false;
          }
          slideCodeShow.value = true;
          resolve(!unref(slideCodeShow));
          return !unref(slideCodeShow);
        })
      }
     

      return {
        handleCopy,
        sendCodeApi,
        registerModal,
        handleSubmit,
        getTitle,
        formData,
        getFormRules,
        inviteCode,
        inviteLink,
        organizeName
      }
    },
  })
</script>
<style lang="less" scoped>
.modal-title{
  margin-right: 20px;
}
.organize-name{
  color: #666;
  padding:2px 10px;
  box-sizing: border-box;
  border-radius: 20px;
  min-width: 50px;
  text-align: center;
  font-size: 12px;
  display: inline-block;
  background-color: #afcde5;
}
  .invite-content{
    display: flex;
    justify-content: space-between;
    .block{
      border-radius: 4px;
      background-color: #f4f4f4;
      padding:25px 20px;
      box-sizing: border-box;
      margin:0 5px;
      width:50%;
      p{
        margin-bottom: 0px;
      }
      .block-title{
        font-size: 14px;
        color:#000;
      }
      .block-desc,a{
        font-size: 12px;
      }
      .block-code{
        font-size: 30px;
        color:#000;
        margin-top:30px;
        min-height: 100px;
      }
      .block-link{
        width:100%;
        margin:0 auto;
        min-height: 100px;
        border-radius: 4px;
        margin-top:50px;
        background-color: #ddd;
      }
      .copy-btn{
        margin-top: 20px;
        font-size: 12px;
      }
    }
  }
</style>
