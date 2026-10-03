/*
 * @description 资助审批电子签章系统
 */

import { MenuModeEnum } from '/@/enums/menuEnum';
import type { Menu as MenuType } from '/@/router/types';
import type { MenuState } from './types';

import { computed, Ref, toRaw } from 'vue';

import { unref } from 'vue';
import { uniq } from 'lodash-es';
import { useMenuSetting } from '/@/hooks/setting/useMenuSetting';
import { getAllParentPath } from '/@/router/helper/menuHelper';
import { useTimeoutFn } from '/@/hooks/core/useTimeout';

export function useOpenKeys(
  menuState: MenuState,
  menus: Ref<MenuType[]>,
  mode: Ref<MenuModeEnum>,
  accordion: Ref<boolean>,
) {
  const { getCollapsed, getIsMixSidebar, getMenuExpandAll} = useMenuSetting();

  async function setOpenKeys(path: string) {
    if (mode.value === MenuModeEnum.HORIZONTAL) {
      return;
    }
    const native = unref(getIsMixSidebar);
    useTimeoutFn(
      () => {
        const menuList = toRaw(menus.value);
        if (menuList?.length === 0) {
          menuState.openKeys = [];
          return;
        }
        if (!unref(accordion)) {
          menuState.openKeys = uniq([...menuState.openKeys, ...getAllParentPath(menuList, path)]);
        } else {
          menuState.openKeys = getAllParentPath(menuList, path);
        }
      },
      16,
      !native,
    );
  }

  const getOpenKeys = computed(() => {
    // const collapse = unref(getIsMixSidebar) ? false : unref(getCollapsed);
    // return collapse ? menuState.collapsedOpenKeys : menuState.openKeys;

    // 只展开一个菜单
    let menuKeys:string[] = [];
    if(getMenuExpandAll){
      menus.value.map(item=>{
        menuKeys.push('submenu-'+item.path);
      })

      return menuKeys
    }
    if(!menuState.openKeys.length){
      return 
    }
    if(menuState.openKeys[menuState.openKeys.length-1].indexOf('submenu-')>-1){
        return  [menuState.openKeys[menuState.openKeys.length-1]];
    }else{
      return [`submenu-${menuState.openKeys[0]}`]
    }
  });
  /**
   * @description:  重置值
   */
  function resetKeys() {
    menuState.selectedKeys = [];
    menuState.openKeys = [];
  }

  function handleOpenChange(openKeys: string[]) {
    // console.log(menuState,openKeys,'锁有keys')
    // let menuKeys:string[] = [];
    // menus.value.map(item=>{
    //   menuKeys.push('submenu-'+item.path);
    // })
    // menuState.openKeys =  menuKeys;
    // return false
    if (unref(mode) === MenuModeEnum.HORIZONTAL || !unref(accordion) || unref(getIsMixSidebar)) {
      menuState.openKeys = openKeys;
    } else {
      // const menuList = toRaw(menus.value);
      // getAllParentPath(menuList, path);
      const rootSubMenuKeys: string[] = [];
      for (const { children, path } of unref(menus)) {
        if (children && children.length > 0) {
          rootSubMenuKeys.push(path);
        }
      }
      if (!unref(getCollapsed)) {
        const latestOpenKey = openKeys.find((key) => menuState.openKeys.indexOf(key) === -1);
        if (rootSubMenuKeys.indexOf(latestOpenKey as string) === -1) {
          menuState.openKeys = openKeys;
        } else {
          menuState.openKeys = latestOpenKey ? [latestOpenKey] : [];
        }
      } else {
        menuState.collapsedOpenKeys = openKeys;
      }
    }
  }
  return { setOpenKeys, resetKeys, getOpenKeys, handleOpenChange };
}
