package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15903_카드합체놀이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			long temp = pq.poll();
			temp += pq.poll();
			
			pq.add(temp);
			pq.add(temp);
		}
		
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
	
}
