package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 옥수수밭_30024 {

	static class Point {
		int r;
		int c;
		int corns;

		Point(int r, int c, int corns) {
			this.r = r;
			this.c = c;
			this.corns = corns;
		}
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] corns = new int[N + 1][M + 1]; // 옥수수밭

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				corns[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(br.readLine()); // 반복하는 횟수 또는 K그루의 옥수수만 수확
		
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.corns - a.corns); //내림차순 정렬이 필요함

		boolean[][] visit = new boolean[N + 1][M + 1];

		//가장자리 탐색
		for (int r = 1; r <= N; r++) {
			if (!visit[r][1]) {
				visit[r][1] = true;
				pq.add(new Point(r, 1, corns[r][1]));
			}

			if (!visit[r][M]) {
				visit[r][M] = true;
				pq.add(new Point(r, M, corns[r][M]));
			}
		}

		for (int c = 1; c <= M; c++) {
			if (!visit[1][c]) {
				visit[1][c] = true;
				pq.add(new Point(1, c, corns[1][c]));
			}

			if (!visit[N][c]) {
				visit[N][c] = true;
				pq.add(new Point(N, c, corns[N][c]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int k = 0; k < K; k++) {
			if(!pq.isEmpty()) {
				Point now = pq.poll();
				sb.append(now.r + " " + now.c + "\n");
				
				for(int d = 0; d < 4; d++) {
					
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(nr < 1 || nr > N || nc < 1 || nc > M) continue;
					
					if(visit[nr][nc]) continue; //방문한 곳이면 빼고
					
					visit[nr][nc] = true;
					
					pq.add(new Point(nr, nc, corns[nr][nc]));
				}
			}
		}
		
		System.out.println(sb);

	}
}
