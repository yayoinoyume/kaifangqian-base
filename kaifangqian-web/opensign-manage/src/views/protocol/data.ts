/*
 * @description 资助审批电子签章系统
 */

/*
 * @Author: ningw 
 * @Date: 2022-10-25 19:29:57 
 * @Last Modified by: ningw
 * @Last Modified time: 2023-10-25 18:10:01
 */

import { FormSchema } from '/@/components/Table';


export const tinyFormSchema:FormSchema[] =[
  {
    field: 'content',
    label: '内容',
    component: 'Input',
    slot: 'content',
    required:true,
    colProps: { span: 24 },
  },
]