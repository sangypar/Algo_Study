import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_2573_빙산 {
	static int n, m; // 행, 열 크기
	static int[][] arr; // 빙산 2차원 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { -0, 0, -1, 1 };
	static boolean[][] visited; // 방문 체크 2차원 배열

	static class Node { // bfs를 위한 클래스
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()); // 빙산 입력 받기
			}
		}
		
		int result = 0; // 결과값 배열
		
		while (countice() == 1) { // 빙산이 0개거나 2개 이상이면 더 할필요 X
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (arr[r][c] > 0) { // 얼음이 있다면 상하좌우 0개수 만큼 빼주기
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) { 
								arr[r][c] = --arr[r][c] < 0 ? 0 : arr[r][c]; // 0보다 작으면 0으로 바꿔주기
							}
						}
					}
				}
			}
			result++;
		}

		if (countice() == 0) // 다 녹았을경우 결과는 0
			result = 0;
		
		System.out.println(result); // 출력

	}

	static int countice() { // 빙산 수 세는 메서드
		visited = new boolean[n][m];

		int cnt = 0; // 빙산 갯수 담을 변수
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				
				if (arr[r][c] != 0 && !visited[r][c]) { // bfs로 개수 셈
					Queue<Node> q = new LinkedList<>(); // queue에 담기
					q.add(new Node(r, c));
					visited[r][c] = true; // 방문 체크

					while (!q.isEmpty()) { // 큐가 빌때까지 돌기
						int oldr = q.peek().r;
						int oldc = q.poll().c;

						for (int d = 0; d < 4; d++) {
							int nr = oldr + dr[d];
							int nc = oldc + dc[d];
							if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && arr[nr][nc] > 0) {
								visited[nr][nc] = true; // 방문 체크 및 큐에 다음 갈 장소 넣어주기
								q.add(new Node(nr, nc));
							}
						}

					}
					cnt++;
				}
			}
		}
		return cnt;

	}
}
