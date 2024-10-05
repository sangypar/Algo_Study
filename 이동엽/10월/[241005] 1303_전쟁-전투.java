package boj;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main1303 {

    static int N, M;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 가로
        M = sc.nextInt(); // 세로
        visited = new boolean[M][N];
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int white = 0;
        int blue = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int count = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        white += count * count;
                    } else {
                        blue += count * count;
                    }
                }
            }
        }
        System.out.println(white + " " + blue);
        sc.close();
    }

    static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && !visited[nx][ny] && map[nx][ny] == team) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
