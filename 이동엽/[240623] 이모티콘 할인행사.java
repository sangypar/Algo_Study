import java.util.*;

// 이모티콘 할인 행사, 프로그래머스 lv.2
// 조합으로 모든 할인율 
// 모든 조합 List에 넣은 후 조건에 따라 정렬
//테스트 1 〉	통과 (0.58ms, 73.8MB)
//테스트 2 〉	통과 (2.45ms, 74.3MB)
//테스트 3 〉	통과 (0.93ms, 73.8MB)
//테스트 4 〉	통과 (1.89ms, 80.6MB)
//테스트 5 〉	통과 (2.01ms, 73.9MB)
//테스트 6 〉	통과 (2.15ms, 79.4MB)
//테스트 7 〉	통과 (4.74ms, 72.5MB)
//테스트 8 〉	통과 (4.46ms, 76MB)
//테스트 9 〉	통과 (16.69ms, 75.9MB)
//테스트 10 〉 통과 (15.76ms, 75.5MB)
//테스트 11 〉 통과 (30.73ms, 87.4MB)
//테스트 12 〉 통과 (38.65ms, 83.3MB)
//테스트 13 〉 통과 (109.94ms, 79.5MB)
//테스트 14 〉 통과 (86.51ms, 80.4MB)
//테스트 15 〉 통과 (11.79ms, 76.4MB)
//테스트 16 〉 통과 (16.55ms, 85.4MB)
//테스트 17 〉 통과 (0.68ms, 82.9MB)
//테스트 18 〉 통과 (8.57ms, 78.6MB)
//테스트 19 〉 통과 (0.42ms, 72.9MB)
//테스트 20 〉 통과 (0.50ms, 76.3MB)

class Solution {

	static int[] percentages = { 10, 20, 30, 40 };

	public int[] solution(int[][] users, int[] emoticons) {
		int length = emoticons.length;
		List<int[]> combinations = new ArrayList<>(); // 할인율 경우의 수
		comb(new int[length], 0, combinations);

		List<int[]> results = new ArrayList<>();
		for (int[] c : combinations) {
			int subscribers = 0; // 이모티콘 플러스 구독자
			int sales = 0; // 매출

			for (int[] u : users) {
				int satisfyDiscount = u[0]; // 이 할인율 넘으면 다 사기
				int subscribeLimit = u[1]; // 넘어가면 구독
				int costSum = 0; // 구입한 이모티콘 가격 합

				for (int i = 0; i < length; i++) {
					if (c[i] >= satisfyDiscount) {
						costSum += emoticons[i] * (100 - c[i]) / 100;
					}
				}
				if (costSum >= subscribeLimit) {
					subscribers++;
				} else {
					sales += costSum;
				}
			}
			results.add(new int[] { subscribers, sales });
		}
		// 1번 목표 : 서비스 가입자를 최대로, 2번 목표 : 이모티콘 매출 최대로
		Collections.sort(results, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				} // 이모티콘 매출을 최대로
				return o2[0] - o1[0]; // 서비스 가입자를 최대
			}
		});
		return results.get(0);
	}

	// 모든 할인율 경우의 수
	public void comb(int[] discounts, int idx, List<int[]> combinations) {
		if (idx == discounts.length) {
			combinations.add(discounts.clone());
			return;
		}
		for (int p : percentages) {
			discounts[idx] = p;
			comb(discounts, idx + 1, combinations);
		}
	}
}