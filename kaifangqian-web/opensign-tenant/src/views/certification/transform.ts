/*
 * @description 资助审批电子签章系统
 */

export function loadCerStatus(status){
  switch(status){
    case 1:
      return  '有效';
    default:
      return '失效'
  }
}
export function loadCerAlgorithmType(status){
  switch(status){
    case 'RSA':
      return  'RSA';
    case 'SM2':
      return  'SM2';
    default:
      return ''
  }
}
export function loadCerType(status){
  switch(status){
    case 1:
      return  '平台防篡改证书';
    case 2:
      return  '测试数字证书';
    case 3:
      return  'CA事件数字证书';
    case 4:
      return  'CA长效数字证书';
    default:
      return ''
  }
}
