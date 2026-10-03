<!--
  @description 资助审批电子签章系统
-->

<template>
	<div class="position-container"  :style="'height: '+ (height-63) +'px'">
	  <Loading  :loading="loading" :absolute="false"/>
    <TemplateHeader :previousStep="previousStep" :actions="actions" :doc="template">
      <!-- <GeneralControls  :nowDocument="template" 
      	@dragOver="controlsDragOver" :controlTypeList="controlTypeList"/> -->
    </TemplateHeader>
    <div class="document-layout">
      <div class="document-layout-left">
        <TemplateControls :controls="template.activeControl" @controlMousedown="controlMousedown" @searchPosition="searchPosition" @delControl="delControl"/>
      </div>
      <div class="document-layout-center">
        <TemplateContent @controlMousedown="controlMousedown" :nowDocument="template"
          @controlDelete="delControl" :showControl="true" />
      </div>
      <div class="document-layout-right">
        <TemplateControlDrawer :element="template.nowElement"/>
      </div>
    </div>
	</div>
</template>

<script lang="ts">
  import {ref, createVNode, defineComponent, onMounted, reactive, toRefs,onUnmounted} from "vue";
  import { Loading } from '/@/components/Loading';
  import {useRouter} from "vue-router"
  import { message,Modal } from 'ant-design-vue';
  import {htmlNodeFilter} from "/@/utils/ClickOther";
  import { CheckCircleOutlined } from '@ant-design/icons-vue';
  
  
  import {getTemplateImage,getTemplateInfo,templateSaveControl} from "./api";
  import {currentPosition} from "/@/utils/control/ControlerMoveRange";
  // import {controlList,CanvasZoom,getColtrolByType,isFillControl} from '/@/utils/control/ControlData';
  // import {controlBuildParams,paramBuildControls} from '/@/utils/control/ControlParamsBuild';
  import {controlBuildParams,paramBuildControls} from './components/dist/ControlParamsBuild';
  import {backParent} from "/@/utils";
  import GeneralControls from './components/GeneralControls.vue' ;
  import TemplateHeader from './components/TemplateHeader.vue' ;
  import TemplateContent from './components/TemplateContent.vue' ;
  import TemplateControls from './components/TemplateControls.vue' ;
  import TemplateControlDrawer from './components/TemplateControlDrawer.vue' ;
  import {CanvasZoom,pageScaling} from './components/dist/ControlData';
  
  
  // interface BtnFun {
  //  	 ():void   
  // }
  
  // interface ButtonItem {
  //   type:string;
  //   text:string;
  //   disabled?:boolean;
  //   callBack:BtnFun,
  //   show:boolean
  // }
  
  export default defineComponent({
    name:"PositionParams",
    components:{
      Loading,message,TemplateHeader,GeneralControls,TemplateContent,TemplateControls,TemplateControlDrawer
    },
    setup(props,{emit}) {
      const router = useRouter();
      
      const compState = reactive({
        absolute: false,
        loading: false,
        tip:''
      })
      const actions = ref([
        {
          type:'default',
          text:'关闭',
          callBack:handleColse,
          show:true
        }
      ])
      const template:any = ref({
        templateName:"模板查看",
        activeControl:[],
        pageSize:2,
        images:[],
        nowElement:{}
      }); 
      const templateId = ref<string>('');
      const annexId = ref<string>('');
      const previousStep = ref({
        title:"模板查看",
        icon:"ant-design:close-outlined",
        callBack:handleColse
      })
      
      const controlTypeList = []; 
      
      function controlsDragOver(e,element:any){
        template.value.nowElement = element;
      }
      async function handleSave(){
        
        if(!template.value.activeControl || template.value.activeControl.length==0){
          message.warning("请先设置控件后再进行保存")
          return;
        }
        compState.loading = true;
        const result = await templateSaveControl({templateId:templateId.value,controlVoList:controlBuildParams(template.value.activeControl)});
        if(result.code == 200){
           Modal.confirm({
            icon: createVNode(CheckCircleOutlined,{ style: 'color:#52c41a;' }),
            content: createVNode('div', { style: 'color:#52c41a;' }, '保存成功'),
            okText:"关闭此页",
            cancelText:"取消",
            centered:true,
            onOk() {
              handleColse();
            }
          });
        }
        setTimeout(()=>{
          compState.loading = false; 
        },200)
      }
      function handleColse(){
        // backParent("/template/manage",router,{templateId:templateId.value});
        router.push("/template/manage");
      }
       
      function searchPosition(element:any){
        compState.loading = true;
        const moveY = element.position.top - 30;
        setTimeout(()=>{
          document.getElementsByClassName('document-content')[0].scrollTo(0,moveY);
          compState.loading = false; 
          controlMousedown(element);
        },100)
      }
      function delControl(element:any){
        element.controlClick = false;
        template.value.activeControl = template.value.activeControl.filter((item:any) => {
        	return item.uid !== element.uid 
        })
      }
      
      function controlMousedown(element:any){
      	template.value.activeControl.forEach((item:any)=>{
      		item.controlClick = element.uid == item.uid;
      	})
        template.value.nowElement = element;
      }
      
      
      
      //header文档切换
      function handleDocChange(){
        
      }
      //
      function initWindow() {
          var h = document.documentElement.clientHeight || document.body.clientHeight;
      	return h;
      }
      const height = ref(initWindow());
      
      async function initData(){
        const query:any = router.currentRoute.value.query;
        if(!query.templateId){
          message.warning("请求参数错误")
          return false;
        }
        annexId.value = query.annexId;
        templateId.value = query.templateId;
        
        const result:any = await getTemplateInfo({templateId:templateId.value});
        var templateImg = await getTemplateImage({annexId:result.templateVo.annex.id});
        
        //排序
        templateImg = templateImg.sort((a, b) => a.page - b.page);
        const {targets,maxWidth} = pageScaling(templateImg);
        
        template.value.targets = targets;
        template.value.maxWidth = maxWidth;
        template.value.images = templateImg; //.sort((a, b) => a.page - b.page);
        template.value.pageSize = templateImg.length;
        template.value.activeControl = paramBuildControls(result.templateControlVoList,template.value.targets,template.value.maxWidth,true);
        // paramBuildControls(result.templateControlVoList,template.value.targets,template.value.maxWidth);
          
      }
      //清除控件选中事件
      function clearControlClick(e:any){
      	let flag =  htmlNodeFilter(e.target,"this-click");
      	if(flag){
      		return;
      	}else{
      		template.value.activeControl.forEach((item:any)=>{
      			item.controlClick = false
      		})
      	}
      	e.preventDefault();
      }
      const app:any = ref(document.getElementById("app-tenant"));
      app.value.addEventListener('click',clearControlClick);
      onUnmounted(()=>{
      	//页面销毁时解除全局click的监听
      	app.value.removeEventListener('click', clearControlClick)
      })
      
      onMounted(() => {
        initData();
      });
      return {
        ...toRefs(compState),height,actions,template,templateId,controlTypeList,controlsDragOver,controlMousedown,delControl,
        searchPosition,previousStep
      }
    }
  });
</script>

<style lang="less" scoped>
	 @import url("./data/DocumentDetail.css");
</style>
 
