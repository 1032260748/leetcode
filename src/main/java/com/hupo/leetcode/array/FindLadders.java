package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class FindLadders {

    private Set<String> wordSet = new HashSet<>();

    private String beginWord;

    private String endWord;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        for (String str : wordList) {
            this.wordSet.add(str);
        }
        List<String> pre = new LinkedList<>();
        boolean temp = trans(beginWord, pre);
        if (temp) {
            Collections.reverse(pre);
            return pre;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        FindLadders so = new FindLadders();
        List<String> arrays = Arrays.asList("most", "mist", "miss", "lost", "fist", "fish");
        List<String> result = so.findLadders("lost", "miss", arrays);
        System.out.println(result);
    }

    private boolean trans(String pre, List<String> stack) {
        if (pre.equals(this.endWord)) {
            stack.add(pre);
            return true;
        }
        List<String> next = getNext(pre);
        if (next == null || next.size() == 0) {
            return false;
        }
        for (String str : next) {
            if (trans(str, stack)) {
                stack.add(pre);
                return true;
            }
        }
        return false;
    }

    private List<String> getNext(String pre) {
        if (this.wordSet.size() == 0) {
            return null;
        }
        List<String> next = new ArrayList<>();
        for (String str : this.wordSet) {
            if (diff(pre, str) == 1) {
                next.add(str);
            }
        }
        for (String str : next) {
            this.wordSet.remove(str);
        }
        return next;
    }

    private int diff(String m, String n) {
        int diff = 0;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) != n.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

}
