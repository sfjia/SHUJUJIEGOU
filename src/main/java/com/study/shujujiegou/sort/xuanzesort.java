package com.study.shujujiegou.sort;

/**
 * @Author 贾
 * @Date 2020/4/1621:23
 *
 *
 * 选择排序：
 * 1.初始状态：无序空间R[1,2,,,,n],有序为空
 * 2。第 i 趟排序【i = 1,2,3 .... n】开始时，当前有序区和无序区分别为R[1...i-1]和R[i...m],该趟排序从当前无序区中选出关键字最小的记录R[k]
 *    将他与无序区的第一个记录交换，使R[1...i] 和 R[i+1 ... n]分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区。
 * 3.  n-1趟结束，数组有序化了
 *
 */
public class xuanzesort {

    public static void sort2(int[] array){
        int length = array.length;
        if(length <= 1){
            return;
        }
        //
        for (int i = 0; i <length ; i++) {
            //从未排序中查询最小的放在最前面
            for (int j = i+1; j < length; j++) {
                if(array[i] > array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }

        }
    }
}
