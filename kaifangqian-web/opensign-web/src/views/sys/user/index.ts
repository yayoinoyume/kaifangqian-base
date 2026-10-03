/*
 * @description 资助审批电子签章系统
 */

import {
  companyAuthApi,
  personAuthApi,
  personalAuthUpdateApi,
  companyAuthUpdateApi,
} from '/@/api/auth/userAuth';
import { useUserStore } from '/@/store/modules/user';
import { message } from 'ant-design-vue';

export async function handleAuth(tenantType: number, asyncUrl?: string) {
  const userStore = useUserStore();
  const asyncPage = asyncUrl || window.location.origin + '/#/user/centerInfo';
  if (tenantType === 1) {
    const result = await companyAuthApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      message.warning(result.resultMessage, 5);
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    } else {
      message.warning('获取实名认证链接异常', 5);
    }
  } else {
    const result = await personAuthApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      // userStore.clearUserInfo();
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      message.warning(result.resultMessage, 5);
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    } else {
      message.warning('获取实名认证链接异常', 5);
    }
  }
}

export async function handleUpdateAuth(tenantType: number, asyncUrl?: string) {
  const userStore = useUserStore();
  const asyncPage = asyncUrl || window.location.origin + '/#/user/centerInfo';
  if (tenantType === 1) {
    const result = await companyAuthUpdateApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  } else {
    // todo 个人
    const result = await personalAuthUpdateApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  }
}

// /yundun/auth/personal/update
