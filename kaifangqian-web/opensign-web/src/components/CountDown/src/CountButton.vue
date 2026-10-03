<!--
  @description 资助审批电子签章系统
-->

<template>
  <Button v-bind="$attrs" :disabled="isStart" @click="handleStart" :loading="loading" 
  style="text-align: center;font-size:12px;" :style="
  ['height:'+(size=='small'?36:40) + 'px']
  ">
    {{ getButtonText }}
  </Button>
</template>
<script lang="ts">
  import { defineComponent, ref, watchEffect, computed, unref } from 'vue';
  import { Button } from 'ant-design-vue';
  import { useCountdown } from './useCountdown';
  import { isFunction } from '/@/utils/is';
  import { useI18n } from '/@/hooks/web/useI18n';

  const props = {
    value: { type: [Object, Number, String, Array] },
    count: { type: Number, default: 60 },
    beforeStartFunc: {
      type: Function as PropType<() => Promise<boolean>>,
      default: null,
    },
    size:{type:String,default:"default"}
  };

  export default defineComponent({
    name: 'CountButton',
    components: { Button },
    props,
    setup(props) {
      const loading = ref(false);
      console.log(props,"-------------111");
      const { currentCount, isStart, start, reset } = useCountdown(props.count);
      const { t } = useI18n();

      const getButtonText = computed(() => {
        return !unref(isStart)
          ? '获取验证码'
          : t('component.countdown.sendText', [unref(currentCount)]);
      });

      watchEffect(() => {
        props.value === undefined && reset();
      });

      /**
       * @description:
       */
      async function handleStart() {
        const { beforeStartFunc } = props;
        if (beforeStartFunc && isFunction(beforeStartFunc)) {
          // loading.value = true;
          try {
            const canStart = await beforeStartFunc();
            canStart && start();
          } finally {
            // loading.value = false;
          }
        } else {
          start();
        }
      }
      function trigeerStart(){
        start();
      }
      return { handleStart, currentCount, loading, getButtonText, isStart, trigeerStart,props };
    },
  });
</script>
<style lang="less" scoped>
  :deep(.ant-btn){
    height:auto;
    font-size: 12px;
  }
</style>
