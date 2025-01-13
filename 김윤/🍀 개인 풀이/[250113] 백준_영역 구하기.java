package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	
	static int M;
	static int N;
	static int K;
	static int[][] section;
	static boolean[][] visit;
	static List<Integer> list = new ArrayList<>();
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		section = new int[N][M];
		visit = new boolean[N][M];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					if (section[i][j] == 0) section[i][j]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (section[i][j] == 0 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(list.size());
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
	}
	
	static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		int count = 1;
		visit[r][c] = true;
		queue.offer(new Point(r, c));
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && section[nr][nc] == 0) {
					visit[nr][nc] = true;
					queue.offer(new Point(nr, nc));
					count++;
				}
			}
		}
		
		list.add(count);
	}
	
}
