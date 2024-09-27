package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_10773_제로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				list.remove(list.size() - 1);
			} else {
				list.add(num);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
	}
	
}
