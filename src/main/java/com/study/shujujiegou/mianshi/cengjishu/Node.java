package com.study.shujujiegou.mianshi.cengjishu;

/**
 * @Author 贾
 * @Date 2020/5/720:07
 */
public class Node {

    int id;
    int parentId;
    String name;

    public Node(int id, int parentId, String name){
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}
