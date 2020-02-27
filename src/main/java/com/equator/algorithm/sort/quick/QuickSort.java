package com.equator.algorithm.sort.quick;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;
import com.equator.algorithm.sort.bubble.BubbleSort;
import com.equator.algorithm.sort.insertion.InsertionSort;

/**
 * @Author: Equator
 * @Date: 2019/11/26 20:36
 **/

public class QuickSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int low = 0, high = array.length - 1;
        sort(array, low, high);
    }

    public void sort(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        // 取数组第一个数作为比较的键值
        int key = array[low];
        while (low < high) {
            // 找到一个比键值小的数据，并交换到低端
            while (low < high && array[high] >= key) {
                high--;
            }
            SortUtil.swap(array, low, high);
            // 找到一个比键值大的数据下标，并交换到高端
            while (low < high && array[low] <= key) {
                low++;
            }
            SortUtil.swap(array, low, high);
        }
        // 最终 low 等于 high
        return low;
    }

    public static void main(String[] args) {
        // SortUtil.sort(new QuickSort());
        int[] nums = {1, 3, 5, 2, 4};
        new QuickSort().sort(nums);
    }
}
