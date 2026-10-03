/**
 * @description 网站title
 */
import { useTitle as usePageTitle } from '@vueuse/core';
import Api from '@/api/user';

export function useTitle() {
    let defaultTitle = import.meta.env.VITE_APP_TITLE;
    let title = usePageTitle()
    let { result, code } = Api.getWebTitle({});
    if (code == 200) {
        title.value = result || defaultTitle;
    }
}