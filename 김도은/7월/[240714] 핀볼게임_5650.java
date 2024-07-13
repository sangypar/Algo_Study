import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 핀볼게임_5650 {

	// 하 상 우 좌
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int startR, startC; // 시작 좌표
	static int[][] game;
	static int N;
	static int max;

	static ArrayList<Point>[] worm;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케개수

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());// 맵크기
			game = new int[N][N]; // 게임판 크기
			worm = new ArrayList[11]; // 웜홀은 6부터 10까지

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					game[r][c] = Integer.parseInt(st.nextToken());

					if (game[r][c] >= 6 && game[r][c] <= 10) {
						if (worm[game[r][c]] == null) {
							worm[game[r][c]] = new ArrayList<>();
						}
						worm[game[r][c]].add(new Point(r, c));
					} // 웜홀 좌표 저장
				}
			} // 입력완

			max = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (game[r][c] == 0) {
						// 핀볼이 있을 수 있는 위치일때
						for (int d = 0; d < 4; d++) {
							// 4방향중 하나로 임의 선정 가능
							startR = r;
							startC = c;
							dfs(r, c, d, 0);
						}
					}
				}
			}

			System.out.println("#" + tc + " " + max);

		} // 테케끝
	}

	private static void dfs(int r, int c, int dir, int sum) {
		// 다음좌표
		int R = r + dr[dir];
		int C = c + dc[dir];

		// 종료
		if ((r == startR && c == startC) || (game[r][c] == -1)) {
			// 출발지점으로 되돌아오거나, 블랙홀을 만나면 종료
			max = Math.max(max, sum); // 최대점수 구하기
			return;
		}

		// 경계값을 만났을 경우
		if (R < 0 || R >= N || C < 0 || C >= N) {
			dir = changeDir(dir);
			dfs(R, C, dir, sum + 1); // 벽에 부딪혔으니까 +1점
		}

		// 하 상 우 좌
		// 가다가 블록을 만났을 경우
		if (game[R][C] == 1) {
			if (dir == 2 || dir == 1) {
				// 위로 오고잇었거나 오른쪽으로 오다 만나면 반대로
				dir = changeDir(dir);
			} else {
				if (dir == 3)
					dir = 1;
				else if (dir == 0)
					dir = 2;
			}

			dfs(R, C, dir, sum + 1); // 벽에 부딪혔으니까 +1점

		} else if (game[R][C] == 2) {
			if (dir == 0 || dir == 2) {
				dir = changeDir(dir);
			} else {
				if (dir == 1)
					dir = 2;
				else if (dir == 3)
					dir = 0;
			}
			dfs(R, C, dir, sum + 1); // 벽에 부딪혔으니까 +1점

		} else if (game[R][C] == 3) {
			if (dir == 0 || dir == 3) {
				dir = changeDir(dir);
			} else {
				if (dir == 1)
					dir = 3;
				else if (dir == 2)
					dir = 0;
			}

			dfs(R + dr[dir], C + dr[dir], dir, sum + 1); // 벽에 부딪혔으니까 +1점
		} else if (game[R][C] == 4) {
			if (dir == 0 || dir == 2) {
				dir = changeDir(dir);
			} else {
				if (dir == 1)
					dir = 2;
				else if (dir == 4)
					dir = 0;
			}

			dfs(R, C, dir, sum + 1); // 벽에 부딪혔으니까 +1점
		} else if (game[R][C] == 5) {
			dir = changeDir(dir);
			dfs(R, C, dir, sum + 1); // 벽에 부딪혔으니까 +1점
		}
		// 웜홀을 만나면
		else if (game[R][C] >= 6 && game[R][C] <= 10) {
			ArrayList<Point> wormhole = worm[game[R][C]];
			Point other;

			if (wormhole.get(0).x == R && wormhole.get(0).y == C) {
				other = wormhole.get(1);
			} else {
				other = wormhole.get(0);
			}

			dfs(other.x, other.y, dir, sum);

		} else if (game[R][C] == 0) {
			dfs(R, C, dir, sum); // 벽에 부딪혔으니까 +1점
		}
	}

	private static int changeDir(int dir) {
		// 방향 전환
		if (dir == 0)
			return 1; // 하 -> 상
		else if (dir == 1)
			return 0; // 상 -> 하
		else if (dir == 2)
			return 3; // 우 -> 좌
		else
			return 2; // 좌 -> 우
	}

}
