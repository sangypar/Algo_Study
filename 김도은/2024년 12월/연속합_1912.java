package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] plus = new int[N];
		
		plus[0] = num[0];
		int max = num[0];
		
		for(int n = 1; n < N; n++) {
			plus[n] = Math.max(plus[n-1] + num[n], num[n]); //둘중 더 큰걸로
			max = Math.max(max, plus[n]);
		}
		
		System.out.println(max);
	}
}
