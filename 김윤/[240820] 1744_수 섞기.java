package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1744 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		int result = 0;
		boolean zero = false;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) plus.add(num);
			else if (num == 1) result += 1;
			else if (num == 0) zero = true;
			else minus.add(num);
		}
		
		plus.sort((o1, o2) -> o2 - o1);
		minus.sort((o1, o2) -> o1 - o2);
		
		// 양수일 때
		for (int i = 0; i < plus.size(); i += 2) {
			if (i + 1 < plus.size()) {
				result += plus.get(i) * plus.get(i + 1);
			} else {
				result += plus.get(i);
			}
		}
		
		// 음수일 때
		for (int i = 0; i < minus.size(); i += 2) {
			if (i + 1 < minus.size()) {
				result += minus.get(i) * minus.get(i + 1);
			} else if (!zero) {
				result += minus.get(i);
			}
		}
		
		System.out.println(result);
	}
	
}
