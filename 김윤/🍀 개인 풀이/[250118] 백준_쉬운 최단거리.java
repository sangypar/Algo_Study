package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	
	static class Point {
		int r;
		int c;
		int v;
		
		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					bfs(i, j);
					break out;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) map[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M-1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(map[i][M-1]);
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, 0));
		map[r][c] = 0;
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				int nv = point.v;
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && map[nr][nc] != 0) {
					queue.offer(new Point(nr, nc, nv + 1));
					map[nr][nc] = nv + 1;
					visit[nr][nc] = true;
				}
			}
			
		}
	}
	
}
