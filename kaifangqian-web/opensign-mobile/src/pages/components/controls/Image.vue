<!--
  @description image
-->
<template>
    <div :class="['control-'+element.controlType,'control-item','arow-content','this-click',
        element.controlClick?'click':'default',
        ]" :style="[
        'width:' + element.size.width + 'px',
        'height:' + element.size.height + 'px']"
      >
  
      <div :class="element.uploadImg?'preview':''"
      >
        <div v-if="!element.uploadImg">
            <span v-if="!element.uploadImg" style="visibility:hidden;position:absolute">{{loadImg(element)}}</span>
            <SvgIcon name="img" :size="30" style="margin:0 auto;"></SvgIcon>
            <!-- <p style="margin: 0;text-align: center;color:#979797">图片</p> -->
        </div>
        <div v-if="element.uploadImg" class="default-img">
            <van-image
                :src="element.uploadImg"
            />
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts" setup>
    import {ref} from 'vue';
    import Api from '@/api/system';



    const props = defineProps({
      element:{
          type: Object,
        default:{}
      },
    });
    const emit = defineEmits(["change","blur"]);
    const inputRef = ref();
    const fileList = ref([]);

    async function loadImg(item:any){
      if(!item.value) return;
      if(item.controlType != 'image') return;
      let { result, code } = await Api.getImgBase64({imgId:item.value})
          if(code==200){
              item.uploadImg = result.image; 
      }
    }
  
    
   
    
    function inputBlur(){
      emit('blur')
    }
    
    function itemFocus(){
      
      if(inputRef.value)
      inputRef.value.click();
    }
    
    const uploadImg = ref();
   
    
    
    
    defineExpose({
      itemFocus
    })
  </script>
  
  <style lang="less">
    .control-image{
      display: flex;
      justify-content: center;
      align-items: center;
      .default-img{
        width: 100%;
        height:100%;
      }
      .van-image{
        width:100%;
        height:100%;
      }
      .preview{
        width: 100%;
        height: 100%;
        // display: flex;
        // align-items: center;
        &>span{
          width: 100%;
          height: 100%;
        };
        .ant-upload{
          width: 100%;
          height: 100%;
        }
        
        background-repeat: no-repeat;
        background-position: center;
        background-size: contain;
      }
      
    }
  </style>
  