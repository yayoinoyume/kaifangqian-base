<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicModal v-bind="$attrs" @register="registerModal" :title="getTitle" @ok="handleSubmit">
           <Form  class="p-2 enter-x" :model="formData" :rules="getFormRules" ref="formRef" :labelCol="{span:3}">
              <FormItem name="mobile" class="enter-x" label="邮箱">
                  <Input
                    size="large"
                    :disabled="formData.disabled"
                    v-model:value="formData.email"
                    placeholder="邮箱"
                    class="fix-auto-fill"
                  />
                </FormItem>
                <FormItem name="sms" class="enter-x" label="验证码">
                  <CountdownInput
                    size="large"
                    class="fix-auto-fill"
                    v-model:value="formData.sms"
                    placeholder="验证码"
                    ref="smsCount"
                    :sendCodeApi="sendCodeApi"
                  />
                </FormItem>
          </Form>
          <PuzzleVerification :w="356" :style="positionStyle" @success="handleSildeSuccess" :sliderText="sliderText" @fail="handleFail"  v-if="slideCodeShow"/>
      </BasicModal>
  </div>
</template>
<script lang='ts'>
  import { defineComponent,ref,unref,computed,reactive } from 'vue'
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { CountdownInput } from '/@/components/CountDown';
  import PuzzleVerification from '/@/components/verification/index.vue';
  import {getEmailCode,unBindEmail,bindEmail, getTokenEmail  } from '/@/api/sys/user';
  import { Form, Input,Row, Col } from 'ant-design-vue';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { validateSmscode } from '/@/utils/rules';
  import {useFormValid} from '/@/views/sys/login/useLogin';


  export default defineComponent({
    name: 'AnnounceFormModal',
    components:{
      BasicModal,
      CountdownInput,
      PuzzleVerification,
      Form,
      FormItem:Form.Item,
      Input,
      Row, Col
    },
    setup(_, { emit }){
      const isUpdate = ref(true);
      const sliderText = ref('向右滑动完成拼图');
      const smsCount = ref(null);
      const slideCodeShow = ref(false);
      const { createMessage: msg } = useMessage();
      const formData = reactive({
        email:'',
        sms:'',
        disabled:false,
        captchaKey:''
      })
      const positionStyle = {
        left: '50%',
        transform: `translate(${-50 + '%' }, ${-50 + '%'})`,
        top: '50%'
      }
      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ confirmLoading: false,width:550, });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          formData.email = data.record.email;
          formData.disabled = data.record.email?true:false;
          formData.sms = '';
        }
         
      });
      const  getFormRules  = ref({
        sms:[{ required: true, trigger:'blur', validator:validateSmscode}],
      })
      const formRef = ref();
      const { validForm } = useFormValid(formRef);
      const getTitle = computed(() => (unref(isUpdate) ? '解绑邮箱' : '绑定邮箱'));

      async function handleSubmit() {
        try {
          const data = await validForm();
          if(!data) return;
          setModalProps({ confirmLoading: true });
          // TODO custom api
          let params = {
            email:formData.email,
            captcha:formData.sms,
            captchaKey:formData.captchaKey,
          }
          let result:any = {};
          if(unref(isUpdate)){
            result = await unBindEmail(params);
          }else{
            result = await bindEmail(params);
          }
          if(result){
            closeModal();
            msg.success('操作成功');
            emit('success' );
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }
      function handleTinymceChange(value: string) {
        console.log(value);
      }
      function sendCodeApi(){
        return new Promise(async (resolve)=>{
          // let data = await validate()
          // if(!data.email){
          //   createMessage.warning('请输入手机号');
          //   return false;
          // }
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
            let result = await getTokenEmail({email:formData.disabled?undefined:formData.email, type:'mobile_login'});
            if(result){
             formData.captchaKey = result;
            }
            smsCount.value.triggerClick();
          }
        },2000)
      }

      return {smsCount, formRef,registerModal,positionStyle,formData,getFormRules, getTitle, handleSubmit,handleTinymceChange,handleSildeSuccess,sliderText,slideCodeShow,sendCodeApi,
      handleFail };
    }
  })
</script>
<style >
 
</style>
