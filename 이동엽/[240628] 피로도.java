// 프로그래머스 lv.2
// 백트래킹
class Solution {

	int max;
	boolean explored[];

	// 던전배열 앞 : 최소 필요, 뒤 : 소모 피로도
	public int solution(int k, int[][] dungeons) {
		explored = new boolean[dungeons.length];
		max = 0;
		return explore(k, 0, dungeons);
	}

	public int explore(int k, int cnt, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!explored[i] && k >= dungeons[i][0] ) {
				explored[i] = true;
				explore(k - dungeons[i][1], cnt + 1, dungeons);
				explored[i] = false;
			}
		}
		max = Math.max(max, cnt);
		return max;
	}
}


//테스트 1 〉	통과 (0.05ms, 76.4MB)
//테스트 2 〉	통과 (0.04ms, 79.5MB)
//테스트 3 〉	통과 (0.04ms, 77.3MB)
//테스트 4 〉	통과 (0.09ms, 76.6MB)
//테스트 5 〉	통과 (0.51ms, 72.9MB)
//테스트 6 〉	통과 (0.55ms, 80.3MB)
//테스트 7 〉	통과 (1.27ms, 77.4MB)
//테스트 8 〉	통과 (2.67ms, 77.9MB)
//테스트 9 〉	통과 (0.04ms, 78.7MB)
//테스트 10 〉	통과 (0.42ms, 73.1MB)
//테스트 11 〉	통과 (0.04ms, 73.4MB)
//테스트 12 〉	통과 (0.50ms, 74.5MB)
//테스트 13 〉	통과 (0.19ms, 78.6MB)
//테스트 14 〉	통과 (0.05ms, 74MB)
//테스트 15 〉	통과 (0.06ms, 73.7MB)
//테스트 16 〉	통과 (0.05ms, 76.2MB)
//테스트 17 〉	통과 (0.06ms, 75.6MB)
//테스트 18 〉	통과 (0.04ms, 78.3MB)
//테스트 19 〉	통과 (0.05ms, 70.8MB)
