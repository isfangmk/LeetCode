package 字符串相关;

import org.junit.Test;

public class q8_字符串转换整数 {


    @Test
    public void test() {
        System.out.println(myAtoi("+12309"));
    }
    public int myAtoi(String str) {
        int len = str.length();
        char[] strCharArray = str.toCharArray();
        int index = 0;
        while (index < len && strCharArray[index] == ' ') {
            index++; // 指向第一个不为空格的字符
        }
        int sign = 1;
        char firstChar = strCharArray[index];
        if (firstChar == '-') {
            sign = -1;
        }
        index++;

        int res = 0;
        while (index < len) {
            char curChar = strCharArray[index];
            if (curChar < '0' || curChar > '9') {
                break;
            }
            if ((res > Integer.MAX_VALUE / 10) ||
                    ((res == Integer.MAX_VALUE / 10) && (curChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if ((res < Integer.MIN_VALUE / 10) ||
                    ((res == Integer.MIN_VALUE / 10) && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (curChar - '0');
            index++;

        }
        return res;
    }
}
