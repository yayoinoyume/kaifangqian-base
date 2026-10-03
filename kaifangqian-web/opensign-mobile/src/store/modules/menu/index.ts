/**
 * @description : menu
 */
import { defineStore } from 'pinia';


export const useMenuStore = defineStore('menu', {
    state: () => {
        return {
            isCollapse: true,
            cacheViews: <string[]>['']
        };
    },
    getters: {
        getCacheViews(): Array<string> {
            return this.cacheViews || {};
        }
    },
    actions: {
        updateCollapse() {
            this.isCollapse = !this.isCollapse;
        },
        setCacheViews(caches: Array<string>) {
            this.cacheViews = caches
        }
    },
});
