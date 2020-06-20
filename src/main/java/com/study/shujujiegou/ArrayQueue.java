package com.study.shujujiegou;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/1421:11
 * 
 * 基于数组实现的队列叫顺序队列
 */

class testArrayQueue{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0 ; i < 20 ; i++){
            queue.inQueue(i);
        }
        System.out.println(queue.size());
        queue.outQueue();
        queue.outQueue();
        queue.outQueue();
        System.out.println("queue.size() = " + queue.size());
    }
}

class ArrayQueue {
    
    //定义队列结构
    private Object[] element;
    
    private int size;
    
    private int default_size = 2;
    
    private int max_size = Integer.MAX_VALUE - 8;
    //头指针
    private int head;
    //尾指针
    private int tail ;
    
    public ArrayQueue(){
        element = new Object[default_size];
        //初始化首尾指针
        this.initPoint(0,0);
    }
    
    private void initPoint(int head,int tail){
        this.head = head;
        this.tail = tail;
    }

    public ArrayQueue(int capacity){
        if(capacity <= 0 ){
            capacity = default_size;
        }
        element = new Object[capacity];
        this.initPoint(0,0);
    }
    
    //定义结构的操作
    
    //入队列
    public boolean inQueue(Object obj){
        ensureSizeEnough();
        element[tail++] = element;
        size++;
        return true;
    }
    
    //出队列
    public Object outQueue(){
        if(head == tail){
            return null;
        }
        Object o = element[head++];
        size--;
        return o;
    }
    
    
    
    //动态扩容
    
    //判断队列容量是否够用
    private void ensureSizeEnough(){
        //尾指针已经越过size
        if(tail == element.length){
            if(size <= element.length){
                if(head == 0){
                    //扩容
                    grow(size);
                }else {
                    for (int i = head ; i<tail ; i++){
                        element[i-head] = element[i];
                        this.initPoint(0,tail - head);
                    }
                }
            }
        }
    }
    
    //扩容
    private void grow(int oldSize){
        int newSize = oldSize + (oldSize>>1); //扩容 1.5倍
        if(newSize - oldSize < 0){
            newSize = default_size;
        }
        if(newSize - max_size > 0){
            newSize = max_size;
        }
        Object[] taget = new Object[newSize];
        element = Arrays.copyOf(element, newSize);
    }
    
    public  int size(){
        return size;
    }
    
}
