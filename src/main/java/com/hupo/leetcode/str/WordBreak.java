package com.hupo.leetcode.str;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))) {
                if (s.length() == wordDict.get(i).length()) {
                    result = true;
                } else {
                    result = result || wordBreak(s.substring(wordDict.get(i).length()), wordDict);
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }


    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean[] result = new boolean[s.length()];

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))) {
                result[wordDict.get(i).length() - 1] = true;
            }
        }

        return false;
    }


}
