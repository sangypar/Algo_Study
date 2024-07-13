import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_14500_테트로미노 {
	static int[][] arr; // 종이
	static boolean[][] visited; // 방문체크
	static int result, N, M; // 결과, 세로, 가로
	static int[] dr = { -1, 1, 0, 0 }; // 델타배열
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) { // 종이 입력
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, 0, arr[r][c]); // 4칸 탐색
				visited[r][c] = false;

				int min = 9999; // ㅗ모양 탐색 -> +에서 한칸 빼주기
				int sum = arr[r][c];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
						min = Math.min(min, arr[nr][nc]);
						sum += arr[nr][nc];
					} else {
						min = 0;
					}
				}
				result = Math.max(result, sum - min);
			}
		}

		System.out.println(result);
	}

	private static void dfs(int r, int c, int count, int sum) {
		if (count == 3) {
			result = Math.max(result, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, count + 1, sum + arr[nr][nc]);
				visited[nr][nc] = false;
			}
		}

	}
}
