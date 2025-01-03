package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512_예산 {
	
	static int N, M;
	static int[] budget;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		budget = new int[N];
		
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(budget);
		System.out.println(binarySearch(0, budget[N-1]));
	}
	
	static int binarySearch(int start, int end) {
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long sum = calculate(mid);
			
			if (sum <= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	static long calculate(int limit) {
		long sum = 0;
		
		for (int b : budget) {
			sum += Math.min(b, limit);
		}
		
		return sum;
	}
	
}
