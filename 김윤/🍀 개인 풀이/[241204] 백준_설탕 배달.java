package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = Integer.MAX_VALUE;
		
		for (int five = 0; five <= N/5; five++) {
			int remain = N - (5 * five);
			
			if (remain >= 0 && remain % 3 == 0) {
				int three = remain / 3;
				int total = five + three;
				count = Math.min(count, total);
			}
		}
		
		System.out.println(count == Integer.MAX_VALUE ? -1 : count);
	}
	
}
