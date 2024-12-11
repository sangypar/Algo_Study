package baekjoon_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {

	static int[][] world;
	static int H, W;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		world = new int[H + 1][W]; // 2차원세계
		// 젤 밑은 어차피 막히는 거 보려고

		st = new StringTokenizer(br.readLine());

		for (int c = 0; c < W; c++) {
			int block = Integer.parseInt(st.nextToken()); // 현재 쌓이는 블록 높이

			for (int r = H - 1; r > H - 1 - block; r--) {
				world[r][c] = 1; // 1로 채워줌
			}

			world[H][c] = 1; // 제일 밑 바닥은 1로 깔아둠
		} // 벽세우기

		int rain = 0; // 빗물용량 세어주기

		for (int r = H - 1; r >= 0; r--) {
			for (int c = 1; c < W - 1; c++) {
				// c의 경계선에는 빗물이 고일 수 없음 다 흘러내림

				if (world[r][c] == 0) {
					// 빗물이 들어갈 공간이 있을 때
					if ((world[r + 1][c] == 1) && check(r, c)) {
						// 아래에 막힌 곳이 있고, 내 왼쪽 또는 오른쪽이 막혀있따면(또는 물로차있다면)
						world[r][c] = 1; // 1로 바꾸고
						rain++; // 빗물 더해줘
					}
				}
			}
		} // 다 돌아

		System.out.println(rain);

	}

	private static boolean check(int r, int c) {

		int count = 0; // 양옆에 벽이 있는 개수

		for (int nc = 0; nc < c; nc++) {
			if (world[r][nc] == 1) {
				count++;
				break;
			}
		}

		for (int nc = c + 1; nc < W; nc++) {
			if (world[r][nc] == 1) {
				count++;
				break;
			}
		}
		
		if(count == 2) return true;

		return false;
	}
}
