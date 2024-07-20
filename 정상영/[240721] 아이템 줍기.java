// 실패

import java.util.*;

class Solution {

    static int[][] map;
    static int[][] dist;
    static int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[51][51];
        dist = new int[51][51];

        // 1. 지도에 네모 전부 표시
        for (int[] rect : rectangle) {
            marker(rect);
        }

        // 2. BFS로 최단 거리 찾기
        bfs(characterY, characterX, itemY, itemX);

        return dist[itemY][itemX];
    }

    public static void marker(int[] coords) {
        int c1 = Math.min(coords[0], coords[2]);
        int r1 = Math.min(coords[1], coords[3]);
        int c2 = Math.max(coords[0], coords[2]);
        int r2 = Math.max(coords[1], coords[3]);

        for (int i = c1; i <= c2; i++) {
            map[r1][i] = 1;
            map[r2][i] = 1;
        }

        for (int i = r1; i <= r2; i++) {
            map[i][c1] = 1;
            map[i][c2] = 1;
        }
    }

    public static void bfs(int startR, int startC, int endR, int endC) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 51; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        dist[startR][startC] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];

                if (nr >= 0 && nr < 51 && nc >= 0 && nc < 51 && map[nr][nc] == 1 && dist[nr][nc] > dist[currR][currC] + 1) {
                    queue.add(new int[]{nr, nc});
                    dist[nr][nc] = dist[currR][currC] + 1;
                }
            }
        }
    }
}
