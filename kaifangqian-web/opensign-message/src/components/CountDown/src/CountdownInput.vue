<!--
  @description 资助审批电子签章系统
-->

<template>
  <a-input v-bind="$attrs" :class="prefixCls" :size="size" :value="state">
    <template #addonAfter>
      <CountButton :size="size" :count="count" :value="state" :beforeStartFunc="sendCodeApi" ref="countRef"/>
    </template>
    <template #[item]="data" v-for="item in Object.keys($slots).filter((k) => k !== 'addonAfter')">
      <slot :name="item" v-bind="data || {}"></slot>
    </template>
  </a-input>
</template>
<script lang="ts">
  import { defineComponent, PropType, ref } from 'vue';
  import CountButton from './CountButton.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { useRuleFormItem } from '/@/hooks/component/useFormItem';
  type PromiseValue = boolean | null ;
  const props = {
    value: { type: String },
    size: { type: String, validator: (v) => ['default', 'large', 'small'].includes(v) },
    count: { type: Number, default: 60 },
    sendCodeApi: {
      type: Function as PropType<() => Promise<PromiseValue>>,
      default: null,
    }
  };

  export default defineComponent({
    name: 'CountDownInput',
    components: { CountButton },
    inheritAttrs: false,
    props,
    setup(props) {
      const countRef = ref(null);
      const { prefixCls } = useDesign('countdown-input');
      const [state] = useRuleFormItem(props); 
      function triggerClick(){  
        if(countRef.value){
          countRef?.value.trigeerStart();
        }
      }
      return { prefixCls, state, triggerClick, countRef};
    },
  });
</script>
<style lang="less">
  @prefix-cls: ~'@{namespace}-countdown-input';

  .@{prefix-cls} {
    .ant-input-group-addon {
      padding-right: 0;
      background-color: transparent;
      border: none;

      button {
        font-size: 14px;
      }
    }
    .ant-input{
      // padding:10px 11px;
      height: 32px;
    }
    .ant-input-affix-wrapper{
      height: 40px;
    }
  }
 
</style>
