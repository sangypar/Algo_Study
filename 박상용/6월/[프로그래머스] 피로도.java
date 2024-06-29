class Solution {
	static int answer = 0;
	static boolean[] visited;

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		bf(0, dungeons, k);
		return answer;
	}

	private void bf(int cnt, int[][] dungeons, int k) {
		answer = Math.max(cnt, answer);
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				bf(cnt + 1, dungeons, k - dungeons[i][1]);
				visited[i] = false;
			}
		}
	}

}