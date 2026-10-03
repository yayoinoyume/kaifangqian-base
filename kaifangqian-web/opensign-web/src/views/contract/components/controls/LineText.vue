<!--
  @description 资助审批电子签章系统
-->

<template>
  
  <div :class="['control-'+element.type,'control-item','arow-content','this-click',
  	element.controlClick?'click':'default',
  	]"
    :style="[
      'transform:translate('+element.position.left+'px,'+element.position.top+'px)',
      'width:' + element.size.width + 'px',
      'height:' + element.size.height + 'px']"
    >
  	<Input ref="inputRef" v-model:value="element.value"  @blur="inputBlur" 
  		:style="['width:100%;height:100%',
  		'font-size:'+element.style.fontSize + 'px !important',
  		'text-align:' + element.style.textAlign,
  		'fontFamily:' + element.style.fontFamily,
  		'pointer-events: none;']"
  	 :placeholder="element.placeholder" :bordered="false"></Input>
  </div>
  
</template>

<script lang="ts" setup>
  import {ref} from 'vue';
  import {Input} from 'ant-design-vue';
  const props = defineProps({
    element:{
    	type: Object,
      default:{}
    },
  });
  const emit = defineEmits(["change","blur"]);
  
  const inputRef = ref();
  
  // function valueChange(element:any){
  // 	if(element.required){
  // 		element.error = false;
  // 	}
  // }
  
  function inputBlur(){
  	// props.element.controlClick = false;
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
