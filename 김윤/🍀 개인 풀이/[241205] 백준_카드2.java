package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		
		for (int n = 1; n <= N; n++) {
			queue.add(n);
		}
		
		while (queue.size() != 1) {
			count++;
			
			if (count % 2 == 1) {
				queue.poll();
			} else {
				int value = queue.poll();
				queue.add(value);
			}
		}
		
		System.out.println(queue.peek());
	}
	
}
