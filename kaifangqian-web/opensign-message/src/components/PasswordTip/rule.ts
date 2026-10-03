/*
 * @description 资助审批电子签章系统
 */



export interface RuleItem {
  status:boolean;
  tipText: string;

} 
export const PassRuleProps = {
  RuleList: Array as PropType<RuleItem[]>,
  passwordTipVisible : Boolean,
  password: String,
}