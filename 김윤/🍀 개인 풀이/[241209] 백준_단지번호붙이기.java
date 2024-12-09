package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	static List<Integer> home = new ArrayList<>();
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;

		public Point(int r,int  c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visit[r][c]) {
					count = 0;
					BFS(r, c);
					home.add(count);
				}
			}
		}
		
		Collections.sort(home);
		
		System.out.println(home.size());
		for (int homeCount : home) {
			System.out.println(homeCount);
		}
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visit[r][c] = true;
		count++;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !visit[nr][nc]) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
					count++;
				}
			}
		}
	}
	
}
