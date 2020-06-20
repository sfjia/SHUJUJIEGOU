package com.study.shujujiegou.mianshi.cengjishu;



import java.util.*;


/**
 * @Author 贾
 * @Date 2020/5/720:29
 */
public class NodePrint {

    public static void print(List<Node> list){
        TreeNode treeNode = new TreeNode();
        for (Node node : list) {
            treeNode.addNode(node);
        }
        TreeNode root = treeNode.root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root!=null){
//            queue.add(root);
//        }
//        while (!queue.isEmpty()){
//            TreeNode poll = queue.poll();
//            printLevel(poll);
//            if(poll.left!=null) {
//                queue.add(poll.left);
//            }
//            if(poll.right != null) {
//                queue.add(poll.right);
//            }
//
//        }
        prePrintLevel(root);
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(1,0,"AA"));
        list.add(new Node(2,1,"BB"));
        list.add(new Node(3,1,"CC"));
        list.add(new Node(4,2,"DD"));
        list.add(new Node(5,2,"EE"));
        list.add(new Node(6,3,"FF"));
        list.add(new Node(7,3,"GG"));
        list.add(new Node(8,4,"HH"));
        list.add(new Node(9,5,"II"));
        print(list);
    }

    public static void printLevel(TreeNode node){
        for (int i = 0; i <node.level ; i++) {
            System.out.print(" ");
        }
        System.out.println(node.name);
    }

    public static void prePrintLevel(TreeNode node){
        if(Objects.isNull(node)){
            return;
        }
        for (int i = 0; i <node.level ; i++) {
            System.out.print(" ");
        }
        System.out.println(node.name);
        prePrintLevel(node.left);
        prePrintLevel(node.right);
    }
}
