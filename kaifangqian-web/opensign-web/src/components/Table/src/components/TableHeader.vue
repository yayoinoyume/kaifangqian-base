<!--
  @description 资助审批电子签章系统
-->

<template>
  <div style="width: 100%">
    
    <div class="flex items-center">
      <slot name="tableTitle" v-if="$slots.tableTitle"></slot>
      <TableTitle
        :helpMessage="titleHelpMessage"
        :title="title"
        v-if="!$slots.tableTitle && title"
      />
      <div :class="[`${prefixCls}__toolbar`,tableSetting.align??'left']">
        <slot name="toolbar"></slot>
        
        <Divider type="vertical" v-if="$slots.toolbar && showTableSetting" />
        <TableSetting
          :setting="tableSetting"
          v-if="showTableSetting"
          @columns-change="handleColumnChange"
        />
      </div>
    </div>
    <div v-if="$slots.headerTop" style="margin: 5px">
      <slot name="headerTop"></slot>
    </div>
  </div>
</template>
<script lang="ts">
  import type { TableSetting, ColumnChangeParam } from '../types/table';
  import type { PropType } from 'vue';
  import { defineComponent } from 'vue';
  import { Divider } from 'ant-design-vue';
  import TableSettingComponent from './settings/index.vue';
  import TableTitle from './TableTitle.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { usePermission } from '/@/hooks/web/usePermission';
  import { RoleEnum } from '/@/enums/roleEnum';

  export default defineComponent({
    name: 'BasicTableHeader',
    components: {
      Divider,
      TableTitle,
      TableSetting: TableSettingComponent,
    },
    props: {
      title: {
        type: [Function, String] as PropType<string | ((data: Recordable) => string)>,
      },
      tableSetting: {
        type: Object as PropType<TableSetting>,
        default: 'left',
      },
      showTableSetting: {
        type: Boolean,
      },
      titleHelpMessage: {
        type: [String, Array] as PropType<string | string[]>,
        default: '',
      },
    },
    emits: ['columns-change'],
    setup(props, { emit }) {
      const { prefixCls } = useDesign('basic-table-header');
      const { hasPermission } = usePermission();
      function handleColumnChange(data: ColumnChangeParam[]) {
        emit('columns-change', data);
      }
      console.log(props.tableSetting,'列表设置-----')
      return { 
        prefixCls, 
        handleColumnChange ,
        RoleEnum,
        hasPermission
      };
    },
  });
</script>
<style lang="less">
  @prefix-cls: ~'@{namespace}-basic-table-header';

  .@{prefix-cls} {
    &__toolbar {
      flex: 1;
      display: flex;
      align-items: center;
      justify-content:flex-start;

      > * {
        margin-right: 8px;
      }
    }
    &__toolbar.left{
      justify-content:flex-start;
    }
    &__toolbar.right{
        justify-content: flex-end;
    }
    &__toolbar.center{
        justify-content: center;
    }
   
  }
  .header-top-action{
      float: right;
  }
  .resrun-basic-table-header__toolbar{
    .ant-btn{
      font-size:12px;
      height: 28px;
      padding:2px 15px;
    }
  }
  
</style>
