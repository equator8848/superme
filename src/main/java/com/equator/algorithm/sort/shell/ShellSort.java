package com.equator.algorithm.sort.shell;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;
import com.equator.algorithm.sort.insertion.InsertionSort;
import com.equator.algorithm.sort.quick.QuickSortBetter;

/**
 * @Author: Equator
 * @Date: 2019/11/27 9:59
 **/

/**
 *  希尔排序，将数组按照 增量 （步长）划分为子序列，再对子序列进行直接插入排序
 *  化远为近，减少数据移动次数
 */
public class ShellSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int gap = array.length, len = array.length, i, j, temp;
        do {
            // 计算增量，增量最后必须为1，进行全盘扫描
            gap = gap / 3 + 1;
            for (i = gap; i < len; i++) {
                // 从第gap个元素，逐个对其所在组进行直接插入排序操作
                if (array[i] < array[i - gap]) {
                    temp = array[i];
                    for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                        // 数据后移
                        array[j + gap] = array[j];
                    }
                    array[j + gap] = temp;
                }
            }
        } while (gap > 1);
    }

    public static void main(String[] args) {
        // SortUtil.sort(new ShellSort());
        int[] array = {5, 3, 4, 6, 2};
        SortUtil.print("排序前", array);
        long time = SortUtil.monitor(new ShellSort(), array);
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + time);
    }
}
