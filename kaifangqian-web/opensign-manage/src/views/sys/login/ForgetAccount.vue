<!--
  @description 资助审批电子签章系统
-->

<template>
  <template v-if="getShow">
    <Form class="p-4 enter-x" :model="formData" :rules="getFormRules" ref="formRef">
      <FormItem name="email" class="enter-x" v-if="!getMobile">
        <Input size="large" v-model:value="formData.email" placeholder="邮箱" />
      </FormItem>
      <FormItem name="phone" class="enter-x" v-if="getMobile">
        <Input size="large" v-model:value="formData.phone" placeholder="手机号" />
      </FormItem>
       <FormItem name="captcha" class="enter-x">
          <CountdownInput
            size="large"
            class="fix-auto-fill"
            ref="smsCount"
            v-model:value="formData.captcha"
            placeholder="验证码"
            :sendCodeApi="(sendCodeApi as any)"
          />
      </FormItem>
      <FormItem class="enter-x">
        <a-button type="primary" size="large" block @click="handleReset" :loading="loading">
          确定
        </a-button>
        <a-button size="large" block class="mt-4" @click="handleBackLogin"> 返回 </a-button>
      </FormItem>
    </Form>
    <PuzzleVerification :w="356" @success="handleSildeSuccess" @fail="handleFail" :sliderText="sliderText" v-if="slideCodeShow"/>
  </template>
</template>
<script lang="ts" setup>
  import { reactive, ref, computed, unref, h } from 'vue';
  import { Input, Form} from 'ant-design-vue';
  import { useLoginState, useFormRules, LoginStateEnum,ResetPassEnum, useFormValid } from './useLogin';
  import { CountdownInput } from '/@/components/CountDown';
  import PuzzleVerification from '/@/components/verification/index.vue';
  import { getUserName, getSmsCode, getEmailCode } from '/@/api/sys/user';
  import { useMessage } from '/@/hooks/web/useMessage';
  
  const { handleBackLogin, getLoginState, getResetPasswordType } = useLoginState();
  const { getFormRules } = useFormRules();
  const FormItem = Form.Item;
  
  const formRef = ref();
  const loading = ref(false);

  const formData = reactive({
    phone: '',
    email: '',
    captcha: '',
    newpassword:'',
    confirmpassword:'',
    inputPassword:true,
    inputConfirmPassword:true
  });
  const captchaKey = ref('');
  const slideCodeShow = ref(false);
  const sliderText = ref('向右滑动完成拼图');
  const { createMessage, createConfirm } = useMessage();
  const smsCount = ref(null);
  const getShow = computed(() => unref(getLoginState) === LoginStateEnum.FIND_ACCOUNT);
  const getMobile = computed(() => unref(getResetPasswordType) === ResetPassEnum.MOBILE);
  
  const { validForm } = useFormValid(formRef);

  async function handleReset() {
    const data = await validForm();
    if (!data) return;
    let params = {
      phone:formData.phone,
      email:formData.email,
      captchaKey:unref(captchaKey),
      captcha:formData.captcha,
      type:getMobile.value?'phone':'email'
    }
    let result =  await getUserName(params);
    if(result){
      // createMessage.success('操作成功');
      createConfirm({
          iconType: 'success',
          title: () => h('span', '账号找回成功'),
          content: () => h('span',`您的账号为: ${result}, 点击确定跳转至登录页`),
          okText:'确定',
          cancelText:'取消',
          onOk: async () => {
            handleBackLogin()
          },
      })
    }
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
          let result
          if(getMobile.value){
            result = await getSmsCode({email:formData.email,phone:formData.phone,type:'mobile'});
          }else{
            result = await getEmailCode({email:formData.email,phone:formData.phone,type:'email'});
          }
          if(result){
            captchaKey.value = result;
            console.log(result,'结果');
          }
          smsCount.value.triggerClick();
        }
      },1000)
    }
    function sendCodeApi(){
      return new Promise((resolve)=>{
        console.log(getMobile.value,'--类型--')
        if(getMobile.value&&!formData.phone){
          createMessage.warning('请输入手机号');
          return false;
        }
        if(!getMobile.value&&!formData.email){
          createMessage.warning('请输入邮箱');
          return false;
        }
        slideCodeShow.value = true;
        resolve(!unref(slideCodeShow));
        return !unref(slideCodeShow);
      })
    }
</script>
