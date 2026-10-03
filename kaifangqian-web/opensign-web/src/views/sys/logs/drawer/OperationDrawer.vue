<!--
  @description 资助审批电子签章系统
-->

<template>
  <BasicDrawer
    v-bind="$attrs"
    @register="registerDrawer"
    showFooter
    :title="getTitle"
    width="50%"
    @ok="handleSubmit"
    >
      <span>{{logContent}}</span>
      <!-- <BasicForm @register="registerForm" /> -->
  </BasicDrawer>
</template>
<script lang="ts">
  import { defineComponent, ref, computed, unref } from 'vue';
  // import { BasicForm, useForm } from '/@/components/Form/index';
  // import { logInfoSchema, } from '../log';
  import { BasicDrawer, useDrawerInner } from '/@/components/Drawer';
  import { Tabs,Card } from 'ant-design-vue';
  import { getSysErrorlogInfo } from '/@/api/sys/log';

  export default defineComponent({
    name: 'DeptBatchDrawer',
    components: { BasicDrawer,
    //  BasicForm, 
     Tabs,  
     TabPane: Tabs.TabPane
     ,Card},
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const isUpdate = ref(true);
      const logContent = ref('');

      // const [registerForm, { resetFields, setFieldsValue }] = useForm({
      //   labelWidth: 100,
      //   schemas: logInfoSchema,
      //   showActionButtonGroup: false,
      //   baseColProps: { lg: 24, md: 24 },
      // });
      const [registerDrawer, { setDrawerProps, closeDrawer }] = useDrawerInner(async (data) => {
        // resetFields();
        setDrawerProps({ confirmLoading: false });
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
          if(data.record.errorLogId){
            getStackErrorContent(data.record.errorLogId)
          }
        }
      });


      const getTitle = computed(() => ('日志详情'));

      async function handleSubmit() {
        try {
          setDrawerProps({ confirmLoading: true });
          closeDrawer();
          emit('success');
        } finally {
          setDrawerProps({ confirmLoading: false });
        }
      }
      async function getStackErrorContent( id: string){
        let result = await getSysErrorlogInfo({id});
        if(result){
          logContent.value = result.errorStackInfo;
          // setFieldsValue({
          //   logContent:result.errorStackInfo
          // });
        }
      }

      return { registerDrawer, getTitle, handleSubmit ,isUpdate, logContent};
    },
  });
</script>
