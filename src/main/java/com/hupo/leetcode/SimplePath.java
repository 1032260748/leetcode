package com.hupo.leetcode;

import java.util.Stack;

public class SimplePath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        String[] list = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i <= list.length - 1; i++) {
            if (list[i].length() == 0) {
                continue;
            }
            if (".".equals(list[i])) {
                continue;
            }
            if ("..".equals(list[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(list[i]);

        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, "/");

        }
        if (builder.length() > 0) {

            return builder.toString();
        } else {
            return "/";
        }
    }
}
