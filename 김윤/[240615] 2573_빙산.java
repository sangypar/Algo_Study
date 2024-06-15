package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IceBerg {
	int r;
	int c;
	
	public IceBerg(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main_2573 {
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int cnt = 0;
		
		while ((cnt = count()) < 2) {
			if (cnt == 0) {
				answer = 0;
				break;
			}
			
			melt();
			answer++;
		}
		
		System.out.println(answer);
	}
	
	// 빙산 개수 세기
	static int count() {
		boolean[][] visit = new boolean[N][M];
		int cnt = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0 && !visit[r][c]) {
					dfs(r, c, visit);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				continue;
			}
			
			if (map[nr][nc] != 0 && !visit[nr][nc]) {
				dfs(nr, nc, visit);
			}
		}
	}
	
	// 빙하 녹이기
	static void melt() {
		Queue<IceBerg> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					queue.offer(new IceBerg(r, c));
					visit[r][c] = true;
				}
			}
		}
		
		while (!queue.isEmpty()) {
			IceBerg iceberg = queue.poll();
			int seaCnt = 0; // 빙하 근처에 있는 바다 영역의 수
			
			for (int d = 0; d < 4; d++) {
				int nr = iceberg.r + dr[d];
				int nc = iceberg.c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				
				if (!visit[nr][nc] && map[nr][nc] == 0) {
					seaCnt++;
				}
			}
			
			if (map[iceberg.r][iceberg.c] - seaCnt < 0) {
				map[iceberg.r][iceberg.c] = 0;
			} else {
				map[iceberg.r][iceberg.c] -= seaCnt;
			}
		}
	}
}
