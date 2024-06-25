class Solution {
	static int[] score = new int[11]; // 라이언의 모든 점수를 담을 배열
	static int count, maxscore, lowscore, lowcount; // 화살 갯수, 라이언과 어피치 점수 차, 최고 차이일 때 최저점수, 최고 차이일 때 최저점수의 갯수
	static int[] answer; // 결과 값 담을 배열

	public int[] solution(int n, int[] info) {
		count = n;
		match(0, 0, info);

		if (maxscore == 0)
			answer = new int[] { -1 };
		return answer;
	}

	private void match(int targetidx, int cnt, int[] info) { // 몇점 판인지, 화살 몇개 썼는지, 어피찌 배열
		if (cnt == count) { // 다쏘면 점수 계산
			int lion = 0, peach = 0;
			for (int i = 0; i < 10; i++) {
				if (!(info[i] == 0 && score[i] == 0) && info[i] >= score[i]) // 피치가 점수 획득
					peach += (10 - i);
				else if (!(info[i] == 0 && score[i] == 0) && info[i] < score[i]) // 라이언이 점수 획득
					lion += (10 - i);
			}
			if (maxscore < lion - peach) { // 점수차가 최대일 경우
				maxscore = lion - peach; // 점수차 갱신
				for (int i = 10; i >= 0; i--) { // 갱신
					if (score[i] != 0) {
						lowscore = i;
						lowcount = score[i];
						break;
					}
				}
				answer = score.clone(); // 배열 복사
			} else if (maxscore == lion - peach) { // 점수차가 같을 경우
				for (int i = 10; i >= 0; i--) {
					if (score[i] != 0) {
						if (i >= lowscore) { // 최저점수 비교
							if (i == lowscore && score[i] < lowcount) 
								break;
							lowscore = i;
							lowcount = score[i];
							answer = score.clone();
						}
						break;
					}
				}
			}
			return;
		}

		if (targetidx == 11) return; // 인덱스 넘어가면 탈출
		
		score[targetidx]++;
		match(targetidx, cnt + 1, info);
		score[targetidx]--;
		match(targetidx + 1, cnt, info);
	}
}

//테스트 1 〉	통과 (0.06ms, 72MB)
//테스트 2 〉	통과 (17.70ms, 89.8MB)
//테스트 3 〉	통과 (10.07ms, 80.3MB)
//테스트 4 〉	통과 (1.29ms, 77.9MB)
//테스트 5 〉	통과 (26.20ms, 82.3MB)
//테스트 6 〉	통과 (18.59ms, 73.5MB)
//테스트 7 〉	통과 (1.05ms, 75MB)
//테스트 8 〉	통과 (0.23ms, 76.4MB)
//테스트 9 〉	통과 (1.22ms, 72.9MB)
//테스트 10 〉	통과 (0.37ms, 78.2MB)
//테스트 11 〉	통과 (0.69ms, 75.9MB)
//테스트 12 〉	통과 (0.67ms, 75.9MB)
//테스트 13 〉	통과 (4.58ms, 77.9MB)
//테스트 14 〉	통과 (11.11ms, 81.6MB)
//테스트 15 〉	통과 (9.94ms, 76.8MB)
//테스트 16 〉	통과 (1.50ms, 81.1MB)
//테스트 17 〉	통과 (1.20ms, 80.1MB)
//테스트 18 〉	통과 (0.06ms, 72.9MB)
//테스트 19 〉	통과 (0.02ms, 74MB)
//테스트 20 〉	통과 (9.70ms, 80.9MB)
//테스트 21 〉	통과 (9.52ms, 83.5MB)
//테스트 22 〉	통과 (20.09ms, 97MB)
//테스트 23 〉	통과 (0.23ms, 74.8MB)
//테스트 24 〉	통과 (22.58ms, 78MB)
//테스트 25 〉	통과 (23.56ms, 81.8MB)