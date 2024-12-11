package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길_1520 {

	static int[][] map;
	static int[][] dp;
	static int N, M;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N][M];
		dp = new int[N][M]; // dp

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = -1;
			}
		} // 입력완


		System.out.println(dfs(0, 0));

	}

	private static int dfs(int r, int c) {
		// 기저 조건: 도착점에 도달한 경우
		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		// 이미 계산한 경우 그 값을 반환
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = 0; // 방문 체크 및 경로 수 초기화

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue; // 맵을 벗어난 경우 무시

			if (map[r][c] > map[nr][nc]) {
				dp[r][c] += dfs(nr, nc); // 유효한 경로에 대해 재귀적으로 경로 수를 더함
			}
		}

		return dp[r][c]; // 최종 경로 수 반환
	}
}
