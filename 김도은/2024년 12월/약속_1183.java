package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약속_1183 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N];
		
		//T = B - A 의 총 합
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			T[n] = B-A; //모든 값 저장
		}
		
		Arrays.sort(T);
		
		//T의 중앙값 = 약속시간의 합이 최소
		
		if(N%2==1) System.out.println(1); //홀수면 한개
		
	    else System.out.println(Math.abs(T[N/2]-T[N/2-1])+1); //짝수면 둘 사이의 개수
		
	}
}
