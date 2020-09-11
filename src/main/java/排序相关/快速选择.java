package 排序相关;

import org.junit.Test;

public class 快速选择 {

    @Test
    public void test() {
        int[] nums = {7, 9, 0, 4, 3, 8, 10};
        System.out.println(select(nums, 2));
    }
    // 返回从小到大排序的第k+1个数
    public int select(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums, int l, int r) {
        int i = l, j = r + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < r);
            while ((nums[--j]) > nums[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
