/*
 * @description 资助审批电子签章系统
 */

export function loadCertificationStatus(status){
  switch(status){
    case 0:
      return '#ff9900';
    case 1:
      return '#ed952d';
    case 2:
      return '#19be6b';
    case 3:
      return '#f56c6c';
    default:
      return '#ff9900';
  }
}
export function loadCertificationText(status){
  switch(status){
    case 0:
      return '未认证';
    case 1:
      return '认证审核中';
    case 2:
      return '已认证';
    case 3:
      return '认证审核失败';
    default:
      return '未认证';
  }
}
export function loadCertificationAuthType(status){
  switch(status){
    case 1:
      return '实名认证';
    case 2:
      return '认证变更';
    case 3:
      return '实名认证';
    default:
      return '实名认证';
  }
}
export function loadCertificationRealItemType(status){
  switch(status){
    case 1:
      return '实名认证';
    case 2:
      return '企业名称变更';
    case 3:
      return '企业法人变更';
    case 4:
      return '企业主体变更';
    default:
      return '企业主体变更';
  }
}