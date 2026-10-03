<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="main-content">
    <div class="customer-service">
            <div class="service-item">
                <a-popover class="item" effect="light" placement="left" trigger="hover">
                    <template  #content>
                      <div class="customer-item">
                        <Icon icon="ant-design:phone-twotone" size="30" color="#a6a4a4" />
                        <div>
                          <p  class="customer-title">电话咨询</p>
                          <p class="customer-text">400-888-8888</p>
                        </div>
                       
                      </div>
                      <div class="customer-item">
                        <Icon icon="ant-design:wechat-filled" size="30"  color="#a6a4a4"></Icon>
                        <div>
                          <p  class="customer-title" >微信客服</p>
                        
                        </div>
                      </div>
                      <p class="customer-text">
                          <img src="~@/assets/images/wx-custom.png" alt="" class="wx-img">
                        </p>
                    </template >
                    <div class="customer-us">联系我们</div>
                </a-popover>
            </div>
            <div class="service-line"></div>
        </div>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue"
import { Icon } from '/@/components/Icon';


export default defineComponent({
  name:"Contact",
  components:{
    Icon
  }, 
  setup() {
    const data = ref('') 
    return {
         data  
    }
  }
})
</script>

<style lang="less" scoped>
.customer-service{
    position: fixed;
    right: 0px;
    top: 70%;
    z-index: 999;
    width: 35px;
    font-size: 20px;
    text-align: center;
    background: #127fd2;
    box-shadow: 0 0 10px 2px #bcb6b6;
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    padding: 20px 0 20px 10px;
    font-size: 14px;
    color:#fff;
    writing-mode:vertical-lr;
    cursor: pointer;
}
.customer-item{
  display: flex;
  align-items: center;
  padding: 5px 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  .customer-title{
    font-size:14px;
    color:#666;
    margin-bottom: 5px;
  }
  .customer-text{
    font-size:12px;
    color:#000;
    font-weight: 600;

  }
  .app-iconify{
    margin-right: 15px;
  }
  
}
.wx-img{
    width:130px;
  }
</style>
