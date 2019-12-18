package com.hupo.leetcode.link;


public class DlinkNode<T> {

    public T val;

    public DlinkNode<T> next;

    public DlinkNode<T> pre;

    public DlinkNode(T data) {
        this.val = data;
    }

}
