package 双指针遍历.q11_盛最多水的容器;

/**
 * @author fmk
 * @date 2020/8/9 19:57
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int i = 0, j = height.length - 1, res = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            // 若向内移动短板，可能变大
            // 若向内移动长板，可能不变或者变小
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
