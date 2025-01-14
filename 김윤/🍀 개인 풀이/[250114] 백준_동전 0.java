package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			if (K >= coin[N - 1 - i]) {
				count += K / coin[N - 1 - i];
				K = K % coin[N - 1 - i];
			}
		}
		
		System.out.println(count);
	}
	
}
