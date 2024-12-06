package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	
	static int[][] paper;
	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void divide(int r, int c, int size) {
		if (isSameColor(r, c, size)) {
			if (paper[r][c] == 0) white++;
			else blue++;
			return;
		}
		
		int newSize = size / 2;
		divide(r, c, newSize);
		divide(r + newSize, c, newSize);
		divide(r, c + newSize, newSize);
		divide(r + newSize, c + newSize, newSize);
	}
	
	static boolean isSameColor (int r, int c, int size) {
		int color = paper[r][c];
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] != color) return false;
			}
		}
		
		return true;
	}
	
}
