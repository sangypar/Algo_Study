package baekjoon;

import java.io.*;

public class Main_17626_FourSquares {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int k = 1; k * k <= i; k++) {
				dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
	
}
