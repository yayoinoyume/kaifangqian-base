<!--
  @description 资助审批电子签章系统
-->

<template>
  <div :helpMessage="helpMessage">
    {{ title }}
  </div>
</template>
<script lang="ts">
  import type { PropType } from 'vue';
  import { defineComponent } from 'vue';

  export default defineComponent({
    name: 'BasicModalHeader',
    components: {},
    props: {
      helpMessage: {
        type: [String, Array] as PropType<string | string[]>,
      },
      title: { type: String },
    },
    emits: ['dblclick'],
  });
</script>
