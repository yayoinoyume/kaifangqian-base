/*
 * @description 资助审批电子签章系统
 */

import { companyAuthApi, companyAuthUpdateApi } from '/@/api/auth/userAuth';
import { useUserStore } from '/@/store/modules/user';
import { message } from 'ant-design-vue';

export async function handleAuth(tenantType: number, asyncUrl?: string) {
  const userStore = useUserStore();
  const asyncPage = asyncUrl || window.location.origin + window.location.pathname + '#/overview';
  if (tenantType === 1) {
    const result = await companyAuthApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      message.warning(result.resultMessage);
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  }
}

export async function handleUpdateAuth(tenantType: number, asyncUrl?: string) {
  const userStore = useUserStore();
  const asyncPage = asyncUrl || window.location.origin + window.location.pathname + '#/overview';
  if (tenantType === 1) {
    const result = await companyAuthUpdateApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  }
}
