import java.util.*;

public class Main6593 {

    static int L, R, C; // 층, 행, 열
    static char[][][] map;
    static boolean[][][] visited;
    static int[][] move = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int[] start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.next();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        } else if (map[i][j][k] == 'E') {
                            end = new int[]{i, j, k};
                        }
                    }
                }
            }

            int result = escape();
            sb.append(result == -1 ? "Trapped!" : "Escaped in " + result + " minute(s).").append("\n");
        }

        System.out.print(sb);
        sc.close();
    }

    static int escape() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int z = curr[2];
            int time = curr[3];

            if (x == end[0] && y == end[1] && z == end[2]) {
                return time;
            }

            for (int i = 0; i < 6; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                int nz = z + move[i][2];

                if (isIn(nx, ny, nz) && !visited[nx][ny][nz] && map[nx][ny][nz] != '#') {
                    visited[nx][ny][nz] = true;
                    q.add(new int[]{nx, ny, nz, time + 1});
                }
            }
        }

        return -1;
    }

    static boolean isIn(int x, int y, int z) {
        return 0 <= x && x < L && 0 <= y && y < R && 0 <= z && z < C;
    }
}
