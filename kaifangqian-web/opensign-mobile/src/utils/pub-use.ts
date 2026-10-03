/**
 * @description : 获取静态资源文件
 */
export const getAssetsFile = (url: string) => {
   return new URL(`../assets/images/${url}`, import.meta.url).href
}