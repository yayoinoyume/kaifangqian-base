<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="no-auth">
    <SvgIcon name="no-auth1" :size="100"/>
    <p>您暂无该应用的权限</p>
    <p>请联系企业管理员为您分配权限</p>
    <a-button type="primary" @click="backParent()" style="width: 100px;">返回</a-button>
  </div>
</template>

<script lang="ts">
  import { defineComponent, ref, onMounted, unref } from 'vue';
  import { SvgIcon } from '/@/components/Icon';
    
  export default defineComponent({
    name: 'noAuth',
    components: {
      SvgIcon
    },
    setup() {
      const backParent=()=>{
      	if(window.opener){
          window.close();
          window.opener.focus();
      	}else{
          window.open(window.appInfo.sign_app_info.url);
          window.close();
      	}
      }
      return{
        backParent
      }
    }
  })
</script>

<style lang="less">
  .no-auth{
    width: 300px;
    text-align: center;
    margin: 0 auto;
    padding-top: 300px;
    font-size: 16px;
    font-weight: 600;
  }
</style>
