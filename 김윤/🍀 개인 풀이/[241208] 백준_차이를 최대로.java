package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	
	static int N;
	static int[] numbers;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(new int[N], 0);
		System.out.println(max);
	}
	
	static void permutation(int[] current, int depth) {
		if (depth == N) {
			max = Math.max(max, calculate(current));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				current[depth] = numbers[i];
				permutation(current, depth + 1);
				visit[i] = false;
			}
		}
	}
	
	static int calculate(int[] array) {
		int sum = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			sum += Math.abs(array[i] - array[i+1]);
		}
		
		return sum;
	}
	
}
