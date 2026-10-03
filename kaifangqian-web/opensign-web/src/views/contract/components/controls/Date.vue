<!--
  @description 资助审批电子签章系统
-->

<template>
  
  <div ref="input" :class="['control-'+ element.type,'control-item','arow-content',
  	element.controlClick?'click':'default',]"
    :style="[
      'transform:translate('+element.position.left+'px,'+ element.position.top + 'px)',
      'width:' + element.size.width + 'px',
      'height:' + element.size.height + 'px']"
    >
  	<DatePicker ref="inputRef" v-model:value="element.value"
  	:placeholder="element.format.toUpperCase()" :format="element.format.toUpperCase()" :value-format="element.format.toUpperCase()"
  	class="control-date-picker"
  	 :style="['width:100%;height:100%; resize: none;',  
     'font-size:'+  element.style.fontSize + 'px', 
      'text-align:' + element.style.textAlign, 
      'fontFamily:' + element.style.fontFamily,
  	 dbclick?'':'pointer-events: none;'
  	 ]" :open="datePickerOpen"
  	 @blur="inputBlur" :bordered="false" @change="valueChange">
  	<template #suffixIcon>
  	</template>
  	</DatePicker>
  </div> 
</template>

<script lang="ts" setup>
  import {ref} from 'vue';
  import {DatePicker} from 'ant-design-vue';
  const props = defineProps({
    element:{
    	type: Object,
      default:{}
    },
  });
  const datePickerOpen = ref(false);
  const emit = defineEmits(["change","blur"]);
  
  const dbclick = ref(false);
  const inputRef = ref();
  
  // function valueChange(element:any){
  // 	if(element.required){
  // 		element.error = false;
  // 	}
  // }
  
  function inputBlur(){
  	// props.element.controlClick = false;
    dbclick.value = false;
    datePickerOpen.value = false;
    emit('blur')
  }
  
  function itemFocus(){
    dbclick.value = true;
    datePickerOpen.value = true;
    inputRef.value.focus();
  }
  
  function valueChange(){
     datePickerOpen.value = false;
  }
  
  defineExpose({
    itemFocus
  })
</script>

<style lang="less">
  .control-date .ant-picker .ant-picker-input,.ant-picker-input>input{
    text-align: inherit;
    font-size: inherit !important;
  }
</style>
