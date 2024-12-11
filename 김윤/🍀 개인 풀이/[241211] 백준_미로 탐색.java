package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	
	static int N, M;
	static int[][] maze;
	static boolean[][] visit;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				maze[i][j] = temp.charAt(j) - '0';
			}
		}
		
		System.out.println(BFS(0, 0));
	}
	
	static int BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && maze[nr][nc] == 1 && !visit[nr][nc]) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
					
					maze[nr][nc] = maze[point.r][point.c] + 1;
				}
			}
		}
		
		return maze[N - 1][M - 1];
	}
	
}
