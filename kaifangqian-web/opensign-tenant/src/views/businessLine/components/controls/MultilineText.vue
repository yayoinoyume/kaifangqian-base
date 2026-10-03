<!--
  @description 资助审批电子签章系统
-->

<template>
  
  <div ref="input" :class="['control-'+element.type,'control-item','arow-content',
  	element.controlClick?'click':'default']"
    :style="[
      'transform:translate('+element.position.left+'px,'+element.position.top+'px)',
      'width:' + element.size.width + 'px',
      'height:' + element.size.height + 'px']"
    >
  	<a-textarea ref="inputRef"  v-model:value="element.value" :placeholder="element.placeholder"
  	 :style="['width:100%;height:100%; resize: none;',
  	 'font-size:'+element.style.fontSize + 'px !important',
  	 'text-align:' + element.style.textAlign,
  	 'fontFamily:' + element.style.fontFamily,
  	 'pointer-events: none;']"
  	 @blur="inputBlur" @change="valueChange(element)" :bordered="false" />
  </div>
  
</template>

<script lang="ts" setup>
  import {ref} from 'vue';
  const props = defineProps({
    element:{
    	type: Object,
      default:{}
    },
  });
  const emit = defineEmits(["change","blur"]);
  
  const inputRef = ref();
  
  function valueChange(element:any){
  	if(element.required){
  		element.error = false;
  	}
  }
  
  function inputBlur(){
  	emit('blur')
  }
  
  function itemFocus(){
    inputRef.value.focus();
  }
  
  
  defineExpose({
    itemFocus
  })
</script>

<style>
</style>
