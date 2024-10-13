package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		long N = 0;
		
		for (int i = 1; i <= S; i++) {
			sum += i;
			N++;
			
			if (sum > S) {
				N--;
				break;
			}
		}

		System.out.println(N);
	}
	
}
