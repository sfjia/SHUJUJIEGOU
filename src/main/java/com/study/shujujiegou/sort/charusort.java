package com.study.shujujiegou.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @Author 贾
 * @Date 2020/4/1621:01
 *
 * 插入排序：
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5. 将新元素超如到该位置后
 * 6.重复步骤 2~5
 */
public class charusort {


    public static void sort(int[] array){
        int length = array.length;
        if(length <=1){
            return;
        }
        for (int i= 1; i < length ; i++ ){
            //取出当前序列中未排序的元素
            int curr = array[i];
            //取出已排序区间的最后一位
            int preindex = i-1;
            //
            while (preindex >=0 && array[preindex] > curr){
                array[preindex+1] = array[preindex];
                preindex--;
            }
            array[preindex+1]=curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,9,8,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,9};
        System.out.println("arr = " + Arrays.toString(arr));
        sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
