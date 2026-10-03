/*
 * @description 资助审批电子签章系统
 */


import {CanvasZoom} from "./ControlData";
import {bubbleSort,uuid} from "/@/utils"
import {retainDecimals} from "/@/utils"

/**
 * 子控件移动范围判断
 * @param {any} opt 
 * @param {any} targets 
 * @return 
 */ 
export function currentMoveRange(opt:any,targets:any){
  console.log("sub item move：",opt);
  // debugger;
  // currentPage
  const target = targets.find(item=>item.page == opt.currentPage);
  //计算控件所在页码
  // const page = currentPage(opt);
  const startHeight = target.transformHeight + CanvasZoom.space * (opt.currentPage+1);
  const endHeight = startHeight + target.height;
  
  const minX = retainDecimals((opt.maxWidth - target.width) / 2);
  const maxX = retainDecimals(opt.maxWidth - ((opt.maxWidth - target.width )/ 2));
  
  console.log("范围：",minX,maxX,startHeight,endHeight);
  //判断坐标是否移出文档的范围
  if(opt.x < minX){
  	opt.x = minX;
  }else if(opt.x>maxX - opt.size.width){
  	opt.x = maxX - opt.size.width;
  }
  
  if(opt.y < startHeight){
  	opt.y = startHeight;
  }else if(opt.y > endHeight - opt.size.height){
  	opt.y = endHeight - opt.size.height;
  }
  
  console.log("result:",opt);
  
}

/**
 * 主控件移动范围判断
 * @param {any} opt 
 * @param {any} targets 
 * @return 
 */ 
export function moveRange(opt:any,targets:any){
  const originxy = {
    x:opt.x,
    y:opt.y
  }
  // debugger;
  const allHeight = opt.allHeight;
	//计算控件所在的页码
  currentPage(opt,targets);
  //计算控件可移动的范围
  calculateOffset(opt,allHeight);
  
  //计算控件是否骑在两页中间
	isControlPage(opt,targets);
  console.log("moveRange",opt);
}

function calculateOffset(opt:any,allHeight:number){
  const minX = retainDecimals((opt.maxWidth - opt.width) / 2);
  const maxX = retainDecimals(opt.maxWidth - ((opt.maxWidth - opt.width )/ 2));
  
  //判断坐标是否移出文档的范围
  if(opt.x < minX){
  	opt.x = minX;
  }else if(opt.x>maxX - opt.size.width){
  	opt.x = maxX - opt.size.width;
  }
  if(opt.y<CanvasZoom.space){
  	opt.y = CanvasZoom.space;
  }else if(opt.y>allHeight - opt.size.height){
  	opt.y = allHeight - opt.size.height;
  }
}
//计算控件所在每页的位置
export function currentPosition(top:number,target:any){
	// return top - (pageSize + 1) * CanvasZoom.space - pageSize * CanvasZoom.height;
  return top - target.transformHeight - (target.page + 1) * CanvasZoom.space
}
//将每页的位置转换成为一大页的位置
export function currentPositionReverse (top:number,target:any){
	return parseInt(top) + (target.page + 1) * CanvasZoom.space + target.transformHeight;
}


export function currentPage(opt:any,targets:any){
	var searchFlag = false;
  //处理在可见区域内的
  for(var i =0;i<opt.pageSize;i++){
    var start = i * CanvasZoom.space + targets[i].transformHeight;
    var end = start + targets[i].height + CanvasZoom.space;
    console.log("在中间",start,end);
    if(opt.y>=start && opt.y<= end){
    	opt.currentPage = i;
      opt.height = targets[i].height;
      opt.width = targets[i].width;
      opt.transformHeight = targets[i].transformHeight
      searchFlag = true;
    }
  }  
  //处理在非可见区域外的位置
  if(!searchFlag){
    if(opt.y < CanvasZoom.space){
      opt.currentPage = 0;
      opt.height = targets[0].height;
      opt.width = targets[0].width;
      opt.transformHeight = targets[0].transformHeight
    }else{
      opt.currentPage = targets.length-1;
      opt.height = targets[targets.length - 1].height;
      opt.width = targets[targets.length - 1].width;
      opt.transformHeight = targets[targets.length - 1].transformHeight
    }
  }
}


//判断控件是否再边界上
function isControlPage(opt:any,allHeight:number){
	//var temHeight = 0;
  var recalculate = false;
  // debugger;
	var start = opt.currentPage * CanvasZoom.space + opt.transformHeight;
	var end = start + opt.height + CanvasZoom.space;
  
  const startHeight = opt.transformHeight + CanvasZoom.space * (opt.currentPage+1);
  const endHeight = startHeight + opt.height;
  
  const minX = retainDecimals((opt.maxWidth - opt.width) / 2);
  const maxX = retainDecimals(opt.maxWidth - ((opt.maxWidth - opt.width )/ 2));
  
	var top = opt.y;
	console.log("scope:",start,end,minX,maxX,opt);
	
	if(top>start && top< end){
    // if(top > start - CanvasZoom.space){
    //   opt.y = start + CanvasZoom.space;
    // }
    if(opt.y < startHeight){
    	opt.y = startHeight;
    }else if(opt.y > endHeight - opt.size.height){
    	opt.y = endHeight - opt.size.height;
    }
    
    if(opt.width < opt.size.width){
    	opt.size.width = opt.width ;
    }
    if(opt.height < opt.size.height){
    	opt.size.height = opt.height;
      opt.y = startHeight;
    }
    
		return;
	}
	if(top>allHeight){
		opt.y = allHeight - opt.size.height ;
		return;
	}
	
	var outSize = top - end;
	
	// if(outSize>opt.size.height/2){
		// opt.currentPage += 1;
		// opt.y = end + CanvasZoom.space;
    // recalculate = true;
	// }else{
	// 	opt.y = end - opt.size.height;
	// }
	console.log("超出：",outSize);
  return recalculate;
}


export function getMoveScoped(element:any){
    var xs:Array<any> = [];
    var ys:Array<any> = [];
    element.widgetList.forEach((sub)=>{
      xs.push(sub.x);
      ys.push(sub.y);
    })
    bubbleSort(xs);
    bubbleSort(ys);
    const minX2 = xs.length == 1?xs[0]:xs[1];
    const maxX2 = xs.length == 1 || xs.length == 2?xs[0]:xs[xs.length-2];
    
    const minY2 = ys.length == 1?ys[0]: ys[1];
    const maxY2 = ys.length == 1 || ys.length == 2?ys[0]:ys[ys.length-2];
    
    return {
      minX:xs[0],
      minX2:minX2,
      maxX: xs[xs.length-1],
      maxX2: maxX2,
      minY:ys[0],
      maxY:ys[ys.length-1],
      minY2:minY2,
      maxY2:maxY2
    }
  }
  
