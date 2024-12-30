package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테트로미노
public class Main_14500 {
	
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visit;
	static int max;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[N][M];
		// int start = Integer.MIN_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				// 오류 3) 시작점을 최고 큰 수로 잡으면 테케 3 오류 발생. 'ㅗ' 로직이 이상한가?
				// start = Math.max(start, board[r][c]);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visit[r][c] = true;
				dfs(r, c, board[r][c], 1);
				visit[r][c] = false;
				check(r, c);
			}
		}
		
		System.out.println(max);
		
	}
	
	static void dfs(int r, int c, int sum, int count) {
		// 기저 조건
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		// 재귀 조건
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, sum + board[nr][nc], count + 1); // 오류 1) ++count하면 값이 변해서 원복이 되지 않는다.
				visit[nr][nc] = false;
			}
		}
	}
	
	// 오류 2) 'ㅗ', 'ㅜ', 'ㅓ', 'ㅏ' 모양을 체크하는 것은 따로 해야 한다.
	static void check(int r, int c) {
        if (r >= 1 && c >= 1 && c < M - 1) {
            int sum = board[r][c] + board[r - 1][c] + board[r][c - 1] + board[r][c + 1];
            max = Math.max(max, sum);
        }
        
        if (r >= 1 && r < N - 1 && c >= 1) {
            int sum = board[r][c] + board[r - 1][c] + board[r + 1][c] + board[r][c - 1];
            max = Math.max(max, sum);
        }
        
        if (r < N - 1 && c >= 1 && c < M - 1) {
            int sum = board[r][c] + board[r + 1][c] + board[r][c - 1] + board[r][c + 1];
            max = Math.max(max, sum);
        }
        
        if (r >= 1 && r < N - 1 && c < M - 1) {
            int sum = board[r][c] + board[r - 1][c] + board[r + 1][c] + board[r][c + 1];
            max = Math.max(max, sum);
        }
    }
}