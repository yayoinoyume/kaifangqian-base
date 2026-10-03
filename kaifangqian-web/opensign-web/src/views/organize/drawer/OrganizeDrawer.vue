<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicDrawer
    v-bind="$attrs"
    @register="registerDrawer"
    showFooter
    :title="getTitle"
    width="70%"
    @ok="handleSubmit"
    >
      <Tabs>
        <TabPane key="1" tab="基本信息">
            <BasicForm @register="registerForm" />
        </TabPane>
      </Tabs>
  </BasicDrawer>
</template>
<script lang='ts'>

import { defineComponent, computed, unref, ref } from 'vue';
import { Tabs } from 'ant-design-vue';
import { BasicForm, useForm } from '/@/components/Form/index';
import { BasicDrawer, useDrawerInner } from '/@/components/Drawer';
import {organizeFormSchema } from '../data';
import { addOrganize} from '/@/api/sys/dept'


export default defineComponent({
  name: 'Organize',
  components:{
    BasicForm,
    BasicDrawer,
    Tabs,
    TabPane: Tabs.TabPane
  },
  setup(_, { emit }){
      const isUpdate = ref(true);
      const getTitle = computed(() => ('添加组织'));
      const [registerForm, { setFieldsValue, validate,clearValidate }] = useForm({
        labelWidth: 100,
        schemas: organizeFormSchema,
        showActionButtonGroup: false,
        baseColProps: { lg: 24, md: 24 },
      });
      const [registerDrawer, { setDrawerProps, closeDrawer }] = useDrawerInner(async (data) => {
        clearValidate()
        if(unref(isUpdate)) {
          setFieldsValue({
            ...data.record
          })
        }
      })

      async function handleSubmit(){
       try {
          const values = await validate();
          setDrawerProps({ confirmLoading: true });
          // TODO custom api
          let result = await addOrganize(values);
          
          if(result){
            closeDrawer();
            emit('success');
          }
         
        } finally {
          setDrawerProps({ confirmLoading: false });
        }
    }
    return {
      registerDrawer,
      registerForm,
      getTitle,
      handleSubmit

    }
  }
})
</script>
<style>
 
</style>
