<!--
  @description 资助审批电子签章系统
-->

<template>
	<div class="controls wh100">
		<ul class="clear_flaot">
			<draggable :list="controlList" ghost-class="ghost" handle=".control-move" filter=".forbid" item-key="icon"
				 :force-fallback="true" chosen-class="chosenClass" animation="300" @end="controlsDragOver" @start="controlsDragStart"
				 :group="group" :fallback-class="false" :fallback-on-body="true" :touch-start-threshold="50"
				 :fallback-tolerance="50" :clone="clone" :sort="false">
				<template #item="{ element }">
					<li class="control-li control-move">
						<span>
							<SvgIcon :name="element.icon" :size="20"></SvgIcon>
						</span>
						<span class="name">{{element.name}}</span>
					</li>
				</template>
			</draggable>
		</ul>
	</div>
</template>

<script lang="ts">
	import {defineComponent,ref,reactive,getCurrentInstance} from 'vue';
	
	import draggable from 'vuedraggable'
	import {controlList} from "./data/ControlData"
	import {Icon,SvgIcon} from "@/components/Icon";
	
	import {moveRange} from "./data/ControlerMoveRange"
	
	export default defineComponent({
		name: 'Controls',
		components: {
			Icon,SvgIcon,draggable,
		},
		props:{
			user:{
				type: Object
			},
			activeControl:{
				type: Array
			},
			nowDocument:{
				type: Object
			}
		},
		emits:["dragOver"],
		setup(props:any,{emit}) {
			function clone(origin:any){
				const data = JSON.parse(JSON.stringify(origin))
				//判断是否选中可参与方
				if(props.user){
					data.user.index = props.user.index;
					data.user.userName = props.user.userName;
					data.user.userId = props.user.userId;
					data.user.userType = props.user.userType;
				}
				data.controlClick = true;
				// data.user.userName = signerIndex.value;
				data.uid = parseInt(new Date().getMilliseconds() + "" + Math.ceil(Math.random() * 100000)).toString(16);
				return data
			}
			//开始之前将所有的控件设置为非点击状态
			function controlsDragStart(){
				props.nowDocument.activeControl.forEach((item:any)=>{
					item.controlClick = false;
				})
			}
			function controlsDragOver(e:any) {
				// console.log("dragOver",e);
				const moveTarget  = props.nowDocument.activeControl[e.newIndex];
				if(moveTarget){
					// moveTarget.position.left = e.originalEvent.offsetX - (moveTarget.size.width/2);
					// moveTarget.position.top = e.originalEvent.offsetY - (moveTarget.size.height/2);
					
					const opt:any = {
						x:e.originalEvent.offsetX - (moveTarget.size.width/2),
						y:e.originalEvent.offsetY - (moveTarget.size.height/2),
						pageSize:props.nowDocument.pageSize,
						size:moveTarget.size,
						currentPage:0,
					};
					moveRange(opt);
					moveTarget.position.left = opt.x;
					moveTarget.position.top = opt.y
					moveTarget.position.page = opt.currentPage;
					moveTarget.controlClick = true;
					console.log(moveTarget);
					emit("dragOver",e,moveTarget)
					//controlMove.elementMove = moveTarget;
				}
				
				
				
			}
			const group = ref({
				name: "itxst",
				put: true, //允许拖入
				pull:'clone', //允许拖出
			})
			return{
				controlList,
				clone,group,
				controlsDragOver,
				controlsDragStart
			}
		}
	})
	
</script>

<style lang="scss">
	.controls{
		display: flex;
		justify-content:center;
		align-items: center;
	}
	.control-li{
		width: 80px;
		height: 46px;
		// border: 1px solid #eee;
		float: left;
		// margin-left: 10px;
		// margin-top: 10px;
		box-sizing: content-box;
		cursor:grab;
		user-select: none;
	}
	.control-li:hover{
		background-color: #e3e3e3;
	}
	.control-li span{
		display: block;
		line-height: 27px;
		text-align: center;
	}
	.control-li span:nth-child(1){
		height: 20px;
		text-align: center;
		padding-top: 6px;
	}
</style>