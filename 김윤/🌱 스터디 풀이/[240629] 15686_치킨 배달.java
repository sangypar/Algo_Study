package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨 배달
class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_15686 {
	
	static int N, M;
	static int[][] map;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static boolean[] open;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		home = new ArrayList<Point>(); // 1
		chicken = new ArrayList<Point>(); // 2
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if (map[r][c] == 1) {
					home.add(new Point(r, c));
				} else if (map[r][c] == 2) {
					chicken.add(new Point(r, c));
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.println(answer);
	}
	
	static void dfs(int start, int count) {
		if (count == M) {
			int sum = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance);
					}
				}
				
				sum += temp;
			}
			
			answer = Math.min(answer, sum);
			return;
 		}
		
		for (int i = start; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, count + 1);
			open[i] = false;
		}
	}
}
