package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
	
	static int K, N;
	static long[] line;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		line = new long[K];
		
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			line[i] = Long.parseLong(br.readLine());
			max = Math.max(max, line[i]);
		}
		
		System.out.println(binarySearch(1, max));
	}
	
	static long binarySearch(long start, long end) {
		long result = 0;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;
			
			for (int i = 0; i < K; i++) {
				count += (line[i] / mid);
			}
			
			if (count >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
}
