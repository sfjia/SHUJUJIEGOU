package com.study.shujujiegou;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @Author 贾
 * @Date 2020/4/1420:23
 *
 *  数组 栈
 *   先进后出
 */

class testArrayStack{
    public static void main(String[] args) {
        ArrayStak stak = new ArrayStak(10);
        for (int i= 0 ; i< 10 ; i++){
            stak.push(i);
        }
        System.out.println(stak.size());
        for (int i= 0 ; i< 10 ; i++){
            stak.pop();
        }
        System.out.println(stak.size());
    }
}


class ArrayStak {

    private Object[] element ;

    private int size;

    private int DEFAULT_CAPACITY = 10;

    private int MAX_SIZE = Integer.MAX_VALUE - 8 ;

    public ArrayStak(){
        element = new Object[DEFAULT_CAPACITY];
    }

    public ArrayStak(int capacity){
        if(capacity <= 0 || capacity >= MAX_SIZE){
            capacity = DEFAULT_CAPACITY;
        }
        element = new Object[capacity];
    }

    public Object pop(){
        if(size == 0 || element == null){
            return null;
        }
        Object o = element[size - 1];
        element[--size] = null;
        return o;
    }

    public boolean push (Object obj){
        if(size == 0 || element == null){
            element = new Object[DEFAULT_CAPACITY];
        }
        element[size++] = obj;
        return true;
    }

    public int size(){
        return size;
    }
}

