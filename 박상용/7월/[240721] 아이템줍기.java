import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Item {
		int r;
		int c;
		int count;

		public Item(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}

	}

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] arr = new int[101][101];
		boolean[][] visited = new boolean[101][101];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < rectangle.length; i++) {
			int startR = 2 * rectangle[i][0];
			int endR = 2 * rectangle[i][2];
			int startC = 2 * rectangle[i][1];
			int endC = 2 * rectangle[i][3];
			for (int r = startR; r <= endR; r++) {
				for (int c = startC; c <= endC; c++) {
					if (arr[r][c] == -1)
						continue;
					if (r == startR || r == endR || c == startC || c == endC)
						arr[r][c] = 1;
					else
						arr[r][c] = -1;
				}
			}
		}

		Queue<Item> queue = new LinkedList<>();
		queue.add(new Item(characterX*2, characterY*2, 0));
		visited[characterX*2][characterY*2] = true;
		int answer = 0;
		out: while (true) {
			int newr = queue.peek().r;
			int newc = queue.peek().c;
			int newcount = queue.poll().count;

			for (int d = 0; d < 4; d++) {
				int nr = newr + dr[d];
				int nc = newc + dc[d];

				if (nr == itemX*2 && nc == itemY*2) {
					answer = newcount + 1;
					break out;
				}

				if (nr >= 0 && nc >= 0 && nr <= 100 && nc <= 100 && arr[nr][nc] == 1 && !visited[nr][nc]) {
					queue.add(new Item(nr, nc, newcount + 1));
					visited[nr][nc] = true;
				}
			}

		}

		return answer / 2;
	}
}