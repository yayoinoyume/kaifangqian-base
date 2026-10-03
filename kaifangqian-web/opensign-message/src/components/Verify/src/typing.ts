/*
 * @description 资助审批电子签章系统
 */

export interface DragVerifyActionType {
  resume: () => void;
}

export interface PassingData {
  isPassing: boolean;
  time: number;
}

export interface MoveData {
  event: MouseEvent | TouchEvent;
  moveDistance: number;
  moveX: number;
}
