<!--
  @description 资助审批电子签章系统
-->

<template>
  <ConfigProvider :locale="getAntdLocale">
    <AppProvider>
      <RouterView /> 
    </AppProvider>
  </ConfigProvider>
</template>

<script lang="ts" setup>
  import { ConfigProvider  } from 'ant-design-vue';
  import { AppProvider } from '/@/components/Application';
  import { useTitle } from '/@/hooks/web/useTitle';
  import { useLocale } from '/@/locales/useLocale';

  /**汉化时间选择 */
  // import zhCN from 'ant-design-vue/es/locale/zh_CN';
  import dayjs from 'dayjs';
  import 'dayjs/locale/zh-cn';
  dayjs.locale('zh-cn');
  
  const { getAntdLocale } = useLocale();
  const isMIcro = window.eventCenterForAppNameVite?true:false;
  console.log(getAntdLocale,'语言');
  
  useTitle();
</script>

<style lang="less">
#app{
  height:100%!important;
}
</style>