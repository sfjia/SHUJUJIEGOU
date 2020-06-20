package com.study.shujujiegou.digui;

import com.sun.xml.internal.messaging.saaj.soap.ver1_2.BodyElement1_2Impl;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author 贾
 * @Date 2020/4/1620:14
 * 
 * n 的阶乘  n！
 */
public class jiecheng {

    public static void main(String[] args) {
        BigInteger integer = factorial2(100);
        System.out.println("i = " + integer);
    }


    public static BigInteger factorial2(int n){
        if( n == 0 || n==1){
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial2(n-1));
    }

    //
    public static int factorial(int n){
        if( n == 0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
