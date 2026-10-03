<!--
  @description 资助审批电子签章系统
-->

<template>
  <span :class="$attrs.class">
    <Icon :icon="icon" />
  </span>
</template>
<script lang="ts" setup>
  import { Icon } from '/@/components/Icon';
  defineProps({
    icon: String,
  });
</script>
