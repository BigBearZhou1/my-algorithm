package algorithm.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS广度遍历寻找到岛屿的数量
 * 借助队列来遍历
 * 非递归
 * 将‘1’点周围的点都加入队列
 * 如果是‘0’点就不会再向队列中加入
 * 队列为空了，就退出方法了，这次寻找就结束了
 */
public class NumIslandBFS200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i, j - 1});
                queue.offer(new int[]{i, j + 1});
            }
        }
    }
}
