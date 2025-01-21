package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셉_1629 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken()); //A 수를
		long B = Integer.parseInt(st.nextToken()); //B 번 
		long C = Integer.parseInt(st.nextToken()); //나누는 수
		
		long answer = calculate(A, B, C);
		
		System.out.println(answer);
		
	}

	private static long calculate(long A, long B, long C) {
		if(B == 1) {
			return A % C;
		}
		
		long tmp = calculate(A, B / 2, C);
	
		if(B % 2 == 1) {
			return (tmp*tmp % C) * A % C;
		}
		
		return tmp*tmp % C;
	}
}
