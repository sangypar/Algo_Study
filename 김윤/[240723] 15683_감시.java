package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 감시 (인덱스 에러남,,, 다시 한 번 풀어볼게요!)
public class Main_15683 {
	
	static int[][] map;
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static List<CCTV> cctvs = new ArrayList<>();
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class CCTV {
		int r;
		int c;
		int type;
		
		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
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
				if (map[r][c] >= 1 && map[r][c] <= 5) {
					cctvs.add(new CCTV(r, c, map[r][c]));
				}
			}
		}
		
		dfs(0, map);
		System.out.println(min);
	}
	
	static void dfs(int depth, int[][] prevMap) {
        if (depth == cctvs.size()) {
            min = Math.min(min, countBlindSpot(prevMap));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] newMap;

        for (int i = 0; i < 4; i++) {
            newMap = copyMap(prevMap);
            watch(newMap, cctv, i);
            dfs(depth + 1, newMap);
        }
    }

    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, M);
        }
        return copy;
    }

    static void watch(int[][] map, CCTV cctv, int dir) {
        switch (cctv.type) {
            case 1:
                check(map, cctv.r, cctv.c, dir);
                break;
            case 2:
                check(map, cctv.r, cctv.c, dir);
                check(map, cctv.r, cctv.c, (dir + 2) % 4);
                break;
            case 3:
                check(map, cctv.r, cctv.c, dir);
                check(map, cctv.r, cctv.c, (dir + 1) % 4);
                break;
            case 4:
                check(map, cctv.r, cctv.c, dir);
                check(map, cctv.r, cctv.c, (dir + 1) % 4);
                check(map, cctv.r, cctv.c, (dir + 2) % 4);
                break;
            case 5:
                check(map, cctv.r, cctv.c, 0);
                check(map, cctv.r, cctv.c, 1);
                check(map, cctv.r, cctv.c, 2);
                check(map, cctv.r, cctv.c, 3);
                break;
        }
    }

    static void check(int[][] map, int r, int c, int dir) {
        while (true) {
            r += dr[dir];
            c += dc[dir];
            if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6) break;
            if (map[r][c] == 0) map[r][c] = 7;
        }
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) count++;
            }
        }
        return count;
    }
}
