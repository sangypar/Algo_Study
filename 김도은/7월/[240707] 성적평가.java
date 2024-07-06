package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 성적평가 {

	static class People {
		int num; // 몇번째 사람인지
		int score; // 해당 대회의 점수

		public People(int num, int score) {
			this.num = num;
			this.score = score;
		}
	}
	
	/*
	 * 내가 헤맨 점
	 * 1. finalScore 구하기 전에 test 배열을 sort 해버린 점
	 * 2. 출력을 잘못이해하고 있던 점
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 참가자수

		People[][] test = new People[3][N]; // 대회 테이블ㄴ

		for (int r = 0; r < 3; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {
				test[r][c] = new People(c, Integer.parseInt(st.nextToken()));
			}
		} // 각 사람에 대한 점수 넣기

		People[] finalScore = new People[N]; // 등수를 위한 최종점수

		for (int c = 0; c < N; c++) {
			finalScore[c] = new People(c, 0);
		}

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < N; c++) {
				finalScore[test[r][c].num].score += test[r][c].score;
			}
		}

		for (int r = 0; r < 3; r++) {
			Arrays.sort(test[r], new Comparator<People>() {
				@Override
				public int compare(People o1, People o2) {
					return o2.score - o1.score;// 내림차순정렬
				}
			});
		} // 해당 줄마다 정렬

		Arrays.sort(finalScore, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				return o2.score - o1.score; // 내림차순정렬
			}
		}); // 해당줄마다 정렬

		int[][] answer = new int[4][N];

		///////////// 대회별 등수 구하는거
		for (int r = 0; r < 3; r++) {
			answer[r][test[r][0].num] = 1; // 지금 r행에 젤 앞에잇는애가 1등~

			for (int c = 1; c < N; c++) {
				if (test[r][c - 1].score == test[r][c].score) {
					// 앞애랑 점수 같으면
					answer[r][test[r][c].num] = answer[r][test[r][c - 1].num]; // 같게해야해
					continue;
				} // 같은 등수가 나와도 다음은 어차피 1씩 밀림

				answer[r][test[r][c].num] = c + 1;
			}
		} // 해당 대회별 등수 끝
		
		////////////// 최종등수 구하는거
		answer[3][finalScore[0].num] = 1;

		for (int c = 1; c < N; c++) {
			if (finalScore[c - 1].score == finalScore[c].score) {
				// 앞애랑 점수 같으면
				answer[3][finalScore[c].num] = answer[3][finalScore[c - 1].num]; // 같게해야해
				continue;
			} // 같은 등수가 나와도 다음은 어차피 1씩 밀림

			answer[3][finalScore[c].num] = c + 1;
		}


		StringBuilder sb = new StringBuilder();

		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(answer[r][c]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
