package hash相关.q49_字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Long, List<String>> map = new HashMap<>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        for (String str : strs) {
            long sum = 1;
            for (char c : str.toCharArray()) {
                sum *= primes[c - 'a'];
            }
            List<String> list = map.get(sum);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sum, list);
            } else {
                list = map.get(sum);
            }
            list.add(str);
        }
        for (long n : map.keySet()) {
            List<String> list = map.get(n);
            res.add(list);
        }
        return res;
    }
}
