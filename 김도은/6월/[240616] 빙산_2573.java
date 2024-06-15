package baekjoon_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산_2573 {

	static int N, M;
	static int[][] ice;
	static boolean[][] visit;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 }; // 4방향 델타배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		ice = new int[N][M]; // 빙산2차원배열

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				ice[r][c] = Integer.parseInt(st.nextToken()); // 하나씩 숫자 넣어주기
			}
		}

		int year = 0; // 시작년도

		while (true) {
			// 빙하가 1개보다 작거나 같다면... 아래를 돌아줘
			int count = 0; // 일단 빙하가 한 덩어리로 시작

			int[][] findzero = new int[N][M]; // 주변에 0인거 찾을 배열

			// 우선 ice배열을 돌면서 주변이 0인애들을 개수를 r c에 저장해준다
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (ice[r][c] != 0) {
						for (int d = 0; d < 4; d++) {
							if (ice[r + dr[d]][c + dc[d]] == 0) {
								findzero[r][c]++; // 하나씩 증가
							}
						}
					}
				}
			} // 0인개수 저장끝

			// 그러면 이제 zero개수만큼 ice에서 빼줌
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (ice[r][c] != 0) {
						ice[r][c] -= findzero[r][c];

						if (ice[r][c] < 0)
							ice[r][c] = 0; // 0보다 작으면 0으로 맞춰줌
					}
				}
			}
			
//			System.out.println("---------------------------------");
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.print(ice[r][c]);
//				}
//				System.out.println();
//			}
			
			year++; // 1년 증가

			visit = new boolean[N][M]; // 방문쳌

			// 빙하 덩어리 수 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (ice[r][c] != 0 && !visit[r][c]) {
						DFS(r, c);
						count++;
						if (count > 1) {
							// 두 개 이상으로 나뉘어진 것
							System.out.println(year);
							return;
						}
					}
				}
			} // 확인 끝

			if (count == 0) {
				System.out.println(0);
				return;
			}
		} // while 문
	}

	private static void DFS(int r, int c) {

		if (r < 0 || r >= N || c < 0 || c >= M || visit[r][c] || ice[r][c] == 0) {
			return;
		}

		visit[r][c] = true;

		for (int d = 0; d < 4; d++) {
			DFS(r + dr[d], c + dc[d]);
		}

	}
}
