package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	
	static boolean[] isPrime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		prime(N);
		
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}
	
	static void prime(int n) {
		isPrime = new boolean[n+1];
		
		for (int i = 2; i < n+1; i++) {
			isPrime[i] = true;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int j = i*i; j <= n; j+= i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
}
