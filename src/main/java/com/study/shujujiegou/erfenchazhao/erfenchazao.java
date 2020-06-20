package com.study.shujujiegou.erfenchazhao;

/**
 * @Author 贾
 * @Date 2020/4/2119:10
 *
 *  二分查找：
 *
 */
public class erfenchazao {

    public static int search(int[] arr,int value){
        int low = 0;
        int hight = arr.length-1;
        while (low <= hight){
            int mid = (low + hight)/2;
            if(arr[mid] == value){
                return mid;
            }else if(arr[mid] < value){
                low = mid + 1;
            }else {
                hight = mid -1;
            }
        }
        return -1;
    }

    /**
     * 有重复元素的的查找出第一个元素的位置
     * @param arr
     * @param value
     * @return
     */
    public static int chongfuFirstSearch(int[] arr,int value){
        int low = 0;
        int hight = arr.length-1;
        while (low <= hight){
            int mid = (low + hight)/2;
            if(arr[mid] == value){
                if(mid ==0 || arr[mid-1] != value){
                    return mid;
                }else {
                    hight = mid-1;
                }

            }else if(arr[mid] < value){
                low = mid + 1;
            }else {
                hight = mid -1;
            }
        }
        return -1;
    }

    /**
     *  重复元素的最后一个索引
     * @param arr
     * @param value
     * @return
     */
    public static int chongfuLastSearch(int[] arr,int value){
        int low = 0;
        int hight = arr.length-1;
        while (low <= hight){
            int mid = (low + hight)/2;
            if(arr[mid] == value){
                if(mid ==arr.length-1 || arr[mid+1] != value){
                    return mid;
                }else {
                    low = mid+1;
                }

            }else if(arr[mid] < value){
                low = mid + 1;
            }else {
                hight = mid -1;
            }
        }
        return -1;
    }

    /**
     * 查询大于等于给定值的第一个元素
     * @param arr
     * @param value
     * @return
     */
    public static int firstdayudengyuSearch(int[] arr,int value){
        int low = 0;
        int hight = arr.length-1;
        while (low <= hight){
            int mid = (low + hight)/2;
            if(arr[mid] >= value){
                if(mid ==0 || arr[mid-1] <value){
                    return mid;
                }else {
                    hight = mid-1;
                }

            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查询小于等于给定值的最后一个元素
     * @param arr
     * @param value
     * @return
     */
    public static int lastxiaoyudengyuSearch(int[] arr,int value){
        int low = 0;
        int hight = arr.length-1;
        while (low <= hight){
            int mid = (low + hight)/2;
            if(arr[mid] <= value){
                if(mid == arr.length-1 || arr[mid+1] > value){
                    return mid;
                }else {
                    low = mid+1;
                }

            }else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    public static int diguisearch(int[] arr,int value,int low , int high){
      if(low > high){
          return -1;
      }
      int mid = (low + high ) / 2;
        if(arr[mid] == value){
            return mid;
        }else if(arr[mid] < value){
            low = mid + 1;
        }else {
            high = mid -1;
        }
        return diguisearch(arr,value,low,high);
    }


    public static void main(String[] args) {
        int[] arr = {1,3,40,41,43,46,60};
        int search = search(arr, 5);
        System.out.println("search = " + search);
        int diguisearch = diguisearch(arr, 5, 0, arr.length - 1);
        System.out.println("search = " + diguisearch);
        int chongfuSearch = chongfuFirstSearch(arr, 40);
        System.out.println("search = " + chongfuSearch);
        int lastchongfuSearch = chongfuLastSearch(arr, 40);
        System.out.println("search = " + lastchongfuSearch);
        int firstdayudengyuSearch = firstdayudengyuSearch(arr, 42);
        System.out.println("search = " + firstdayudengyuSearch);
        int lastxiaoyudengyuSearch = lastxiaoyudengyuSearch(arr, 42);
        System.out.println("search = " + lastxiaoyudengyuSearch);
    }
}
