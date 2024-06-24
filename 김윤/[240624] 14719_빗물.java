package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
public class Main_14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] rain = new int[W];
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			rain[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W-1; i++) {
			int first = 0;
			int last = 0;
			
			for (int j = 0; j < i; j++) {
				first = Math.max(rain[j], first);
			}
			
			for (int j = i; j < W; j++) {
				last = Math.max(rain[j], last);
			}
			
			if (rain[i] < first && rain[i] < last) {
				result += Math.min(first, last) - rain[i];
			}
		}
		
		System.out.println(result);
		
	}
	
}
