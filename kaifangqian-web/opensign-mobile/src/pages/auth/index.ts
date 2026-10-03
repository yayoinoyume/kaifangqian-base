/**
 * @description 云盾认证API
 */
import Api from '@/api/user';
// import { useUserStore } from '/@/store/modules/user';

export async function handleAuth(tenantType: number, asyncUrl?: string) {
  // const userStore = useUserStore();
  const asyncPage = asyncUrl || window.location.origin + window.location.pathname + '#/index';
  if (tenantType === 1) {
    const { result } = await Api.companyAuthApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      // await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  } else {
    const { result } = await Api.personAuthApi({ callbackPage: asyncPage });
    if (result.authStatus === 0) {
      // userStore.clearUserInfo();
      window.open(result.authUrl, '_self');
    } else if (result.authStatus === 1) {
      // await userStore.getTnantInfo();
      window.open(asyncPage, '_self');
    }
  }
}
