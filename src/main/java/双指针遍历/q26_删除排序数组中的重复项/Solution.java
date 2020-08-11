package 双指针遍历.q26_删除排序数组中的重复项;

/**
 * @author fmk
 * @date 2020/8/10 7:55
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int pre = 0;
        for (int cur = 1; cur < nums.length; cur++) {
            if (nums[pre] != nums[cur]) {
                nums[++pre] = nums[cur];
            }
        }
        return pre + 1;
    }
}
