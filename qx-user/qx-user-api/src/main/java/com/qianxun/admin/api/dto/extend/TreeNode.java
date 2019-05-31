package com.qianxun.admin.api.dto.extend;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/31 15:16
 */
@Data
public class TreeNode {
    protected int id;
    protected int parentId;
    /**
     * 前端渲染名
     */
    protected String label;

    /**
     * 菜单名
     */
    private String name;
    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
