package level2;

import java.awt.Point;

public class 피로도 {
	
	static int max; //최대 던전수
	
	public static void main(String[] args) {

		int k = 80; // 체력
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

		int result = solution(k, dungeons);

		System.out.println(result); // 최대던전수 리턴
	}

	private static int solution(int k, int[][] dungeons) {

		// 순열로 순서를 만든 후 모든 탐색 갈기자
		boolean[] visit = new boolean[dungeons.length];
		
		Point[] select = new Point[dungeons.length]; // 던전을 돌 순서 배열
		max = 0;
		perm(k, dungeons, visit, 0, select);

		return max;
	}

	private static void perm(int k, int[][] dungeons, boolean[] visit, int idx, Point[] select) {
		if (idx == select.length) {
			// 순열을 만들었다면 여기서 계산
			go(k, select);
			return;
		}
		
		for (int r = 0; r < dungeons.length; r++) {
			//던전순서를 정하자
			if(!visit[r]) {
				//방문안했다면, 그곳 방문쳌
				visit[r] = true;
				select[idx] = new Point(dungeons[r][0], dungeons[r][1]);
				perm(k, dungeons, visit, idx+1, select);
				
				//다시 나올때 원복
				visit[r] = false;
			}
		}
	}

	private static void go(int k, Point[] select) {
		
		int count = 0;
		
		for(int i = 0; i < select.length; i++) {
			if(select[i].x <= k) {
				//들어갈 수 있는 최소 피로도
				count++;
				k -= select[i].y; //소모된거만큼 뺴준다
			}
		}
		
		max = Math.max(max, count);
	}
}

/*
테스트 1 〉	통과 (97.50ms, 74.4MB)
테스트 2 〉	통과 (103.79ms, 91.2MB)
테스트 3 〉	통과 (0.67ms, 75.7MB)
테스트 4 〉	통과 (0.70ms, 76.5MB)
테스트 5 〉	통과 (1.51ms, 70.6MB)
테스트 6 〉	통과 (1.66ms, 76.8MB)
테스트 7 〉	통과 (8.00ms, 75.8MB)
테스트 8 〉	통과 (7.21ms, 79.7MB)
테스트 9 〉	통과 (0.36ms, 68.6MB)
테스트 10 〉	통과 (2.14ms, 74.9MB)
테스트 11 〉	통과 (0.46ms, 69.9MB)
테스트 12 〉	통과 (7.65ms, 80.4MB)
테스트 13 〉	통과 (13.07ms, 78.2MB)
테스트 14 〉	통과 (12.81ms, 78.6MB)
테스트 15 〉	통과 (24.87ms, 76.8MB)
테스트 16 〉	통과 (2.21ms, 77.3MB)
테스트 17 〉	통과 (12.48ms, 80.2MB)
테스트 18 〉	통과 (0.27ms, 77.7MB)
테스트 19 〉	통과 (0.53ms, 87.9MB)
*/
