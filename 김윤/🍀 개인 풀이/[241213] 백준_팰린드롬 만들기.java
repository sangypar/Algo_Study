package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1213_팰린드롬만들기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alphabet = new int[26];
		
		for (char c : str.toCharArray()) {
			alphabet[c - 'A']++;
		}
		
		int oddCount = 0;
		char oddChar = 0;
		
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] % 2 != 0) {
				oddCount++;
				oddChar = (char) (i + 'A');
			}
		}
		
		if (oddCount > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		StringBuilder half = new StringBuilder();
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				half.append((char) (i + 'A'));
			}
		}
		
		StringBuilder result = new StringBuilder(half);
		if (oddCount == 1) result.append(oddChar);
		result.append(half.reverse());
		
		System.out.println(result);
	}
	
}
