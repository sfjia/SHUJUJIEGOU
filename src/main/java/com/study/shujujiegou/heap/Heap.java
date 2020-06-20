package com.study.shujujiegou.heap;

import java.util.Arrays;

/**
 * @Author 贾
 * @Date 2020/4/2621:12
 *
 * // 用数组实现一个堆：
 *
 *      父节点存储在 i 位置，
 *      则左子节点 存储在 2*i 位置 ，
 *      右子节点存储在 2*i + 1 位置。
 *
 *      大顶堆：
 *                  33
 *           /            \
 *         17             21
 *      /       \       /    \
 *     16      13      15     9
 *    /  \    /  \    /  \
 *   5   6   7   8   1   2
 *
 *   新增元素： 22
 */
public class Heap {
    /**
     * 创建堆
     */
    //创建一个数组存储堆
    private int[] data;
    //堆中存放的最大元素个数
    private int size;
    //堆中已有元素个数
    private int count;

    /**
     *  堆
     * @param cp
     */
    public Heap(int cp){
       this.data = new int[cp+1];
        this.size = cp;
        this.count = 0;
    }

    /**
     *
     * @return
     *
     * 堆化：
     *      方式（ 从下往上）
     */
    private void heapB2T(int[] date,int index){
        int end = index;
        while (end/2 > 0  && date[end/2] < date[end]){
            swap(date,end,end/2);
            end = end/2;
        }
    }

    /**
     *
     * @return
     *
     * 大顶堆 堆化：
     *      方式（从上往下）
     */
    private void heapT2B(int[] date,int begin,int end){
        while (true){
            //定义最大值的小标
            int maxPos = begin;
            //用当前节点和他的左右子节点比较，找出最大值 进行交换
            if(2*begin <= end && date[maxPos] < date[2*begin]){
                maxPos = 2*begin;
            }
            if(2*begin + 1 <= end && date[maxPos] < date[2*begin + 1]){
                maxPos = 2*begin + 1;
            }
            if(begin == maxPos){
                break;
            }
            swap(date,begin,maxPos);
            begin = maxPos;
        }
    }

    private void swap(int[] arr,int begin ,int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    /**
     *
     * @return
     *
     * 插入一个元素：
     *     1.放在数组的最后一个位置
     *     2.堆化操作， 直到满足堆的要求
     */
      public void  add(int value){
          if(count > size){
              return;
          }
          this.data[++count] = value;
          //堆化
          this.heapB2T(data,count);
      }

    /**
     * 删除 堆 顶元素
     * @return
     * 自 顶向下的堆化
     *
     * 1.取出 堆 中最后一个元素
     * 2.放在 堆 顶
     * 3.依次和其左右子节点比较互换，直到 到达 叶子节点
     */
    public int  removeTop(){
        int max = data[1];
        data[1] = data[count--];
        heapT2B(data,1,count);
        return max;
    }

    public boolean  removeValue(int value){
        for (int i = 0; i < data.length ; i++) {
            if(data[i]==value){
                data[i] = data[count--];
                heapT2B(data,1,count);
                return true;
            }
        }
        return false;
    }




    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }
}
