import java.util.Scanner;

// 백준14500, 테트로미노, GOLD IV
// ㅏ ㅓ ㅗ ㅜ 말고 다른 모양이 DFS 모든 경우의 수라서
// DFS 돌리고 ㅏ ㅓ ㅗ ㅜ 도 계산해서 구해주기
public class Main_14500 {

    static int n, m, paper[][], max;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        max = -1;
        // 모든 위치에서 dfs 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 1, paper[i][j]);
                ohOoh(i, j);
            }
        }

        System.out.println(max);
        sc.close();
    }

    static void dfs(int x, int y, int idx, int sum) {
        if (idx == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                dfs(nx, ny, idx + 1, sum + paper[nx][ny]);
            }
        }

        visited[x][y] = false;
    }

    static void ohOoh(int x, int y) {
        if (x + 2 < n && y + 1 < m) { // ㅏ
            int temp1 = paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y + 1];
            max = Math.max(max, temp1);
        }

        if (x + 2 < n && y - 1 >= 0) { // ㅓ
            int temp2 = paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y - 1];
            max = Math.max(max, temp2);
        }

        if (x - 1 >= 0 && y + 2 < m) { // ㅗ
            int temp3 = paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x - 1][y + 1];
            max = Math.max(max, temp3);
        }

        if (x + 1 < n && y + 2 < m) { // ㅜ
            int temp4 = paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1];
            max = Math.max(max, temp4);
        }
    }


}
