<!--
  @description 资助审批电子签章系统
-->

<template>
	<Drawer
	    v-model:visible="element.controlClick"
	    class="custom-control-drawer"
	    :title="element.title+'属性'"
	    placement="right" 
		:closable="false"
		width="240px"
		:mask="false">
		<template #extra>
			<div class="drawer-close" @click="element.controlClick = false">
				<Icon icon="ant-design:close-outlined"></Icon>
			</div>
		</template>
	    <div>
			<Form :model="element" :labelWrap="true" layout="vertical" class="custom-control-from">
				<FormItem :rules="[{ required: true,message: '请输入'+element.placeholder}]"
					name="name" label="控件名称" v-if="attrFilter('name')">
				    <Input v-model:value="element.name" size="small" style="width: 200px;" />
				</FormItem>
				<FormItem name="user" label="参与方设置" v-if="attrFilter('signer')">
				    <Select v-model:value="element.user.index" size="small" style="width: 200px"> 
						<SelectOption :value="-1" >未设置</SelectOption>
						<SelectOption :value="item.index" v-for="item in signerList">{{item.userName}}</SelectOption>
					</Select>
				</FormItem>
				<FormItem name="placeholder" label="文本提示" v-if="attrFilter('placeholder')">
				    <Input v-model:value="element.placeholder" placeholder="请输入文本提示" size="small" style="width: 200px;" />
				</FormItem>
				<FormItem name="value" label="默认值"  v-if="attrFilter('value')">
				    <Input v-if="element.type == ControlType.LineText" v-model:value="element.value" placeholder="请输入默认值" size="small" style="width: 200px;" />
					<Textarea v-if="element.type == ControlType.MultilineText" 
						v-model:value="element.value" placeholder="请输入默认值" 
						:autosize="{ minRows: 2, maxRows: 6 }"
						size="small" style="width: 200px;" />
					<InputNumber v-if="element.type == ControlType.Number"  v-model:value="element.value"
						size="small" style="width: 200px;" 
						:placeholder="element.placeholder" :controls="false" :stringMode="true" />
					<DatePicker v-if="element.type == ControlType.Date"  v-model:value="element.value"
					 :placeholder="element.format" :format="element.format" style="width: 200px;"/>
						 
				</FormItem>
				<FormItem name="user" label="日期格式" v-if="attrFilter('format')">
				    <Select v-model:value="element.format" 
						size="small" style="width: 200px">
						<SelectOption value="YYYY年MM月DD日">YYYY年MM月DD日</SelectOption>
						<SelectOption value="YYYY-MM-DD">YYYY-MM-DD</SelectOption>
						<SelectOption value="YYYY/MM/DD">YYYY/MM/DD</SelectOption>
					</Select>
				</FormItem>
				<FormItem name="user" label="字体设置" v-if="attrFilter('fontFamily')">
				    <Select v-model:value="element.style.fontFamily" 
						size="small" style="width: 200px">
						<SelectOption value="宋体">宋体</SelectOption>
						<SelectOption value="楷体">楷体</SelectOption>
						<SelectOption value="微软雅黑">微软雅黑</SelectOption>
					</Select>
				</FormItem>
				<FormItem name="fontSize" label="字号" v-if="attrFilter('fontSize')">
				    <Select
				          v-model:value="element.style.fontSize"
				          size="small"
				          style="width: 200px"
				          :options="selectOptions"
				        />
				</FormItem>
				
				<FormItem name="align" label="对齐方式" v-if="attrFilter('textAlign')">
				    <RadioGroup v-model:value="element.style.textAlign" size="small"  style="width: 200px;">
						<RadioButton value="left">居左</RadioButton>
						<RadioButton value="center">居中</RadioButton>
						<RadioButton value="right">居右</RadioButton>
					</RadioGroup>
				</FormItem>
			</Form>
			<!-- <div>{{element}}</div> -->
		</div>
	  </Drawer>
</template>

<script lang="ts">
	import {defineComponent,ref,reactive,getCurrentInstance} from 'vue';
	import {Input,Textarea,InputNumber,Drawer,Form,FormItem,
	Select,RadioGroup,RadioButton,SelectOption,DatePicker} from 'ant-design-vue';
	import {SvgIcon,Icon} from "@/components/Icon";
	import type { SelectProps } from 'ant-design-vue';
	import {ControlFontSizeList,ControlType} from "./data/ControlData"
	export default defineComponent({
		name: 'ControlDrawer',
		components: {
			Input ,Textarea,
			InputNumber,Drawer,Icon,
			Form,FormItem,Select,SelectOption,
			RadioGroup,RadioButton,DatePicker
		},
		props:{
			element:{
				type: Object
			},
			signerList:{
				type:Object
			}
		},
		emits:["controlMousedown","controlDelete"],
		setup(props:any) {
			const visible = ref(true);
			const selectOptions = ref<SelectProps['options']>(ControlFontSizeList);
			
			function attrFilter(attr:string){
				if(props.element.attr){
					return props.element.attr.includes(attr)
				}else{
					return false;
				}
			}
			return{
				visible,
				selectOptions,
				attrFilter,ControlType
			}
		}
	})
	
</script>
<style lang="scss" scoped>
	.drawer-close{
		margin-right: 20px;
		cursor: pointer;
		opacity: 0.5;
	}
	.drawer-close:hover{
		opacity: 1;
	}
</style>
<style lang="less">
	.custom-control-drawer{
		height: calc(100% - 64px);
		bottom: 0;
		top:inherit;
	}
	.custom-control-drawer{
		.ant-drawer-header{
			padding: 9px 0 9px 20px !important;
		}
		.ant-form-item{
			margin-bottom: 5px !important;
		}
		.ant-form-item-label{
			padding: 0;
		}
		.ant-drawer-body{
			padding: 15px;
		}
	} 
	
</style>