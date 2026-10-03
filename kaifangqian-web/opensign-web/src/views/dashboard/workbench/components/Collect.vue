<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="main-collect">
    <Card size="small" title="收藏">
      <template #title>
        <div>
          <span>我的收藏</span>
          <Icon icon="ant-design:plus-outlined" />
          <span>添加</span>
        </div>
      </template>
      <ul class="collect-list">
        <li v-for="item in collectData">
          <span>{{ item.name }}</span>
        </li>
      </ul>
    </Card>
  </div>
</template>

<script lang="ts">
import {ref,defineComponent} from "vue";
import { Card } from 'ant-design-vue';
import Icon from '/@/components/Icon';
export default defineComponent({
  name:"Collect",
  components:{
    Card,
    Icon
  },
  setup() {
    const data = ref('');
    const collectData = ref([
      {name:'订单管理',icon:''},
      {name:'采购申请',icon:''},
      {name:'员工档案',icon:''},
    ]) 
    return {
      collectData,
      data  
    }
  }
})
</script>
<style lang="less" scoped>
.ant-card{
  margin:20px 0;
}
.collect-list{
  display: flex;
  justify-content: flex-start;
  li{
    width:160px;
    padding:10px 20px;
    box-sizing: border-box;
    margin-right: 20px;
    &:hover{
      background:#f5f5f5;
    }
  }

}

</style>
