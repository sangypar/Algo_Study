import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Iceberg {
	int x;
	int y;
	int h; // 높이
	
	public Iceberg(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
}

public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int ans = 1;
        while(true) {
        	melts();
        	
        	visited = new boolean[N][M];
        	int cnt = 0;	// 덩어리
        	
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			if (arr[i][j] != 0 && !visited[i][j]) {
        				BFS(i, j);
        				cnt++;
        			}
        		}
        	}
        	
        	if (cnt == 0) {
        		ans = 0;
        		break;
        	} else if (cnt == 1) {
        		ans++;
        	} else if (cnt >= 2) {
        		break;
        	}
        }
        System.out.println(ans);
    }

    // 빙산 높이 수정
	private static void melts() {
		Queue<Iceberg> Q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					int height = arr[i][j];
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (checkBounds(nx, ny) && arr[nx][ny] == 0) {
							height--;
							if (height == 0)
								break;
						}
					}
					Q.add(new Iceberg(i, j, height));
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Iceberg I = Q.poll();
			arr[I.x][I.y] = I.h;
		}
	}

	private static boolean checkBounds(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	// 빙산 덩어리 수 체크 & 리턴
	private static void BFS(int x, int y) {
		
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			
			int size = Q.size();
			
			for (int s = 0; s < size; s++) {
				Point p = Q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					
					if (arr[nx][ny] != 0 && checkBounds(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						Q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
}