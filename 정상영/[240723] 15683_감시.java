import java.util.*;

public class BJ15683_감시 {

    static int n, m, ans;
    static int[][] map;
    static List<int[]> cctv;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        cctv = new ArrayList<>();

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                int input = sc.nextInt();

                if(1 <= input && input <= 5) {
                    cctv.add(new int[] {r, c});
                }
                map[r][c] = input;
            }
        }

        boolean[][] visited = new boolean[n][m];
        ans = Integer.MAX_VALUE;

        dfs(0, visited);

        System.out.println(ans);
    }

    public static void dfs(int idx, boolean[][] visited) {
        // basecase
        if(idx == cctv.size()) {
            calc(visited);
            return;
        }

        // recursive
        int[] curr = cctv.get(idx);
        int currR = curr[0];
        int currC = curr[1];

        boolean[][] newVisited;

        switch (map[currR][currC]) {
            case 1:
                for(int d = 0; d < 4; d++) {
                    newVisited = copyArray(visited);
                    monitor(currR, currC, d, newVisited);
                    dfs(idx + 1, newVisited);
                }
                break;

            case 2:
                for(int d = 0; d < 2; d++) {
                    newVisited = copyArray(visited);
                    monitor(currR, currC, d, newVisited);
                    monitor(currR, currC, (d + 2) % 4, newVisited);
                    dfs(idx + 1, newVisited);
                }
                break;

            case 3:
                for(int d = 0; d < 4; d++) {
                    newVisited = copyArray(visited);
                    monitor(currR, currC, d, newVisited);
                    monitor(currR, currC, (d + 1) % 4, newVisited);
                    dfs(idx + 1, newVisited);
                }
                break;

            case 4:
                for(int d = 0; d < 4; d++) {
                    newVisited = copyArray(visited);
                    monitor(currR, currC, d, newVisited);
                    monitor(currR, currC, (d + 1) % 4, newVisited);
                    monitor(currR, currC, (d + 2) % 4, newVisited);
                    dfs(idx + 1, newVisited);
                }
                break;

            case 5:
                newVisited = copyArray(visited);
                for(int d = 0; d < 4; d++) {
                    monitor(currR, currC, d, newVisited);
                }
                dfs(idx + 1, newVisited);
                break;
        }
    }

    public static void monitor(int r, int c, int d, boolean[][] visited) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        while(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 6) {
            if (map[nr][nc] == 0) {
                visited[nr][nc] = true;
            }
            nr += dr[d];
            nc += dc[d];
        }
    }

    public static void calc(boolean[][] visited) {
        int cnt = 0;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(!visited[r][c] && map[r][c] == 0) cnt++;
            }
        }

        ans = Math.min(ans, cnt);
    }

    public static boolean[][] copyArray(boolean[][] array) {
        boolean[][] newArray = new boolean[array.length][array[0].length];
        for(int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, array[0].length);
        }
        return newArray;
    }
}
