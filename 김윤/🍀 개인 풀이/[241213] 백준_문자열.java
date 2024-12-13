package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120_문자열 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int answer = Integer.MAX_VALUE;
		int count = 0;
		
		if (A.length() == B.length()) {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) count++;
			}
			
			answer = count;
		} else {
			int length = B.length() - A.length();
			
			for (int i = 0; i < length + 1; i++) {
				String temp = "";
				count = 0;
				
				for (int j = 0; j < i; j++) {
					temp += B.charAt(j);
				}
				
				temp += A;
				
				for (int j = i + A.length(); j < B.length(); j++) {
					temp += B.charAt(j);
				}
				
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) != B.charAt(j)) count++;
				}
				
				answer = Math.min(answer, count);
			}
		}
		
		System.out.println(answer);
	}
	
}
