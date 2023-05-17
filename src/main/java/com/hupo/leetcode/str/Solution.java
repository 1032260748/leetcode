package com.hupo.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

    public String getHint(String secret, String guess) {
        int same = 0;
        int diff = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            Character current = secret.charAt(i);
            if (guess.charAt(i) == current) {
                same++;
            } else {
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                } else {
                    map.put(current, 1);
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            Character current = guess.charAt(i);
            if (secret.charAt(i) != current) {
                if (map.containsKey(current) && map.get(current) > 0) {
                    diff++;
                    int currentCount = map.get(current);
                    if (currentCount - 1 >= 1) {
                        map.put(current, currentCount - 1);
                    } else {
                        map.remove(current);
                    }
                }
            }
        }
        return same + "A" + diff + "B";
    }

    public static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;

        private Integer top;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (this.top != null) {
                return this.top;
            }
            if (hasNext()) {
                this.top = next();
            }
            return this.top;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (this.top != null) {
                Integer result = this.top;
                this.top = null;
                return result;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return this.top != null || iterator.hasNext();
        }
    }

    private Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.getHint("1123", "0111");
        System.out.println(result);
    }

    public int length(List<Integer> list, List<Integer> other) {
        int diff = Math.abs(other.get(0) - list.get(0));
        int i = 0;
        int j = 0;
        while (i < list.size() && j < other.size()) {
            int currentDiff = Math.abs(list.get(i) - other.get(j));
            if (currentDiff < diff) {
                diff = currentDiff;
            }
        }
        return diff;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            if (t == null && s == null) {
                return true;
            } else {
                return false;
            }
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> fan = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character one = s.charAt(i);
            Character other = t.charAt(i);
            if (map.containsKey(one) && map.get(one) != other) {
                return false;
            } else {
                if (fan.containsKey(other) && fan.get(other) != one) {
                    return false;
                }
                map.put(one, other);
                fan.put(other, one);
            }
        }
        return true;
    }

    public List<String> getValidT9Words(String num, String[] words) {
        if (num == null || words == null || num.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != num.length()) {
                continue;
            }
            if (match(num, words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private boolean match(String num, String word) {
        for (int i = 0; i <= word.length() - 1; i++) {
            if (num.charAt(i) != map.get(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 面试题 17.13. 恢复空格
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t
     * boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary
     * ，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     * <p>
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }
        int result[][] = new int[sentence.length()][sentence.length()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
        for (int n = 0; n <= sentence.length(); n++) {
            for (int i = 0; i < sentence.length(); i++) {
                if (i + n < sentence.length()) {
                    String subString = sentence.substring(i, i + n + 1);
                    if (set.contains(subString)) {
                        result[i][i + n] = 0;
                    } else {
                        result[i][i + n] = n + 1;
                        for (int m = 0; m < n; m++) {
                            result[i][i + n] = Math.min(result[i][i + n], result[i][i + m] + result[i + m + 1][i + n]);
                        }
                    }
                } else {
                    break;
                }

            }
        }
        return result[0][sentence.length() - 1];
    }
}
