<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="header-container">
    <div class="header-line">
        <div class="title-name">   
            <!-- <Icon icon="ant-design:alert-outlined" size="40" color="#127fd2" /> -->
            <span>{{ headerName }}</span>
        </div>
      <div class="header-close" @click="handleClose"> 
        <Icon icon="ant-design:close-outlined"></Icon>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent, h} from "vue";
import Icon from '/@/components/Icon';
import { notification } from 'ant-design-vue';

export default defineComponent({
  name:"LayoutHeader",
  components:{
    Icon
  },
  props:{
    headerName:{
      type:String,
      default:'消息中心'
    }
  },
  setup(props) { 
    const headerName = ref(props.headerName)

    function handleClose(){
        window.close()
    }
    // const content1 =  h('span', {domProps: {innerHTML:'<p>fdsfdsfdsfds</p>'}})
    //       notification.open({
    //           duration: null,
    //           message: '温馨提示',
    //           description: () => {
            
    //               return  content1
    //         },
    //         });
    return {
         headerName,
         handleClose 
    }
  }
})
</script>

<style lang="less" scoped>
.header-container{
  height:60px;
  width:100%;
  display:flex;
  padding:0 20px;
  position:fixed;
  background:#fff;
  z-index:999;
  border-bottom:1px solid #d9d9d9;
  .header-line{
    width:100%;
    display:flex;
    font-size:18px;
    justify-content: space-between;
    align-items: center;
    font-weight:600;
    .header-close{
      cursor: pointer;
      font-size:14px;
      font-weight:500;
    }
    .title-name{
        display: flex;
        align-items: center;
    }
  }
}
</style>
