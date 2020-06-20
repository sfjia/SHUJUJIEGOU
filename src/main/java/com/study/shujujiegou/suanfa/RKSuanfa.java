package com.study.shujujiegou.suanfa;

/**
 * @Author 贾
 * @Date 2020/4/2920:53
 *
 *  RK算法： 在BF算法上增加了hash算法
 *     在主串（目标串）中 匹配 子串（模式串）
 *
 *  例：主串：abdfdkdl
 *      模式串： dfd
 *
 */
public class RKSuanfa {
    
    
    
    public static int RK(String t,String p){
        if(t==null || t.length() ==0 || p==null || p.length() ==0){
            return -1;
        }
        int hash = hash(p, 26, 31, 0, p.length());
        for (int i = 0; i < t.length(); i++) {
            if((hash(t,26,31,i,p.length()) == hash) && match(t,p,i)){
                return i;
            }
        }
        return -1;
    }


    /**
     * hash算法
     * @param string 主串
     * @param R R进制
     * @param K 将字符串映射到 k 的范围
     * @param start 开始位置
     * @param len 模式串长度
     * @return
     */
    public static int hash(String string , int R ,int K , int start , int len){
        int hash = 0;
        for (int i = start; i < start+len ; i++) {
            hash=(R*hash+string.charAt(i)%K);
        }
        return hash%K;
    }

    /**
     *
     * @param t 主串
     * @param p 子串
     * @param i 从主串下标为i的地方开始；11
     * @return
     */
    public static boolean match(String t, String p,int i){
        for (int j = 0; j < p.length() ; j++) {
            if(p.charAt(j) != t.charAt(j+i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abced";
        String subStr = "ce";
        int rk = RK(str, subStr);
        System.out.println("rk = " + rk);
    }
}
