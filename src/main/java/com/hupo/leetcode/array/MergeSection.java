package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeSection {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Section[] secArr = new Section[intervals.length];
        for (int i = 0; i <= intervals.length - 1; i++) {
            secArr[i] = (new Section(intervals[i][0], intervals[i][1]));
        }
        Arrays.sort(secArr);

        List<Section> sectionList = new ArrayList<>();

        int start = secArr[0].start;
        int end = secArr[0].end;
        for (int i = 0; i <= secArr.length - 1; i++) {
            if (secArr[i].start <= end) {
                end = Math.max(secArr[i].end, end);
            } else {
                sectionList.add(new Section(start, end));
                start = secArr[i].start;
                end = secArr[i].end;
            }
        }
        sectionList.add(new Section(start, end));
        int[][] mergeResult = new int[sectionList.size()][2];

        for (int i = 0; i <= sectionList.size() - 1; i++) {
            mergeResult[i] = new int[2];
            mergeResult[i][0] = sectionList.get(i).start;
            mergeResult[i][1] = sectionList.get(i).end;
        }
        return mergeResult;
    }

    public static class Section implements Comparable<Section> {
        public int start;

        public int end;

        public Section() {

        }

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Section o) {
            if (start != o.start) {
                return Integer.compare(start, o.start);
            } else {
                return Integer.compare(end, o.end);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arrays = new int[2][2];
        arrays[0] = new int[] { 1, 4 };
        arrays[1] = new int[] { 2, 3 };
        //        arrays[2] = new int[] { 8, 10 };
        //        arrays[3] = new int[] { 15, 18 };
        MergeSection mergeSection = new MergeSection();
        int[][] result = mergeSection.merge(arrays);
        System.out.println(result);
    }
}
