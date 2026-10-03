<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="tootip-box">
    <Tooltip :title="content" :visible="isShowTooltip">
      <p class="over-flow"  @mouseenter="onMouseOver" @mouseleave="onMouseLeave">
        <span :ref="refName">{{content||'-'}}</span>
      </p>
    </Tooltip>
  </div>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';
  export default defineComponent({
    name: 'BasicToolTip',
  });
</script>
<script lang='ts' setup>
import { Tooltip } from 'ant-design-vue';
import {ref} from 'vue'

const props = defineProps({
  content:{
    type:String
  },
  // 外层框的样式，在传入的这个类名中设置文字显示的宽度
  className: {
    type: String
  },
  // 为页面文字标识（如在同一页面中调用多次组件，此参数不可重复）
  refName: {
    type: String
  }
})

const { content, refName } = props;

const isShowTooltip = ref(false);

function onMouseOver(e){
  // console.log(e.target.offsetWidth);
  // console.log(e.target.childNodes[0].offsetWidth);
    let parentWidth = e.target.offsetWidth;
    let contentWidth =  e.target.childNodes[0].offsetWidth;
    // 判断是否开启tooltip功能
    if (contentWidth>parentWidth-3) {
      isShowTooltip.value = true;
    } else {
      isShowTooltip.value = false;
    }
}
function onMouseLeave(){
  isShowTooltip.value = false;
}
  
</script>
<style lang="less" scoped>
  .tootip-box{
    width:100%;
  }
 .over-flow{
  margin-bottom:0;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
 }
</style>
