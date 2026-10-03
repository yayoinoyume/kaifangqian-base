/*
 * @description 资助审批电子签章系统
 */

import { revokeRuSignRu, restoreRu, deleteSignRu, deleteCompleteRu} from '/@/api/contract';
import { useMessage } from '/@/hooks/web/useMessage';
import { getCurrentInstance} from "vue";
import eventHub from '/@/utils/eventHub';
import { Router } from 'vue-router';

// 定义 Action 接口
export interface Action {
  key: string;
  name: string;
  callback: (params: any, router?: Router) => void;
  params: any;
}

const { createMessage: msg, createConfirm} = useMessage();
let requestFun,requestParams,setTable,setPage,setLoad

export function revoke(params) {
  // const instance = getCurrentInstance();
  // const { eventHub } = instance?.proxy;
  console.log("revoke")
  eventHub.emit('triggerConfirm',params)
  return
  
  // let result = await revokeRuSignRu({signRuId:params.signRuId});
  // if(result){
  //   msg.success('操作成功')
  //   setLoad(true)
  //   let reloadResult = await requestFun(requestParams);
  //   if(reloadResult){
  //     setTable(reloadResult);
  //     // setPage({total:reloadResult.total})
  //   }
  //   setLoad(false)
  // }
}
export function testRevoke(params){
  console.log("testRevoke",params);
}
export  function send(params) {

}
export  async function deleteRow(params) {

  createConfirm({
    title: '', 
    content: '确定删除该记录？',
    iconType: 'warning',
    cancelText:'取消',
    onCancel() {
      console.log('Cancel');
    },
    onOk:async function  () {
      let result = await deleteSignRu({signRuId:params.signRuId});
      if(result){
        msg.success('操作成功')
        setLoad(true)
        let reloadResult = await requestFun(requestParams);
        if(reloadResult){
          setTable(reloadResult);
          // setPage({total:reloadResult.total})
        }
        setLoad(false)
      }
    },
  })
  

}

export function deleteComplete(params){
  createConfirm({
    title: '温馨提示', 
    content: `${'您是否确定执行彻底删除操作 ? 执行后数据将无法恢复!'}`,
    okText:'确定',
    cancelText:'取消',
    iconType: 'warning',
    onCancel() {
      console.log('Cancel');
    },
    onOk:async function  () {
      let result = await deleteCompleteRu({signRuId:params.signRuId});
      if(result){
        msg.success('操作成功')
        setLoad(true)
        let reloadResult = await requestFun(requestParams);
        if(reloadResult){
          setTable(reloadResult);
          // setPage({total:reloadResult.total})
        }
        setLoad(false)
      }
    },
  })
}
export  function editRow(params,router) {
  router.push({
    path:"/contract/start",
    query:{
      __full__:"",
      signRuId:params.signRuId
    }
  })
}
export  async function recover(params) {
  let result = await restoreRu({signRuId:params.signRuId});
  if(result){
    setLoad(true)
    msg.success('操作成功')
    let reloadResult = await requestFun(requestParams);
    if(reloadResult){
      setTable(reloadResult);
    }
    setLoad(false)
  }
}
export  function write(params,router) {
  router.push({
    path:"/contract/params",
    query:{
      __full__:"",
      signRuId:params.signRuId,
      taskId:params.result.taskId,
      type:params.result.startFlag?'':'receive',
      from:'list'
    }
  })
  
} 
export function sign (params,router) {
  router.push({
    path:"/contract/sign",
    query:{
      __full__:"",
      signRuId:params.signRuId,
      taskId:params.result.taskId,
      from:'list'
    }
  })
}
export function approval (params,router) {
  router.push({
    path:"/contract/approval",
    query:{
      __full__:"",
      signRuId:params.signRuId,
      taskId:params.result.taskId,
      from:'list'
    }
  })
}

export const actions: Action[] = [
  {
    key:'revoke',
    name:'撤回',
    callback:revoke,
    params:{}
  },
  {
    key:'send',
    name:'发送',
    callback:send,
    params:{}
  },
  {
    key:'edit',
    name:'编辑',
    callback:editRow,
    params:{}
  },
  {
    key:'recover',
    name:'恢复',
    callback:recover,
    params:{}
  },
  {
    key:'write',
    name:'填写',
    callback:write,
    params:{}
  },
  {
    key:'sign',
    name:'签署',
    callback:sign,
    params:{}
  },
  {
    key:'approval',
    name:'审批',
    callback:approval,
    params:{}
  },
  {
    key:'delete',
    name:'删除',
    callback:deleteRow,
    params:{}
  },
  {
    key:'deleteComplete',
    name:'彻底删除',
    callback:deleteComplete,
    params:{}
  },
]


export function mapActions(keys): Action[] {
  let acts: Action[] = []
  keys.forEach(v=>{
    actions.map(m=>{
      if(m.key==v){
        acts.push(m)
      }
    })
  })
  return acts;
}

export function formatAction (row,result): Action[] {
  //整合参数
  actions.map(m=>{
    m.params = {
      ...row,
      ...result
    }
  })
  let actionResult: Action[] = [];
  //发起审批中
  if(row.status==1){
    actionResult = mapActions(['edit','delete'])
  }
  //发起审批中
  if(row.status==2){
    actionResult = mapActions(['revoke'])
  }
  //发起审批不通过
  if(row.status==3){
    actionResult = mapActions(['edit','delete'])
  }
  //已删除
  if(row.status==4){
    actionResult = mapActions(['recover','deleteComplete']);
  }
  //发起审批不通过
  if(row.status==5){
    if(result.startFlag){
      if(result.taskId){
        actionResult = mapActions(['write']);
      }else{
        actionResult = mapActions(['revoke']);
      } 
    }else{
      if(result.taskId){
        actionResult = mapActions(['write']);
      }else{
        actionResult = mapActions([]);
      }
    }
  }
  //已拒填
  if(row.status==6){
    actionResult = []
  }
  //签署中
  if(row.status==7){
    if(result.startFlag){
      if(result.taskId && result.taskType == 'sign_task'){
        actionResult = mapActions(['sign','revoke']);
      }else if(result.taskId && result.taskType == 'approve_task'){
        actionResult = mapActions(['approval','revoke']);
      }else{
        actionResult = mapActions(['revoke']);
      }
    }else{
      if(result.taskId && result.taskType == 'sign_task'){
        actionResult = mapActions(['sign']);
      }else if(result.taskId && result.taskType == 'approve_task'){
        actionResult = mapActions(['approval']);
      }else{
        actionResult = mapActions([]);
      }
    }
  }
  //已拒签
  if(row.status==8){
    actionResult = []
  }
  //已失效
  if(row.status==9){
    actionResult = []
  }
  //已撤回
  if(row.status==10){
    if(result.startFlag){
      //actionResult = mapActions(['delete']);
    }
  }
  return actionResult
}

export function tableReload(reloadCallback,params,setTableData,setPagination, setLoading){
  requestFun = reloadCallback;
  requestParams = params;
  setTable = setTableData;
  setPage = setPagination;
  setLoad = setLoading;
}
