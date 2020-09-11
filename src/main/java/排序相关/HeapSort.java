package 排序相关;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort extends Sort{


    @Test
    public void test() {
        int[] arr = {0, 8, 7, 50, 8, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Override
    public void sort(int[] nums) {
        heapSort(nums, nums.length - 1);
    }
    //  数组第 0 个位置不能有元素
    private void heapSort(int[] nums, int N) {
        // 将所有的非叶子节点下沉
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }
        // 依次将堆顶元素移动到数据的末端
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }
    // 下沉
    private void sink(int[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums[j], nums[j + 1])) {
                j++;
            }
            if (less(nums[j], nums[k])) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }
}
