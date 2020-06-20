package com.study.shujujiegou.mianshi.cengjishu;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author 贾
 * @Date 2020/5/720:09
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int id;
    String name;
    int parentId;
    int level;

    TreeNode root;

    public TreeNode(Node node,TreeNode left,TreeNode right){
        this.id = node.id;
        this.name = node.name;
        this.parentId = node.parentId;
        this.left = left;
        this.right = right;
        this.level = 0;
    }
    public TreeNode(){
        this.left = null;
        this.right = null;
        this.level = 0;
    }


    public void addNode(Node node){
        if(root==null){
            root = createNode(node);
            return;
        }
        TreeNode newNode = createNode(node);
        TreeNode newNode_parent = getNode(root,newNode);
        newNode.level = newNode_parent.level+1;
        if(Objects.isNull(newNode_parent.left)){
            newNode_parent.left = newNode;
        }else if(Objects.isNull(newNode_parent.right)){
            newNode_parent.right = newNode;
        }else {
            System.err.println("节点已经没有位置！");
        }
    }

    public TreeNode createNode(Node node){
        TreeNode treeNode = new TreeNode(node,null,null);
        return treeNode;
    }

    public TreeNode getNode(TreeNode parent ,TreeNode node){
        if(node == null || parent ==null){
            return null;
        }
        if(parent.id == node.parentId){
            return parent;
        }

        TreeNode N;
        TreeNode P;
        if((N=getNode(parent.left,node))!=null){
            return N;
        }else if ((P=getNode(parent.right,node))!=null){
            return P;
        }else {
            return null;
        }

    }

}
