package baekjoon_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {

	static int max;
	static int[][] tetro;
	static int N, M;
	static boolean[][] visit;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tetro = new int[N][M]; // 테트로 판

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				tetro[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료

		max = 0;
		visit = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visit[r][c] = true;
				dfs(r, c, tetro[r][c], 1);
				visit[r][c] = false;
			}
		}
		
		System.out.println(max);

	}

	private static void dfs(int startR, int startC, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			// 4개의 테트로미노를 다 채우면 멈춰~!
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nextR = startR + dr[d];
			int nextC = startC + dc[d]; // 다음좌표

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
				// 범위체크
				continue;
			}

			if (!visit[nextR][nextC]) {
				
				if(count == 2) {
					//두번째 좌표일 때 한가지 길을 더 가봐야해
					visit[nextR][nextC] = true; // 방문체크
					dfs(startR, startC, sum + tetro[nextR][nextC], count + 1); //다음거
					////내가 놓친 부분: 무조건 next로 하면 안됨 그전걸로 돌아가서 가지를 벌리는거라서 첨 받은 좌표대로 다시 해야함
					visit[nextR][nextC] = false;
				}

				visit[nextR][nextC] = true; // 방문체크
				dfs(nextR, nextC, sum + tetro[nextR][nextC], count + 1); //다음거
				visit[nextR][nextC] = false;
			}
		}
	}
}
