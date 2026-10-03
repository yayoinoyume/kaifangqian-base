<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container">
    <div class="header-area">
      <div class="header-left">
        <img src="../../../assets/images/logo.png" alt="">
      </div>
      <div class="header-right">
        <a-button type="primary">免费注册</a-button>
      </div>
    </div>
    <div class="body-area">
      隐私协议
    </div>
   
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue"
export default defineComponent({
  name:"App",
  setup() {
    const data = ref('') 
    return {
         data  
    }
  }
})
</script>

<style lang="less" scoped>
.header-area{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 5px 8px 0 rgb(64 106 103 / 13%);
  background: hsla(0,0%,100%,.95);
  padding:0 20px;
  .header-left{
    img{
      width:300px;
    }
  }
}
.body-area{
  margin-top:60px;
}
</style>
