<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicTable @register="registerTable" @fetch-success="onFetchSuccess">
      <template #headerTop  v-if="checkedKeys.length > 0">
            <a-alert type="info" show-icon>
              <template #message>
                <template v-if="checkedKeys.length > 0">
                  <span>已选中{{ checkedKeys.length }}条记录</span>
                  <a-button type="link" @click="checkedKeys = []" size="small">清空</a-button>
                </template>
                <template v-else>
                  <span>未选中任何项目</span>
                </template>
              </template>
            </a-alert>
      </template>
      <template #mesSendStatus="{ text }">
        <span>{{loadSendStatus(text)}}</span>
      </template>
      <template #channelType="{ text }">
        <span>{{loadChannelType(text)}}</span>
      </template>
      <template #action="{ record }">
        <TableAction
          :actions="[
            {
              // icon: 'ant-design:eye-twotone',
              label:'重新发送',
              onClick: handleReSend.bind(null, record),
              auth:'3rdRecord:retry',
              disabled:(record.mesSendStatus == 2 || record.mesSendStatus == 0)?false:true
            },
          ]"
        />
      </template>
    </BasicTable>
  </div>
</template>
<script lang="ts">
  import { defineComponent, ref, onMounted  } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { Tag } from 'ant-design-vue';
  import { getMessageHistory,getMessageRetry } from '/@/api/message';
  import { messageHistoryColumns, messageHistorySearchFormSchema } from './data';
  import { useMessage } from '/@/hooks/web/useMessage';

  export default defineComponent({
    name: 'MyMessage',
    components: { BasicTable, TableAction,Tag },
    setup() {
      const checkedKeys = ref<Array<string | number>>([]);
      const { createMessage: msg } = useMessage();
      const [registerTable, { reload, setTableData}] = useTable({
        title: '',
        api: getMessageHistory,
        columns:messageHistoryColumns,
        formConfig: {
          labelWidth: 120,
          schemas: messageHistorySearchFormSchema,
        },
        immediate:true,
        useSearchForm: true,
        rowSelection:{
          type:'checkbox',
          onChange:onSelectChange
        },
        fetchSetting:{
          listField:'records'
        },
        tableSetting: { fullScreen: false },
        showIndexColumn: true,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
        actionColumn: {
          width: 80,
          title: '操作',
          dataIndex: 'action',
          slots: { customRender: 'action' },
          fixed: undefined,
        },
      })
      onMounted(()=>{
        let list = [{msgTitle:"测试", msgType:'ddssd',msgDate:'2022-09-22'}];
        setTableData(list);
      })

      function onSelectChange(selectedRowKeys: (string | number)[]) {
        console.log(selectedRowKeys);
        checkedKeys.value = selectedRowKeys;
      }

      function handleDelete(record: Recordable) {
        console.log(record);
      }

      function handleSuccess() {
        reload();
      }
      function handleReSend(record){
        console.log(record)
        getMessageRetry({id:record.id}).then(res=>{
          if(res.code){
            msg.success('发送成功')
            reload()
          }
        })
      }

      function loadChannelType(status){
        switch(status){
          case 0:
            return '站内信';
          case 1:
            return '邮件';
          case 2:
            return '短信';
          default:
            return ''
        }
      }
      function loadSendStatus(status){
         switch(status){
          case 0:
            return '未发送';
          case 1:
            return '发送成功';
          case 2:
            return '发送失败';
          default:
            return ''
        }
      }

      function onFetchSuccess() {
        // 演示默认展开所有表项
      }

      return {
        checkedKeys,
        registerTable,
        handleDelete,
        handleSuccess,
        onFetchSuccess,
        onSelectChange,
        handleReSend,
        loadChannelType,
        loadSendStatus
      };
    },
  });
</script>
