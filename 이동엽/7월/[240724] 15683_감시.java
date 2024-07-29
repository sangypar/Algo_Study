import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m, min, map[][];
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static List<Cctv> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    list.add(new Cctv(i, j, map[i][j]));
                }
            }
        }

        min = n * m;
        dfs(0, map);

        System.out.println(min);
        sc.close();
    }

    static void dfs(int idx, int[][] map) {
        if (idx == list.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        Cctv cctv = list.get(idx);
        int x = cctv.x;
        int y = cctv.y;
        int type = cctv.type;

        int[][] copied = new int[n][m];
        copyMap(map, copied);

        for (int i = 0; i < Cctv.directions[type].length; i++) {
            int[][] temp = new int[n][m];
            copyMap(map, temp);
            int[] direction = Cctv.directions[type][i];

            inScope(x, y, direction, temp);

            dfs(idx + 1, temp);
        }
    }
    // 감시
    static void inScope(int x, int y, int[] direction, int[][] temp) {
        for (int d : direction) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || temp[nx][ny] == 6) {
                    break;
                }
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = -1; // 감시 되면 -1
                }
            }
        }
    }

    static void copyMap(int[][] original, int[][] copied) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copied[i][j] = original[i][j];
            }
        }
    }

    static class Cctv {
        int x, y, type;
        static int[][][] directions = {
                {},
                {{0}, {1}, {2}, {3}}, // 1
                {{0, 2}, {1, 3}}, //  2
                {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3
                {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4
                {{0, 1, 2, 3}} // 5
        };

        public Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
