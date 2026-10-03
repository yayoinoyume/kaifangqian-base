<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="transition-area">
      <div class="main-transition">
        <Icon icon="ant-design:check-circle-outlined" size="80" color="#127fd2"/>
        <p class="transition-title">用户注册成功</p>
        <p class="transition-tip">
          <span class="transition-number">{{ countNumber  }}</span>
          <span>秒后自动跳转登录页</span>
        </p>
      </div>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent,onMounted,nextTick} from "vue";
import { Icon } from '/@/components/Icon';
import { useGo } from '/@/hooks/web/usePage';

export default defineComponent({
  name:"Transition",
  components:{
    Icon
  },
  setup() {
    const countNumber = ref(3);
    let timer: ReturnType<typeof setInterval> | null;
    const go = useGo();

    onMounted(()=>{
          timer = setInterval(() => {
          console.log(countNumber.value,'00000----')
          if(countNumber.value == 0){
            clearInterval(timer);
            go('/login')
            return;
          }
          nextTick(()=>{
            countNumber.value = countNumber.value - 1;
          })
        },1000)
      
    })
    return {
      countNumber  
    }
  }
})
</script>

<style lang="less" scoped>
.transition-area{
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  .transition-title{
    font-size: 34px;
    margin-top:20px;
  }
  .main-transition{
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }
  .transition-tip{
    font-size: 18px;
  }
  .transition-number{
    font-size: 28px;
    color:#127fd2;
    margin-right: 10px;
  }
}
</style>
