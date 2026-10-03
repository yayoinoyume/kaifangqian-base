<!--
  @description 资助审批电子签章系统
-->

<template>
  
  <div :class="['control-'+element.controlType,'control-item','arow-content','this-click',
  	element.controlClick?'click':'default',
  	]"
    :style="[
      // 'transform:translate('+element.position.left+'px,'+element.position.top+'px)',
      'width:' + element.size.width + 'px',
      'height:' + element.size.height + 'px']"
    >
     <Select ref="inputRef" v-model:value="element.value" :bordered="false" :open="open"
     :placeholder="element.placeholder"
     :style="[
       'width:100%;height: 100%;',
       'font-size:'+element.style.fontSize + 'px !important',
       'justify-content:' + element.style.textAlign,
       'fontFamily:' + element.style.fontFamily,
       'pointer-events: none;'
     ]" @blur="inputBlur"
     @change="inputBlur">
       <SelectOption  :value="item.uid" v-for="(item,indexOption) in element.widgetList" :key="indexOption">{{item.n}}</SelectOption>
     </Select>
  </div>
  
</template>

<script lang="ts" setup>
  import {ref,onMounted} from 'vue';
  import {Select,SelectOption } from 'ant-design-vue';
  import {uuid} from "/@/utils"
  const props = defineProps({
    element:{
    	type: Object,
      default:{}
    },
  });
  const emit = defineEmits(["change","blur"]);
  
  const inputRef = ref();
  const open = ref(false);
  // function valueChange(element:any){
  // 	if(element.required){
  // 		element.error = false;
  // 	}
  // }
  
  function inputBlur(){
  	// props.element.controlClick = false;
    open.value = false;
    emit('blur')
  }
  
  function itemFocus(){
    open.value = true;
    if(inputRef.value)
    inputRef.value.focus();
  }
  
  function init(){
    
    const widgetList = [
      {
        n:"选项1",
        v:false,
        uid:uuid()
      },
      {
        n:"选项2",
        v:false,
        uid:uuid()
      }
    ]
    props.element.widgetList = widgetList;
  }
  
  onMounted(()=>{
    // init();
  })
  
  
  defineExpose({
    itemFocus
  })
</script>

<style lang="less" scoped>
  .control-dropdown-list .ant-select .ant-select-selector,.ant-select-selector .ant-select-selection-item  {
    height: 100%;
    justify-content:inherit;
  }

  :deep(.ant-select-selection-search){
    input{
      position:absolute;
      z-index:-1;
    }
  }
  
  
  .control-dropdown-list .ant-select .ant-select-selector .ant-select-selection-item{
    display: flex;
    // justify-content: center;
    align-items: center;
    font-size: inherit !important;
  }
</style>
