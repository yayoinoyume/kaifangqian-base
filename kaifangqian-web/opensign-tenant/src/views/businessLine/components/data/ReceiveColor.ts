/*
 * @description 资助审批电子签章系统
 */

import type{ReceiveColor} from "./ReceiveColorItem";

const color:Array<ReceiveColor> = [
	{
		primary:"#1F56B8",
		translucent:"#5589E2",
		background:"#00A0E8",
		backgroundRgb:"0, 160, 232",
		backgroundRgba:"0, 160, 232, 0.2",
	},
	{
		primary:"#F7BA02",
		translucent:"#FEE290",
		background:"#01BAD2",
		backgroundRgb:"1, 186, 210",
		backgroundRgba:"1, 186, 210, 0.2"
	},
	{
		primary:"#6D858D",
		translucent:"#8FA2A8",
		background:"#4d9821",
		backgroundRgb:"77, 152, 33",
		backgroundRgba:"77, 152, 33, 0.2"
	},
	{
		primary:"#5C9E29",
		translucent:"#C2E8A6",
		background:"#E01515",
		backgroundRgb:"224, 21, 21",
		backgroundRgba:"224, 21, 21, 0.2",
	},
	{
		primary:"#C2D402",
		translucent:"#F6FE9F",
		background:"#FF6100",
		backgroundRgb:"255, 97, 0",
		backgroundRgba:"255, 97, 0, 0.2",
	},
	{
		primary:"#DB0FC4",
		translucent:"#F570E6",
		background:"#FAC450",
		backgroundRgb:"250, 196, 80",
		backgroundRgba:"250, 196, 80, 0.2"
	},
	{
		primary:"#F74602",
		translucent:"#FE9D77",
		background:"#005074",
		backgroundRgb:"0, 80, 116",
		backgroundRgba:"0, 80, 116, 0.2",
	},
	{
		primary:"#9D896C",
		translucent:"#CEC4B6",
		background:"#274c11",
		backgroundRgb:"39, 76, 17",
		backgroundRgba:"39, 76, 17, 0.2",
	},
	{
		primary:"#D0586C",
		translucent:"#EBB7C0",
		background:"#700b0b",
		backgroundRgb:"211, 11, 11",
		backgroundRgba:"211, 11, 11, 0.2",
	},
	{
		primary:"#1b29e2",
		translucent:"#EBB7C0",
		background:"#5E30B5",
		backgroundRgb:"94, 48, 181",
		backgroundRgba:"94, 48, 181, 0.2",
	},
	{
		primary:"#5ed772",
		translucent:"#EBB7C0",
		background:"#7d6228",
		backgroundRgb:"125, 98, 40",
		backgroundRgba:"125, 98, 40, 0.2",
    
	}
]
const warningColor = {
	primary:"#FF0000",
	translucent:"#FF4040",
	background:"#FF7373",
	backgroundRgb:"255, 115, 115",
	backgroundRgba:"255, 115, 115, 0.9",
}

export function getColor(index:number,key:string|null){
  if(index==undefined){
    return {}
  }
	if(index == -1){
		return warningColor;
	}else if(index == -2){
		return color[0];
	}
	index = index % color.length;
	if(key){
		return color[index][key];
	}
	return color[index];
}
