package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	
	static int L, C;
	static String[] array;
	static String[] alphabet;
	static String vowels = "aeiou";
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new String[L];
		alphabet = new String[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken();
		}
		
		Arrays.sort(alphabet);
		combination(0, 0);
		
		System.out.print(sb);
	}
	
	static void combination(int idx, int sidx) {
		if (sidx == L) {
			if (hasVowels()) {
				for (int i = 0; i < L; i++) {
					sb.append(array[i]);
				}
				
				sb.append("\n");
			}
			return;
		}
		
		if (idx == C) return;
		
		array[sidx] = alphabet[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);
	}
	
	static boolean hasVowels() {
		int vowelCount = 0;
		int consonantCount = 0;
		
		for (String s : array) {
			if (vowels.contains(s)) vowelCount++;
			else consonantCount++;
		}
		
		return vowelCount >= 1 && consonantCount >= 2;
	}
	
}
