package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A와 B
public class Main_12904 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder tb = new StringBuilder(br.readLine());
		int answer = 0;
		
		while (tb.length() > sb.length()) {
			if (tb.charAt(tb.length() - 1) == 'A' ) {
				tb.deleteCharAt(tb.length() - 1);
			} else {
				tb.deleteCharAt(tb.length() - 1);
				tb.reverse();
			}
		}
		
		if (tb.toString().equals(sb.toString())) answer = 1;
		
		System.out.println(answer);
	}
	
}
