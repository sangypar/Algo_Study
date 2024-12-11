package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열의합_1024 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int len = L; len <= 100; len++) {
			
			int tmp = N - len * (len + 1) / 2;
			
			if(tmp % len == 0) {
				//a가 이렇게 해야 정수
				int start = tmp / len + 1;
				
				if (start >= 0) {
					
					for(int i = 0; i < len; i++) {
						sb.append(start + i).append(" ");
					}
					
					System.out.println(sb.toString().trim());
					return;
				}
			}
		}
		
		System.out.println(-1);
	}
}
