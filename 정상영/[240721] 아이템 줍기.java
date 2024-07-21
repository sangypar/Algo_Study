/*
테스트 1 〉	통과 (0.26ms, 76.2MB)
테스트 2 〉	통과 (0.19ms, 78.3MB)
테스트 3 〉	통과 (0.26ms, 78.8MB)
테스트 4 〉	통과 (0.18ms, 71MB)
테스트 5 〉	통과 (0.17ms, 74.3MB)
테스트 6 〉	통과 (0.17ms, 71.8MB)
테스트 7 〉	통과 (0.22ms, 76.1MB)
테스트 8 〉	통과 (0.23ms, 75.7MB)
테스트 9 〉	통과 (0.56ms, 76.1MB)
테스트 10 〉	통과 (0.55ms, 75.3MB)
테스트 11 〉	통과 (0.68ms, 65.7MB)
테스트 12 〉	통과 (0.53ms, 73.2MB)
테스트 13 〉	통과 (0.95ms, 75.2MB)
테스트 14 〉	통과 (0.47ms, 76.5MB)
테스트 15 〉	통과 (0.23ms, 75.8MB)
테스트 16 〉	통과 (0.44ms, 73.3MB)
테스트 17 〉	통과 (0.70ms, 80.2MB)
테스트 18 〉	통과 (0.61ms, 72.3MB)
테스트 19 〉	통과 (1.01ms, 77.7MB)
테스트 20 〉	통과 (0.84ms, 71.7MB)
테스트 21 〉	통과 (0.72ms, 78MB)
테스트 22 〉	통과 (0.34ms, 78.9MB)
테스트 23 〉	통과 (0.52ms, 75.1MB)
테스트 24 〉	통과 (0.70ms, 74.7MB)
테스트 25 〉	통과 (0.23ms, 74.3MB)
테스트 26 〉	통과 (0.27ms, 79.3MB)
테스트 27 〉	통과 (0.40ms, 78.1MB)
테스트 28 〉	통과 (0.26ms, 78MB)
테스트 29 〉	통과 (0.31ms, 83.7MB)
테스트 30 〉	통과 (0.28ms, 76.2MB)
*/

import java.util.*;

class Solution {

    static int[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];

        // 1. 지도에 네모 전부 표시
        for(int[] rect : rectangle) {
            marker(rect);
        }

        // 2. BFS로 최단 거리 찾기
        return bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
    }

    public static void marker(int[] coords) {
        int c1 = coords[0] * 2;
        int r1 = coords[1] * 2;
        int c2 = coords[2] * 2;
        int r2 = coords[3] * 2;

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (r == r1 || r == r2 || c == c1 || c == c2) {
                    if (map[r][c] == -1) continue;
                    map[r][c] = 1;
                } else {
                    map[r][c] = -1;
                }
            }
        }
    }
    
    public static int bfs(int startR, int startC, int endR, int endC) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];

        queue.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = curr[2];

            if(currR == endR && currC == endC) {
                return currDist / 2;
            }

            for(int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];

                if(nr >= 0 && nr < 101 && nc >= 0 && nc < 101 && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, currDist + 1});
                }
            }
        }
        return -1;
    }

    
}
