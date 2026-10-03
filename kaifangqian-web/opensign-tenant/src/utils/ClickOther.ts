/*
 * @description 资助审批电子签章系统
 */

/**
 * 点击其他关闭当前显示的内容
 * 
 * addOtherClickEvent
 * 
 * removeOtherClickEvent
 */

export const addOtherClickEvent=(click:any)=>{
	document.addEventListener('click', click);
}
export const removeOtherClickEvent=(click:any)=>{
	document.removeEventListener('click', click);
}

export const htmlNodeFilter=(e:any,className:string):boolean=>{
	var parentNode = e.parentNode;
	if(parentNode && parentNode.localName != 'body'){
		if(parentNode.className  && classNameIncludes(parentNode,className)){
			return true;
		}else{
			return htmlNodeFilter(parentNode,className);
		}
	}else{
		return false;
	}
}
export const test=(e:any):boolean=>{
	 
	var parentNode = e.parentNode;
	console.log(parentNode);
	if(parentNode){
		if(parentNode.className && parentNode.className.includes('this-no-close',0)){
			//closeFlag = false;
			return true;
		}else{
			return test(parentNode);
		}
	}
	return false;
	
}

function classNameIncludes(parentNode,className){
  try{
    return parentNode.className.includes(className,0)
  }catch(e){
    console.log(e);
    return false;
  }
}

export function parentElement(e:any){
	return e.parentNode;
}
