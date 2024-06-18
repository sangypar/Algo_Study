import java.util.*;

public class PRGMS_큰수만들기 {


	    public String solution(String number, int k) {
	        Stack<Character> stack = new Stack<>();
	        
	        for (char num : number.toCharArray()) {
	            // 스택의 마지막 숫자가 현재 숫자보다 작고, 제거할 수 있는 숫자가 남아있는 동안 제거
	            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
	                stack.pop();
	                k--;
	            }
	            stack.push(num);
	        }
	        
	        // 남은 k개만큼 뒤에서 제거
	        while (k > 0) {
	            stack.pop();
	            k--;
	        }
	        
	        // 스택에 남은 숫자들을 문자열로 합치기
	        StringBuilder result = new StringBuilder();
	        for (char num : stack) {
	            result.append(num);
	        }
	        
	        return result.toString();
	    }
	}
