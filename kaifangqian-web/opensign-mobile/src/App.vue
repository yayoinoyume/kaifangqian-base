<!--
  @description ：App.vue
-->
<template>
  <router-view />
</template>

<script setup lang="ts">
  import debug from '@/utils/debug';
  import copyPaste from '@/utils/lib/copy-paste';
  import { useTitle } from '@vueuse/core';
  // import Api from '@/api/user';
  import { useUserStore } from '@/store/modules/user';

  onMounted(() => {
    // 因为debug是存入localStorage中的，刷新页面会从localStorage取出，根据debug控制是否隐藏
    debug.init();

    copyPaste.disable();
    const user = useUserStore();
    console.log('user.getWebConfig', user.getWebConfig);
    initTitle(user.getWebConfig?.websiteTitle);
  });

  async function initTitle(websiteTitle: any) {
    let defaultTitle = import.meta.env.VITE_APP_TITLE;
    let title = useTitle(defaultTitle);
    // let { result, code } = await Api.getWebTitle({});
    // if (code == 200) {
    title.value = websiteTitle || defaultTitle;
    // }
  }

  onBeforeUnmount(() => {
    copyPaste.enable();
  });
</script>

<style>
  #app {
    font-family: Inter, Avenir, Helvetica, Arial, sans-serif;
    font-synthesis: none;
    text-rendering: optimizeLegibility;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    -webkit-text-size-adjust: 100%;
  }
</style>
