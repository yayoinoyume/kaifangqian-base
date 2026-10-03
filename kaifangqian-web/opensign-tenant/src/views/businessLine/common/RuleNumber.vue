<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="container">
    <Form :model="state">
      <draggable :list="state.rules" :animation="300"   ghost-class="ghost" chosen-class="chosenClass">
        <div class="rule-item" v-for="(element,index) in state.rules" :key="index">
          <Row class="enter-x" :gutter="6">
                <Col :span="6">
                  <Icon icon="ant-design:holder-outlined"/>
                  <span>{{ element.ruleType }}</span>
                </Col>
                <Col :span="12" v-if="element.ruleType==='text'">
                  <FormItem :name="['ruleList', index, 'text']" :rules="{required:true, message:'内容不能空'}">
                    <Input   v-model:value="element.text"  placeholder="请输入" v-if="element.edit"/>
                    <span v-else>{{ element.text }}</span>
                  </FormItem>
                </Col>
                <Col :span="12" v-if="element.ruleType==='datetime'">
                  <FormItem >
                    <Select v-model:value="element.datetime" placeholder="请选择日期" > 
                        <SelectOption value="yyyy" >年，示例：2021</SelectOption>
                        <SelectOption value="yyyyMM" >年月，示例：202101</SelectOption>
                        <SelectOption value="yyyyMMdd" >年月日，示例：20210125</SelectOption>
                        <SelectOption value="yyyyMMddHH" >年月日时，示例：2021012503</SelectOption>
                        <SelectOption value="yyyyMMddHHmm" >年月日时分，示例：202101250313</SelectOption>
                        <SelectOption value="yyyyMMddHHmmss" >年月日时分秒，示例：20210125031310</SelectOption>
                    </Select>
                  </FormItem>
                </Col>
                <Col :span="9" v-if="element.ruleType==='serialnum'">
                  <Select v-model:value="element.ruleLength" style="width:100%" placeholder="请选择序列号位数">
                      <SelectOption :value="item" :key="index" v-for="(item,index) in 10">{{item}}</SelectOption>
                  </Select>
                </Col>
            </Row>
        </div>
      
      </draggable>
    </Form>
  </div>
</template>

<script lang="ts">

import {ref,defineComponent, computed} from "vue"
import { VueDraggableNext } from 'vue-draggable-next';
import { Icon } from '/@/components/Icon';
import { Checkbox,Form, Input, Tabs, Row, Col,Select } from 'ant-design-vue';


export interface RuleItem {
    ruleType:string;
    serialType:string;
    text?:string;
    edit?:boolean
}

export default defineComponent({
  name:"RuleNumber",
  components:{
    Checkbox,Form, Input, Tabs, Row, Col,Select ,
    Icon,
    draggable:VueDraggableNext
  },
  props:{
    ruleList:{
      type:Array,
      default:function(){
        return <RuleItem[]>[]
      }

    }
  },
  setup(props,{emit}) {

    const state:any = computed(()=>{
      return {
        rules:props.ruleList
      }
    });
    
    
    return {
      state  
    }
  }
})
</script>

<style lang="less" scoped>
</style>
