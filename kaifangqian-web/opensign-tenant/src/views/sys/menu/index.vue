<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicTable @register="registerTable" @fetch-success="onFetchSuccess">
      <template #toolbar>
        <a-button type="primary" @click="handleCreate" v-if="hasPermission(['menu:add'])" > 新增菜单 </a-button>
      </template>
      <template #menuType="{record}">
          <span>{{record.menuType===0?'目录':'菜单'}}</span>
      </template>
      <template #action="{ record }">
        <TableAction
          :actions="[
            // {
            //   label:'详情',
            //   onClick: handleEdit.bind(null, record),
            // },
            {
              label:'编辑',
              onClick: handleEdit.bind(null, record),
              auth:'menu:edit'
            },
            {
              label:'删除',
              color: 'error',
              auth:'menu:delete',
              popConfirm: {
                title: '是否确认删除',
                confirm: handleDelete.bind(null, record),
              },
            },
          ]"
        />
      </template>
    </BasicTable>
    <MenuDrawer @register="registerDrawer" @success="handleSuccess" />
  </div>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';

  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { getMenuList,deleteMenu } from '/@/api/demo/system';

  import { useDrawer } from '/@/components/Drawer';
  import MenuDrawer from './MenuDrawer.vue';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { columns, searchFormSchema } from './menu.data';
  import { usePermission } from '/@/hooks/web/usePermission';

  export default defineComponent({
    name: '菜单管理',
    components: { BasicTable, MenuDrawer, TableAction },
    setup() {
      const { createMessage } = useMessage();
      const { hasPermission } = usePermission();
      const [registerDrawer, { openDrawer }] = useDrawer();
      const [registerTable, { reload }] = useTable({
        title: '',
        api: getMenuList,
        columns,
        formConfig: {
          labelWidth: 120,
          schemas: searchFormSchema,
        },
        isTreeTable: true,
        pagination: false,
        striped: false,
        useSearchForm: false,
        showTableSetting: false,
        bordered: false,
        showIndexColumn: false,
        canResize: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        actionColumn: {
          width: 150,
          title: '操作',
          dataIndex: 'action',
          slots: { customRender: 'action' },
          fixed: 'right',
        },
      });

      function handleCreate() {
        openDrawer(true, {
          isUpdate: false,
        });
      }

      function handleEdit(record: Recordable) {
        openDrawer(true, {
          record,
          isUpdate: true,
        });
      }

      async function handleDelete(record: Recordable) {
        let deleteResult = await deleteMenu({id:record.id});
        if(deleteResult){
          createMessage.success(`操作成功`);
          reload();
        }
      }

      function handleSuccess() {
        reload();
      }

      function onFetchSuccess() {
        // 演示默认展开所有表项
        // nextTick(expandAll);
      }

      return {
        registerTable,
        registerDrawer,
        handleCreate,
        handleEdit,
        handleDelete,
        handleSuccess,
        onFetchSuccess,
        hasPermission
      };
    },
  });
</script>
