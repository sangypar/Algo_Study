package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성적평균 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] student = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 1; n <= N; n++) {
			student[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] score = new int[N+1]; //학생 성적 누적합
		
		for(int n = 1; n <= N; n++) {
			score[n] = score[n-1] + student[n];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			double num = B - A + 1; //명수
			double total = score[B] - score[A-1];
			
			double answer = total / num;
			
			sb.append(String.format("%.2f", answer)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
