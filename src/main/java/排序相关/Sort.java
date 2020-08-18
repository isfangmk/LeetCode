package 排序相关;

import java.util.Arrays;

/**
 * @author fmk
 * @date 2020/8/2 17:31
 */
public abstract class Sort {

    public abstract void sort(int[] nums);

    // protected 包内可见的，并且对子类可见
    protected boolean less(int v, int w) {
        return v < w;
    }

    protected void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    protected void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

}
