<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="main-task-enter">
    <Card size="small">
        <div class="upcoming-enter">
          <div class="upcoming-body"  @click="handleEnter({appFront:'/#/bpmns/application/upcoming'})">
            <SvgIcon name="tip" size="36"/>
            <div>
              <p class="upcoming-title">我的待办</p>
              <p class="upcoming-count">{{ upcomingCount }}</p>
            </div>
          </div>
        </div>
        <div class="business-list">
          <ul>
            <li v-for="(item,index) in businessData" :key="index">
              <div class="business-item" @click="handleEnter(item)">
                <SvgIcon :name="item.svgIcon" size="28"/>
                <p class="business-title">{{ item.title }}</p>
              </div>
            </li>
          </ul>
        </div>
    </Card>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent, onMounted} from "vue";
import { Card } from 'ant-design-vue';
import { SvgIcon } from '/@/components/Icon';
import Icon from '/@/components/Icon';
import {  getProcessTodo } from '/@/api/bpmns';
export default defineComponent({
  name:"TaskEnter",
  components:{
    Card,
    Icon,
    SvgIcon
  },
  props:{
    flowInfo:{
      type:Object
    }
  },
  setup(props,{emit}) {
    const data = ref('');
    const upcomingCount = ref(0);
    const businessData = ref([
      {svgIcon:'start',title:'我发起的',appFront:'/#/bpmns/application/track'},
      {svgIcon:'done',title:'我处理的',appFront:'/#/bpmns/application/done'},
      {svgIcon:'cc',title:'抄送我的',appFront:'/#/bpmns/application/pending'},
      // {svgIcon:'initiate',title:'发起流程',path:'/#/bpmns/initiate/index'},
    ]) 
    onMounted(()=>{
      getTodo()
    })

    async function getTodo(){
      let result = await getProcessTodo({});
      if(result){
        upcomingCount.value = result.total;
      }

    }
    function handleEnter(item){
      emit('enter',{
        ...props.flowInfo,
        appFront:item.appFront
      })
    }
    return {
         data,
         upcomingCount,
         businessData,
         SvgIcon,
         Icon,
         handleEnter 
    }
  }
})
</script>

<style lang="less" scoped>
.ant-card{
  margin:20px 0; 
  :deep(.ant-card-body){
    display: flex;
    .upcoming-enter{
      cursor: pointer;
      display: flex;
      flex-basis: 500px;
      padding:10px 20px;
      justify-content: center;
      border-right: 1px solid #f5f5f5;
      .upcoming-body{
        display: flex;
        justify-content: center;
        padding:20px;
        width: 100%;
        align-items: center;
        p{
          margin-bottom: 0;
          line-height: 1;
        }
        .resrun-svg-icon{
          margin-right: 20px;
        }
        .upcoming-title{
          font-size:18px;
          color: #000;
          margin-bottom: 10px;
          // font-weight: 600;
        }
        .upcoming-count{
          font-size: 30px;
        }
      }
      &:hover .upcoming-body{
        background: #f5f5f5;
        border-radius: 2px;
        width: 100%;
      }
    }
    .business-list{
      
      ul{
        display: flex;
        justify-content: space-between;
        align-items: center;
        height:100%;
        margin-bottom:0;
        li{
          width: 240px;
          height:100%;
          display: flex;
          justify-content: center;
          align-items: center;
        
          .business-item{
            display: flex;
            cursor: pointer;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 200px;
            padding:30px 20px;
            border-radius: 4px;
            &:hover{
              background: #f5f5f5;
            }
            .business-title{
              margin-top:20px;
              font-size: 16px;
              color: #333;
            }

          }
        }
      }
    }
  }
}
</style>
