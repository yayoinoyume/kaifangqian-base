<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :class="prefixCls" class="relative w-full h-full">
    <div :class="prefixCls + '-header'">
      <div class="header-left">
        <!-- <img src="../../../assets/images/logo-sign.png" alt="" style="width:150px">  -->
        <img :src="logoBase64" alt="" style="width: 150px" />
        <!-- <span class="header-title">资助审批电子签章系统</span> -->
      </div>
      <!-- <div class="header-right">
        <a href="#" target="_blank">帮助文档</a>
        <a href="#" target="_blank">官网</a>
      </div> -->
    </div>
    <div class="container relative">
      <div class="flex">
        <div class="login-bg-container">
          <p class="copyright-footer">
            {{ webCopyRight }}
            <!-- <span>本平台仅用于学习交流</span> -->
          </p>
        </div>
        <div
          :class="`${prefixCls}-form`"
          class="relative w-full px-5 py-7 mx-auto my-auto rounded-md shadow-md xl:bg-transparent sm:px-8 xl:p-4 xl:shadow-none sm:w-3/4 lg:w-2/4 xl:w-auto enter-x"
        >
          <p class="login-title" v-if="TabKey === 'LOGIN' || TabKey === 'LOGIN_MOBILE'">欢迎登录</p>
          <Tabs
            size="large"
            @change="changeTab"
            class="login-tab-header"
            v-model:activeKey="TabKey"
          >
            <TabPane
              tab="账号登录"
              key="LOGIN"
              v-if="TabKey === 'LOGIN' || TabKey === 'LOGIN_MOBILE' || TabKey === 'EXPERIENCE'"
            >
              <LoginForm @change="changeTab" />
            </TabPane>
            <TabPane
              tab="验证码登录"
              key="LOGIN_MOBILE"
              v-if="TabKey === 'LOGIN' || TabKey === 'LOGIN_MOBILE' || TabKey === 'EXPERIENCE'"
            >
              <MobileForm />
            </TabPane>
            <!-- <TabPane tab="体验账号登录" key="EXPERIENCE" v-if="TabKey==='LOGIN'  || TabKey === 'EXPERIENCE' || TabKey=== 'LOGIN_MOBILE'">
              <MobileForm />
          </TabPane> -->
            <TabPane tab="登录校验" key="LOGIN_VERIFY" v-if="TabKey === 'LOGIN_VERIFY'">
              <MobileForm />
            </TabPane>
            <!-- <ForgetPasswordForm /> -->
            <TabPane tab="重置密码" key="RESET_PASSWORD" v-if="TabKey === 'RESET_PASSWORD'">
              <ForgetPasswordForm />
            </TabPane>
            <TabPane tab="找回账号" key="FIND_ACCOUNT" v-if="TabKey === 'FIND_ACCOUNT'">
              <ForgetAccount />
            </TabPane>
          </Tabs>
        </div>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
  import { computed, unref, ref } from 'vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import LoginForm from './LoginForm.vue';
  import MobileForm from './MobileForm.vue';
  import ForgetPasswordForm from './ForgetPasswordForm.vue';
  import ForgetAccount from './ForgetAccount.vue';
  import { Tabs } from 'ant-design-vue';
  // import { useRoute } from 'vue-router';
  import { useUserStore } from '/@/store/modules/user';
  import { useLoginState, LoginStateEnum } from './useLogin';
  import { getWhiteLogo, getOtherLogo, getWebCopyRight } from '/@/api/sys/user';
  import defaultLogo from '/@/assets/images/logo-sign.png';
  defineProps({
    sessionTimeout: {
      type: Boolean,
    },
  });

  const { prefixCls } = useDesign('login');
  const { getLoginState, setLoginState } = useLoginState();
  const TabPane = Tabs.TabPane;
  setLoginState(LoginStateEnum.LOGIN);
  const userStore = useUserStore();
  const logoBase64 = ref(defaultLogo);
  const webCopyRight = ref(
    '本平台仅用于学习交流',
  );

  userStore.setLoginToken(undefined);

  // if(route.fullPath.indexOf('experience')>-1){
  //   setLoginState(LoginStateEnum.EXPERIENCE)
  // }
  const TabKey = computed(() => LoginStateEnum[unref(getLoginState)]);

  // async function getLogo(){
  //   getOtherLogo({}).then(res=>{
  //       if(res){
  //           logoBase64.value = res.image;
  //       }
  //   })
  // }
  // getLogo();

  // async function geCopyRight(){
  //   let result = await getWebCopyRight({});
  //   if(result){
  //       webCopyRight.value = result;
  //   }
  // }
  // geCopyRight();
  async function initData() {
    const web: any = userStore.getWebConfig;
    webCopyRight.value = web.websiteCopyright || webCopyRight.value;
    logoBase64.value = web.websiteOtherLogo || logoBase64.value;
  }
  initData();
  // const getShow = computed(() => unref(getLoginState) === LoginStateEnum.LOGIN);
  function changeTab(val) {
    if (val === 'LOGIN_VERIFY') {
      setLoginState(LoginStateEnum.LOGIN_VERIFY);
    }
    // if(val==='LOGIN' && route.fullPath.indexOf('experience') === -1){
    if (val === 'LOGIN') {
      setLoginState(LoginStateEnum.LOGIN);
    }
    // if(val==='LOGIN_MOBILE' && route.fullPath.indexOf('experience') === -1){
    if (val === 'LOGIN_MOBILE') {
      setLoginState(LoginStateEnum.LOGIN_MOBILE);
    }
    if (val === 'EXPERIENCE') {
      setLoginState(LoginStateEnum.EXPERIENCE);
    }
  }
</script>
<style lang="less">
  @import './login.less';
</style>
