import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int length = number.length() - k;
        char[] result = new char[length];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        for (int i = 0; i < length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }
}