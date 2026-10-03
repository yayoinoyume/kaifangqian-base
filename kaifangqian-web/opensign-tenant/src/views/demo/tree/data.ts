/*
 * @description 资助审批电子签章系统
 */

import { TreeItem } from '/@/components/Tree/index';

export const treeData: TreeItem[] = [
  {
    title: '运维 ',
    name: '运维 ',
    key: '0-0',
    icon:'ion:home',
    type:'user',
    children: [
      { title: 'leaf', key: '0-0-0' },
      {
        title: 'leaf',
        key: '0-0-1',
        children: [
          { title: 'leaf', key: '0-0-0-0', children: [{ title: 'leaf', key: '0-0-0-0-1' }] },
          { title: 'leaf', key: '0-0-0-1' },
        ],
      },
    ],
  },
  {
    title: '运维2 ',
    name: '运维2 ',
    key: '0-9',
    icon:'ion:home',
    type:'user',
    children: [
      { title: 'leaf', key: '0-9-0' },
      {
        title: 'leaf',
        key: '0-9-1',
        children: [
          { title: 'leaf', key: '0-9-0-0', children: [{ title: 'leaf', key: '0-9-0-0-1' }] },
          { title: 'leaf', key: '0-9-0-1' },
        ],
      },
    ],
  },
  {
    title: '运维3 ',
    name: '运维3 ',
    key: '0-8',
    icon:'ant-design:api-filled',
    type:'dept',
    children: [
      { title: 'leaf', key: '0-8-0' },
      {
        title: 'leaf',
        key: '0-8-1',
        children: [
          { title: 'leaf', key: '0-8-0-0', children: [{ title: 'leaf', key: '0-8-0-0-1' }] },
          { title: 'leaf', key: '0-8-0-1' },
        ],
      },
    ],
  },
  {
    title: '后端',
    key: '1-1',
    icon:'ant-design:folder-open-filled',
    children: [
      { title: 'leaf', key: '1-1-0' },
      { title: 'leaf', key: '1-1-1' },
    ],
  },
  {
    title: '前端',
    key: '2-2',
    children: [
      { title: 'leaf', key: '2-2-0' },
      { title: 'leaf', key: '2-2-1' },
    ],
  },
];

export const treeData2: any[] = [
  {
    name: 'parent ',
    id: '0-0',

    children: [
      { name: 'leaf', id: '0-0-0' },
      {
        name: 'leaf',
        id: '0-0-1',

        children: [
          {
            name: 'leaf',

            id: '0-0-0-0',
            children: [{ name: 'leaf', id: '0-0-0-0-1' }],
          },
          { name: 'leaf', id: '0-0-0-1' },
        ],
      },
    ],
  },
  {
    name: 'parent 2',
    id: '1-1',

    children: [
      { name: 'leaf', id: '1-1-0' },
      { name: 'leaf', id: '1-1-1' },
    ],
  },
  {
    name: 'parent 3',
    id: '2-2',

    children: [
      { name: 'leaf', id: '2-2-0' },
      { name: 'leaf', id: '2-2-1' },
    ],
  },
];

export const treeData3: any[] = [
  {
    name: 'parent ',
    key: '0-0',
    children: [
      { name: 'leaf', key: '0-0-0' },
      {
        name: 'leaf',
        key: '0-0-1',
        children: [
          {
            name: 'leaf',
            key: '0-0-0-0',
            children: [{ name: 'leaf', key: '0-0-0-0-1' }],
          },
          { name: 'leaf', key: '0-0-0-1' },
        ],
      },
    ],
  },
  {
    name: 'parent 2',
    key: '1-1',

    children: [
      { name: 'leaf', key: '1-1-0' },
      { name: 'leaf', key: '1-1-1' },
    ],
  },
  {
    name: 'parent 3',
    key: '2-2',

    children: [
      { name: 'leaf', key: '2-2-0' },
      { name: 'leaf', key: '2-2-1' },
    ],
  },
];
