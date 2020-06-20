package com.study.shujujiegou;

import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;

/**
 * @Author 贾
 * @Date 2020/4/1421:46
 *
 * 单链表实现 队列
 *
 * 入队列：在队列尾部添加
 *
 * 出队列：在列表头部出
 */

class testLinkedQueu{
    public static void main(String[]args){

        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 20 ; i++) {
            queue.inQueue(i);
        }
        System.out.println("queue = " + queue.size());

        for (int i = 0; i < 20 ; i++) {
            Object o = queue.outQueue();
            System.out.println("o.toString() = " + o.toString());
        }
        System.out.println("queue = " + queue.size());
    }
}

class LinkedQueue {
    //队列个数
    private int size;

    private LinkNode head;

    private LinkNode tail;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
    }

    public boolean inQueue(Object obj){
        LinkNode node = new LinkNode(obj,null);
        if(tail == null){
            head=node;
            tail = node;
        }else {
            tail.next=node;
            tail =node;
        }
        size++ ;
        return true;
    }


    public Object outQueue(){
        if(head == null){
            return null;
        }
        Object data = head.getData();
         head = head.next;
         if(head == null ){
             tail = null;
         }
         size--;
         return data;
    }

    public int size(){
        return size;
    }
}
class LinkNode{
    private Object data;
    public LinkNode next;

    public LinkNode(Object data , LinkNode next){
        this.data = data;
        this.next = next;
    }

    public Object getData(){
        return data;
    }
}
