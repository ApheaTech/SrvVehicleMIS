package com.ctis.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private String ID;
    private String name;
    private List<TreeNode> childList = new ArrayList<TreeNode>();

    public TreeNode(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    //增加子结点
    public void addTreeNode(TreeNode t){
        childList.add(t);
    }

    //返回ID指定ID的节点
    public TreeNode getTreeNodeByID(TreeNode t, String ID){
        if (t.ID == ID){//当前节点ID相等，则返回当前节点
            return t;
        }else {//否则，遍历子节点
            if (!t.childList.isEmpty()){//不为空
                for (TreeNode child:
                        t.getChildList()) {
                    TreeNode resNode =  getTreeNodeByID(child, ID);
                    if (resNode.getID() == null){
                        continue;
                    }else{
                        return resNode;
                    }
                }
            }

            return new TreeNode(null, null);//此深度路线未查找到，返回特殊节点
        }
    }
}
