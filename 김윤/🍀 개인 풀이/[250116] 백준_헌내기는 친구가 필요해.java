package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736_헌내기는친구가필요해 {
	
	static int N;
	static int M;
	static char[][] campus;
	static boolean[][] visit;
	static int count = 0;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new char[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				campus[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (campus[i][j] == 'I') {
					bfs(i, j);
				}
			}
		}
		
		if (count == 0) System.out.println("TT");
		else System.out.println(count);
	}
	
	static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && campus[nr][nc] != 'X') {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
					
					if (campus[nr][nc] == 'P') count++;
				}
			}
		}
	}
	
}
