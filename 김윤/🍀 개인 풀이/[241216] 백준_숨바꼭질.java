package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	
	static int N, K;
	static boolean[] visit = new boolean[100001];
	
	static class Point {
		int v;
		int t;
		
		public Point(int v, int t) {
			this.v = v;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(BFS(N));
	}
	
	static int BFS(int v) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(v, 0));
		visit[v] = true;
		
		while (true) {
			Point point = queue.poll();
			
			if (point.v == K) return point.t;
			
			if (point.v - 1 >= 0 && !visit[point.v - 1]) {
				queue.offer(new Point(point.v - 1, point.t + 1));
				visit[point.v - 1] = true;
			}
			
			if (point.v + 1 <= 100000 && !visit[point.v + 1]) {
				queue.offer(new Point(point.v + 1, point.t + 1));
				visit[point.v + 1] = true;
			}
			
			if (point.v * 2 <= 100000 && !visit[point.v * 2]) {
				queue.offer(new Point(point.v * 2, point.t + 1));
				visit[point.v * 2] = true;
			}
		}
	}
}
