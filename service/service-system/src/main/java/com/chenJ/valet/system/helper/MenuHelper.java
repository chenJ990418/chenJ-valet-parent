package com.chenJ.valet.system.helper;


import com.chenJ.valet.model.entity.system.SysMenuDo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 根据菜单数据构建菜单数据
 * </p>
 */
public class MenuHelper {

    /**
     * 使用递归方法建菜单
     *
     * @param sysMenuList
     * @return
     */
    public static List<SysMenuDo> buildTree(List<SysMenuDo> sysMenuList) {
        List<SysMenuDo> trees = new ArrayList<>();
        for (SysMenuDo sysMenu : sysMenuList) {
            if (sysMenu.getParentId().longValue() == 0) {
                trees.add(findChildren(sysMenu, sysMenuList));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static SysMenuDo findChildren(SysMenuDo sysMenu, List<SysMenuDo> treeNodes) {
        sysMenu.setChildren(new ArrayList<SysMenuDo>());

        for (SysMenuDo it : treeNodes) {
            if (sysMenu.getId().longValue() == it.getParentId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return sysMenu;
    }
}
