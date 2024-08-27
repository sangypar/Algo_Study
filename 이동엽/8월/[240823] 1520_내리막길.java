import java.util.Scanner;

// 192,684KB, 748ms
public class Main1520 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N, map[][], routes[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        routes = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                routes[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
        sc.close();
    }

    static int dfs(int i, int j) {
        if (i == M - 1 && j == N - 1) {
            return 1;
        }

        if (routes[i][j] != -1) {
            return routes[i][j];
        }

        routes[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (0 <= x && x < M && 0 <= y && y < N && map[i][j] > map[x][y]) {
                routes[i][j] += dfs(x, y);
            }
        }
        return routes[i][j];
    }
}
