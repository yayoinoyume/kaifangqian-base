/*
 * @description 资助审批电子签章系统
 */

export const getAssetsFile = (url: string) => {
   return new URL(`../assets/images/${url}`, import.meta.url).href
}