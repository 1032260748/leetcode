package com.hupo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> total = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return total;
        }
        di(s, new ArrayList<>(), total);
        return total;
    }

    public void di(String s, List<String> pre, List<String> total) {

        if (s == null) {
            return;
        }

        if (s.length() <= 3 - pre.size()) {
            return;
        }

        if (pre.size() == 3) {
            if (!checkItem(s)) {
                return;
            }

            pre.add(s);

            total.add(String.join(".", pre));
            pre.remove(pre.size() - 1);

            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String subStr = s.substring(0, i);

            if (!checkItem(subStr)) {
                break;
            }

            pre.add(subStr);

            di(s.substring(i), pre, total);

            pre.remove(pre.size() - 1);
        }
    }


    private boolean checkItem(String item) {

        if (item == null || item.length() == 0) {
            return false;
        }
        if (item.length() >= 4) {
            return false;
        }

        int parse = Integer.parseInt(item);
        if (parse > 255) {
            return false;
        }

        if (item.startsWith("0") && item.length() > 1) {
            return false;
        }
        return true;

    }


}
