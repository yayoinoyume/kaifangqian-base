<!--
  @description 人脸识别
-->
<script lang="ts" setup>
  import { ref, onMounted, onUnmounted } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  import { Toast } from 'vant';
  import Api from '@/api/user';
  const route = useRoute();
  const router = useRouter();

  const data = {
    orderNo: route.query.bizOrderNo,
    userId: route.query.userId,
    taskId: route.query.taskId,
    signRuId: route.query.signRuId,
  };

  onMounted(async () => {
    console.log(data);
    // 后端检验是否实名通过
    const response: any = await Api.checkFace(data);
    console.log(response);
    setTimeout(() => {
      if (response && response.result) {
        Toast.success('实名认证成功');
        router.push({
          path: '/signContract',
          query: {
            signRuId: data.signRuId,
            taskId: data.taskId,
          },
        });
      } else {
        Toast.fail('实名认证失败');
        router.push({
          path: '/personal',
          query: {
            signRuId: data.signRuId,
            taskId: data.taskId,
            path: '/signContract',
          },
        });
      }
    }, 500);
  });
</script>

<template>
  <div class="face-loading">
    <van-overlay :show="true" z-index="0" />
    <van-loading color="#fff" type="spinner" :vertical="true">加载中...</van-loading>
  </div>
</template>
<style lang="less" scoped>
  .face-loading {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }
</style>
