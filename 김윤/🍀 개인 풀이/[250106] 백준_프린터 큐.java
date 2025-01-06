package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				queue.offer(new int[] {Integer.parseInt(st.nextToken()), i});
			}
			
			int order = 0;
			
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				boolean isMax = true;
				
				for (int[] q : queue) {
					if (q[0] > current[0]) {
						isMax = false;
						break;
					}
				}
				
				if (isMax) {
					order++;
					
					if (current[1] == M) {
						System.out.println(order);
						break;
					}
				} else {
					queue.offer(current);
				}
			}
		}
	}
	
}
