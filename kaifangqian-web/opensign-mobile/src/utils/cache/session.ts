/**
 * @description session
 */
const ls = window.localStorage;
export default {
    getItem(key:string) {
        try {
            let tem = ls.getItem(key);
            if(tem){
                return JSON.parse(ls.getItem(key));
            }else{
                return null;
            }
        } catch (err) {
            return ls.getItem(key);
        }
    },
    setItem(key:string, val:any) {
        ls.setItem(key, JSON.stringify(val));
    },
    clear() {
        ls.clear();
    },
    keys(index:number) {
        return ls.key(index);
    },
    removeItem(key:string) {
        ls.removeItem(key);
    }
}
