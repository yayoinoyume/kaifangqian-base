/*
 * @description 资助审批电子签章系统
 */

/**
 * useTableDraggable.ts 表格列拖拽
 * @param dataSource table数据集合
 * @returns customRow 行属性方法
 */

 import type { BasicTableProps } from '../types/table';
 import { ComputedRef,unref } from 'vue';

 export function useDrag<T>(
  propsRef: ComputedRef<BasicTableProps>,
  dataSource: Array<T>,
 ){
  let dragItem;
  let targItem;
  const customDrag = (record: T) => {
    const {showDragColumn } = unref(propsRef);
    return {
      draggable: true,
      ondrag(e: DragEvent) {
        dragItem = record
      },
      ondrop(e: DragEvent) {
        targItem = record
      },
      ondragend(e: DragEvent) {
        if(!showDragColumn) return
        if (dragItem.id !== targItem.id) {
          const dragItemIndex = dataSource.indexOf(dragItem);
          const targItemIndex = dataSource.indexOf(targItem);
          // 解构交换
          [dataSource[dragItemIndex], dataSource[targItemIndex]] = [dataSource[targItemIndex], dataSource[dragItemIndex]]
        }
      },
      ondragover(e: DragEvent) {
        return false
      }
    }
  }
 
  return {
    customDrag
  }
}