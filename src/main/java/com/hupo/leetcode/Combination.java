package com.hupo.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Combination {


    public static List<String> getAll(List<List<String>> arrayList) {

        List<String> result = new ArrayList<>();
        List<String> prefix = new ArrayList<>();

        getAll(arrayList, prefix, result, 0);

        return result;

    }

    public static void getAll(List<List<String>> arrayList, List<String> prefix, List<String> result, int number) {

        if (number == arrayList.size() - 1) {
            String prior = String.join("", prefix);
            for (String text : arrayList.get(number)) {
                result.add(prior + text);
            }
        } else {
            List<String> stringList = arrayList.get(number);
            for (int i = 0; i <= stringList.size() - 1; i++) {
                prefix.add(stringList.get(i));
                getAll(arrayList, prefix, result, number + 1);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}
