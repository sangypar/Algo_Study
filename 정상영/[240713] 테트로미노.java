import java.util.*;

public class BJ14500_테트로미노 {

    static int n, m, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = Integer.MIN_VALUE;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                // T자 제외한 모양
                select(r, c, 0, 0);
                // T자 모양
                tShape(r, c);
            }
        }

        System.out.println(ans);
    }

    static void select(int r, int c, int cnt, int point) {
        // basecase
        if(cnt == 4) {
            ans = Math.max(point, ans);
            return;
        }

        visited[r][c] = true;
        point += map[r][c];

        // recursive
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {

                select(nr, nc, cnt + 1, point);
            }
        }

        visited[r][c] = false;
    }

    static void tShape(int r, int c) {
        int[][] arr = {
                {0, -1, 0, -1, 0, 1},
                {-1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, -1},
                {1, 0, -1, 0, -1, 0}
        };

        for(int d = 0; d < 4; d++) {
            int sum = map[r][c];
            int cnt = 0;

            for(int i = 0; i < 3; i++) {
                int nr = r + arr[d][i];
                int nc = c + arr[d][i + 3];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) break;
                else {
                    sum += map[nr][nc];
                    cnt++;
                }

                if(cnt == 3) ans = Math.max(ans, sum);
            }
        }
    }
}
