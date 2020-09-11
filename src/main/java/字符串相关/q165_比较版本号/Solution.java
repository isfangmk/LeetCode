package 字符串相关.q165_比较版本号;

import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        System.out.println(compareVersion("01", "1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] str1Array = version1.split("\\.");
        String[] str2Array = version2.split("\\.");
        int i = 0, len = Math.max(str1Array.length, str2Array.length);
        int v1, v2;
        while (i < len) {
            v1 = i < str1Array.length ? Integer.parseInt(str1Array[i]) : 0;
            v2= i < str2Array.length ? Integer.parseInt(str2Array[i]) : 0;
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
            i++;
        }
        return 0;

    }
}
