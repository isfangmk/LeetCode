package 排序相关;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/17 20:13
 * 时间复杂度   平均O(nlogn)  最好O(nlogn)  最差O(nlogn)
 * 空间复杂度   O(n)
 */
public class MergeSort extends Sort{

    @Test
    public void test() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {2, 5, 6, 2, 5, 7};
        mergeSort.sort(arr);
        mergeSort.print(arr);
    }
    @Override
    public void sort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }
    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            if (arr[mid] <= arr[mid + 1]) return;
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 把temp中的元素复制到arr中
        System.arraycopy(temp, 0, arr, left, right - left + 1);
    }
}
