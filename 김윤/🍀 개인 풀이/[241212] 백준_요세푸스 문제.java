package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int index = 0;
		
		while (!queue.isEmpty()) {
			index++;
			int value = queue.poll();
			
			if (index == K) {
				list.add(value);
				index = 0;
			} else {
				queue.offer(value);
			}
		}
		
		sb.append("<");
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i)).append(", ");
		}
		sb.append(list.get(list.size() - 1)).append(">");
		
		System.out.println(sb);
	}
	
}
