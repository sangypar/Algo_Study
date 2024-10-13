package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int n = 1; n <= 1000000; n++) {
			String number = n + "";
			int sum = n;
			
			for (int i = 0; i < number.length(); i++) {
				sum += number.charAt(i) - '0';
			}
			
			if (N == sum) {
				answer = n;
				break;
			}
		}
		
		System.out.println(answer);
	}
	
}
