/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

enum Api {
  ArticleAddGroup = '/sys/article/type/add',
  ArticleEditGroup = '/sys/article/type/edit',
  ArticleDeleteGroup = '/sys/article/type/delete',
  ArticleGrouplist = '/sys/article/type/list',
  ArticleAdd = '/sys/article/add',
  ArticleInfo = '/sys/article/info',
  ArticleEdit = '/sys/article/edit',
  ArticleDelete = '/sys/article/delete',
  ArticleList = '/sys/article/list',
  ArticleNoAuthList = '/sys/article/listNoAuth',

}

/**
 * @description: 文章新增分类
 */
export function addArticleGroup(params) {
  return defHttp.post({ url: Api.ArticleAddGroup,params });
}

/**
 * @description: 文章编辑分类
 */
export function editArticleGroup(params) {
  return defHttp.put({ url: Api.ArticleEditGroup,params });
}
/**
 * @description: 文章删除分类
 */
export function deleteArticleGroup(params) {
  return defHttp.delete({ url: Api.ArticleDeleteGroup,params });
}
/**
 * @description: 文章分类列表
 */
export function getArticleGroupList(params) {
  return defHttp.get({ url: Api.ArticleGrouplist,params });
}
/**
 * @description: 文章新增
 */
export function addArticleAdd(params) {
  return defHttp.post({ url: Api.ArticleAdd,params });
}
/**
 * @description: 文章详情
 */
export function getArticleInfo(params) {
  return defHttp.get({ url: Api.ArticleInfo,params });
}
/**
 * @description: 文章编辑
 */
export function editArticle(params) {
  return defHttp.put({ url: Api.ArticleEdit,params });
}
/**
 * @description: 文章删除
 */
export function deleteArticle(params) {
  return defHttp.delete({ url: Api.ArticleDelete,params });
}
/**
 * @description: 文章列表
 */
export function getArticleList(params) {
  return defHttp.get({ url: Api.ArticleList,params });
}
/**
 * @description: 文章无权限列表
 */
export function getNoAuthArticleList(params) {
  return defHttp.delete({ url: Api.ArticleNoAuthList,params });
}