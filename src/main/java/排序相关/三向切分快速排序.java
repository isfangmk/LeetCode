package 排序相关;

import org.junit.Test;

import java.util.Arrays;

public class 三向切分快速排序 {


    @Test
    public void test() {
        int[] arr = {5, 3, 5, 6, 3, 3, 7, 8};
        threeWayQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void threeWayQuickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);

    }
    public void sort(int[] a, int lo, int hi){
        if(lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];
        while (i <= gt){
            if (a[i] < v) exch(a, lt++, i++);
            // 将比v大的数据移动到数组的末端
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
