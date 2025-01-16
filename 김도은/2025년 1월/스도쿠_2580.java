package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠_2580 {

	static int[][] sdoku;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sdoku = new int[9][9];

		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < 9; c++) {
				sdoku[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력

		start(0, 0); // 스도쿠 풀기

		StringBuilder sb = new StringBuilder();

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(sdoku[r][c]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static boolean start(int R, int C) {

		if (C == 9) {
			// 열이 끝나면
			return start(R+1, 0); // 다음줄로 다시 시작
		}

		if (R == 9)
			return true;
		
		if(sdoku[R][C] != 0) return start(R, C+1);

		for (int i = 1; i <= 9; i++) {
			if (check(R, C, i)) {
				sdoku[R][C] = i;
				
				if(start(R, C+1)) {
					return true;
				};
				
				sdoku[R][C] = 0;
			}
		}
		
		return false;
	}

	private static boolean check(int R, int C, int num) {

		// 가로 검사
		for (int c = 0; c < 9; c++) {
			if (sdoku[R][c] == num) {
				return false;
			}
		}

		// 세로 검사
		for (int r = 0; r < 9; r++) {
			if (sdoku[r][C] == num) {
				return false;
			}
		}

		// 정사각 검사
		int nR = R / 3 * 3;
		int nC = C / 3 * 3;

		for (int r = nR; r < nR + 3; r++) {
			for (int c = nC; c < nC + 3; c++) {
				if (sdoku[r][c] == num) {
					return false;
				}
			}
		}

		return true;
	}
}
