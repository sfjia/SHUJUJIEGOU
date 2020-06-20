package com.study.shujujiegou.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author 贾
 * @Date 2020/4/2020:16
 *
 * 桶排序的关键环节：
 *  1.元素值域的划分，也就是元素到桶的映射规则，映射规则需要根据待排序的集合的分布特性进行选择，若规则的设计过于模糊，宽泛，则可能导致排序集合
 *      元素全部映射到一个桶上，若映射规则设计过于具体，严苛，则可能导致待排序集合中每一个元映射到一个桶上
 *  2.从待排序集合中元素映射到各个桶上的过程，并不存在元素的比较和交换操作，再对各个桶中元素进行排序的时候，可以自由选择合适的算法。每个桶中
 *      的排序算法的复杂度和稳定性，决定了最总算法的复杂度和稳定性
 */
public class tongSort {
    /**
     *
     * @param arr 待排序的序列
     * @param bucksize 每个桶可以存放的格数
     * @return
     */
    public static List<Integer> sort(List<Integer> arr,int bucksize){
        if(arr == null || arr.size() <= 1 || bucksize < 1 ){
            return arr;
        }
        //计算最大值，最小值
        int max = arr.get(0);
        int min = arr.get(0);
        for (int i = 0; i < arr.size() ; i++) {
            Integer cur = arr.get(i);
            if(cur > max){
                max = cur;
            }
            if(cur < min){
                min = cur;
            }
        }
        // 计算桶的个数【 集合中的最小值min -- 集合中的最大值max 】表示我们整个所有待排序的数据范围
        int bucketCount = (max - min) / bucksize + 1 ;

        List<List<Integer>> bucketList = new ArrayList<>();

        //对按照顺序创建桶
        for (int i = 0; i <bucketCount ; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        //将待排序的集合一次添加到对应的桶中
        for (int i = 0; i < arr.size() ; i++) {
            int bucketIndex = (arr.get(i)-min)/bucksize;
            bucketList.get(bucketIndex).add(arr.get(i));
        }

        //桶内元素排序
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketList.size() ; i++) {
            List<Integer> everyBucket = bucketList.get(i);

            if(everyBucket.size() > 0){
                if(bucketCount == 1){
                    bucksize--;
                }
                List<Integer> temp = sort(everyBucket, bucksize);
                for (int j = 0; j < temp.size() ; j++) {
                    resultList.add(temp.get(j));
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(3);
        list.add(0);
        list.add(8);
        System.out.println("arr = " + list);
        List<Integer> sort = sort(list, 2);
        System.out.println("arr = " +sort);
    }
}
