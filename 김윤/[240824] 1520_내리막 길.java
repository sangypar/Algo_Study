package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {
	
	static int M;
	static int N;
	static int[][] map;
	static int[][] visit;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new int[M][N];
		
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				visit[r][c] = -1; // 아직 방문 안했을 때
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int r, int c) {
		if (r == M-1 && c == N-1) return 1; // 도착
		if (visit[r][c] != -1) return visit[r][c]; // 중복 계산 방지
		
		visit[r][c] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
				visit[r][c] += dfs(nr, nc);
			}
		}
		
		return visit[r][c];
	}
	
}
