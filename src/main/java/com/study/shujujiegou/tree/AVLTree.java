package com.study.shujujiegou.tree;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @Author 贾
 * @Date 2020/4/2420:52
 *
 *  平衡二叉树：
 *  1.性质：
 *      1，可以使空树
 *      2.如果不是空树，任何一个节点的左子树与右子树都是平衡二叉树，并且高度之差的绝对值不超过 1
 *  2.平衡二叉树的失衡问题及调整方法：
 *      1.在节点的左子树的左子树插入元素， LL旋转
 *      2.在节点的左子树的右子树插入元素， LR元素
 *      3.在节点的右子树的左节点插入元素， RL元素
 *      4.在节点的右子树的右节点插入元素， RR元素
 */
public class AVLTree<T extends Comparable> {
    
    //平衡二叉树的根节点
    private AVLNode root;
    
    /**
     * 某个节点的高度
     */
    private int height(AVLNode node){
        return  node == null? 0 : node.height;
    }

    /**
     * 树的高度
     * @return
     */
    private int height(){
        return this.height(root);
    }

    /**
     * 计算两个高度的最大值
     * 
     */
    private int getMax(int h1,int h2){
        return h1 > h2 ? h1:h2;
    }

    /**
     * 采用中序遍历
     */
    public void inOrder(AVLNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println("node.getData() = " + node.getData());
        inOrder(node.right);
    }

    /**
     * 前序遍历
     */
    public void beforeOrder(AVLNode node){
        if(node == null){
            return;
        }
        System.out.println("node.getData() = " + node.getData());
        inOrder(node.left);
        inOrder(node.right);
    }
    /**
     * 后序遍历
     */
    public void afterOrder(AVLNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println("node.getData() = " + node.getData());
    }
    @Override
    public String toString() {
        inOrder(root);
        return "";
    }

    /**
     * LL 旋转
     * 
     * @param node 失衡
     * @return 左旋后的根节点
     */
    public AVLNode LL(AVLNode node){
        // 定义一个临时变量保存我们失衡节点的左子树
        AVLNode node_left = node.left;
        //将我们失衡节点左子树的右子树作为失衡节点的左子树
        node.left = node_left.right;
        //将失衡节点作为根节点的一个右子树
        node_left.right=node;
        //重新计算失衡节点和旋转后根节点的高度
        node.height=getMax(height(node_left),height(node.right))+1;
        node_left.height=getMax(height(node_left.left),height(node_left.right))+1;
        return node_left;
    }

    /**
     * RR 旋转
     * @param node 失衡节点
     * @return 右旋后的根节点
     */
    public AVLNode RR(AVLNode node){
        // 定义一个临时变量保存我们失衡节点的右子树
        AVLNode new_root = node.right;
        //将我们失衡节点右子树的左子树作为失衡节点的右子树
        node.right = new_root.left;
        //将失衡节点作为根节点的一个左子树
        new_root.left=node;
        //重新计算失衡节点和旋转后根节点的高度
        node.height=getMax(height(node.left),height(node.right))+1;
        new_root.height=getMax(height(new_root.left),height(new_root.right))+1;
        return new_root;
    }

    /**
     *  LR旋转：
     *      先进性 RR旋转
     *      在进行 LL 旋转
     * @param node
     * @return
     */
    public AVLNode LR(AVLNode node){
        // RR
        node.left = RR(node.left);
        //LL
        AVLNode avlNode = LL(node);
        return avlNode;
    }

    /**
     *  RL旋转：
     *      先进行 LL 旋转
     *      在进行 RR 旋转
     * @param node
     * @return
     */
    public AVLNode RL(AVLNode node){
        // LL
        node.right = LL(node.right);
        //RR
        AVLNode avlNode = RR(node);
        return avlNode;
    }
    private void insert(T data){
        this.root=insert(root,data);
    }
    
    
    private AVLNode insert(AVLNode node, T data){
        if(node == null){
            node = new AVLNode(data);
        }else{
            int i = data.compareTo(node.data);
            if( i > 0){
                node.right = insert(node.right,data);
                if(height(node.right)-height(node.left) == 2 ){
                    if(data.compareTo(node.right.getData()) > 0){
                        // RR旋转
                        node = this.RR(node);
                    }else {
                        //RL 旋转
                        node = this.RL(node);
                    }
                }
            }else if( i < 0){
                node.left = insert(node.left,data);
                if(height(node.left) - height(node.right) == 2 ){
                    if(data.compareTo(node.left.getData()) > 0){
                        // 进行 LR
                        node = this.LR(node);
                    }else {
                        // 进行 LL
                       node =  this.LL(node);
                    }
                }
            }else {
                //
            }
        }
        node.height = getMax(height(node.left),height(node.right))+1;
        return node;
    }



    static class AVLNode<T extends Comparable>{
        //数据
        private T data;
        //左子树
        private AVLNode<T> left;
        //右子树
        private AVLNode<T> right;
        //节点高度
        private int height;
        
        
        public AVLNode(T data ,AVLNode left , AVLNode right){
           this(data,left,right,0);
        }

        public AVLNode(T data ,AVLNode left , AVLNode right,int height){
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }
        
        public AVLNode(T data){
           this(data,null,null,0);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AVLNode<T> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<T> left) {
            this.left = left;
        }

        public AVLNode<T> getRight() {
            return right;
        }

        public void setRight(AVLNode<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(2);
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(1);
        tree.insert(5);


        System.out.println( tree.toString());
    }
}
