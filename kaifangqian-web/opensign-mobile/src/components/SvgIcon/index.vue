<!--
  @description svg 图标组件
-->
<template>
    <svg aria-hidden="true" :style="getStyle">
        <use :href="symbolId" :fill="color" />
    </svg>
</template>
  
<script>
// import type { CSSProperties } from 'vue';
import { defineComponent, computed } from 'vue'

export default defineComponent({
    name: 'SvgIcon',
    props: {
        prefix: {
            type: String,
            default: 'icon',
        },
        name: {
            type: String,
            required: true,
        },
        color: {
            type: String,
            default: '#333',
        },
        size: {
            type: [Number, String],
            default: 16,
        },
    },
    setup(props) {
        const symbolId = computed(() => `#${props.prefix}-${props.name}`)
        const getStyle = computed(() => {
            const { size } = props;
            let s = `${size}`;
            s = `${s.replace('px', '')}px`;
            return {
                width: s,
                height: s,
            };
        });
        return { symbolId, getStyle }
    },
})
</script>