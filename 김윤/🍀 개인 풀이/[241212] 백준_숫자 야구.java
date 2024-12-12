package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2503_숫자야구 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		int[] number = new int[N];
		int[] strike = new int[N];
		int[] ball = new int[N];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			number[n] = Integer.parseInt(st.nextToken());
			strike[n] = Integer.parseInt(st.nextToken());
			ball[n] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 123; i <= 987; i++) {
			if (!hasDuplicate(i)) {
				boolean possible = true;
				
				for (int j = 0; j < N; j++) {
					if (!check(i, number[j], strike[j], ball[j])) {
						possible = false;
						break;
					}
				}
				
				if (possible) answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean hasDuplicate(int num) {
		String str = Integer.toString(num);
		if (str.contains("0")) return true;
		
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i+1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) return true;
			}
		}
		
		return false;
	}
	
	static boolean check(int guess, int number, int strike, int ball) {
		String guessStr = Integer.toString(guess);
        String numberStr = Integer.toString(number);
        int s = 0, b = 0;
        
        for (int i = 0; i < 3; i++) {
            if (guessStr.charAt(i) == numberStr.charAt(i)) s++;
            else if (guessStr.contains(String.valueOf(numberStr.charAt(i)))) b++;
        }

        return s == strike && b == ball;
	}
}
