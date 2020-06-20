package com.study.shujujiegou.sort;


import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/2622:05
 *
 *  堆排序：
 *      1.建堆
 *      2.排序
 *
 */
public class BigHeapSort {

    /**
     * 建堆
     * 1.自顶向下的堆化
     * 2.交换
     */

    private void heapT2B(int[] data,int begin,int end){
        while (true){
            int maxPosi = begin;
            if(2*begin <= end && data[maxPosi] < data[2*begin]){
                maxPosi = 2* begin;
            }
            if(2*begin+1 <= end && data[maxPosi] < data[2*begin+1]){
                maxPosi = 2* begin+1;
            }
            if(begin == maxPosi){
                break;
            }
            swap(data,begin,maxPosi);
            begin = maxPosi;
        }
    }

    private void swap(int[] arr,int begin ,int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public void  buildHeap(int[] data,int n){
        for (int i = n/2; i > 0 ; i--) {
            heapT2B(data,i,n);
        }
    }

    private void sort(int[] arr,int n){
        while (n>1){
            swap(arr,1,n);
            heapT2B(arr,1,--n);
        }
    }


    public void heapSort(int[] arr){
        //1.建堆
        buildHeap(arr,arr.length-1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        //2.排序
        sort(arr,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {0,2,6,9,0,3,5};
        System.out.println("arr = " + Arrays.toString(arr));
        BigHeapSort sort = new BigHeapSort();
        sort.heapSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

}
