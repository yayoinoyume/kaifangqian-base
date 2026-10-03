<!--
  @description 资助审批电子签章系统
-->

<script lang="ts" setup>
  import { defineComponent, ref, unref, computed, onMounted } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicTable, useTable, EditRecordRow } from '/@/components/Table';
 
  import { quickRecordQueryApi } from '/@/api/yundun/quick';

  const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
    setModalProps({ confirmLoading: false, width: 800, canFullscreen: false, draggable: false });
    reload();
  });

  const [registerTable, { reload, setProps }] = useTable({
    title: '',
    titleHelpMessage: [],
    api: quickRecordQueryApi,
    columns: [
      {
        title: '开通时间',
        dataIndex: 'openTime',
      },
      {
        title: '截止日期',
        dataIndex: 'deadline',
        slots: { customRender: 'deadline' },
      },
      // {
      //   title: '通知邮箱',
      //   dataIndex: 'email',
      // },
      {
        title: '状态',
        dataIndex: 'status',
        slots: { customRender: 'status' },
      },
    ],
    immediate: false,
    fetchSetting: {
      listField: 'freeSignAuthorizes',
    },
    rowKey: 'id',
    useSearchForm: false,
    showIndexColumn: false,
    canResize: false,
    isTriggerSelect: false,
    striped: false,
    showTableSetting: false,
    // tableSetting: { fullScreen: false, redo: true, setting: false, size: false },
    pagination: false,
  });
  onMounted(() => {});
</script>
<template>
  <BasicModal v-bind="$attrs" @register="registerModal" title="开通记录">
    <BasicTable @register="registerTable">
        <template #deadline="{record}">
            <span v-if="record.deadline == 'FOREVER_VALID'">长期有效</span>
            <span v-else>{{ record.deadline }}</span>
        </template>
        <template #status="{record}">
            <a-tag :bordered="true" color="processing" v-if="record.status === 1">有效</a-tag>
            <a-tag v-else>失效</a-tag>
        </template>
    </BasicTable>
  </BasicModal>
</template>
