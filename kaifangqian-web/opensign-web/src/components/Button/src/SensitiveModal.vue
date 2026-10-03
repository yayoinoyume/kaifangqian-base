<!--
  @description 资助审批电子签章系统
-->

<template>
  <span >
    <Modal class="sensitive-modal" v-model:visible="visibleModal" width="450px" title="当前操作为敏感操作请完成验证以继续" @ok="handleOk"  @cancel="handleCancel" :closable="false" :destroyOnClose="true">
        <Form  class="p-3 enter-x" :model="formData" :rules="getFormRules" ref="formRef">
            <FormItem name="sensitivePhone" class="enter-x" v-if="verifyType==='phone'">
              <Input
                size="large"
                v-model:value="formData.sensitivePhone"
                placeholder="手机号"
                class=""
              />
            </FormItem>
            <FormItem name="sensitivePassword" class="enter-x" v-if="verifyType==='password'">
              <Input
                size="large"
                v-model:value="formData.sensitivePassword"
                placeholder="密码"
                class=""
              />
            </FormItem>
            <FormItem name="sensitiveCaptch" class="enter-x" v-if="verifyType==='phone'">
              <CountdownInput
                size="large"
                class="fix-auto-fill"
                v-model:value="formData.sensitiveCaptch"
                placeholder="短信验证码"
                ref="smsCount"
                :sendCodeApi="sendCodeApi"
              />
            </FormItem>
        </Form>
        <PuzzleVerification  :w="385" @success="handleSildeSuccess" :sliderText="sliderText" @fail="handleFail"  v-if="slideCodeShow"/>
    </Modal>
  </span>
</template>
<script lang='ts'>
import { defineComponent,ref, unref ,reactive, computed} from 'vue';
import { Form, Input, Modal} from 'ant-design-vue';
import PuzzleVerification from '/@/components/verification/index.vue';
import { CountdownInput } from '/@/components/CountDown';
import { getSmsCode } from '/@/api/sys/user'; 
import {useFormValid } from '/@/views/sys/login/useLogin';
import { useAppStoreWithOut } from '/@/store/modules/app';


export default defineComponent({
  name: 'SensitiveModal',
  components:{
    Form,
    Input,
    FormItem:Form.Item,
    PuzzleVerification,
    CountdownInput,
    Modal

  },
  props:{
    visible:{ type: Boolean },
    sensitiveVerifyType:{type:String}
  },
  setup(props,{emit}){

    const slideCodeShow = ref(false);
    const sliderText = ref('向右滑动完成拼图');
    const smsCount = ref(null);
    // const visibleModal = computed(()=> props.visible);
    // console.log(visibleModal,'0000000000000000')
    const verifyType = computed(()=> props.sensitiveVerifyType)
    const formRef = ref();


    const getFormRules = ref({
      sensitivePhone:[{ required: true, trigger:'blur', message:'请输入账号'}]
    })
    const formData = reactive({
      sensitivePhone:'',
      sensitiveCaptch:'',
      sensitiveCaptchKey:'',
      sensitivePassword:''

    });
    const { validForm } = useFormValid(formRef);
    const appStore  = useAppStoreWithOut();
    // const visibleModal = computed(()=> appStore.getSensitiveConfig.visible);
    // console.log(visibleModal,'显示与否')
    const visibleModal = ref(false);



    async function sendCodeApi(){
      const data = await validForm();
      if(!data) return;
      return new Promise((resolve)=>{
        slideCodeShow.value = true;
        resolve(!unref(slideCodeShow));
        return !unref(slideCodeShow);
      })
    }
    function handleFail(){
      sliderText.value = '验证失败';
      setTimeout(()=>{
        sliderText.value = '向右滑动完成拼图';
      },1000)
    }

     function handleSildeSuccess(){
      sliderText.value = '验证成功';
      setTimeout(async ()=>{
        if(smsCount.value){
          slideCodeShow.value = false;
          let result = await getSmsCode({sensitivePhone:formData.sensitivePhone,type:'mobile_login'});
          if(result){
            formData.sensitiveCaptchKey = result;
          }
          smsCount.value.triggerClick();
        }
      },2000)
    }


    async function handleOk(){
      const data = await validForm();
      if(!data) return;





      emit('confirm')
    }
    function handleCancel(){
      emit('cancelModal')
    }
    return {  
      handleCancel,
      handleOk,
      formData,
      sendCodeApi,
      slideCodeShow,
      handleSildeSuccess,
      sliderText,
      getFormRules,
      smsCount,
      handleFail,
      formRef,
      visibleModal,
      verifyType
    }
  }
})
</script>

<!-- <style lang="less" scoped>
.sensitive-modal{
  .ant-modal{
    .ant-modal-body{
      padding:24px;
    }
  }
}

</style> -->
