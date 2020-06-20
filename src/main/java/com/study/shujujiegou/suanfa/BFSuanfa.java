package com.study.shujujiegou.suanfa;

/**
 * @Author 贾
 * @Date 2020/4/2920:53
 *  
 *  BF算法：
 *      暴力方法
 *  在主串（目标串）中 匹配 子串（模式串）
 *  
 *  例：主串：abdfdkdl
 *      模式串： dfd
 *  
 */
public class BFSuanfa {

    /**
     *  使用 bf 算法在主串中匹配 子串
     * 
     * @param t 主串
     * @param p 模式串
     * @return
     */
    public  int BF(String t ,String p){
        if( t.isEmpty()|| t.length() ==0  || p.isEmpty() || p.length() ==0 || p.length() >t.length()){
            return -1;
        }
        char[] ct = t.toCharArray();
        char[] cp = p.toCharArray();
        return match(ct,cp);
    }
    
    private int match(char[] t, char[] p){
        int i = 0 ;
        int j = 0;
        int posi = 0;
        while (i<t.length && j<p.length){
            if(t[i] == p[j]){
                i++;
                j++;
            }else {
                i = i-j+1;
                j=0;
            }
        }
        if(i <= t.length){
            posi = i - p.length;
        }else{
            posi = -1;
        }
        return posi;
    }

    public static void main(String[] args) {
//        BFSuanfa bf = new BFSuanfa();
//        String t = "sddabfdabd";
//        String p = "abd";
//        int poi = bf.BF(t, p);
//        System.out.println("poi = " + poi);

        int[] a = {1,2,3,4,5,6};
        int i = 0;
        while (i < a.length){
            System.out.println("a[i] = " + a[i]);
            i+=1;
        }
    }
}
