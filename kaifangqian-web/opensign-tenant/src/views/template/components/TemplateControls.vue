<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="template-controls">
    <div class="controls-title">
      <span>控件列表</span>
    </div>
    <div class="controls-scrollbar">
      <Scrollbar width="100%" height="100%">
        <draggable :list="controls" itemKey="uid" :sort="true" handle=".mover"
         :animation="300" :touchStartThreshold="5">
        	<template #item="{ element }"  >
            <li class="control-li this-click"
              :class="[element.controlClick?'click':'']">
              <div class="mover control-drag">
                <SvgIcon name="control-drag" size="18"></SvgIcon>
              </div>
              <div class="control-item" @click="controlMousedown(element)">
                <div class="control-icon">
                  <SvgIcon :name="element.icon" :size="20"/>
                </div>
                <div class="control-text">
                  <span>{{element.name}}</span>
                </div>
              </div>
              <div class="control-local" @click="searchPosition(element)">
                <SvgIcon name="control-local" :size="18"/>
              </div>
              <div class="control-local" @click="delControl(element)" v-if="!element.disabled">
                 <SvgIcon name="delete" color="red" :size="20"/>
              </div>
            </li>
          </template>
        </draggable>
      </Scrollbar>
    </div>
  </div>
</template>

<script lang="ts">
  
  import {defineComponent,ref,watch,getCurrentInstance} from 'vue';
  import {Badge,Modal } from 'ant-design-vue';
  import { Scrollbar } from '/@/components/Scrollbar';
  import {Icon,SvgIcon} from "/@/components/Icon";
  import draggable from 'vuedraggable'
  
  export default defineComponent({
  	name: 'TemplateControls',
  	components: {
  		Badge,Scrollbar,Icon,SvgIcon,draggable
  	},
    props:{
    	controls:{
    		type: Array
    	},
    },
    emits:["controlMousedown","controlDelete","searchPosition"],
    setup(props,{emit}) {
      function delControl(element:any){
        emit("delControl",element)
      }
      function controlMousedown(element:any){
        emit("controlMousedown",element)
      }
      function searchPosition(element:any){
          console.log("开始找位置 sref",element);
        // controlMousedown(element);
        emit("searchPosition",element)
      }
      return {
        delControl,controlMousedown,searchPosition
      }
    }
  });
   
</script>

<style lang="less" scoped>
  .template-controls{
    width: 100%;
    height: 100%;
    padding: 0 25px;
  }
  .controls-title{
    height: 50px;
    font-size: 14px;
    font-weight: 600;
    line-height: 50px;
    border-bottom: 1px solid #e9e9e9;
  }
  .controls-scrollbar{
    width: 100%;
    height: calc(100% - 50px);
    padding:15px 0;
  }
  .controls-scrollbar{
    .control-li{
      list-style: none;
      display: flex;
      width: 100%;
      margin-bottom: 15px;
      border-color: rgba(0, 0, 0, 0.5);
      color: rgba(0, 0, 0, 0.5);
      .control-item{
        height: 36px;
        width:260px;
        border:1px solid;
        cursor: pointer;
        border-radius: 5px;
        display: flex;
        padding: 8px 20px;
        flex:1;
        color:inherit;
        border-color:inherit;
      }
      .control-text{
        padding-left: 10px;
        user-select: none;
      }
    }
    .control-li.click{
      // border-color: rgba(0, 0, 0);
      // color: rgba(0, 0, 0);
      // background-color: #e9e9e9;
      border-color: #5589e2;
      color: #5589e2;
    }
    .control-local{
      height: 36px;
      width: 36px;
      cursor: pointer;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .control-drag{
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 0 5px;
      cursor: pointer;
    }
  }
  
</style>
