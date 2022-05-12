import java.util.Arrays;

public class LC_174 {
    int[][] memo;
    int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 备忘录中都初始化为 -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, 0, 0);
    }

    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m-1 && j==n-1){
            return grid[i][j] >= 0 ?1: -grid[i][j] +1;
        }
        if (i == m || j==n){
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = Math.min(
                dp(grid,i,j+1),
                dp(grid,i+1,j)
        )-grid[i][j];
        memo[i][j] = res <=0? 1: res;
        return memo[i][j];
    }
}
