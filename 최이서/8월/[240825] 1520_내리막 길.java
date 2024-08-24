import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int M, N;
	static int[][] map;
	static int[][] DP;
//	static int ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
	   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
      
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		DP = new int[M][N];
		
		// -1로 초기화
		for (int[] arr: map) {
			Arrays.fill(DP, -1);
		}
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(DFS(0, 0));
	}

	private static int DFS(int r, int c) {
		// 도착지점까지 도달했을 경우
		if (r == M-1 && c == N-1)
		return 1;
		    
	    // 방문한 적이 없는 경우
	    if (DP[r][c] == -1) {
	      DP[r][c] = 0;
	      for (int i = 0; i < 4; i++) {
	          int nx = r + dx[i];
	          int ny = c + dy[i];

	          if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) continue;

	          // 내리막 길인 경우
	          if (map[r][c] > map[nx][ny]) {
	              DP[r][c] += DFS(nx, ny);
	          }
	      }
	    }
	    return DP[r][c];
	}
}