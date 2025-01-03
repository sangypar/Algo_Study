package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14235_크리스마스선물 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			
			if (A == 0) {
				if (pq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				for (int a = 0; a < A; a++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
	
}
