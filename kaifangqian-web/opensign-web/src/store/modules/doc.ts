/*
 * @description 资助审批电子签章系统
 */

// import Vuex from 'vuex'
import document from "/@/views/contract/document/data/menu";
import template from "/@/views/contract/template/data/menu";
import users from  "/@/views/contract/users/data/menu";
import storage from '@/utils/storage/SessionStorage'
import {getEmnuActive} from "@/utils/MenuActiveIndex"
import {groupBy} from "@/utils";
// import {getToken,setToken,removeToken} from '@/utils/storage/Cookie' 

export default store;


import { defineStore } from 'pinia';
import { store } from '/@/store';

export const useDocMenu = defineStore({
  id: 'app-doc-menu',
  state: ()=>({
		menuActive:storage.getItem("MenuActive"),
		windowHeight:storage.getItem("windowHeight"),
		leftMenu:[],
		leftButton:[],
		leftFolder:[],
	}),
	getters: {
		getMenuInfo(){
      return this
    }
	},
	actions: {
		setMenuActive(content){
			this.menuActive = content
		},
		setLeftMenu ( content) {
			this.leftMenu = content
		},
		setLeftButton(content) {
			this.leftButton = content
		},
		setLeftFolder(content)  {
			this.leftFolder = content
		},
    commitMenuActive({commit},content) {
			const EmnuActive = getEmnuActive();
			if(content == EmnuActive.document){
        this.setLeftMenu(groupBy(document.menu,"tag"))
        this.setLeftButton(document.button)
        this.setLeftFolder(document.folder)

			}else if(content == EmnuActive.template){

        this.setLeftMenu(groupBy(template.menu,"tag"))
        this.setLeftButton(template.button)
        this.setLeftFolder(template.folder)


			}else if(content == EmnuActive.users){

        this.setLeftMenu(groupBy(users.menu,"tag"))
        this.setLeftButton(users.button)
        this.setLeftFolder([]);

			}else{
				  this.setLeftMenu([])
          this.setLeftButton([])
			}
      this.setMenuActive(content)
		}
		
	},
});

export function useDocMenuWithOut() {
  return useDocMenu(store);
}
