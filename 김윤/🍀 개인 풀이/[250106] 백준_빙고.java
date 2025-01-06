package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		out: for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int announce = Integer.parseInt(st.nextToken());
				
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (bingo[r][c] == announce) bingo[r][c] = 0;
					}
				}
				
				int count = 0;
				
				// 가로줄 확인
				for (int r = 0; r < 5; r++) {
					int temp = 0;
					for (int c = 0; c < 5; c++) {
						if (bingo[r][c] == 0) temp++;
					}
					
					if (temp == 5) count++;
				}
				
				// 세로줄 확인
				for (int c = 0; c < 5; c++) {
					int temp = 0;
					for (int r = 0; r < 5; r++) {
						if (bingo[r][c] == 0) temp++;
					}
					
					if (temp == 5) count++;
				}
				
				// 대각선 확인
				if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0 && bingo[4][4] == 0) {
					count++;
				}
				
				if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0 && bingo[4][0] == 0) {
					count++;
				}
				
				// 빙고 확인
				if (count >= 3) {
					System.out.println((i * 5) + (j + 1));
					break out;
				}
			}
		}
		
	}
	
}
