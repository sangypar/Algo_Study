import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
	   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
      
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 입력
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	         for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	         }
	    }
	    
	    for (int i = 0; i < N; i++) {
	    	for (int j = 0; j < M; j++) {
	    		visited[i][j] = true;
	    		DFS(i, j, 1, map[i][j]);
	    		visited[i][j] = false;
	    		makeT(0, i, j, 1, map[i][j]);
	    	}
	    }
	    
	    System.out.println(max);
	}

	private static boolean checkBounds(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	private static void DFS(int x, int y, int depth, int sum) {
		
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!checkBounds(nx, ny) || visited[nx][ny]) {
				continue;
			}
			
			visited[nx][ny] = true;
			DFS(nx, ny, depth + 1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}

	private static void makeT(int start, int x, int y, int depth, int sum) {
		
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for (int d = start; d < 4; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!checkBounds(nx, ny) || visited[nx][ny]) {
				continue;
			}
			makeT(d + 1, x, y, depth + 1, sum + map[nx][ny]);
		}
	}

}