/*
 * @description 资助审批电子签章系统
 */

export function loadCertificationStatus(status){
  switch(status){
    case 1:
      return '#dff9d9';
    case 2:
      return '#fbe7e5';
    case 3:
      return '#f9f0dd';
    case 4:
      return '#fbe7e5';
    default:
      return '';
  }
}
export function loadCertificationText(status){
  switch(status){
    case 0:
      return '未认证';
    case 1:
      return '审核中';
    case 2:
      return '已认证';
    case -1:
      return '认证失败';
    case 3:
      return '未通过';
    default:
      return '';
  }
}