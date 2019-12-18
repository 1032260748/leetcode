package com.hupo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    private int getUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>(); //创建整形动态数组;
        uglys.add(1); //把特殊值1首先加入;

        //分别代表了与2、3、5相乘元素的序号,相当于指针;
        int p2 = 0, p3 = 0, p5 = 0;

        //用前面各个位置的数与2,3,5相乘直到比上一个数大，并获得相应位置;
        for (int i = 0; i <= n - 2; i++){
            //获取数组中上一个元素，第n个数的上一个对应下标为n-2;
            int lastNumber = uglys.get(i);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            //对比p2,p3,p5位置上分别与2,3,5相乘的结果，最小值添加为下一元素;
            uglys.add(Math.min(Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3), uglys.get(p5) * 5));
        }
        return uglys.get(n - 1);
    }

}
