/*
 * @description 资助审批电子签章系统
 */

import type{ReceiveColor} from "./ReceiveColorItem";

const color:Array<ReceiveColor> = [
	{
		primary:"#1F56B8",
		translucent:"#5589E2",
		background:"#ACC5F1",
		backgroundRgb:"172, 197, 241"
	},
	{
		primary:"#F7BA02",
		translucent:"#FEE290",
		background:"#FEE9A9",
		backgroundRgb:"254, 233, 169"
	},
	{
		primary:"#6D858D",
		translucent:"#8FA2A8",
		background:"#B1BEC3",
		backgroundRgb:"177, 190, 195"
	},
	{
		primary:"#5C9E29",
		translucent:"#C2E8A6",
		background:"#A7DE7D",
		backgroundRgb:"167, 222, 125"
	},
	{
		primary:"#C2D402",
		translucent:"#F6FE9F",
		background:"#F1FE6D",
		backgroundRgb:"241, 254, 109"
	},
	{
		primary:"#DB0FC4",
		translucent:"#F570E6",
		background:"#F137DB",
		backgroundRgb:"241, 55, 219"
	},
	{
		primary:"#F74602",
		translucent:"#FE9D77",
		background:"#FD713A",
		backgroundRgb:"253, 113, 58"
	},
	{
		primary:"#15B251",
		translucent:"#56EB8F",
		background:"#1FE56B",
		backgroundRgb:"31, 229, 107"
	},
	{
		primary:"#9D896C",
		translucent:"#CEC4B6",
		background:"#B6A791",
		backgroundRgb:"182, 167, 145"
	},
	{
		primary:"#D0586C",
		translucent:"#EBB7C0",
		background:"#DD8896",
		backgroundRgb:"221, 136, 150"
	},
]
const warningColor = {
	primary:"#FF0000",
	translucent:"#FF4040",
	background:"#FF7373",
	backgroundRgb:"255, 115, 115"
}

export function getColor(index:number,key:string|null){
	if(index == -1){
		return warningColor;
	}else if(index == -2){
		return color[0];
	}
	if(key){
		return color[index][key];
	}
	return color[index];
}