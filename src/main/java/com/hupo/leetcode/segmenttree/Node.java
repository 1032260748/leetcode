package com.hupo.leetcode.segmenttree;

public class Node {

    //区间的左端点
    int start;

    //区间的右端点
    int end;

    //该节点的值
    int data;

    //延迟更新的标记
    int mark = 0;

    public Node(int start, int end)//构造方法中传入左端点和右端点
    {
        this.start = start;
        this.end = end;
    }

    void addMark(int value)//做标记
    {
        this.mark += value;
    }

    void clearMark() {
        this.mark = 0;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }



}
