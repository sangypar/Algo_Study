package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1074_Z {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(check(N, r, c));
	}
	
	static int check(int n, int r, int c) {
		if (n == 0) return 0;
		
		int half = 1 << (n - 1);
		int area = half * half;
		
		if (r < half && c < half) {
			return check(n-1, r, c);
		} else if (r < half && c >= half) {
			return area + check(n-1, r, c-half);
		} else if (r >= half && c < half) {
			return 2 * area + check(n-1, r-half, c);
		} else {
			return 3 * area + check(n-1, r-half, c-half);
		}
		
	}
	
}
