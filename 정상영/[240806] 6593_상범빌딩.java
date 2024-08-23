import java.util.*;

public class BJ6593_상범빌딩 {

    static int lev, row, col;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] start, end;
    static int[] dl = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            lev = sc.nextInt();
            row = sc.nextInt();
            col = sc.nextInt();

            if (lev == 0 && row == 0 && col == 0) {
                break;
            } else {
                sc.nextLine();
            }

            map = new char[lev][row][col];
            visited = new boolean[lev][row][col];

            for (int l = 0; l < lev; l++) {
                for (int r = 0; r < row; r++) {
                    map[l][r] = sc.nextLine().toCharArray();
                }
                sc.nextLine();
            }

            start = new int[3];
            end = new int[3];

            // 출발지 도착지 좌표 찾기
            for (int l = 0; l < lev; l++) {
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (map[l][r][c] == 'S') {
                            start = new int[]{l, r, c};
                        } else if (map[l][r][c] == 'E') {
                            end = new int[]{l, r, c};
                        }
                    }
                }
            }

            int result = bfs(start[0], start[1], start[2]);

            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    public static int bfs(int sl, int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sl, sr, sc, 0});
        visited[sl][sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int l = current[0];
            int r = current[1];
            int c = current[2];
            int cnt = current[3];

            // 도착점에 도달하면
            if (l == end[0] && r == end[1] && c == end[2]) {
                return cnt;
            }

            // 6가지 방향으로 이동 (위아래, 상하좌우)
            for (int d = 0; d < 6; d++) {
                int nl = l + dl[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nl >= 0 && nl < lev && nr >= 0 && nr < row && nc >= 0 && nc < col &&
                        map[nl][nr][nc] != '#' && !visited[nl][nr][nc]) {
                    visited[nl][nr][nc] = true;
                    queue.add(new int[]{nl, nr, nc, cnt + 1});
                }
            }
        }

        return -1; // 탈출 불가능한 경우
    }
}
