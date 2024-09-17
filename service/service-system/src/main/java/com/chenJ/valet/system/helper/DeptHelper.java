package com.chenJ.valet.system.helper;


import com.chenJ.valet.model.entity.system.SysDeptDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 根据权限数据构建菜单数据
 * </p>
 */
public class DeptHelper {

    //把一个List转成树
    public static List<SysDeptDo> buildTree(List<SysDeptDo> list, Long parentId) {
        List<SysDeptDo> tree = new ArrayList<>();
        for (SysDeptDo org : list) {
            if (Objects.equals(org.getParentId(), parentId)) {
                tree.add(findChild(org, list));
            }
        }
        return tree;
    }

    private static SysDeptDo findChild(SysDeptDo org, List<SysDeptDo> list) {
        for (SysDeptDo n : list) {
            if (Objects.equals(n.getParentId(), org.getId())) {
                if (org.getChildren() == null) {
                    org.setChildren(new ArrayList<SysDeptDo>());
                }
                org.getChildren().add(findChild(n, list));
            }
        }
        return org;
    }
}
