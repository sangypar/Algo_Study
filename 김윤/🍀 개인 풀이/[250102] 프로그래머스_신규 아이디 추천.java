import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        char[] array = new_id.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 90) {
                answer.append((char)(array[i] + 32));
            } else if ((array[i] < 48 || array[i] > 57) && (array[i] < 97 || array[i] > 122) && (array[i] != '-') && (array[i] != '_') && (array[i] != '.')) {
                continue;
            } else if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.' && array[i] == '.') {
                continue;
            } else {
                answer.append(array[i]);
            }
        }
        
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer.deleteCharAt(0);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        if (answer.length() == 0) {
            answer.append("a");
        }
        
        if (answer.length() >= 16) {
            answer.setLength(15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        
        if (answer.length() <= 2) {
            while (answer.length() != 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }
        
        return answer.toString();
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.03ms, 74.4MB)
// 테스트 2 〉	통과 (0.04ms, 74.2MB)
// 테스트 3 〉	통과 (0.04ms, 76.9MB)
// 테스트 4 〉	통과 (0.07ms, 77.6MB)
// 테스트 5 〉	통과 (0.04ms, 75.1MB)
// 테스트 6 〉	통과 (0.03ms, 85.8MB)
// 테스트 7 〉	통과 (0.04ms, 89.3MB)
// 테스트 8 〉	통과 (0.04ms, 81.8MB)
// 테스트 9 〉	통과 (0.06ms, 87.6MB)
// 테스트 10 〉	통과 (0.03ms, 78.6MB)
// 테스트 11 〉	통과 (0.06ms, 79.7MB)
// 테스트 12 〉	통과 (0.06ms, 76.2MB)
// 테스트 13 〉	통과 (0.04ms, 68.9MB)
// 테스트 14 〉	통과 (0.04ms, 84.8MB)
// 테스트 15 〉	통과 (0.08ms, 85.7MB)
// 테스트 16 〉	통과 (0.10ms, 79.9MB)
// 테스트 17 〉	통과 (0.21ms, 87.2MB)
// 테스트 18 〉	통과 (0.33ms, 71.3MB)
// 테스트 19 〉	통과 (0.51ms, 83.6MB)
// 테스트 20 〉	통과 (0.24ms, 77.9MB)
// 테스트 21 〉	통과 (0.79ms, 83.2MB)
// 테스트 22 〉	통과 (0.20ms, 85.9MB)
// 테스트 23 〉	통과 (0.53ms, 84MB)
// 테스트 24 〉	통과 (0.51ms, 73.5MB)
// 테스트 25 〉	통과 (0.61ms, 80.1MB)
// 테스트 26 〉	통과 (0.52ms, 71.9MB)
