<!--
  @description 资助审批电子签章系统
-->

<template>
  <div>
    <BasicTable @register="registerTable" @fetch-success="onFetchSuccess"
    :rowSelection="{ type: 'checkbox', selectedRowKeys: checkedKeys, onChange: onSelectChange }">
      <template #toolbar>
        <a-button type="primary" @click="handleEdit"> 新增 </a-button>
      </template>
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
      <template #action="{ record }">
          <a-button type="link"  size="small" @click="handleEdit(record)">编辑</a-button>
          <Divider type="vertical" />
          <a-button type="link"  size="small" @click="handleFunTest(record)">功能测试</a-button>
          <Divider type="vertical" />
          <Dropdown   :trigger="['hover']">
            <template #overlay>
              <Menu>
                  <MenuItem>
                      <a href="javascript:;" @click="handleSend(record)">测试</a>
                  </MenuItem>
              </Menu>
            </template>
          <a-button type="link"  size="small">更多<DownOutlined /></a-button>
        </Dropdown>
      </template>
    </BasicTable>
    <VerifyModal @register="register" @success="handleSuccess" />
    <FunTest @register="registerFun" @success="handleSuccess" />
  </div>
</template>
<script lang="ts">
  import { defineComponent,ref } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { Tag,Dropdown,Menu,MenuItem, Divider } from 'ant-design-vue';
  import { DownOutlined } from '@ant-design/icons-vue';
  import { getCheckRuleList } from '/@/api/dict';
  import { verifyColumns, verifySearchFormSchema } from './data';
  import { useModal } from '/@/components/Modal';

  import VerifyModal from './modal/VerifyModal.vue';
  import FunTest from './modal/FunTest.vue';

  export default defineComponent({
    name: 'Verify',
    components: { BasicTable, TableAction,Tag, DownOutlined ,Dropdown,Menu,MenuItem,Divider,VerifyModal,FunTest},
    setup() {
      const checkedKeys = ref<Array<string | number>>([]);
      const [register, { openModal }] = useModal();
      const [registerFun, { openModal: openFunModal}] = useModal();


      const [registerTable, { reload }] = useTable({
        title: '',
        api: getCheckRuleList,
        columns:verifyColumns,
        formConfig: {
          labelWidth: 120,
          schemas: verifySearchFormSchema,
        },
        fetchSetting:{
          listField:'records'
        },
        useSearchForm: true,
        showTableSetting: false,
        tableSetting: { fullScreen: false ,redo:true,setting:false,size:false},
        showIndexColumn: true,
        rowKey: 'id',
        striped: false,
        bordered: false,
        canResize: false,
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
      function handleView(){

      }

      function onFetchSuccess() {
        // 演示默认展开所有表项
      }
      function handleEdit(record: Recordable){
        if(!record.id){
          openModal(true,{
            isUpdate:false
          })
        }else{

        }
         console.log(record);
      }
      function handleSend(record: Recordable){
         console.log(record);
      }
      function handleFunTest(record){
        console.log(record)
        openFunModal(true,{
          isUpdate:false,
        })
      }

      return {
        register,
        registerFun,
        checkedKeys,
        handleFunTest,
        registerTable,
        handleDelete,
        handleSuccess,
        onFetchSuccess,
        onSelectChange,
        handleView,
        handleSend,
        handleEdit
      };
    },
  });
</script>
