package com.study.shujujiegou;

import java.util.Stack;

/**
 * @Author 贾
 * @Date 2020/4/1420:42
 *
 * 基于链表实现的 栈
 */

class TestLinkedStack{
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        for (int i= 0 ; i < 10 ; i++) {
            stack.push(i);
        }
        System.out.println("stack. = " + stack.size());
        for (int i= 0 ; i < 10 ; i++) {
            Object pop = stack.pop();
            System.out.println("pop = " + pop);
        }
        System.out.println("stack. = " + stack.size());
    }
}

class LinkedStack {
    //尾节点
    private Node tail ;
    //栈大小
    private int size;

    public LinkedStack(){
        this.tail = null;
    }

    public Object pop(){
       if(size == 0){
           return null;
       }
        Object data = tail.getData();
         tail = tail.pre;
         if(tail != null) {
             tail.next = null;
         }
         size--;
         return data;
    }

    public boolean push (Object obj){
        Node newNode = new Node(tail,obj,null);
        if(tail != null){
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }
    public int size(){
        return size;
    }

}

class Node{
    private Object data;
    public Node pre;
    public Node next;

    public Node(Node pre , Object data , Node next){
        this.pre = pre;
        this.data = data;
        this.next = next;
    }

    public Object getData(){
        return data;
    }
}
