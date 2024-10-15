package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2309_일곱난쟁이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			int number = Integer.parseInt(br.readLine());
			list.add(number);
			sum += number;
		}

		list.sort((o1, o2) -> o1 - o2);
		
		out: for (int i = 0; i < 8; i++) {
			for (int j = 1; j < 9; j++) {
				if (sum - list.get(i) - list.get(j) == 100) {
					list.remove(i);
					list.remove(j-1);
					break out;
				}
			}
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.println(list.get(i));
		}
	}
	
}
