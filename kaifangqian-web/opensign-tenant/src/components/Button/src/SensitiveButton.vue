<!--
  @description 资助审批电子签章系统
-->

<template>
  <Button v-bind="getBindValue" :class="getButtonClass" @click="handleClick">
    <template #default="data">
      <Icon :icon="preIcon" v-if="preIcon" :size="iconSize" />
      <slot v-bind="data || {}"></slot>
      <Icon :icon="postIcon" v-if="postIcon" :size="iconSize" />
    </template>
  </Button>
  <SensitiveModal :visible="visible" @cancelModal="handleCancel" @confirm="handleConfirm" :sensitiveVerifyType="sensitiveVerifyType"/>
</template>

<script lang="ts">
  import { defineComponent } from 'vue';
  export default defineComponent({
    name: 'SensitiveButton',
    inheritAttrs: false,
  });
</script>
<script lang="ts" setup>
  import { computed, unref,ref  } from 'vue';
  import { Button } from 'ant-design-vue';
  import Icon from '/@/components/Icon/src/Icon.vue';
  import { buttonProps } from './props';
  import { useAttrs } from '/@/hooks/core/useAttrs';
  import SensitiveModal from './SensitiveModal.vue';
  import { usePermission } from '/@/hooks/web/usePermission';
  // import { getSensitiveTime } from '/@/utils/auth';


  const props = defineProps(buttonProps);
  const { isSensitive } = usePermission();
  const emit = defineEmits(["onClick"]);
  const visible = ref(false);
  const sensitiveVerifyType = ref('phone');
  // get component class
  const attrs = useAttrs({ excludeDefaultKeys: false });
  const getButtonClass = computed(() => {
  const { color, disabled,sensitiveType } = props;
  console.log(sensitiveType,'----敏感操作类型------')
    return [  
      {
        [`ant-btn-${color}`]: !!color,
        [`is-disabled`]: disabled,
      },
    ];
  });
  function handleCancel(){
    visible.value = false;
  }

  function handleClick(){
   if(isSensitive()){
      visible.value = true;
   }else{
    visible.value = false;
    emit('onClick');
   }
  }
  function handleConfirm(){
    visible.value = false;
    emit('onClick');
  }

  // get inherit binding value
  const getBindValue = computed(() => ({ ...unref(attrs), ...props }));
</script>

<style lang="less" scoped>
.sensitive-modal{
  .ant-modal{
    min-height: 220px;
    .ant-modal-body{
      padding:24px;
    }
  }
}

</style>

