package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	
	static boolean[][] chess;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		chess = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if (c == 'W') chess[i][j] = true;
				else chess[i][j] = false;
			}
		}
		
		for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
	}
	
	static void find(int x, int y) {
		int countWhite = 0;
		int countBlack = 0;
		
		boolean firstColor = chess[x][y];
		
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if ((i + j) % 2 == 0) {
					if (chess[i][j] != firstColor) countWhite++;
					else countBlack++;
				} else {
					if (chess[i][j] == firstColor) countWhite++;
					else countBlack++;
				}
			}
		}
		
		min = Math.min(min, countWhite);
		min = Math.min(min, countBlack);
	}
	
}
