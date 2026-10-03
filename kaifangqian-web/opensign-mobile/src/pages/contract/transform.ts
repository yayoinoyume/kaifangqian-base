/**
 * @description : 状态转换
 */
export function loadRuStatus(status:number){
  switch(status){
    case 1:
      return '草稿';
    case 2:
      return '发起审批中';
    case 3:
      return '发起审批不通过';
    case 4:
      return '已删除';
    case 5:
      return '填写中';
    case 6:
      return '已拒填';
    case 7:
      return '签署中';
    case 8:
      return '已拒签';
    case 9:
      return '已失效';
    case 10:
      return '已撤回';
    case 11:
      return '已完成';
    case 12:
      return '已发起';
    default:
      return '';
  }
}
export function loadWriteStatus(status:number){
  switch(status){
    case 0:
      return '无需填写';
    case 1:
      return '未填写';
    case 2:
      return '待填写';
    case 3:
      return '已填写';
    case 4:
      return '已拒填';
    default:
        return '';
    
  }
}
export function loadSignColor(status:number){
  switch(status){
    case 0:
      return '#726464';
    case 1:
      return '#726464';
    case 2:
      return '#b55f0a';
    case 3:
      return '#7ab140';
    case 4:
      return '#eb620f';
    default:
        return '#108ee9';
    
  }
}

export function loadSignStatus(status:number){
  switch(status){
    case 0:
      return '无需签署';
    case 1:
      return '未签署';
    case 2:
      return '待签署';
    case 3:
      return '已签署';
    case 4:
      return '已拒签';
    default:
        return '';
    
  }
}
