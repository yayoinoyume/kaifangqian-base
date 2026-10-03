/*
 * @description 资助审批电子签章系统
 */

import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import  { getTemplateTypeList } from '/@/api/message';
import dayjs from 'dayjs';

export const messageHistorySearchFormSchema: FormSchema[] = [
    {
      field: 'mesTitle',
      label: '标题',
      component: 'Input',
      colProps: { span: 4 },
      componentProps: {
       
      }
    },
    // {
    //     field: 'templateType',
    //     label: '类型',
    //     component: 'ApiTreeSelect',
    //     colProps: { span: 4 },
    //     componentProps: {
    //         api:getTemplateTypeList,
    //         fieldNames: {
    //             label: 'name',
    //             key: 'id',
    //             value:'id'
    //           },
    //     },
    // },
    {
        field: 'readFlag',
        label: '状态',
        component: 'Select',
        colProps: { span: 4 },
        componentProps:{
          options: [
            {  label: '已读',   value: 1,  },
            {  label: '未读',   value: 0,  },
          ],
        }
    },
    {
      field: '[beginTime, endTime]',
      label: '接收时间',
      component: 'RangePicker',
      componentProps: {
        allowClear:true,
        format: 'YYYY-MM-DD',
        placeholder: ['开始时间', '结束时间'],
      },
      colProps: { span:  6 },
    },
    
   
    
];

  
export const messageHistoryColumns: BasicColumn[] = [
  {
    title: '消息类型',
    dataIndex: 'typeName',
    width: 100,
    slots: { customRender: 'mesTitle' },
  },
  {
    title: '标题',
    dataIndex: 'mesTitle',
    width: 1000,
    slots: { customRender: 'mesTitle' },
  },
  {
    title: '接收时间',
    dataIndex: 'createTime',
    width: 100,
    customRender: ({ record }) => {
      const date = record.createTime;
      return date ? dayjs(date).format('YYYY年M月D日') : '';
    },
  },
];


