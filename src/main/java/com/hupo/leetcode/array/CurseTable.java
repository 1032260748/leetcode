package com.hupo.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class CurseTable {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    Set<Integer> avi = new HashSet<>();

    public static void main(String[] args) {
        CurseTable table = new CurseTable();
        int[][] prerequisites = new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } };
        boolean ava = table.canFinish(2, prerequisites);
        System.out.println(ava);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            int[] temps = prerequisites[i];
            int curseNumber = temps[0];
            if (!map.containsKey(curseNumber)) {
                map.put(curseNumber, new HashSet<>());
            }
            Set<Integer> preSet = map.get(curseNumber);
            preSet.add(temps[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (avi.contains(i)) {
                continue;
            }
            if (!map.containsKey(i)) {
                avi.add(i);
            } else {
                if (ava(i, map, new HashSet<>())) {
                    avi.add(i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean ava(Integer current, Map<Integer, Set<Integer>> map, Set<Integer> prePath) {
        if (prePath.contains(current)) {
            return false;
        }
        if (!map.containsKey(current)) {
            return true;
        }
        prePath.add(current);
        Set<Integer> preSet = map.get(current);
        for (Integer currentPre : preSet) {
            if (this.avi.contains(currentPre)) {
                prePath.remove(current);
                return true;
            }
            if (!ava(currentPre, map, prePath)) {
                return false;
            }
        }
        prePath.remove(current);
        return true;
    }

}
