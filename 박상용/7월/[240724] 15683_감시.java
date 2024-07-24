import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class psy_15683_감시 {
	static class Cctv {
		int r;
		int c;
		int num;
		int d;

		public Cctv(int r, int c, int num, int d) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.d = d;
		}

	}

	static List<Cctv> list;
	static List<Cctv> list5;
	static int[][] copy;
	static int N, M;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>();
		list5 = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (arr[r][c] >= 1 && arr[r][c] <= 4)
					list.add(new Cctv(r, c, arr[r][c], 0));
				else if (arr[r][c] == 5)
					list5.add(new Cctv(r, c, 5, 0));
			}
		}
		comb(0);
		System.out.println(result);

	}

	private static void comb(int i) {
		if (i == list.size()) {
			cal();
			return;
		}

		for (int d = 0; d < 4; d++) {
			list.get(i).d = d;
			comb(i + 1);
		}
	}

	private static void cal() {
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, copy[i], 0, M);
		}

		for (int i = 0; i < list5.size(); i++) {
			for (int d = 0; d < 4; d++) {
				check(list5.get(i).r, list5.get(i).c, d);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int dir = list.get(i).d;
			if (list.get(i).num == 1)
				check(list.get(i).r, list.get(i).c, dir);
			else if (list.get(i).num == 2) {
				check(list.get(i).r, list.get(i).c, dir);
				check(list.get(i).r, list.get(i).c, dir % 2 == 0 ? dir + 1 : dir - 1);
			} else if (list.get(i).num == 3) {
				check(list.get(i).r, list.get(i).c, dir);
				if (dir == 0)
					check(list.get(i).r, list.get(i).c, 2);
				else if (dir == 1)
					check(list.get(i).r, list.get(i).c, 3);
				else if (dir == 2)
					check(list.get(i).r, list.get(i).c, 1);
				else if (dir == 3)
					check(list.get(i).r, list.get(i).c, 0);
			} else if (list.get(i).num == 4) {
				check(list.get(i).r, list.get(i).c, dir);
				check(list.get(i).r, list.get(i).c, (dir + 1) % 4);
				check(list.get(i).r, list.get(i).c, (dir + 2) % 4);
			}
		}

		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == 0) {
					count++;
				}
			}
		}

		result = Math.min(result, count);
	}

	private static void check(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || copy[nr][nc] == 6)
				break;
			if (copy[nr][nc] == 0)
				copy[nr][nc] = -1;
		}

	}
}
