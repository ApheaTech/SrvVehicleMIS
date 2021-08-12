package com.ctis.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 方法一：
        1. 建立所有节点
        2. 遍历所有节点
            2.1 找到父节点后，把自己挂载过去
    方法二：
        1. 建立所有节点
        2. 找到没有父id的节点
        3. 找父id为2中的的节点，并把自己挂载过去
        4. 依次
    想要的结果：
        orgID: xxx
        childList: [{
            orgID: xxx
            childList: [{
                orgID: xxx
                childList: null
            }]
        }, {
             orgID: xxx
             childList: [{
                 orgID: xxx
                 childList: null
             }]
        }, {
             orgID: xxx
             childList: [{
                 orgID: xxx
                 childList: null
             }]
        }]

 {
    orgID: 534c1325d82a4a27848644d12e0295bb
    childList: [{
        orgID: 3ad9557b609a93b64426b2a4d8d45576
        childList: [{
            orgID: 9985d57d56884e7eb208f1f9adf13623
            childList: []
        }]
    }, {
        orgID: b0cfff76ea5f4f96a1b6430b8a389f8d
        childList: []
    }, {
        orgID: ab188a69f3e541038b73622cf401b2d8
        childList: []
    }, {
        orgID: 96dd8111d0694a8d8d128cc30f94d08b
        childList: [{
            orgID: a377b8cb863d45079362b62481bd4f56
            childList: []
        }, {
            orgID: ae9a8670439c409d8831a525c6722478
            childList: []
        }
    ]}, {
        orgID: 5aa1387c004f45f095d0eb493a15785d
        childList: [{
            orgID: fb471c394bee4ea79c939d4cc3809cc7
            childList: []
        }]
    }]
 }
*/

@Data
@NoArgsConstructor
public class TreeNode {

    private String ID;
    private String fatherID;
    private String label;
    private List<TreeNode> child = new ArrayList<>();

    public TreeNode(String ID, String fatherID, String fullName) {

        this.ID = ID;
        this.fatherID = fatherID;
        this.label = fullName;
    }

    public void addTreeNode(TreeNode t) {

        this.child.add(t);
    }

    public static TreeNode buildTree(HashMap<String, List> origin) {

        // 建造节点集合
        HashMap<String, TreeNode> nodes = new HashMap<>();
        for (Map.Entry<String, List> item : origin.entrySet()) {
            String ID = item.getKey();
            String fatherID = (String) item.getValue().get(0);
            String fullName = (String) item.getValue().get(1);
            nodes.put(ID, new TreeNode(ID, fatherID, fullName));
        }

        // 建造树
        TreeNode tree = new TreeNode();
        for (Map.Entry<String, TreeNode> node : nodes.entrySet()) {
            TreeNode currentNode = node.getValue();
            if (currentNode.getFatherID().equals("0") || currentNode.getFatherID().isEmpty()) {
                tree = currentNode;
            }else {
                nodes.get(currentNode.getFatherID()).addTreeNode(currentNode);
            }
        }
        System.out.println(tree);

        return tree;
    }
}
