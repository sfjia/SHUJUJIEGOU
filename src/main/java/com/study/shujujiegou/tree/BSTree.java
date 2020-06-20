package com.study.shujujiegou.tree;

import javax.lang.model.SourceVersion;
import javax.sound.midi.MidiChannel;

/**
 * @Author 贾
 * @Date 2020/4/2320:24
 *
 *  二叉搜索树【链表结构】：
 */
public class BSTree {

    private BSNode root;


    //删除一个元素
    public void delete(int value){

        //要删除的节点
        BSNode p = root;
        //要删除的父节点
        BSNode p_parent = null;

        //找到要删除的元素及元素
        while (p != null){
            if(p.value > value){
                p_parent = p;
                p = p.left;
            }else if(p.value < value){
                p_parent = p;
                p = p.right;
            }else {
                break;
            }
        }

        if(p==null){
            return;
        }

        // 删除元素

        if(p.left != null && p.right != null){
            // 有两个子节点
            BSNode right = p.right;
            BSNode right_parent = p; //父节点
            //查找右子树的最小值
            while (right.left != null){
                right_parent = right;
                right = right.left;
            }
            //右子树的最小节点 替换 要删除的节点
            p.value = right.value;
            p =right;
            p_parent = right_parent;

        }

        BSNode child = null;
        if(p.right != null){
            child = p.right;
        }else if (p.left != null){
            child =p.left;
        }else {
            child = null;
        }

        // 执行删除操作
        if(p_parent ==null){
            root = null;
        }else if(p_parent.left == p){
            p_parent.left = child;
        }else {
            p_parent.right = child;
        }

    }




    // 查找
    public BSNode get(int value){
        BSNode parent = root;

       while (parent != null){
           //值 大于 父节点
           if(parent.value > value){
               // 往左子树 查
               parent = parent.left;
           }else if(parent.value < value) {//值 小于 父节点
               // 往左子树 查
               parent = parent.right;
           }else {
               return parent;
           }
       }
        return null;
    }

    //插入一个数
    public boolean put(int value){
        //插入的是一颗空树！
        if(root==null){
            root = createNode(value);
            return true;
        }
        BSNode pt = root;
        while (pt!=null){
            //要插入的值 小于 父节点的值
            if(pt.value>value){
                // 在左边 往左子树上插入
                if(pt.left ==null){
                    pt.left = createNode(value);
                    return true;
                }else{// 左子树不为null
                    pt = pt.left;
                }
            }else if(pt.value < value){ //要插入的值 大于 父节点的值
                // 在左边 往左子树上插入
                if(pt.right ==null){
                    pt.right = createNode(value);
                    return true;
                }else{// 左子树不为null
                    pt = pt.right;
                }
            }
        }
        return false;
    }

    //构造一个没有左右孩子的树节点
    private BSNode createNode(int value){
        return new BSNode(null,value,null);
    }
    //构造一个有左右孩子的树节点
    private BSNode createNode(BSNode left,int value,BSNode right){
        return new BSNode(left,value,right);
    }

   private static class BSNode{
       //值
        private int value;

        //左孩子
        private BSNode left;
        //右孩子
        private BSNode right;

        protected BSNode(BSNode left, int value , BSNode right){
            this.left=left;
            this.right=right;
            this.value=value;
        }

       protected BSNode(){
       }

       public int getValue() {
           return value;
       }

       public void setValue(int value) {
           this.value = value;
       }

       public BSNode getLeft() {
           return left;
       }

       public void setLeft(BSNode left) {
           this.left = left;
       }

       public BSNode getRight() {
           return right;
       }

       public void setRight(BSNode right) {
           this.right = right;
       }
   }

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(35);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(25);
        bsTree.put(40);
        bsTree.put(10);
        bsTree.put(20);
        bsTree.put(27);
        bsTree.put(38);
        bsTree.put(41);
        bsTree.put(26);
        bsTree.put(30);
        bsTree.put(39);

        System.out.println("bsTree = " + bsTree);

        bsTree.delete(25);

        System.out.println("bsTree = " + bsTree);
    }
}
