package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BigInteger answer = combination(N, M);
		
		System.out.println(answer);
	}
	
	static BigInteger combination(int n, int m) {
		if (n == m || m == 0) return BigInteger.ONE;
		m = Math.min(m, n - m);
		
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < m; i++) {
			result = result.multiply(BigInteger.valueOf(n - i));
			result = result.divide(BigInteger.valueOf(i + 1));
		}
		
		return result;
	}
  
}
