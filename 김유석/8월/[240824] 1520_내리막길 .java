import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_27_2110_공유기설치 {
	private static int[][] arr;
	private static int[][] memo;
	private static int x;
	private static int y;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		arr = new int[x][y];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memo = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				memo[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	private static int dfs(int curX, int curY) {
		if (curX == x - 1 && curY == y - 1) {
			return 1;
		}

		if (memo[curX][curY] != -1) {
			return memo[curX][curY];
		}

		int pathCount = 0;

		for (int k = 0; k < 4; k++) {
			int nextX = curX + dx[k];
			int nextY = curY + dy[k];

			if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y) {
				if (arr[curX][curY] > arr[nextX][nextY]) {
					pathCount += dfs(nextX, nextY);
				}
			}
		}
		memo[curX][curY] = pathCount;
		return pathCount;
	}
}
