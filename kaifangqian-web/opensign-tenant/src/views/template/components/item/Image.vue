<!--
  @description 资助审批电子签章系统
-->

<template>
  
  <div :class="['control-'+element.type,'control-item','arow-content','this-click',
  	element.controlClick?'click':'default',
  	]" :style="[
      'transform:translate('+element.position.left+'px,'+element.position.top+'px)',
      'width:' + element.size.width + 'px',
      'height:' + element.size.height + 'px']"
    >
    <div :class="uploadImg?'preview':''"
      :style="uploadImg?'background-image: url('+uploadImg+');':''">
      <!-- <img v-if="uploadImg" :src="uploadImg" style="width:100%"/> -->
      <template v-if="!uploadImg">
        <SvgIcon name="img" :size="50"></SvgIcon>
        <p style="margin: 0;text-align: center;">图片</p>
      </template>
    </div>
    <Upload 
      v-model:file-list="fileList"
      name="file"
      action="/resrun-paas/file"
      @change="handleChange"
      accept="image/png"
      :headers="uploadHeaders"
      :showUploadList="false">
          <span ref="inputRef"></span>
      </Upload>
  </div>
  
</template>

<script lang="ts" setup>
  import {ref} from 'vue';
  import {Upload} from 'ant-design-vue';
  import {SvgIcon} from '/@/components/Icon'; 
  import { getImgBase64 } from '/@/api/sys/upload';
  import { getAppEnvConfig } from '/@/utils/env';
  import { getToken } from '/@/utils/auth';
  const props = defineProps({
    element:{
    	type: Object,
      default:{}
    },
  });
  const emit = defineEmits(["change","blur"]);
  const inputRef = ref();
  const fileList = ref([]);
  const {VITE_GLOB_APP_CODE} = getAppEnvConfig();
  const uploadHeaders = ref({
    'X-Access-Token':getToken(),
    'resrun-app-code':VITE_GLOB_APP_CODE
  })
  
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
    // inputRef.value.focus();
    //得到焦点   打开文件上传
    if(inputRef.value)
    inputRef.value.click();
  }
  
  const uploadImg = ref();
  function handleChange (info: any){
    console.log(info)
    if(info.file.status == 'done'){
      props.element.value = info.file.response.result
      getImgBase64({imgId:props.element.value}).then(res=>{
        console.log("111",res);
        uploadImg.value = res.image; 
      });
      // console.log(uploadImg.value);
    }
  }
  
  
  
  defineExpose({
    itemFocus
  })
</script>

<style lang="less">
  .control-image{
    display: flex;
    justify-content: center;
    align-items: center;
    
    .preview{
      width: 100%;
      height: 100%;
      display: flex;
      align-items: center;
      
      background-repeat: no-repeat;
      background-position: center;
      background-size: contain;
    }
    
  }
</style>
