package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	
	static int N, S;
	static int[] array;
	static int[] select;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			select = new int[i];
			combination(0, 0, i);
		}
		
		System.out.println(count);
	}
	
	static void combination(int idx, int sidx, int K) {
		if (sidx == K) {
			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += select[i];
			}
			
			if (sum == S) count++;
			return;
		}
		
		if (idx == N) return;
		
		select[sidx] = array[idx];
		combination(idx + 1, sidx + 1, K);
		combination(idx + 1, sidx, K);
	}
	
}
