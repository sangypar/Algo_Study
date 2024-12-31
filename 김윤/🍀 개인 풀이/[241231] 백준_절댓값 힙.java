package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	
	static class Number implements Comparable<Number> {
		int number;

		public Number(int number) {
			this.number = number;
		}
		
		@Override
		public int compareTo(Number other) {
			if (Math.abs(this.number) != Math.abs(other.number)) {
				return Math.abs(this.number) - Math.abs(other.number);
			}
			
			return this.number - other.number;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Number> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if (value == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll().number);
				}
			} else {
				pq.offer(new Number(value));
			}
		}
	}
	
}
