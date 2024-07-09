import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class psy_로봇 {
	static List<Character> result;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static char[][] arr;
	static int H, W;
	static int resR, resC;
	static char dire;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new char[H][W];
		char[] dir = { '>', 'v', '<', '^' };

		int count = 0;
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < W; c++) {
				arr[r][c] = str.charAt(c);
				if (arr[r][c] == '#')
					count++;
			}
		}

		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (arr[r][c] == '#') {
					for (int d = 0; d < 4; d++) {
						result = new ArrayList<>();
						visited = new boolean[H][W];
						visited[r][c] = true;
						resR = r + 1;
						resC = c + 1;
						dire = dir[d];
						dfs(r, c, d, -1, count - 1);
					}
				}
			}
		}

	}

	private static void dfs(int r, int c, int d, int time, int count) {
		if (!flag) {
			if (count == 0) {
				System.out.println(resR + " " + resC);
				System.out.println(dire);
				for (int i = 0; i < result.size(); i++)
					System.out.print(result.get(i));
				flag = true;
				return;
			}

			if (time == 1) {
				result.add('L');
				dfs(r, c, d - 1 < 0 ? 3 : d - 1, 2, count);
				result.remove(result.size() - 1);
				result.add('R');
				dfs(r, c, d + 1 > 3 ? 0 : d + 1, 3, count);
				result.remove(result.size() - 1);

			}
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nnr = r + 2 * dr[d];
			int nnc = c + 2 * dc[d];
			if ((nnr >= 0 && nnc >= 0 && nnr < H && nnc < W) && !visited[nr][nc] && !visited[nnr][nnc]
					&& arr[nr][nc] == '#' && arr[nnr][nnc] == '#') {
				result.add('A');
				visited[nr][nc] = true;
				visited[nnr][nnc] = true;
				dfs(nnr, nnc, d, 1, count - 2);
				visited[nr][nc] = false;
				visited[nnr][nnc] = false;
				result.remove(result.size() - 1);
			}
		}
	}
}
