/*
 * @description 资助审批电子签章系统
 */

export function loadCertificationStatus(status){
  switch(status){
    case 0:
      return '#ff9900';
    case 1:
      return '#1891ff';
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
      return '审核中';
    case 2:
      return '已认证';
    case 3:
      return '未通过';
    default:
      return '未认证';
  }
}

export function loadCertificationIcon(status){
  switch(status){
    case 0:
      return '@/assets/icons/not-certified.svg';
    case 1:
      return '@/assets/icons/not-certified.svg';
    case 2:
      return '@/assets/icons/certified.svg';
    case 3:
      return '@/assets/icons/not-certified.svg';
    default:
      return '@/assets/icons/not-certified.svg';
  }
}