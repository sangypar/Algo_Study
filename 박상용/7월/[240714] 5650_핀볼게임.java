import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_5650_핀볼게임 {
	static int[] dr = { -1, 1, 0, 0 }; // 델타배열
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int[][] arr;
	static int startR, startC, result;
	static boolean flag;
	static Portal[][] port;

	static class Portal {
		int r;
		int c;
		boolean check;

		public Portal(int r, int c, boolean check) {
			this.r = r;
			this.c = c;
			this.check = check;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			port = new Portal[11][2];

			for (int r = 0; r < 11; r++) {
				for (int c = 0; c < 2; c++) {
					port[r][c] = new Portal(0, 0, false);
				}
			}

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					if (arr[r][c] >= 6) {
						if (!port[arr[r][c]][0].check) {
							port[arr[r][c]][0] = new Portal(r, c, true);
						} else {
							port[arr[r][c]][1] = new Portal(r, c, true);
						}
					}
				}
			}
			result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 0) {
						for (int d = 0; d < 4; d++) {
							startR = r;
							startC = c;
							flag = false;
							move(r, c, 0, d, 0);
						}
					}
				}
			}

			System.out.println("#" + i + " " + result);

		}
	}

	private static void move(int r, int c, int score, int d, int count) {
		if (!flag) {

			if (((r == startR && c == startC) || arr[r][c] == -1) && count != 0) {
				result = Math.max(result, score);
				flag = true;
				return;
			}

			int nr = r + dr[d];
			int nc = c + dc[d];

//			System.out.println(r+" "+c+" "+nr+" "+nc +" "+ d);
			if (nr >= N || nc >= N || nr < 0 || nc < 0) {
				move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
			} else if (arr[nr][nc] == 1) {
				if (d == 1 || d == 2) {
					move(nr, nc, score + 1, d == 1 ? 2 : 1, count + 1);
				} else {
					move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
				}

			} else if (arr[nr][nc] == 2) {
				if (d == 0 || d == 2) {
					move(nr, nc, score + 1, d == 0 ? 2 : 0, count + 1);
				} else {
					move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
				}
			} else if (arr[nr][nc] == 3) {
				if (d == 0 || d == 3) {
					move(nr, nc, score + 1, d == 0 ? 3 : 0, count + 1);
				} else {
					move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
				}
			} else if (arr[nr][nc] == 4) {
				if (d == 1 || d == 3) {
					move(nr, nc, score + 1, d == 1 ? 3 : 1, count + 1);
				} else {
					move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
				}
			} else if (arr[nr][nc] == 5) {
				move(r, c, score + 1, d % 2 == 0 ? d + 1 : d - 1, count + 1);
			} else if (arr[nr][nc] >= 6 && arr[nr][nc] <= 10) {
				System.out.println(port[arr[nr][nc]][1].c); // 1번
				if (port[arr[nr][nc]][0].r == nr && port[arr[nr][nc]][0].c == nc) {
					nr = port[arr[nr][nc]][1].r;
					nc = port[arr[nr][nc]][1].c;
					System.out.println(port[arr[nr][nc]][1].c); // 2번
				} else {
					nr = port[arr[nr][nc]][0].r;
					nc = port[arr[nr][nc]][0].c;
				}
				System.out.println(nr+" "+nc+" "+d);
				move(nr, nc, score, d, count + 1);
			}
		}
	}
}
