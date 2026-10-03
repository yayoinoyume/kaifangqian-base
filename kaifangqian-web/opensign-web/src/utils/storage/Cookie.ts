/*
 * @description 资助审批电子签章系统
 */


// import Cookies from 'js-cookie'
import VueCookies from 'vue-cookies'
import Config from '@/settings'

const Cookies:any = VueCookies

const TokenKey = Config.TokenKey

export function getToken() {
	return Cookies.get(TokenKey)
}

export function setToken(token:string) {
return Cookies.set(TokenKey, token)
}

export function removeToken() {
	return Cookies.remove(TokenKey)
}

export function eqToken(token:string) {
	if(getToken()){
		return Cookies.get(TokenKey) === token
	}else{
		return false;
	}
	
}