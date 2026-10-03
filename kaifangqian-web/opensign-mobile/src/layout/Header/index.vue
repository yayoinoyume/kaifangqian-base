<!--
  @description Header
-->
<template>
  <div class="header">
    <van-nav-bar
      :title="(route.path==='/index'? title :route.name as string)"
      :left-arrow="(route.meta.leftArrow && route.meta.leftArrow as Boolean) == true"
      @click-left="navBack"
      :left-text="(route.meta.leftArrow && route.meta.leftArrow as Boolean) == true ? '返回' : ''"
    >
      <!-- <template #right>
                <van-icon name="friends-o" />
            </template> -->
    </van-nav-bar>
    <!-- <van-action-sheet v-model="actionSheet..show" title="标题">
		  <p>内容</p>
		</van-action-sheet> -->
    <!-- <van-action-sheet v-model:show="actionSheet.show" :actions="actions" @select="onSelect" /> -->
  </div>
</template>

<script setup lang="ts">
  import { getHashQueryString, decodeURIs } from '@/utils/util';
  import Api from '@/api/contract/index';
  import session from '@/utils/cache/session';
  import { APP_WEB_CONFIG } from '@/utils/cache/constant';
  import DownloadActionSheet from '@/pages/components/DownloadActionSheet.vue';

  const title = ref('');
  setTimeout(() => {
    const userConfig = session.getItem(APP_WEB_CONFIG);
    title.value = userConfig.websiteTitle;
  });

  const callbackPage = getHashQueryString('callbackPage');
  const router = useRouter();
  const route = useRoute();

  async function navBack() {
    if (callbackPage && typeof callbackPage == 'string') {
      window.open(decodeURIs(callbackPage), '_self');
    } else {
      router.push({
        path: '/',
      });
      //   router.go(-1);
    }
  }
</script>

<style lang="less" scoped>
  .header {
    .van-nav-bar {
      background: @gray;

      :deep(.van-nav-bar__title) {
        color: #fff;
      }
    }

    :deep(.van-nav-bar .van-icon) {
      color: #fff;
    }

    :deep(.van-nav-bar__text) {
      color: #fff;
    }
  }
</style>
