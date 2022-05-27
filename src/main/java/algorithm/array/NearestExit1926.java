package algorithm.array;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int ans = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dirs[j][0];
                    int ny = tmp[1] + dirs[j][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        if (entrance[0] != tmp[0] || entrance[1] != tmp[1])
                            return ans;
                    } else if (!vis[nx][ny] && maze[nx][ny] == '.') {
                        queue.offer(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
