package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546_평균 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double[] score = new double[N];
		double max = Integer.MIN_VALUE;
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, score[i]);
		}
		
		for (int i = 0; i < N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		
		System.out.println(sum / N);
	}
	
}
