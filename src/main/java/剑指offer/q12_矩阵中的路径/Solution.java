package 剑指offer.q12_矩阵中的路径;

import org.junit.Test;

public class Solution {



    @Test
    public void test() {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }
    int m, n;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        m = rows;
        n = cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    // k当前字符串在str中的索引
    private boolean dfs(char[] matrix, char[] str, int i, int j, int k) {
        int index = i * n + j;
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[index] != str[k]) {
            return false;
        }
        if (k == str.length - 1) return true;
        char tmp = matrix[index];
        matrix[index] = '/';
        boolean res = dfs(matrix, str, i + 1, j, k+1) || dfs(matrix, str, i - 1, j, k+1)
                || dfs(matrix, str, i, j + 1, k+1) || dfs(matrix, str, i, j - 1, k+1);
        matrix[index] = tmp;
        return res;
    }
}
