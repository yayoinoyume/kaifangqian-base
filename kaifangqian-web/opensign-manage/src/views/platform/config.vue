<!--
  @description 资助审批电子签章系统
-->

<template>
  <div class="platform-config-content">
    <div class="content-tabs">
      <a-tabs
        v-model:activeKey="activeKey"
        tab-position="left"
        @tabClick="handleCancel"
        :destroy-inactive-tab-pane="true"
      >
        <!-- <a-tab-pane key="1" tab="网站配置">
          <tabWeb />
        </a-tab-pane> -->
        <a-tab-pane key="2" tab="短信配置">
          <tabMessage />
        </a-tab-pane>
        <a-tab-pane key="3" tab="邮箱配置">
          <tabEmail />
        </a-tab-pane>
        <!-- <a-tab-pane key="4" tab="证书配置">
          <tabCertificate />
        </a-tab-pane> -->
        <a-tab-pane key="5" tab="其他配置">
          <otherConfig />
        </a-tab-pane>
        <!-- <a-tab-pane key="6" tab="人脸识别配置">
          <tabSign />
        </a-tab-pane>
        <a-tab-pane key="7" tab="账号类型配置">
          <account />
        </a-tab-pane> -->
        <!-- <a-tab-pane key="7" tab="文件存储配置">Content of Tab Pane 3</a-tab-pane> -->
      </a-tabs>
    </div>
    <!-- <div class="content-body">
      
    </div> -->
  </div>
</template>

<script lang="ts">
  import { ref, defineComponent, onMounted } from 'vue';
  import { BasicTable, useTable } from '/@/components/Table';
  import Icon from '/@/components/Icon';
  import { message } from 'ant-design-vue';
  import { developerManageList, developerManageEdit } from '/@/api/interface';
  import { useModal } from '/@/components/Modal';
  import { cloneDeep } from 'lodash-es';
  import { CopyOutlined } from '@ant-design/icons-vue';

  import tabWeb from './tabs/web.vue';
  import tabMessage from './tabs/message.vue';
  import tabEmail from './tabs/email.vue';
  import tabCertificate from './tabs/certificate.vue';
  import tabRealame from './tabs/realame.vue';
  import tabSign from './tabs/sign.vue';
  import account from './tabs/account.vue';
  import otherConfig from './tabs/otherConfig.vue';

  export default defineComponent({
    name: 'PlatformConfig',
    components: {
      tabWeb,
      tabMessage,
      tabEmail,
      tabCertificate,
      tabRealame,
      tabSign,
      account,
      otherConfig,
    },
    setup() {
      const activeKey = ref('2');
      const webConfigRef = ref();

      function handleCancel(key) {
        console.log('handleCancel:', key);
        if (key == '1') {
          // webConfigRef.value.initData();
        }
      }
      return {
        activeKey,
        handleCancel,
        webConfigRef,
      };
    },
  });
</script>

<style lang="less" scoped>
  .platform-config-content {
    .content-tabs {
      /* width:150px; */
    }

    .content-content {
      flex: 1;
    }
  }
</style>
