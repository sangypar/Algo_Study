package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	
	static int w, h;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
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
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visit = new boolean[h][w];
			count = 0;
			
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visit[r][c] && map[r][c] == 1) {
						BFS(r, c);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 8; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visit[nr][nc] && map[nr][nc] == 1) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
