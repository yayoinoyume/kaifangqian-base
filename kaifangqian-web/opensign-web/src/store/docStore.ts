/*
 * @description 资助审批电子签章系统
 */

// import Vuex from 'vuex'
import { createStore } from 'vuex'
import document from "/@/views/contract/document/data/menu"
import template from "@/pages/template/data/menu"
import users from "@/pages/users/data/menu"
import storage from '@/utils/storage/SessionStorage'
import {getEmnuActive} from "@/utils/MenuActiveIndex"
import {groupBy,uuid} from "@/utils";
// import {getToken,setToken,removeToken} from '@/utils/storage/Cookie' 

const store = createStore({
	state: {
		menuActive:storage.getItem("MenuActive"),
		windowHeight:storage.getItem("windowHeight"),
		leftMenu:[],
		leftButton:[],
		leftFolder:[],
	},
	getters: {
		
	},
	mutations: {
		setMenuActive: (state, content) => {
			state.menuActive = content
		},
		setLeftMenu: (state, content) => {
			state.leftMenu = content
		},
		setLeftButton: (state, content) => {
			state.leftButton = content
		},
		setLeftFolder: (state, content) => {
			state.leftFolder = content
		},
		
	},
	actions: {
		commitMenuActive({commit},content) {
			const EmnuActive = getEmnuActive();
			if(content == EmnuActive.document){
				// console.log();
				commit('setLeftMenu', groupBy(document.menu,"tag"));
				commit('setLeftButton', document.button);
				commit('setLeftFolder', document.folder);
			}else if(content == EmnuActive.template){
				console.log(template.menu);
				commit('setLeftMenu', groupBy(template.menu,"tag"));
				commit('setLeftButton', template.button);
				commit('setLeftFolder', template.folder);
			}else if(content == EmnuActive.users){
				commit('setLeftMenu', groupBy(users.menu,"tag"));
				commit('setLeftButton', users.button);
				commit('setLeftFolder', []);
			}else{
				commit('setLeftMenu', []);
				commit('setLeftButton', []);
			}
			commit('setMenuActive', content);
		}
	},
	modules: {}
})
export default store;