package baekjoon_gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686 {

	static int N, M;
	static ArrayList<Point> chicken;
	static ArrayList<Point> home;
	static boolean[] ing;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 마을크기
		M = Integer.parseInt(st.nextToken()); // 치킨집개수

		int[][] town = new int[N][N]; // 마을

		chicken = new ArrayList<>(); // 치킨집좌표
		home = new ArrayList<>(); // 집 좌표

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				town[r][c] = Integer.parseInt(st.nextToken()); // 넣어줘잉

				if (town[r][c] == 1) {
					home.add(new Point(r, c)); // 집일 경우
				} else if (town[r][c] == 2) {
					chicken.add(new Point(r, c)); // 치킨집일 경우
				}
			}
		} // 입력 완

		ing = new boolean[chicken.size()]; // 치킨집 운영중 체크할 배열
		answer = Integer.MAX_VALUE; // 정답

		select(0, 0); // 어떤 건 선택하고, 어떤 건 선택하지 않는 치킨집 알아보기 (시작 idx, 치킨집 연 개수);

		System.out.println(answer);

	}

	private static void select(int idx, int count) {
		if (count == M) {
			// M개만큼 열었다면 멈춰
			// M개만큼 열었을 때의 치킨거리 합 구하기
			int chickenSum = 0; // 도시의 치킨거리합

			for (int i = 0; i < home.size(); i++) {
				// 집을 돌면서
				int chickenStreet = Integer.MAX_VALUE; // 각집에 대한 치킨거리
				for (int j = 0; j < chicken.size(); j++) {
					// 치킨집 돌자
					if (ing[j]) {
						// 열려있다면...
						int dist = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);

						chickenStreet = Math.min(chickenStreet, dist); // 각집에 대한 치킨거리
					}
				} // 구함

				chickenSum += chickenStreet; // 더해줌
			}

			answer = Math.min(answer, chickenSum);

			return;
		}

		// count가 아직 M이 되지 않았을 경우
		for (int i = idx; i < chicken.size(); i++) {
			// 치킨집 idx를 도는거니까
			ing[i] = true; // 오픈했다 치고
			select(i + 1, count + 1);
			ing[i] = false; //나오면서 하나씩 false처리하면서 ㄱㄱ
		}
	}
}
