package com.study.shujujiegou.tu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author 贾
 * @Date 2020/4/2819:30
 *
 *  // 无向图：
 *      存储方式：采用邻接表
 *
 *      0 -- 1 -- 2
 *      |    |    |
 *      3 -- 4 -- 5
 *           |    |
 *           6 -- 7
 */
public class UnGraph {
    // 顶点的格数
    private int pinters;

    //邻接表存储
    private LinkedList<Integer>[] liejiebiao;

    public UnGraph(int pinters) {
        this.pinters = pinters;
        this.liejiebiao = new LinkedList[this.pinters];
        //初始化数据中每一个槽位上的链表
        for (int i = 0; i < this.pinters ; i++) {
            liejiebiao[i] = new LinkedList<Integer>();
        }
    }

    public UnGraph() {
    }


    //向图中添加顶点
    public void addPoint(int s , int t){
        liejiebiao[s].add(t);
        liejiebiao[t].add(s);
    }

    /**
     *  广度优先搜索算法:
     *        1.先检索相邻的节点
     *        2，递归
     * @param s  起始顶点
     * @param t  目标顶点
     */
    public void breathSearch(int s, int t){
        if(s==t){
            return;
        }
        //定义一个boolean数组，用来记录我们的顶点是否已被访问
        boolean[] visited = new boolean[this.pinters];

        //定义一个队列，存储已经被访问过的，但是还有相邻顶点的顶点
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);

        //定义一个数组，来存储我们的访问路径
        int[] routes = new int[this.pinters];

        //初始化路线为-1
        for (int i = 0; i < routes.length; i++) {
            routes[i] = -1;
        }

        /**
         * 循环遍历 队列中 没有被访问的顶点
         */
        while (!queue.isEmpty()){
            Integer p = queue.poll();
            //遍历 对应顶点的 相邻的 顶点
            for (int i = 0; i <liejiebiao[p].size() ; i++) {
                Integer p_edg = liejiebiao[p].get(i);
                //没有被访问过
                if(!visited[p_edg]) {
                    // 记录访问l路线
                    routes[p_edg] = p;
                    // 判断和目标相等
                    if (p_edg == t) {
                        //打印 访问 路线
                        printS2T(routes,s,t);
                        return;
                    }
                    //标记已被访问
                    visited[p] = true;
                    //相邻顶点存入 队列
                    queue.add(p_edg);
                }
            }
        }
    }

    /**
     *
     * @param s
     * @param t
     *
     *  DFS:深度优先遍历
     *     回溯算法
     */
    public void dfs(int s , int t){
        if(s==t){
            found = true;
            return;
        }
        //标记某个元素被访问过
        boolean[] visited = new boolean[this.pinters];
        //
        visited[s] = true;
        //定义一个数组，记录从原点到目标定点的线路
        int[] route = new int[this.pinters];
        for (int i = 0; i < this.pinters ; i++) {
            route[i] = -1;
        }
        returnDFS(s,t,visited,route);
        printS2T(route,s,t);

    }
    //标识是否找到t
    private boolean found = false;

    /**
     * 查找顶点point 到我们目标顶点的线路
     * @param point 顶点point
     * @param target 目标顶点
     * @param visited 已经被访问过的顶点的数组
     * @param rount 顶点的线路
     */
    private void returnDFS(int point , int target , boolean[] visited, int[] rount){
        if(found){
            return;
        }
        //标记当前的顶点被访问过
        visited[point] = true;
        //
        if(point == target){
            found = true;
            return;
        }
        //遍历当前顶点的的相连顶点
        for (int i = 0; i < liejiebiao[point].size() ; i++) {
            Integer poing_edg = liejiebiao[point].get(i);
            if(!visited[poing_edg]) {
                //记录路线
                rount[poing_edg]=point;
                // 递归调用
                returnDFS(poing_edg,target,visited,rount);
            }


        }

    }



    private void printS2T(int[] routs,int s, int t){
        if(routs[t] != -1 && s != t){
            printS2T(routs,s,routs[t]);
        }
        System.out.print(t+" >>" );
    }


    public static void main(String[] args) {
        UnGraph unGraph = new UnGraph(8);
        unGraph.addPoint(0,1);
        unGraph.addPoint(0,3);
        unGraph.addPoint(1,4);
        unGraph.addPoint(1,2);
        unGraph.addPoint(2,5);
        unGraph.addPoint(3,4);
        unGraph.addPoint(4,5);
        unGraph.addPoint(4,6);
        unGraph.addPoint(5,7);
        unGraph.addPoint(6,7);
        System.out.println("unGraph = " + unGraph);

        unGraph.breathSearch(0,7);

        System.out.println("unGraph = " + unGraph);
        unGraph.dfs(0,7);

    }
}
