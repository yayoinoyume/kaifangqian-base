/*
 * @description 资助审批电子签章系统
 */

/*
 *localStorage 退出或者关闭浏览器  存储的信息将会永久保存
 */
const storage = window.localStorage;
export default {
    getItem(key:string) {
        try {
			let tem = storage.getItem(key);
			if(tem){
				return JSON.parse(tem);
			}else{
				return null;
			}
			 
        } catch (err) {
			return storage.getItem(key);
        }
    },
    setItem(key:string, val:string) {
        storage.setItem(key, JSON.stringify(val));
    },
    clear() {
        storage.clear();
    },
    keys(index:number) {
        return storage.key(index);
    },
    removeItem(key:string) {
        storage.removeItem(key);
    }
}
