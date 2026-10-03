<!--
  @description loading
-->

<template>
    <van-overlay :show="loading" class='base-mask'>
        <van-loading class='base-loading' v-if="loading" size="24px" color="#1989fa">{{ text }}</van-loading>
    </van-overlay>
</template>

<script lang="ts">
import { ref, defineComponent } from "vue"
export default defineComponent({
    name: "Loading",
    props: {
        loading: {
            type: Boolean,
            default: false
        },
        text: {
            type: String,
            default: '加载中...'
        }
    },
    setup() {
        return {
        }
    }
})
</script>

<style lang="less" scoped>
.base-mask {
    background-color: rgba(41, 39, 39, 0.7);
    z-index: 2210;

    .base-loading {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
}
</style>
