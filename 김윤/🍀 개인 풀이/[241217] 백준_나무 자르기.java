package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	
	static int N, M;
	static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		System.out.println(binarySearch(1, max));
	}
	
	static int binarySearch(int start, int end) {
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) sum += (tree[i] - mid);
			}
			
			if (sum >= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
}
