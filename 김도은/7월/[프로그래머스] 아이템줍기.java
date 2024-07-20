package level3;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {
	public static void main(String[] args) {

		int[][] rectangle = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
		int characterX = 1;
		int characterY = 3;
		int itemX = 7;
		int itemY = 8;
		
		int ans = solution(rectangle, characterX, characterY, itemX, itemY);

		System.out.println(ans);
	}

	static int[][] map = new int[102][102]; // 지금 전체맵 2배로 확장해야 한대 ...
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 여기좌표
	static class Here {
		int x, y, count;

		public Here(int y, int x, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	private static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		characterX *= 2;
		characterY *= 2;
		itemX *= 2;
		itemY *= 2;

		for (int i = 0; i < rectangle.length; i++) {
			int x1 = rectangle[i][0] * 2;
			int y1 = rectangle[i][1] * 2;
			int x2 = rectangle[i][2] * 2;
			int y2 = rectangle[i][3] * 2;

			// x좌표가 열 c
			for (int r = y1; r <= y2; r++) {
				for (int c = x1; c <= x2; c++) {
					if (map[r][c] == 1)
						continue; // 이미1이라면 ㄴㄴ

					map[r][c] = 1;

					if (r == y1 || r == y2 || c == x1 || c == x2) {
						map[r][c] = 2; //테루리는 2로 표시
					}
				}
			} // 테두리 표시 끝

		}
		
		int answer = bfs(characterX, characterY, itemX, itemY);
		return answer;
	}

	private static int bfs(int characterX, int characterY, int itemX, int itemY) {
		
		Queue<Here> queue = new LinkedList<>();
		boolean[][] visit = new boolean[102][102];
		
		queue.add(new Here(characterY, characterX, 0));
		
		while(!queue.isEmpty()) {
			Here now = queue.poll();
			
			int nowY = now.y;
			int nowX = now.x;
			int nowCount = now.count;
			
			if(nowY == itemY && nowX == itemX) {
				//아이템찾으면
				return nowCount/2;
			}
			
			for(int d = 0; d < 4; d++) {
				int nextY = nowY + dc[d];
				int nextX = nowX + dr[d];
				
				if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length || visit[nextY][nextX] || map[nextY][nextX] != 2) {
					//범위를 벗어나거나 방문했거나 테두리가 아니라면
					continue;
				}
				
				visit[nextY][nextX] = true;
				queue.add(new Here(nextY, nextX, nowCount + 1));
			}
		}
		
		return 0;
	}
}
