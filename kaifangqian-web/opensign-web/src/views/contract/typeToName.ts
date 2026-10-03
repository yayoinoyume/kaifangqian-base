/*
 * @description 资助审批电子签章系统
 */

export function loadInitiatorSignerType(type){
  switch (type) {
    case 1:
      return '经办人签字';
    case 2:
      return '法人签字';
    case 3:
      return '个人签字';
    case 4:
      return '组织签章';
    case 5:
      return '个人审批';
    default:
      return '';
  }
}

export function loadControlIcon(type){
  switch (type) {
    case 'seal':
      return 'ant-design:node-index-outlined';
    case 'sign-date':
      return 'ant-design:calendar-outlined';
  }
}