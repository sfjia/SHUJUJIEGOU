package com.study.shujujiegou.digui;

/**
 * @Author 贾
 * @Date 2020/4/1620:00
 */
class demo1 {

    public static void main(String[] args) {
        int sum = sum();
        System.out.println("sum = " + sum);
    }

    static int sum(){
        int a = 0 ;
        int b= 1;
        int c=1;
        b = add(3, 5);
        c = a +b;
        return c;
    }

    static int add(int x , int y){
        int sum = 0 ;
        return x+y;
    }
}
