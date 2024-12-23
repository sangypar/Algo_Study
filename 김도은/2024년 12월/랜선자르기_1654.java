package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); //랜선의 개수
		int N = Integer.parseInt(st.nextToken()); //필요한 랜선 개수
		
		long[] lines = new long[K]; //랜선
		
		long max = 0;
		
		for(int k = 0; k < K; k++) {
			lines[k] = Integer.parseInt(br.readLine());
			
			max = Math.max(max, lines[k]);
		}
		
		long min = 1; //최소는 1
		
		while(min <= max) {
			
			long mid = (max+min) / 2;
			
			long sum = 0;
			
			for(long line : lines) {
				sum += line / mid; //개수만큼
			}
			
			if(sum < N) {
				max = mid - 1; //짧게 만들어야 함
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println((max+min) / 2);
	}
}
