/*
 * @description 资助审批电子签章系统
 */

export function loadCertificationStatus(status){
  switch(status){
    case 0:
      return '';
    case 1:
      return 'orange';
    case 2:
      return 'green';
    case 3:
      return 'red';
    default:
      return '';
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
      return '实名认证';
  }
}
export function loadCertificationMixText(record){
  if(record.authStatus==0 || !record.authStatus ){
    return '未认证'
  }else if(record.authStatus == 1 && (record.authType == 1 ||  record.authType == 3) && record.realItem == 1){
    return '认证审核中'
  }else if(record.authStatus == 1 && (record.authType == 1 ||  record.authType == 3) && record.realItem != 1){
    return '变更认证审核中'
  }else if(record.authStatus == 1 && record.authType == 2){
    return '变更认证审核中'
  }else if(record.authStatus == 2 && record.authType == 1){
    return '认证通过'
  }else if(record.authStatus == 2 && record.authType == 2){
    return '变更认证通过'
  }else if(record.authStatus == 2 && record.authType == 3){
    return '认证通过'
  }else if(record.authStatus == 3 && record.authType == 1){
    return '认证审核失败'
  }else if(record.authStatus == 3 && record.authType == 2){
    return '变更审核失败'
  }else if(record.authStatus == 3 && record.authType == 3){
    return '认证审核失败'
  }
}
