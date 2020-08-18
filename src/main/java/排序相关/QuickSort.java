package 排序相关;

import org.junit.Test;
import java.util.Random;

/**
 * @author fmk
 * @date 2020/8/17 18:54
 * 时间复杂度   平均O(nlogn)  最好O(nlogn)  最差O(n^2)
 * 空间复杂度   O(logn)
 */
public class QuickSort extends Sort{



    @Test
    public void test() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {2, 5, 6, 2, 5, 7};
        quickSort.sort(arr);
        quickSort.print(arr);
    }
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int l, int h) {
        if (h <= l) return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }
    private int partition(int[] nums, int l, int h) {
        if (l < h) {
            int randomIndex = l + 1 + new Random().nextInt(h - l);
            swap(nums, l, randomIndex);
        }

        int i = l, j = h + 1;
        // 选择第一个元素作为比较的基准
        int v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
