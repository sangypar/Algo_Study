package 큰수만들기;

import java.util.*;

// 프로그래머스 큰 수 만들기, lv2
// 그리디 알고리즘
/* 
테스트 1 〉	통과 (9.69ms, 94.1MB)
테스트 2 〉	통과 (12.97ms, 74.3MB)
테스트 3 〉	통과 (10.17ms, 71.4MB)
테스트 4 〉	통과 (14.26ms, 78MB)
테스트 5 〉	통과 (16.83ms, 77.9MB)
테스트 6 〉	통과 (28.62ms, 88.7MB)
테스트 7 〉	통과 (305.84ms, 393MB)
테스트 8 〉	통과 (503.44ms, 390MB)
테스트 9 〉	통과 (9229.50ms, 384MB)
테스트 10 〉통과 (5610.81ms, 382MB)
테스트 11 〉통과 (9.98ms, 74.3MB)
테스트 12 〉통과 (10.41ms, 76.7MB)
*/
public class Solution {

	public static String solution(String number, int k) {
		String answer = "";
		Stack<Character> stack = new Stack<>();
		
		// 앞에서 부터 스택에 넣어주고
		// 이전 값이 현재 값보다 작으면 빼주기, 횟수 --
		for (int i = 0; i < number.length(); i++) {
			char curr = number.charAt(i);
			while (!stack.isEmpty() && k > 0 && stack.peek() < curr) {
				stack.pop();
				k--;
			}
			stack.push(curr);
		}
		
		// 횟수 비우기
		while (k-- > 0) {
			stack.pop();
		}

		for (char s : stack) {
			answer += s;
		}

		return answer;
	}

}
