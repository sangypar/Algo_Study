import java.util.*;

public class Programmers_5_피로도 {

	private static int answer;
	private static boolean[] visited;

	public static void main(String[] args) {
		int[][] dungeons = { {80, 20}, {50, 40}, {30, 10} };
        int result = solution(80, dungeons);
        System.out.println(result);
	}
	
	// dungeons_rows는 2차원 배열 dungeons의 행 길이, dungeons_cols는 2차원 배열 dungeons의 열 길이입니다.
	static int solution(int k, int[][] dungeons) {
		answer = Integer.MIN_VALUE;
		visited = new boolean[dungeons.length];
		dfs(k, dungeons, 0);
		return answer;
	}

	private static void dfs(int k, int[][] dungeons, int cnt) {
		if(cnt > answer) {
			answer = cnt;
		}
		
		for(int i = 0 ; i< dungeons.length; i++) { // x축 던전 포문
			if(dungeons[i][0] <= k && !visited[i]) { //i 번째 던전 진입가능
				visited[i] = true;
				dfs(k - dungeons[i][1], dungeons, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
