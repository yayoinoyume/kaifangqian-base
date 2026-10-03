<!--
  @description 下拉选择
-->
<template>
  
    <div :class="['control-'+element.controlType,'control-item','arow-content','this-click',
        element.controlClick?'click':'default',
        ]"
      :style="[
        'width:' + element.size.width + 'px',
        'height:' + element.size.height + 'px']"
        >

        <van-dropdown-menu class="control-select-content" v-if="element.widgetList" :style="[
            'font-size:'+ element.style.fontSize + 'px',
            'justify-content:' + element.style.textAlign,
            'fontFamily:' + element.style.fontFamily,
            '--fontSize:' + element.style.fontSize,
            'height:100%', 
            ]" >
                <van-dropdown-item v-model="element.value" :options="options" :disabled="true" />
        </van-dropdown-menu>
    </div>
    
  </template>
  
  <script lang="ts" setup>
    import {ref,onMounted, watch} from 'vue';
    import {uuid} from "@/utils/util"

    const props = defineProps({
      element:{
          type: Object,
        default:{}
      },
    });
    const options = ref([]);
    const emit = defineEmits(["change","blur"]);

    const baseImgWidth = window.innerWidth - 20;

    const aspecRatio = baseImgWidth / 800;
    
    const inputRef = ref();
    const open = ref(false);
    options.value = loadOptions(props.element.widgetList)

    watch(
      ()=>props.element.widgetList,
      (list)=>{
        if(list){
          options.value = loadOptions(props.element.widgetList)
          console.log(options.value,'选项目----')
        }
      },{
        deep:true
      }
    )
    
    function inputBlur(){
        // props.element.controlClick = false;
      open.value = false;
      emit('blur')
    }
    function loadOptions(list:[]):[]{
        let result:any = []
        list&&list.map((v:any)=>{
            result.push({
                text:v.n,
                value:v.uid
            })
        })

        return result;
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
    
    
    .control-dropdown-list .ant-select .ant-select-selector .ant-select-selection-item{
      display: flex;
      // justify-content: center;
      align-items: center;
      font-size: inherit !important;
    }
    .control-select-content{
        :deep(.van-dropdown-menu__bar){
            height:100%;
            background:var(--background-rgb);
        }
        :deep(.van-dropdown-menu__title){
            font-size:var(--fontSize);
            color:#333;
        }
    }
  </style>
  