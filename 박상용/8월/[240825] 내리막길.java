import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_1520_내리막길 {
	static int M, N;
	static int[][] arr, visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new int[M][N];

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				visited[r][c] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1)
			return 1;

		if (visited[r][c] == -1) {
			visited[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;

				if (arr[r][c] > arr[nr][nc]) {
					visited[r][c] += dfs(nr, nc);
				}
			}
		}
		return visited[r][c];
	}
}