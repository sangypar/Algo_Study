import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_로봇이지나간자리 {

	static int H;
	static int W;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		out: for (int i = 0; i < H; i++) {
			for (int j = 0;j < W; j++) {
				if (map[i][j] == '#' && isStartPos(i, j, map)) {
					for (int d = 0; d < 4; d++) {
						if (!isStraightDir(i, j, d, map)) continue;

						StringBuilder methodSB = new StringBuilder();
						dfs(i, j, map, d, methodSB);
						
						sb.append(i+1).append(" ").append(j+1).append("\n");
						sb.append(dirConvert(d)).append("\n");
						sb.append(methodSB.toString());
						
						break out;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int y, int x, char[][] map, int dir, StringBuilder sb) {
		// //현재 방향으로 2칸은 이동할수 있음
		int currentY = y + dy[dir] * 2;
		int currentX = x + dx[dir] * 2;
		moveStraight(map, y,x,dir);
		sb.append("A");

		if(currentY==H-1 && currentX==W-1){
			System.out.println();
		}

		//왼쪽
		int leftD = dir - 1 >= 0 ? dir - 1 : 3;
		if (isStraightDir(currentY, currentX, leftD, map)) {
			sb.append("L");
			dfs(currentY, currentX, map, leftD, sb);
			return;
		}
		int rightD = (dir + 1) % 4;
		
		//오른쪽
		if (isStraightDir(currentY, currentX, rightD, map)) {
			sb.append("R");
			dfs(currentY, currentX, map, rightD, sb);
			return;
		}
		
		//직진
		if (isStraightDir(currentY, currentX, dir, map)) {
			dfs(currentY, currentX, map, dir, sb);
			return;
		}
	}
	
	static boolean isStartPos(int y, int x, char[][] map) {
		int count = 0;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && nx >= 0 && ny < H && nx < W && map[ny][nx] == '#')
				count++;
		}

		return count == 1;
	}
	
	static boolean isStraightDir(int y, int x, int d, char[][] map) {
		int ny = y + dy[d] * 2;
		int nx = x + dx[d] * 2;

		return ny >= 0 && nx >= 0 && ny < H && nx < W && map[y+dy[d]][x+dx[d]] == '#' && map[y+dy[d]*2][x+dx[d]*2]=='#';
	}

	//정수로 사용한 방향(시작방향) 문자열화
	static String dirConvert(int d) {
		if (d == 0)
			return "^";
		else if (d == 1)
			return ">";
		else if (d == 2)
			return "v";
		else
			return "<";
	}

	//현재 위치와 직진2칸을 '.'으로 갱신
	static void moveStraight(char[][] map, int y,int x, int d){
		for(int i=0;i<3;i++){
			map[y][x] = '.';
			y = y+dy[d];
			x = x+dx[d];
		}
	}
}
