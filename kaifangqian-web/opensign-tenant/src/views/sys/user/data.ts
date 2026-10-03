/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-06-21 18:39:26 
 * @Last Modified by: ningw
 * @Last Modified time: 2022-10-20 17:46:38
 */
import { FormSchema } from '/@/components/Table';
import { BasicColumn } from '/@/components/Table';



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