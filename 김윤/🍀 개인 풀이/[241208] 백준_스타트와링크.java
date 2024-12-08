package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	
	static int N;
	static int[][] team;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);

		System.out.println(min);
	}
	
	static void combination(int idx, int sidx) {
		if (sidx == N/2) {
			calculate();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combination(i + 1, sidx + 1);
				visit[i] = false;
			}
		}
	}
	
	static void calculate() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i] && visit[j]) start += team[i][j];
				else if (!visit[i] && !visit[j]) link += team[i][j];
			}
		}
		
		min = Math.min(min, Math.abs(start - link));
	}

}
