/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';

export const applicationColumn:BasicColumn[] = [
  {
    title:'应用',
    dataIndex:'name',
    
    slots: { customRender: 'name' },
  },
  {
    title:'版本',
    dataIndex:'version',
    slots: { customRender: 'version' },
  },
  {
    title:'适用范围',
    dataIndex:'limit',
    slots: { customRender: 'limit' },
  },
  {
    title:'状态',
    dataIndex:'status',
    slots: { customRender: 'status' },
  },
  {
    title:'操作',
    dataIndex:'action',
    width:180,
    slots: { customRender: 'action' },
  },
]

export const  appSearchFormSchema:FormSchema[] = [
  {
    field: 'appname',
    label: '应用名称',
    component: 'Input',
    colProps: { span: 8 },
  }
]
export const formSchema:FormSchema[] = [
  {
    field: 'status',
    label: '应用状态',
    component: 'Switch',
    colProps: { span: 8 },
    componentProps: {
      options: [
        { label: '已启用', value: false },
        { label: '已禁用', value: true },
      ],
      checkedChildren:'已启用',
      unCheckedChildren:'已禁用'
    },
  },
  {
    field: 'logo',
    label: '应用logo',
    required: true,
    component: 'Input',
    slot: 'logo',
    colProps: { span: 8 },
  },
  {
    field: 'name',
    label: '应用名称',
    required: true,
    component: 'Input',
    colProps: { span: 8 },
    itemProps: {
      extra: '名称可以由中文、数字以及字母组成，长度在2-20个字符，可修改。点击了解更多《基本信息规范》',
    },
  },
  {
    field: 'desc',
    label: '应用简介',
    component: 'InputTextArea',
    required: true,
    colProps: { span: 8 },
    itemProps: {
      extra: '请煎熬描述应用提供的产品或服务，最多200个字符，可修改。',
    },
  },
  {
    field: 'address',
    label: '应用地址',
    required: true,
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    field: 'isInside',
    label: '内置应用',
    component: 'Switch',
    required: true,
    defaultValue: false,
    itemProps: {
      extra: '当开关处于打开状态，开通租户时该应用默认直接分配给租户',
    },
    componentProps: {
      options: [
        { label: '否', value: false },
        { label: '是', value: true },
      ],
      checkedChildren:'是',
      unCheckedChildren:'否'
    },
  },
  {
    field: 'limit',
    label: '适用范围',
    component: 'RadioGroup',
    required: true,
    itemProps: {
      extra: '适用范围是指使用该应用的用户群体，若该应用面向的用户是个人（ToC应用），则适应范围选择“个人”，若该应用面向的用户是组织/企业/团队（ToB应用），则适应范围选择“组织/企业/团队”，若该应用两者都满足（ToC应用、ToB应用），则全选',
    },
    componentProps: {
      options: [
        { label: '组织/企业/团队', value: 1 },
        { label: '个人', value: 2 },
      ],
    },
  },
]

export const appVersionColumns:BasicColumn[] = [
  {
    title:'版本名称',
    dataIndex:'versionName',
    width:200,
    slots: { customRender: 'versionName' },
  },
  {
    title:'操作',
    dataIndex:'action',
    width:180,
    slots: { customRender: 'action' },
  },
]
export const versionFormSchema:FormSchema[] = [
  {
    field: 'versionName',
    label: '版本名称',
    required: true,
    component: 'Input',
    colProps: { span: 8 },
  },
  {
    field: 'limit',
    label: '适用范围',
    component: 'Select',
    colProps: { span: 8 },
    required: true,
    componentProps: {
      options: [
        {  label: '组织/企业/团队',   value: '1',  },
        {  label: '个人',   value: '2',  },
      ],
    },
  },
  {
    field: 'init',
    label: '初始化',
    component: 'RadioGroup',
    required: true,
    componentProps: {
      options: [
        { label: '是', value: 1 },
        { label: '否', value: 2 },
      ],
    },
    itemProps: {
      extra: '用于授权是是否进行初始化配置',
    },
  },
  {
    field: 'limitKeys',
    label: '',
    slot: 'limitKeys',
    component: 'Input',
  },
]
