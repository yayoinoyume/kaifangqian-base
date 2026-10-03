/*
 * @description 资助审批电子签章系统
 */

/*
 * sessionStorage 退出或者关闭浏览器  存储的信息会丢失
 */
const storage = window.sessionStorage;
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
			if(key){
				return storage.getItem(key);
			}else{
				return null;
			}
            
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
