import java.util.*;

class Solution_아이템줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 1) continue;
                        map[i][j] = 2;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];

            if (x == itemX * 2 && y == itemY * 2) return cnt / 2;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < 101 && 0 <= ny && ny < 101 && !visited[nx][ny] && map[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}
//테스트 1 〉	통과 (0.25ms, 69.6MB)
//테스트 2 〉	통과 (0.15ms, 71.7MB)
//테스트 3 〉	통과 (0.27ms, 75.8MB)
//테스트 4 〉	통과 (0.25ms, 71.6MB)
//테스트 5 〉	통과 (0.33ms, 78MB)
//테스트 6 〉	통과 (0.25ms, 85MB)
//테스트 7 〉	통과 (0.31ms, 81.3MB)
//테스트 8 〉	통과 (0.22ms, 72.2MB)
//테스트 9 〉	통과 (0.55ms, 78.3MB)
//테스트 10 〉	통과 (0.71ms, 72.6MB)
//테스트 11 〉	통과 (0.89ms, 66.9MB)
//테스트 12 〉	통과 (0.55ms, 75MB)
//테스트 13 〉	통과 (0.73ms, 77.2MB)
//테스트 14 〉	통과 (0.47ms, 73.7MB)
//테스트 15 〉	통과 (0.29ms, 78.9MB)
//테스트 16 〉	통과 (0.58ms, 80.7MB)
//테스트 17 〉	통과 (0.66ms, 75.4MB)
//테스트 18 〉	통과 (0.56ms, 72.3MB)
//테스트 19 〉	통과 (0.84ms, 67.9MB)
//테스트 20 〉	통과 (0.98ms, 74.4MB)
//테스트 21 〉	통과 (0.66ms, 75.9MB)
//테스트 22 〉	통과 (0.51ms, 70.8MB)
//테스트 23 〉	통과 (0.49ms, 73MB)
//테스트 24 〉	통과 (0.71ms, 79.6MB)
//테스트 25 〉	통과 (0.31ms, 76.9MB)
//테스트 26 〉	통과 (0.35ms, 81MB)
//테스트 27 〉	통과 (0.49ms, 76.4MB)
//테스트 28 〉	통과 (0.46ms, 72.5MB)
//테스트 29 〉	통과 (0.50ms, 89.3MB)
//테스트 30 〉	통과 (0.44ms, 74.3MB)