package com.study.shujujiegou.sort;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 贾
 * @Date 2020/4/1813:45
 *
 * 快速排序：
 *
 * 1. 从数组中挑选一个元素，成为基准（pivot）
 * 2. 重新排序数列，所有元素比基准值小的排在基准前面，所有元素比基准值大的排在基准值后面（相同的可以在任一边），
 *     在这个分区退出之后，该基准就处于数列的中间位置，这个称之为分区操作
 * 3.递归地把小于基准元素的子数列和大于基准元素的子数列排序
 *
 */
public class kuaisusort {

    public static void sort(int[] arr,int begin,int end){
        // 校验：递归终止条件
        if(arr.length <=1 || begin >= end){
            return ;
        }
        // 获取 分区
        int partition = partition(arr, begin, end);
        //左侧排序
        sort(arr,begin,partition-1);
        //排序右侧
        sort(arr,partition+1,end);
    }
    //返回序列的基准点
    public static int partition(int[] arr,int begin,int end){
        //默认使用数组最后一个元素为基准点，基准点可以随便定义
        int pivot = arr[end];
        //定义分区后的 pivot 下标
        int pivotIndex = begin;
        for (int i = begin ; i < end; i++){

            if(arr[i] < pivot){

                if(i > pivotIndex){
                    //元素交换
                    swap(arr,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr,pivotIndex,end);
        return pivotIndex;
    }

    public static void swap(int[] arr , int i , int j){
        int tem = arr[j];
        arr[j] =arr[i];
        arr[i] = tem;
    }

    public static void main(String[] args) {
        int[] arr = {0,5,4,1,2,7,5,6,8,3};
        System.out.println("arr = " + Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println("sort = " + Arrays.toString(arr));
    }
}
