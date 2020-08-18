import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmk
 * @date 2020/8/10 14:16
 */
public class MyTest {
    @Test
    public void test() {
        System.out.println(addBinary("1010", "1011"));
    }
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int carry = 0, sum = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i < 0 ? 0 : a.charAt(i) - '0';
            int v2 = j < 0 ? 0 : b.charAt(j) - '0';
            sum = carry + v1 + v2;
            carry = sum / 2;
            res.append(sum % 2);
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    @Test
    public void test2() {
        System.out.println(search(new int[] {2, 2}, 2));
    }
    public int search(int[] nums, int target) {
        // 找到第一个 >= target的位置
        int len = nums.length;
        if (len < 1) return 0;
        int index = findFirstNotLess(nums, target);
        if (index >= len || nums[index] != target) {
            return 0;
        }
        int j = index;
        while (++j < len && nums[j] == target) ;
        return j - index;

    }
    public int findFirstNotLess(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
    @Test
    public void test3() {
        System.out.println("212".compareTo("210"));
    }
    @Test
    public void test4() {
        System.out.println(generate(2));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) return res;
        res.add(Arrays.asList(1));
        List<Integer> temp;
        List<Integer> list = new ArrayList<>(numRows);
        for (int i = 2; i <= numRows; i++) {
            temp = res.get(i - 2);
            int len = temp.size();
            list.add(1);
            for (int j = 0; j < len - 1; j++) {
                list.add(temp.get(j) + temp.get(j + 1));
            }
            list.add(1);
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
