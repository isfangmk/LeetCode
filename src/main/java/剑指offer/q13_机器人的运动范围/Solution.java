package 剑指offer.q13_机器人的运动范围;

public class Solution {

    int rows, cols;
    public int movingCount(int m, int n, int k) {
        // 临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        rows = m;
        cols = n;
        return dfs(0, 0, k, visited);


    }
    public int dfs(int i, int j, int k, boolean[][] visited) {
        if (i >= rows || j >= cols || sum(i, j) > k|| visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        // 沿着当前格子的右边和下边继续访问
        return 1 + dfs(i + 1, j, k, visited) + dfs(i, j + 1, k, visited);
    }
    public int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
