/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-21 18:39:26 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-10-17 10:45:11
 */
import { FormSchema } from '/@/components/Table';
import { BasicColumn } from '/@/components/Table';
import { getDictItemsByFixedId } from '/@/api/dict';



export const passwordSchema: FormSchema[] = [
  {
    field: 'phone',
    label: '绑定手机:',
    component: 'Input',
    required:true,
    colProps: { span:24 },
    componentProps: {}
  },
  {
    field: 'sms',
    label: '手机验证码:',
    component: 'Input',
    required:true,
    slot:'smsInput',
    colProps: { span:24 },
    componentProps: {},
  }
]
export const signPasswordSchema: FormSchema[] = [
  {
    field: 'phone',
    label: '手机号或邮箱:',
    component: 'Select',
    required:true,
    colProps: { span:24 },
    componentProps: {}
  },
  {
    field: 'password',
    label: '新密码:',
    component: 'Input',
    required:true,
    slot:'password',
    colProps: { span:24 },
    componentProps: {},
  },
  {
    field: 'sms',
    label: '确认密码:',
    component: 'Input',
    required:true,
    slot:'smsInput',
    colProps: { span:24 },
    componentProps: {},
  },
]

export const authColumns: BasicColumn[] =  [
  {
    title:'权限组名',
    dataIndex:'groupName'
  },
  {
    title:'类型',
    dataIndex:'type',
    slots: { customRender: 'type' }
  },
  {
    title:'名称',
    dataIndex:'name',
    slots: { customRender: 'name' }
  },
]

export const personalSchema: FormSchema[] = [
  {
    field: 'idPic1',
    label: '身份证正面:',
    component: 'Input',
    slot:'idPic1',
    required:true,
    colProps: { span:12 },
    componentProps: {}
  },
  {
    field: 'idPic2',
    label: '身份证反面:',
    component: 'Input',
    slot:'idPic2',
    required:true,
    colProps: { span:12 },
    componentProps: {}
  },
  {
    field: 'tenantName',
    label: '姓名:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
  {
    field: 'phone',
    label: '联系方式:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
  {
    field: 'organizationNo',
    label: '证件号:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
  {
    field: 'ProvinceCityDistrict',
    label: '省市区',
    component: 'ApiCascader',
    required:true,
    show:true,
    slot:'ProvinceCityDistrict',
    colProps: { span: 12 },
    componentProps:{
      initFetchParams: {
        parentId:'100000',
        pageSize:100
      },
      maxTagCount:2,
      asyncFetchParamKey:'parentId',
      labelField:'itemText',
      isLoadData:true,
      showSearch:true,
      valueField:'id',
      api: getDictItemsByFixedId,
      resultField: 'records',
      isLeaf: (record) => {
        return record.childCount == 0;
      },
    },
  },
  {
    field: 'organizationAddress',
    label: '详细地址:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
  {
    field: 'lifespanType',
    label: '证件有效期:',
    component: 'Input',
    slot:'lifespanType',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  }
]

export const enterpriseSchema: FormSchema[] = [
  {
    field: 'organizationPic',
    label: '上传证件:',
    component: 'Input',
    slot:'organizationPic',
    required:true,
    colProps: { span:24 },
    componentProps: {}
  },
  {
    field: 'tenantName',
    label: '机构名称:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {}
  },
  {
    field: 'corporation',
    label: '法定代表人:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {}
  },
  {
    field: 'organizationNo',
    label: '机构代码:',
    component: 'Input',
    required:false,
    colProps: { span:12 },
    componentProps: {}
  },
  {
    field: 'ProvinceCityDistrict',
    label: '省市区',
    component: 'ApiCascader',
    required:true,
    show:true,
    colProps: { span: 12 },
    componentProps:{
      initFetchParams: {
        parentId:'100000',
        pageSize:100
      },
      maxTagCount:2,
      asyncFetchParamKey:'parentId',
      labelField:'itemText',
      isLoadData:true,
      showSearch:true,
      valueField:'id',
      api: getDictItemsByFixedId,
      resultField: 'records',
      isLeaf: (record) => {
        return record.childCount == 0;
      },
    },
  },
  {
    field: 'organizationAddress',
    label: '详细地址:',
    component: 'Input',
    required:true,
    colProps: { span:24 },
    componentProps: {},
  },
  {
    field: 'lifespanType',
    label: '证件有效期:',
    component: 'Input',
    slot:'lifespanType',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
  {
    field: 'phone',
    label: '联系方式:',
    component: 'Input',
    required:true,
    colProps: { span:12 },
    componentProps: {},
  },
]