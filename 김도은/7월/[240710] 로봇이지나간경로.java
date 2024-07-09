package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇이지나간경로 {

	static int H, W;
	static char[][] robot;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visit;
	static StringBuilder sb;
	static int currentDirection; // 현재방향

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken()); // 행
		W = Integer.parseInt(st.nextToken()); // 열

		robot = new char[H][W]; // 로봇의 배열

		for (int r = 0; r < H; r++) {
			String str = br.readLine();
			for (int c = 0; c < W; c++) {
				robot[r][c] = str.charAt(c); // 하나씩 넣어주기
			}
		} // 입력완

		int startR = 0;
		int startC = 0; // 시작하는 좌표

		sb = new StringBuilder();

		// 시작점 찾기
		out: for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (robot[r][c] == '#') {
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < H && nc >= 0 && nc < W && robot[nr][nc] == '#') {
							count++;
						}
					}
					if (count == 1) { // 시작점 조건
						startR = r;
						startC = c;
						break out;
					}
				}
			}
		}

		sb = new StringBuilder();
		sb.append((startR + 1) + " " + (startC + 1) + "\n"); // 시작좌표 출력

		currentDirection = 0; // 현재 진행방향 체크

		// 다음 방향 설정
		for (int d = 0; d < 4; d++) {
			int nr = startR + dr[d];
			int nc = startC + dc[d];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && robot[nr][nc] == '#') {

				currentDirection = d; // 지금 진행방향을 체크해야함

				if (d == 0)
					sb.append('v' + "\n");
				else if (d == 1)
					sb.append('^' + "\n");
				else if (d == 2)
					sb.append('>' + "\n");
				else
					sb.append('<' + "\n");
				break;
			}
		}

		visit = new boolean[H][W];
		dfs(startR, startC);

		System.out.println(sb);

	}

	private static void dfs(int startR, int startC) {

		if (visit[startR][startC] || startR < 0 || startC < 0 || startR >= H || startC >= W) {
			// 방문한적이 있거나, 배열을 벗어난다면 즉시 리턴
			return;
		}

		visit[startR][startC] = true;

		for (int d = 0; d < 4; d++) {
			int nr = startR + dr[d];
			int nc = startC + dc[d];
			int doublenr = startR + 2 * dr[d];
			int doublenc = startC + 2 * dc[d];

			if (nr >= 0 && nr < H && nc >= 0 && nc < W && robot[nr][nc] == '#' && !visit[nr][nc]) {
				// 다음 # 좌표를 찾았을 때
				if (currentDirection == d) {
					// 방향이 똑같다면?
					// 두번째 칸이 범위 넘는 것은 생각 x 방향이 같은데 왜넘음
					sb.append('A');
					visit[nr][nc] = true; // 중간칸 방문처리
					dfs(doublenr, doublenc); // 두칸 이동

				} else {
					// 방향이 다르다면?
					char turn = findDir(currentDirection, d);
					sb.append(turn);
					currentDirection = d;

					currentDirection = d; // 방향을 바꿔줘야해

					// 그리고 방향바꾼 후 지속
					sb.append('A');
					visit[nr][nc] = true;
					dfs(doublenr, doublenc);
				}
			}
		}

	}

	private static char findDir(int from, int to) {

		if ((from == 1 && to == 2) || (from == 2 && to == 0) || (from == 0 && to == 3) || (from == 3 && to == 1))
			return 'R';
		
		return 'L';
	}
}
