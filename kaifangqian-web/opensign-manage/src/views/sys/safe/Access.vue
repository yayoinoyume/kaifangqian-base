<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
      <BasicForm   @register="register"
      >
      </BasicForm>
  </div>
</template>
<script lang='ts'>
import { defineComponent,reactive,onMounted  } from 'vue';
import { BasicForm,useForm} from '/@/components/Form/index';
import { useMessage } from '/@/hooks/web/useMessage';
import { accessSchema } from './data';
import {getSafeConfig,setSafeConfig} from '/@/api/sys/safe';

interface ConfigItem {
  type:string;
  value:string|number
}

export default defineComponent({
  name: 'Access',
  components: { BasicForm },
  setup(){
    const { createMessage:msg } = useMessage();
    const state = reactive({
      list:[] as ConfigItem[]
    })
     const [  register ,{ validate,setFieldsValue} ] = useForm({
        labelWidth: 150,
        schemas:accessSchema,
        showActionButtonGroup: true,
        showResetButton:false,
        baseColProps: { lg: 24, md: 24},
        wrapperCol:{
          span:24
        },
        actionColOptions: {
          span: 24,
        },
        submitButtonOptions: {
          text: '保存修改',
        },
        submitFunc: customSubmitFunc,
       
      });
      async function fetch(){
      let params = {
        types:'login_repeat_limit,long_time_no_login,offsite_login,no_opetate_keep_alive,max_keep_alive'
      }
      let result = await getSafeConfig(params);
      if(result){
        state.list = result;
        result.map(item=>{
          if(item.type==='offsite_login'){
            setFieldsValue({
              offsite_login:(/^true$/i).test(item.value)
            })
          }else{
            setFieldsValue({
              [item.type]:item.value
            })
          }
        })
      }
    }
    onMounted(() => {
        fetch();
      });
    async function customSubmitFunc(){
       try {
          const values = await validate();
          state.list.map(item=>{
            if(item.type==='password_composition'){
              item.value =  values[item.type].join(',')
            }else{
              item.value = values[item.type]
            }
          })
          // TODO custom api
          let result = await setSafeConfig({sysConfigs:state.list});
          if(result){
              msg.success('操作成功');
              fetch()
          }
        } finally {
          
        } 
    }

    return {
      register
    }
  }
})
</script>
