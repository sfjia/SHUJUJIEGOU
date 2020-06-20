package com.study.shujujiegou.sort;

import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/1620:37
 * 
 *  冒泡排序:
 *  1. 比较相邻的两个元素，如果第一个比第二个大，就交换数据
 *  2. 对每一个相邻的元素做同样的操作，第一个开始到结尾的最后一对，这样在最后的元素就应该是最大的数
 *  3，针对所有的元素重复以上步骤，除了最后一个
 *  4，重复 1~3，知道排序完成
 */
public class maopaosort {
    public static void sort(int[] array){
        int length = array.length;
        if(length <= 1){
            return;
        }
        //
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            
        }
    }



    public static void main(String[] args) {
        int[] arr = {2,3,9,5,5,5,3,4,5,6,8,9,9,7,4,3,2,5};
        System.out.println("arr = " + Arrays.toString(arr));
        sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
    
}
