package baekjoon_gold;

import java.util.Arrays;
import java.util.Scanner;

public class 단어수학_1339 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 단어의 개수

		int[] findNum = new int[26]; // 알파벳개수만큼

		for (int n = 0; n < N; n++) {
			String str = sc.next(); // 주어지는 문자
			int num = 1; // 자릿수

			for (int i = str.length() - 1; i >= 0; i--) {
				findNum[str.charAt(i) - 'A'] += num; //대문자를 숫자로 만드는 것은 'A'를 빼기
				num *= 10; // 다음자릿수
			}
		}

		Arrays.sort(findNum); //일단 정렬

		int answer = 0;
		int start = 9; //9부터 시작하는 자연수
		
		for (int i = 25; i >= 0; i--) {
			//오름차순이라 뒤에서부터
			if(findNum[i] == 0) break; //더이상 숫자가 없으면 놉
			
			answer += findNum[i] * start--;
		}
		
		System.out.println(answer);

	}
}
