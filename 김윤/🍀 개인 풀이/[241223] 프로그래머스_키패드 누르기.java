import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, int[]> keypad = new HashMap<>();
        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});
        keypad.put(-1, new int[]{3, 0});
        keypad.put(0, new int[]{3, 1});
        keypad.put(-2, new int[]{3, 2});
        
        int[] left = keypad.get(-1);
        int[] right = keypad.get(-2);
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                left = keypad.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                right = keypad.get(number);
            } else {
                int[] target = keypad.get(number);
                int leftHand = calculate(left, target);
                int rightHand = calculate(right, target);
                
                if (leftHand < rightHand || (leftHand == rightHand && hand.equals("left"))) {
                    answer += "L";
                    left = target;
                } else {
                    answer += "R";
                    right = target;
                }
            }
        }
        
        return answer.toString();
    }
    
    private int calculate(int[] start, int[] target) {
        return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (1.84ms, 83.9MB)
// 테스트 2 〉	통과 (2.70ms, 86.1MB)
// 테스트 3 〉	통과 (1.76ms, 81.2MB)
// 테스트 4 〉	통과 (1.85ms, 83.1MB)
// 테스트 5 〉	통과 (1.67ms, 84.8MB)
// 테스트 6 〉	통과 (1.93ms, 89.3MB)
// 테스트 7 〉	통과 (2.16ms, 81MB)
// 테스트 8 〉	통과 (2.53ms, 83MB)
// 테스트 9 〉	통과 (1.79ms, 90.3MB)
// 테스트 10 〉	통과 (1.98ms, 81.4MB)
// 테스트 11 〉	통과 (2.03ms, 72.5MB)
// 테스트 12 〉	통과 (3.03ms, 86.8MB)
// 테스트 13 〉	통과 (2.07ms, 88.3MB)
// 테스트 14 〉	통과 (2.26ms, 78.7MB)
// 테스트 15 〉	통과 (2.91ms, 71.3MB)
// 테스트 16 〉	통과 (2.63ms, 82.6MB)
// 테스트 17 〉	통과 (3.87ms, 83.3MB)
// 테스트 18 〉	통과 (3.25ms, 85.3MB)
// 테스트 19 〉	통과 (3.26ms, 80.8MB)
// 테스트 20 〉	통과 (2.80ms, 91.9MB)
