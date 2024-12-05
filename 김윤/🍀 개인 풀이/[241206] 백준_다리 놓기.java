package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combination(M, N)).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static long combination(int m, int n) {
		if (n == 0 || m == n) return 1;
		n = Math.min(n,  m - n);
		
		long result = 1;
		for (int i = 0; i < n; i++) {
			result *= (m - i);
			result /= (i + 1);
		}
		
		return result;
	}
	
}
