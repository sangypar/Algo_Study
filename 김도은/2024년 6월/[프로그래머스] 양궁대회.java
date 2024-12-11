package level2;

import java.util.Arrays;
import java.util.Scanner;


public class 양궁대회 {

	static int max = -1000;
	static int[] lion = new int[11]; // 라이언의 과녁배열
	static int[] answer = { -1 }; // 정답배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 5;
		int[] info = new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };

		int[] answer = solution(n, info);

		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int n, int[] info) {
		// 이길수 있는 경우는 어피치보다 1개 더 많이 맞췄을 경우로 계산해서 모든 경우를 다 계신해보자

		comb(0, n, info);

		return answer;
	}

	private static void comb(int arrow, int n, int[] info) {
		if (arrow == n) {

			int apeach_point = 0;
			int lion_point = 0;

			for (int i = 0; i <= 10; i++) {
				if (info[i] != 0 || lion[i] != 0) {
					if (info[i] < lion[i])
						lion_point += 10 - i;
					else
						apeach_point += 10 - i;
				}

			}

			if (lion_point > apeach_point) {
				if (lion_point - apeach_point >= max) {
					answer = lion.clone();
					max = lion_point - apeach_point;
				}
			}

			return;
		}
		for (int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
			lion[j]++;
			comb(arrow + 1, n, info);
			lion[j]--;
		}
	}
}

/*
*
테스트 1 〉	통과 (0.06ms, 86.4MB)
테스트 2 〉	통과 (828.02ms, 92.6MB)
테스트 3 〉	통과 (280.97ms, 92.5MB)
테스트 4 〉	통과 (1.80ms, 77.3MB)
테스트 5 〉	통과 (5103.04ms, 75.4MB)
테스트 6 〉	통과 (7207.89ms, 78.8MB)
테스트 7 〉	통과 (2.12ms, 78.5MB)
테스트 8 〉	통과 (0.17ms, 72.4MB)
테스트 9 〉	통과 (1.88ms, 77MB)
테스트 10 〉	통과 (0.28ms, 75MB)
테스트 11 〉	통과 (0.75ms, 68.3MB)
테스트 12 〉	통과 (0.68ms, 78.6MB)
테스트 13 〉	통과 (21.65ms, 79.1MB)
테스트 14 〉	통과 (1545.57ms, 87.3MB)
테스트 15 〉	통과 (866.38ms, 78.9MB)
테스트 16 〉	통과 (8.56ms, 77.2MB)
테스트 17 〉	통과 (1.59ms, 77.5MB)
테스트 18 〉	통과 (0.05ms, 73.4MB)
테스트 19 〉	통과 (0.03ms, 69.3MB)
테스트 20 〉	통과 (499.11ms, 75.2MB)
테스트 21 〉	통과 (1268.56ms, 80.7MB)
테스트 22 〉	통과 (6140.46ms, 82MB)
테스트 23 〉	통과 (0.25ms, 76.5MB)
테스트 24 〉	통과 (19.74ms, 75.8MB)
테스트 25 〉	통과 (5.17ms, 79.2MB)
*/
