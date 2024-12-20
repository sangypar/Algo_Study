package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14425_문자열집합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> S = new HashSet<>();
		List<String> list = new ArrayList<>();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			S.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			list.add(br.readLine());
		}
		
		for (String str : S) {
			for (String word : list) {
				if (str.equals(word)) count++;
			}
		}
		
		System.out.println(count);
	}
	
}
