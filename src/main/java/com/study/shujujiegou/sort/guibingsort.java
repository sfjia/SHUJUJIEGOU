package com.study.shujujiegou.sort;

import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/1813:01
 * 
 * 归并排序：
 * 
 *  1. 把长度为n的输入序列分成两个长度为 n/2 的子序列
 *  2. 对这两个子序列分别采用归并排序
 *  3. 将两个排好的子序列合并成一个最终的序列
 * 
 */
public class guibingsort {
    
    
    public static int[] sort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        //拆分数组
        int midel = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,midel);
        int[] right = Arrays.copyOfRange(arr,midel,arr.length);
        return merge(sort(left),sort(right));
    }
    
    public static int[] merge(int[] lefr,int[] right){
        //创建一个新的数组
        int[] arr = new int[lefr.length+right.length];
        //定义两个指针，分别指向两个数组的下标
        int leftIndex = 0;
        int rightIndex=0;

        for (int i = 0; i < arr.length; i++) {

            if (leftIndex >= lefr.length) {
                arr[i] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                arr[i] = lefr[leftIndex++];
            } else if (lefr[leftIndex] < right[rightIndex]) {
                arr[i] = lefr[leftIndex++];
            } else {
                arr[i] = right[rightIndex++];
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
        System.out.println("arr = " + Arrays.toString(arr));
        int[] sort = sort(arr);
        System.out.println("sort = " + Arrays.toString(sort));
    }
}
