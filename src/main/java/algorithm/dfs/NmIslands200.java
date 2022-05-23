package algorithm.dfs;

/**
 * 200. 岛屿数量
 * 解题思路
 * 1.深度优先搜索
 * 2.先找到一个陆地节点
 * 3.递归的向四周寻找新的陆地
 * 4.找到就标记成0,变探索边污染
 * 5.当周围都是0，就代表这个岛已经找完了
 * 6.接着遍历矩阵，找下一块陆地，重复dfs
 */
public class NmIslands200 {
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {//越过边界
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        //将已经找到的陆地标记为海洋，防止重复经过
        grid[i][j] = '0';

        //向四处寻找新的陆地
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
