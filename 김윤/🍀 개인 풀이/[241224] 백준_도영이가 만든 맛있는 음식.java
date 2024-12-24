package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	static int N;
	static int[][] food;
	static int[] select;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			select = new int[i];
			backtrack(0, 0);
		}
		
		System.out.println(min);
	}
	
	static void backtrack(int idx, int sidx) {
		if (sidx == select.length) {
			int sour = 1;
			int bitter = 0;
			
			for (int i = 0; i < select.length; i++) {
				sour *= food[select[i]][0];
				bitter += food[select[i]][1];
			}

			int diff = Math.abs(sour - bitter);
			min = Math.min(min, diff);
			return;
		}
		
		if (idx == N) return;
		
		select[sidx] = idx;
		backtrack(idx + 1, sidx + 1);
		backtrack(idx + 1, sidx);
	}
}
