<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :class="bem()">
    <ul v-for="(item,index) in getDataSource" :key="index">
      <p class="group-name" v-if="item.list&&item.list.length>0">{{item.groupName}}</p>
      <div class="group-content" v-if="item.list&&item.list.length>0">
        <li  v-for="(childItem,childIndex) in item.list" :key="childIndex" @click="handlClick(childItem,item.type)">
            <Icon :icon="item.icon" color="#127fd2"/>
            <span :key="childIndex" class="item-title">{{childItem?.realname || childItem.roleName || childItem.departName}}</span>
        </li>
        <span v-if="item.showMore && item.page*5 < item.total" @click="handleLoadMore(item.type, item.page+1)" class="result-more">加载更多<Icon icon="ant-design:ellipsis-outlined" /></span>
      </div>
    </ul>
  </div>
</template>
<script lang='ts'>
import { defineComponent,toRaw, watch ,ref} from 'vue';
import { Icon } from '/@/components/Icon';
// import { arrayGroupBy } from '/@/utils/helper/treeHelper';
import { createBEM } from '/@/utils/bem';

interface ResultChild {
  icon:string;
  realname?:string;
  roleName?:string;
  departName?:string;
}

interface ResultItem {
  type:string;
  icon:string;
  name:string;
  total:number;
  page:number;
  showMore:boolean;
  list:Array<ResultChild>,
  groupName?: string;
}
export default defineComponent({
  name: 'TreeResult',
  props:{
    searchApiData:{
        type: Array
    },
    loadData: {
     type: Function as PropType<(type:string, page:number) => void>,
    },
    rowClick: {
     type: Function as PropType<(type:string, page:number) => void>,
    }

  },
  components:{
    Icon
  },
  setup(props){
    const [bem] = createBEM('list-group');
    const getDataSource = ref<ResultItem[]>([]);
    // const getDataSource = reactive({list:[] as ResultItem[]});
    // function formatResult (list){
    //   let result = list&&arrayGroupBy(list, 'type');
    //   console.log(result,'分类结果');
    //   return result;
    // }
    watch(
        () => props.searchApiData,
        (v) => {
          console.log(v,'----数据变更了----');
          let list = toRaw(v);
          // getDataSource.value = formatResult(list);
          getDataSource.value = list;
          getDataSource.value.map(item=>{
            if(item.type=='dept'){
              item.icon = 'ant-design:apartment-outlined';
              item.groupName = '部门';
            }else if(item.type == 'user'){
              item.icon = 'ant-design:user-outlined';
              item.groupName = '用户';
            }else if(item.type=='role'){
              item.icon = 'ant-design:usergroup-add-outlined';
              item.groupName = '角色';
            }
            // if(item)
          })
          console.log((getDataSource.value),'===============搜索结果====')
         }
      );

      function handleLoadMore(type:string, page:number){
        console.log(page)
         props.loadData&&props.loadData(type,page)
      }
      function handlClick(item,type){
         props.rowClick&&props.rowClick(item,type)
      }
   
    return {
      bem,
      getDataSource,
      handleLoadMore,
      handlClick
    }
  }

})
</script>
<style lang="less" scoped>
.result-more{
  width:100%;
  color: @primary-color;
  text-align:center;
  display: inline-block;
  cursor: pointer;
}
 
</style>
