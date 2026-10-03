<!--
  @description layout
-->
  
<template>
    <div class="layout">
        <Header />
        <div class="content" style="padding: 10px;">
            <router-view v-slot="{ Component }">
                <keep-alive :include="cachedViews">
                    <component :is="Component" />
                </keep-alive>
                <!-- <component :is="Component" v-if="!$route.meta.keepAlive" /> -->
            </router-view>
        </div>
    </div>
</template>

<script setup lang="ts">
import { computed } from "vue";
import Header from './Header/index.vue';
import { useMenuStore } from '@/store/modules/menu';

const menuInfo = useMenuStore();

const cachedViews = computed(() => menuInfo.getCacheViews)


</script>

<style lang="less" scoped>
.layout {
    position: absolute;
    width: 100%;
    height: 100%;

    .header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: @header-height;
        // height: 150px;
        z-index: 1;
        box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.2);
    }

    .content {
        margin-top: @header-height;
        height: calc(100% - @header-height);
        overflow: auto;
        background-color: #f7fafd;
    }
}
</style>
