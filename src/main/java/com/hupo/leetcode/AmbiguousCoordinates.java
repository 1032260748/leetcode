package com.hupo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        if (S.length() == 1) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        String text = S.substring(1, S.length() - 1);

        for (int i = 1; i <= text.length() - 2; i++) {
            String pre = text.substring(0, i + 1);
            String post = text.substring(i + 1);

            if (!isValid(pre) || !isValid(post)) {
                continue;
            }

            List<String> preList = getList(pre);

            List<String> postList = getList(post);

            for (int m = 0; m < preList.size(); m++) {
                for (int n = 0; n < postList.size(); n++) {
                    result.add("(" + preList.get(m) + "," + postList.get(n) + ")");
                }
            }

        }
        return result;
    }

    private boolean isValid(String input) {

        if (input == null || input.length() == 0) {
            return false;
        }

        if (input.length() == 1) {
            return true;
        }

        if (input.startsWith("0") && input.endsWith("0")) {
            return false;
        }
        return true;
    }


    public List<String> getList(String text) {

        List<String> result = new ArrayList<>();
        if (text.length() == 1) {
            result.add("" + text);
            return result;
        }
        if (text.startsWith("0")) {
            result.add("0");
        }
        return result;
    }

}
