package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int max = 1;
	static int count;
	static int height;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(height, map[i][j]);
			}
		}
		
		for (int h = 1; h <= height; h++) {
			count = 0;
			visit = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visit[r][c] && map[r][c] > h) {
						BFS(r, c, h);
						count++;
					}
				}
			}
			
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	static void BFS(int r, int c, int h) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc] && map[nr][nc] > h) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
