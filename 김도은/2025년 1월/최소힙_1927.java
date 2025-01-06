package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //연산 개수
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine()); //들어오는 것
			
			if(num != 0) {
				pq.add(num);
			} else {
				
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
