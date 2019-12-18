package com.hupo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KCombine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        KCombine combine = new KCombine();
        List<List<Integer>> result = combine.combine(4, 2);
        System.out.println(result);
    }

    public void combine(int n, int k, int index, List<Integer> tempList, List<List<Integer>> result) {

        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        if (tempList.size() > k || index > n) {
            return;
        }

        tempList.add(index);

        combine(n, k, index + 1, tempList, result);

        tempList.remove(new Integer(index));

        combine(n, k, index + 1, tempList, result);
    }

}
