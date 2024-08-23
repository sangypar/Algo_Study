package baekjoon_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기_1744 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수 개수

		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		boolean zero = false; // 0의 유무

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0)
				plus.add(num);
			else if (num < 0)
				minus.add(num);
			else
				zero = true;
		} // 입력 완료

		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);

		int sum = 0;

		// 양수일때
		// 양수 리스트 처리
		for (int i = 0; i < plus.size(); i++) {
			if (i + 1 < plus.size() && plus.get(i) != 1 && plus.get(i + 1) != 1) {
				sum += plus.get(i) * plus.get(i + 1);
				i++;
			} else {
				sum += plus.get(i);
			}
		}

		// 음수일때
		// 음수 리스트 처리
		for (int i = 0; i < minus.size(); i++) {
			if (i + 1 < minus.size()) {
				sum += minus.get(i) * minus.get(i + 1);
				i++;
			} else {
				// 홀수일때
				if (zero) {
					sum += 0;
				} else {
					sum += minus.get(i);
				}
			}
		}

		System.out.println(sum);

	}
}
