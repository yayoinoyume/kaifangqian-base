<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <a-modal class="keep-alive-modal" v-model:visible="visibleKeepAliveLogin" width="280px" title="" :footer="null" :closable="false" :destroyOnClose="true" >
      <div class="countdown-process">
        <a-progress type="circle" :percent="countdown" :width="120" status="active">
          <template #format="countdown">
            <p class="countdown-number">{{ progresstext }}</p>
            <p class="countdown-text">秒</p>
          </template>
        </a-progress>
      </div>
      <div class="alive-tip">
        <p class="alive-tip-title">登录超时</p>
        <p class="alive-tip-content">为了您的账号安全，请重新登录</p>
        <p class="alive-tip-content">给您带来的不便敬请谅解</p>
      </div>
      <a-button type="primary" class="alive-btn" @click="handleLoginOut">立即前往登录</a-button>
    </a-modal>
  </div>
</template>
<script lang='ts'>
import { defineComponent, computed,ref, watch} from 'vue';
import { useUserStore } from '/@/store/modules/user';
export default defineComponent({
  name: 'KeepLoginAlive',
  commponents:{
  },
  setup(){

    const userStore = useUserStore();
    const countdown = ref(100);
    const progresstext = ref(5);
    const timer = ref<any>();

    const visibleKeepAliveLogin = computed(() => userStore.getKeepLoginAlive === false);

    watch(
      visibleKeepAliveLogin,
      (val) => {
        console.log(val,'value新值');
        if(val){
          timer.value = setInterval(()=>{
            progresstext.value = progresstext.value - 1;
            countdown.value =  countdown.value - 20;
            console.log(countdown.value,'倒计时')
            if(progresstext.value <= 0){
              clearInterval(timer.value);
              userStore.logout(true);
              userStore.setKeepLoginAlive(true);
            }
          },1000)
        }
      },
      {
        immediate: true,
      },
    );

    function handleLoginOut(){
      userStore.logout(true);
    }



    return {
      visibleKeepAliveLogin,
      countdown,
      handleLoginOut,
      progresstext
    }
  }
})
</script>
<style lang="less">
.keep-alive-modal{
  p{
    margin-bottom: 0;
  }
  text-align: center;
  .ant-modal-body{
    position: relative;
    padding-bottom: 30px;
  }
  .countdown-process{
    margin:-50px 0 30px;
   .ant-progress-inner{
      background-color: #fff;
    }
  }
  .ant-progress-text{
    .countdown-number{
      font-size: 26px;
    }
    .countdown-text{
      font-size: 18px;
      margin-top:10px;
      color: #666;
    }
  }
  .alive-tip-title{
    font-size: 18px;
    margin-bottom:10px;
    font-weight: 600;
  }
  .alive-tip-content{
    font-size: 14px;
    color: #666;
  }
  .alive-btn{
    margin-top:20px;
    width:80%;
  }
}
.countdown-text{

}
 
</style>
