<!--
  @description 资助审批电子签章系统
-->

<template>
    <div class="template-header">
      <div class="template-header-title">
        <a-button type="text" size="large" @click="previousStep.callBack">
          <template #icon>
               <Icon :icon="previousStep.icon" style="font-size: 20px;"/>
               <!-- ant-design:close-outlined -->
          </template>
        </a-button>
        <div class="header-name" :title="previousStep.title">
          <span class="after" v-if="previousStep.title">
            {{previousStep.title}}
          </span>
        </div>
      </div>
      
      <div class="template-header-center"> 
        <slot></slot>
      </div>
      <div class="template-header-action">
        <template v-for="item in actions">
					<a-button v-if="!item.disabled && item.show" :type="item.type" @click="item.callBack" class="doc-action">
            {{item.text}}
          </a-button>
				</template>
      </div>
    </div>
</template>

<script lang="ts">
import {ref, unref, defineComponent,watch} from "vue"
import { Icon } from '/@/components/Icon';
import { useRouter } from 'vue-router';
import {backParent} from "/@/utils";
export default defineComponent({
  name:"DocHeader",
  components:{
    Icon
  },
  props:{
    previousStep:{
      type:Object,
    },
    actions:{
      type:Object,
    },
    doc:{
      type:Object,
    },
    showDoc:{
      type:Boolean,
      default:true
    }
  },
  setup(props,{emit}) {
      // const currentDocId = ref(props.docId)

      const router = useRouter();
      // const { currentRoute } = router;
      // const pageSource = route.query.from;
       
      function handleCancel(){
        //emit('cancel')
        backParent();
      }
    return {
          handleCancel,
          // pageSource,
    }
  }
})
</script>

<style lang="less" scoped>
  
.template-header{
  display: flex;
  height: 64px;
  position: fixed;
  top:0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.08);
  width:100%;
}
.template-header-center{
  height: 64px;
  flex: 1;
  text-align: center;
  min-width:800px;
}
.template-header-title{
  width: 350px;
  line-height: 64px;
  padding-left: 20px;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  .header-name{
  	font-size: 20px;
  	font-weight: 600;
  	position: relative;
  	padding-left: 30px;
  	/* width: 240px; */
    flex: 1;
  	overflow: hidden;
  	text-overflow: ellipsis;
  	white-space: nowrap;
  }
  .header-name .after::after{
  	content: "";
  	position: absolute;
  	width: 2px;
  	height: 18px;
  	background-color: #999;
  	left: 10px;
  	top:22px
  }
}

.template-header-action{
  width: 350px;
  text-align: right;
  line-height: 64px;
  padding-right: 20px;
  box-sizing: border-box;
}
.doc-action{
  margin:0 5px;
}

</style>
