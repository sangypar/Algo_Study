import java.util.*;

class Solution {
    public String solution(String number, int k) {

        int len = number.length();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;        // 숫자를 삭제한 횟수
        String answer = "";

        for (int i = 0; i < len; i++) {
            // 1. 스택이 비어있는 상태가 아닐 때
            // 2. 스택 상단의 숫자보다 현재 인덱스의 수가 더 크고
            // 3. 숫자를 삭제한 횟수가 총 삭제해야하는 횟수보다 작은 경우에는
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && cnt < k) {
                // 스택 상단의 수를 pop한 후 숫자 삭제 횟수를 증가
                stack.pop();
                cnt++;
            }

            // 현재 스택의 사이즈가 len - k (도출해야하는 숫자의 길이)보다 작다면
            if (stack.size() < len - k) {
                // 현재 인덱스의 숫자를 스택에 push
                stack.push(number.charAt(i));
            }
        }

        for (int i = 0; i < len - k; i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}