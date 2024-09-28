package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] alphabet = new boolean[26];
		int count = 0;
		
		out: for (int i = 0; i < N; i++) {
			String word = br.readLine();
			alphabet = new boolean[26];
			alphabet[word.charAt(0) - 'a'] = true;
			
			for (int j = 1; j < word.length(); j++) {
				char prev = word.charAt(j - 1);
				char curr = word.charAt(j);
				
				if (prev != curr && !alphabet[curr - 'a']) {
					alphabet[curr - 'a'] = true;
				} else if (prev != curr && alphabet[curr - 'a']) {
					continue out;
				}
			}
			
			count++;
		}
		
		System.out.println(count);
	}
	
}
