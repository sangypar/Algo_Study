import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int l;
	int r;
	int c;
	
	public Point() {};
	
	public Point(int l, int r, int c) {
		this.l = l;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans; static boolean isEscape;
	
	public static void main(String[] args) throws IOException {
	   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
      
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			Point start = new Point();
			ans = 0; isEscape = false;
			
			if (L == 0 && R == 0 && C == 0)
				break;
			
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String row = br.readLine();
					for (int c = 0; c < C; c++) {
						map[l][r][c] = row.charAt(c);
						
						if (map[l][r][c] == 'S') {
							start.l = l; start.r = r; start.c = c;
						}
					}
				}
				br.readLine();
			}
			
			BFS(start);
			if (!isEscape) 
				System.out.println("Trapped!");
			else
				System.out.printf("Escaped in %d minute(s).\n", ans);
		}
		
	}

	private static void BFS(Point start) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(start);
		visited[start.l][start.r][start.c] = true;
		
		while(Q.size() > 0) {
			ans++;
			int size = Q.size();
			
			for (int s = 0; s < size; s++) {
				Point p = Q.poll();
				
				if (map[p.l][p.r][p.c] == 'E') {
					ans--; isEscape = true;
					return;
				}
				
				if (p.l - 1 >= 0 && map[p.l - 1][p.r][p.c] != '#' && !visited[p.l - 1][p.r][p.c]) {
					Q.add(new Point(p.l - 1, p.r, p.c));
					visited[p.l-1][p.r][p.c] = true;
				}
				
				if (p.l + 1 < L && map[p.l + 1][p.r][p.c] != '#' && !visited[p.l + 1][p.r][p.c]) {
					Q.add(new Point(p.l + 1, p.r, p.c));
					visited[p.l+1][p.r][p.c] = true;
				}
				
				for (int d = 0; d < 4; d++) {
					int nx = p.r + dx[d];
					int ny = p.c + dy[d];
					
					if (checkBounds(nx, ny) && map[p.l][nx][ny] != '#' && !visited[p.l][nx][ny]) {
						Q.add(new Point(p.l, nx, ny));
						visited[p.l][nx][ny] = true;
					}
				}
			}
		}
	}

	private static boolean checkBounds(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
