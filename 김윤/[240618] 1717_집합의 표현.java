package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현
public class Main_1717 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 원소 개수
		int M = Integer.parseInt(st.nextToken()); // 연산의 개수
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (command == 0) {
				union(a, b);
			} else if (command == 1) {
				if (isSameParent(a, b)) sb.append("YES" + "\n");
				else sb.append("NO" + "\n");
			} else {
				continue;
			}
		}
		
		System.out.print(sb);
	}
	
	// 부모를 찾는 함수
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	// 부모를 바꿔주는 함수
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			if (x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	// 부모가 같은지 확인하는 함수
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return true;
		return false;
	}
}
