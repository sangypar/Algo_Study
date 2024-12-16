package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int c = 0; c <= r; c++) {
				triangle[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = triangle[0][0];
		
		for(int r = 1; r < N; r++) {
			dp[r][0] = dp[r-1][0] + triangle[r][0];
			
			for(int c = 1; c <= r; c++) {
				dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-1]) + triangle[r][c];
			}
		}
		
		int max = 0;
		
		for(int c = 0; c < N; c++) {
			max = Math.max(max, dp[N-1][c]);
		}
		
		System.out.println(max);
		
	}
}
