import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_상범빌딩 {
	static class Node {
		int l;
		int r;
		int c;
		int time;

		public Node(int l, int r, int c, int time) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dl = { -1, 1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, -1, 1 };
		out: while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			char[][][] arr = new char[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			Queue<Node> q = new LinkedList<>();

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						arr[i][j][k] = str.charAt(k);
						if (arr[i][j][k] == 'S') {
							q.add(new Node(i, j, k, 0));
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}

			int result = 0;

			while (!q.isEmpty()) {
				int oldR = q.peek().r;
				int oldC = q.peek().c;
				int oldL = q.peek().l;
				int time = q.poll().time;

				if (arr[oldL][oldR][oldC] == 'E') {
					System.out.println("Escaped in " + time + " minute(s).");
					continue out;
				}

				for (int d = 0; d < 6; d++) {
					int nr = oldR + dr[d], nc = oldC + dc[d], nl = oldL + dl[d];
					if (nr < 0 || nc < 0 || nl < 0 || nr >= R || nc >= C || nl >= L || visited[nl][nr][nc])
						continue;
					if (arr[nl][nr][nc] == '.' || arr[nl][nr][nc] == 'E') {
						visited[nl][nr][nc] = true;
						q.add(new Node(nl, nr, nc, time + 1));
					}
				}
			}
			System.out.println("Trapped!");
		}
	}
}
