<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="silent-sign-auth">
    <Unauthenticated
      :index="5"
      v-if="status === 'unauthenticated'"
      @authenticated="handleAuthenticated"
    />

    <NotActivated v-else-if="status === 'notActivated'" @reload="initData" />
    <!-- <NotActivated /> -->

    <Activated v-else-if="status === 'activated'" :expiryDate="expiryDate" @reload="initData" />
    <!-- <Activated /> -->
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref } from 'vue';
  import Unauthenticated from './Unauthenticated.vue';
  import NotActivated from './SilentSignNotActivated.vue';
  import Activated from './SilentSignActivated.vue';
  import { useUserStore } from '/@/store/modules/user';
  import { silentQueryApi, silentQueryRecordApi } from './api';
  import { any } from 'vue-types';

  const status = ref(''); // 'unauthenticated', 'notActivated', 'activated'
  const expiryDate = ref('');
  const userStore = useUserStore();
  const handleAuthenticated = () => {
    status.value = 'notActivated';
  };

  async function initData() {
    // alert(userStore.tenantInfo.authStatus);
    if (userStore.tenantInfo.authStatus !== 2) {
      // 未实名
      status.value = 'unauthenticated';
      return;
    }
    const result = await silentQueryApi();
    console.log('result', result);
    if (result.status === 0) {
      // 未开通
      status.value = 'notActivated';
    } else if (result.status === 1) {
      if (result.deadline && result.deadline == 'FOREVER_VALID') {
        expiryDate.value = '长期有效';
      } else {
        expiryDate.value = result.deadline;
      }
      status.value = 'activated';
    }
  }
  onMounted(() => {
    initData();
  });
</script>

<style lang="less" scoped>
  .silent-sign-auth {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }

  .header {
    text-align: center;
    margin-bottom: 40px;
  }
</style>
