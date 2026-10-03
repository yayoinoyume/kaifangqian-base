/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-23 19:29:57 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-12-21 14:38:01
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { getAuthGroup } from '/@/api/auth/group'; 

/**
 * 列表搜索表单
 */
export const searchFormSchema:FormSchema[] =[
  {
    field: 'name',
    label: '名称',
    component: 'Input',
    colProps: { span: 8 },
  },
]
/**
 * 新建权限组
 */
export const createGroupColumns:BasicColumn[] = [
  {
    title:'名称',
    dataIndex:'name',
    editRow: true,
    editComponent: 'Input',
    width:200
  },
  {
    title:'分类',
    dataIndex:'type',
    editRow: true,
    width:200,
    editComponent: 'ApiSelect',
    editComponentProps: {
      api: getAuthGroup,
      resultField: 'record',
      labelField:'groupName',
      valueField:'id'
    },
  },
  
]
/**
 * 新建权限组表单
 */
export const createFormSchema:FormSchema[] = [
  {
    field: 'groupName',
    label: '名称 ',
    component: 'Input',
    colProps: { span: 12 },
    required:true,
    componentProps: {
      disabled: false,
   }
  },
  {
    field: 'parentId',
    label: '分类',
    component: 'ApiSelect',
    colProps: { span: 12 },
    required:true,
    componentProps:{
      api: getAuthGroup,
      resultField: 'result',
      labelField:'groupName',
      valueField:'id'
    }
  },
  {
    field: 'groupDesc',
    label: '描述',
    component: 'InputTextArea',
    colProps: { span: 24 },
    componentProps: {
      disabled: false,
      autoSize:{ minRows: 5, maxRows: 24 }
   },
  },
]

/**
 * 新建权限组分组
 */

 export const createAuthGroupFormSchema:FormSchema[] = [
  {
    field: 'groupName',
    label: '分组名 ',
    component: 'Input',
    colProps: { span: 24 },
    required:true,
    componentProps: {
      disabled: false,
    }
  },
  {
    field: 'groupDesc',
    label: '描述',
    component: 'InputTextArea',
    colProps: { span: 24 },
    componentProps: {
      disabled: false,
      autoSize:{ minRows: 5, maxRows: 24 }
   },
  },
]



/**
 * 列表字段配置
 */
 export const tableColumns:BasicColumn[] =[
  {
    title:'名称',
    dataIndex:'groupName'
  },
  {
    title:'描述',
    dataIndex:'groupDesc'
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
]

/**
 * 权限组基本信息
 */
export const treeFormSchema:FormSchema[] = [
  {
    field: 'groupName',
    label: '名称',
    required:true,
    component: 'Input',
    colProps: { span: 12 },
  },
  {
    field: 'parentId',
    label: '分类',
    component: 'ApiSelect',
    colProps: { span: 12 },
    required:true,
    componentProps:{
      api: getAuthGroup,
      resultField: 'result',
      labelField:'groupName',
      valueField:'id'
    }
  },
  {
    field: 'groupDesc',
    label: '描述',
    component: 'InputTextArea',
    colProps: { span: 24 },
    componentProps: {
      disabled: false,
      autoSize:{ minRows: 5, maxRows: 24 }
   },
  },
]

/**
 * 权限组基本信息
 */
export const authBasicForm:FormSchema[] = [
 
]

/**
 * 成员管理
 */

export const userColumns:BasicColumn[] = [
  {
    title:'名称',
    dataIndex:'name',
    slots: { customRender: 'name' },
    align: 'left',
  },
]
/**
 * 成员管理
 */

export const roleColumns:BasicColumn[] = [
  {
    title:'名称',
    dataIndex:'roleName',
    slots: { customRender: 'roleName' },
    align: 'left',
  },
]
/**
 * 权限管理
 */

export const authColumns:BasicColumn[] = [
  {
    title:'名称',
    dataIndex:'dataName',
    align: 'left',
    width:250,
    slots: { customRender: 'dataName' },
  },
  {
    title:'说明',
    dataIndex:'dataDesc',
    align: 'left',
  },
  {
    title:'操作',
    dataIndex:'action',
    slots: { customRender: 'action' },
  },
]
/**
 * 策略新建
 */

export const ployFormSchema:FormSchema[] = [
  {
    field: 'dataName',
    label: '策略名称',
    required:true,
    component: 'Input',
    colProps: { span: 24 },
  },
  {
    field: 'dataDesc',
    label: '描述',
    component: 'InputTextArea',
    colProps: { span: 24 },
    componentProps: {
      disabled: false,
      autoSize:{ minRows: 5, maxRows: 24 }
   },
  },
]