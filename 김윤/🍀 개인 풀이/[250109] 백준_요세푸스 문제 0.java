package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int count = 0;
		sb.append("<");
		
		while (!queue.isEmpty()) {
			int number = queue.poll();
			count++;
			
			if (count == K) {
				sb.append(number).append(", ");
				count = 0;
			} else {
				queue.offer(number);
			}
		}
		
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		
		System.out.println(sb.toString());
	}
	
}
