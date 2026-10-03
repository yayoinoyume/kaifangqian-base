<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :class="[`${prefixCls}__header px-2 py-5`, $attrs.class]">
    <div :class="`${prefixCls}__action`">
      <slot name="action"></slot>
    </div>
  </div>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';

  const props = {
    prefixCls: { type: String },
    helpMessage: {
      type: [Array, String] as PropType<string[] | string>,
      default: '',
    },
    title: { type: String },
    show: { type: Boolean },
    canExpan: { type: Boolean },
  };

  export default defineComponent({
    components: {},
    inheritAttrs: false,
    props,
    emits: ['expand'],
  });
</script>
