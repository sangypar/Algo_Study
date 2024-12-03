package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int answer = 0;
		String number = "666";
		
		while (N != count) {
			answer++;
			String str = String.valueOf(answer);
			
			if (str.contains(number)) count++;
			else continue;
			
			if (N == count) break;
		}
		
		System.out.println(answer);
	}
	
}
