package com.study.shujujiegou.sort;

import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/2021:25
 *
 * 技术排序：
 * 1.
 *
 */
public class jishusort {

    public static void sort(int[] arr){
        // 求出待排序区间数组的最大值和最小值，找出区间值
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            int curr = arr[i];
            if(max < curr){
                max = curr;
            }
            if(min > curr){
                min = curr;
            }
        }
        /// 定义一个额外的数组
        int bucketSize = (max-min)+1;
        int[] bucket = new int[bucketSize];

        // 统计对应元素的个数
        for (int i = 0; i < arr.length ; i++) {
            int bucketIndex = arr[i]-min;
            bucket[bucketIndex]+=1;
        }
        //对数组中元素进行累计操作
        for (int i = 1; i <bucket.length ; i++) {
            bucket[i] = bucket[i]+bucket[i-1];
        }

        //创建一个临时数组，存储最终的有序 序列
        int[] temp = new int[arr.length];

        //逆序扫描排序的数组，可以保证我们元素的稳定性
        for (int i = arr.length-1; i >=0 ; i--) {
            int bucketIndex = arr[i]-min;
            temp[bucket[bucketIndex]-1] =arr[i];
            bucket[bucketIndex] -= 1;
        }

        //将我们临时数据一次放入原始数组
        for (int i = 0; i <temp.length ; i++) {
            arr[i] =temp[i];
        }
    }

    public static void main(String[] args) {
        int[]  arr= {2,3,4,12,546,9,3,5,13,234,3};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
