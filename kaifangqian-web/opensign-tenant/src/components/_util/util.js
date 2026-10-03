/*
 * @description 资助审批电子签章系统
 */

/**
 * components util
 */

/**
 * 清理空值，对象
 * @param children
 * @returns {*[]}
 */
export function filterEmpty (children = []) {
  return children.filter(c => c.tag || (c.text && c.text.trim() !== ''))
}
/**
 * 根据id查找对象
 * @param key
 * @returns {*{}}
 */
export function findMatchItemInList(list, conditions) {
    function isMatch(object) {
        return Object.keys(conditions).length > 0 ? Object.keys(conditions).every(key => {
        if (Object.prototype.toString.call(object[key]) === '[object Array]') {
            return object[key].includes(conditions[key])
        } else {
            return object[key] === conditions[key]
        }
        }) : false
    }
    for (const object of list) {
        if (isMatch(object)) {
            return object
        }
        if (object.children) {
            const res = findMatchItemInList(object.children, conditions)
            if (res) return res
        }
    }
    return null
}