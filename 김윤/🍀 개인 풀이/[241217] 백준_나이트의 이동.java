package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
	
	static int N;
	static int[][] board;
	static boolean[][] visit;
	static int sr, sc, fr, fc;
	
	static int[] dr = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static class Point {
		int r;
		int c;
		int p;
		
		public Point(int r, int c, int p) {
			this.r = r;
			this.c = c;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visit = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			fr = Integer.parseInt(st.nextToken());
			fc = Integer.parseInt(st.nextToken());
			
			System.out.println(BFS(sr, sc));
		}
	}
	
	static int BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, 0));
		visit[r][c] = true;
		
		int count = 0;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			if (point.r == fr && point.c == fc) {
				count = point.p;
				break;
			}
			
			for (int d = 0; d < 8; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				int np = point.p + 1;
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
					queue.offer(new Point(nr, nc, np));
					visit[nr][nc] = true;
				}
			}
		}
		
		return count;
	}
	
}
