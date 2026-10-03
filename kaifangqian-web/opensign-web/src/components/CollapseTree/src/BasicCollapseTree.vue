<!--
  @description 资助审批电子签章系统
-->

<!-- <template>
      <Collapse  v-bind="getBindValues">
        <template :key="item.id" v-for="item in getSchema">
           <CollapsePanel >
              <template #header>
                <Icon :icon="item.icon" />
                <span>{{item.name}}</span>
              </template>
            </CollapsePanel>
        </template>
           
        </Collapse>
</template> -->
<script lang='tsx'>
import { defineComponent,computed,unref } from 'vue'
import { Collapse,CollapsePanel,Checkbox,CheckboxGroup } from 'ant-design-vue'
// import { BasicProps } from '../props';
import { Icon } from '/@/components/Icon';
import {CollPaseSchema} from './typing'
import {CollapseProps} from './types/collapse'
export default defineComponent({
  components:{
    Collapse,
    CollapsePanel,
    Checkbox,
    CheckboxGroup,
    Icon,
    // CollapseItem
  },
  // props:BasicProps,
  setup(props){
   
    const getProps = computed(():CollapseProps => {
        return { ...props};
    });
    const getBindValues = computed(() => {
      return {
        ...props,
      }
    })
    const getSchema = computed(()=>{
      const schema:CollPaseSchema[] = unref(getProps.value).list; 
      return schema
    })
    const getHeader = (item)=>{
      const { isCheckedCollapsed = true } = unref(getProps)
      return (
        <div>
         {
            isCheckedCollapsed?
              <Checkbox checked={item.isChecked}></Checkbox>
              :null
          }
          <Icon icon={item.icon} />
          <span>{item.title}</span>
        </div>
      )
      
    }

    const renderCollapseItem=(list,parentIndex)=>{
      const { isCheckedCollapsed = true } = unref(getProps)
        return(
          <div>
              {
                list.map((item,index)=>{
                  return(
                    (
                      <div style={{'marginLeft':(parentIndex+1)*20+'px'}} class={item.children?'has-children':'no-children'}>
                          <div class="group-item">
                               {
                                  isCheckedCollapsed?
                                  <div class="group-header">
                                      <Checkbox ></Checkbox>
                                      <span>{item.title}</span>
                                      {!item.children? <Icon icon='ant-design:safety-outlined' size="18" color="#ef2a2a"/>:null}
                                  </div>
                                  :null
                                } 
                                {
                                  item.children?(
                                        <div>{ renderCollapseItem(item.children,index)}</div>
                                  ):null
                                }
                          </div>
                        </div>
                    )
                  )
                })
              }
          </div>
          
        )
    }




    return()=> {
      const list:CollPaseSchema[] = [
        {
          id:'3',
          title:'测试1',
          isChecked:false,
          icon: 'ant-design:twitter-circle-filled',
          children:[{
            id:'3-1',
            title:'测试1-1',
            isChecked:false,
            icon: 'ant-design:twitter-circle-filled',
            children:[
              {
                id:'3-1-1',
                title:'测试1-1-1',
                isChecked:false,
                icon: 'ant-design:twitter-circle-filled',
                children:[
                  {
                    id:'3-1-1-1',
                    title:'测试1-1-1-1',
                    isChecked:false,
                    icon: 'ant-design:twitter-circle-filled',
                    children:undefined
                  },
                   {
                    id:'3-1-1-2',
                    title:'测试1-1-1-2',
                    isChecked:false,
                    icon: 'ant-design:twitter-circle-filled',
                    children:undefined
                  }
                ]
              },
               {
                id:'3-1-2',
                title:'测试1-1-2',
                isChecked:false,
                icon: 'ant-design:twitter-circle-filled',
                children:undefined
              },  {
                id:'3-1-3',
                title:'测试1-1-3',
                isChecked:false,
                icon: 'ant-design:twitter-circle-filled',
                children:undefined
              }
            ]
          },{
            id:'3-2',
            title:'测试2',
            isChecked:false,
            icon: 'ant-design:twitter-circle-filled',
            children:undefined
          },
          {
            id:'3-3',
            title:'测试3',
            isChecked:false,
            icon: 'ant-design:twitter-circle-filled',
            children:undefined
          }]
        },
        {
          id:'4',
          title:'测试3',
          isChecked:false,
          icon: 'ant-design:twitter-circle-filled',
          children:[{
            id:'4-1',
            title:'测试',
            isChecked:false,
            icon: 'ant-design:twitter-circle-filled',
            children:undefined
          }]
        }
      ]
     
      return (
         <div>
          {
            list.map((item,index)=>{
              return (
                <Collapse  key={index} expandIconPosition={'right'}>
                  <CollapsePanel {...unref(getBindValues)} header={getHeader(item)}>
                      {
                        item.children?
                          renderCollapseItem(item.children,index) 
                        :null
                      }
                  </CollapsePanel>
               
                </Collapse>
              )
            })
          }
           
        </div>
      )
    }
  }
})
</script>
<style lang="less">
// .no-children{
    // display: inline-block;
    // float: left;
// }
.has-children{
  margin:0px 20px;
  .group-item{
    .no-children{
      margin:5px 20px;
    }
  }
}
.group-header{
  // background: #fafafa;
  padding:5px
}
 
</style>
