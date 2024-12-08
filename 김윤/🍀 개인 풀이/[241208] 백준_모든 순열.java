package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_모든순열 {

	static int N;
	static int[] numbers;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i + 1;
		}
		
		permutation(0, new int[N]);
		System.out.print(sb);
	}
	
	static void permutation(int idx, int[] array) {
		if (idx == N) {
			for (int i = 0; i < N-1; i++) {
				sb.append(array[i] + " ");
			}
			sb.append(array[N-1] + "\n");
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((!visit[i])) {
				visit[i] = true;
				array[idx] = numbers[i];
				permutation(idx + 1, array);
				visit[i] = false;
			}
		}
	}
	
}
