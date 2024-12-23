import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        String temp = "";
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c + "";
            } else {
                temp += c + "";
                
                if (map.containsKey(temp)) {
                    answer += map.get(temp) + "";
                    temp = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (9.30ms, 88.1MB)
// 테스트 2 〉	통과 (12.94ms, 88.6MB)
// 테스트 3 〉	통과 (10.87ms, 81.1MB)
// 테스트 4 〉	통과 (9.07ms, 81.4MB)
// 테스트 5 〉	통과 (9.18ms, 88.2MB)
// 테스트 6 〉	통과 (9.55ms, 84MB)
// 테스트 7 〉	통과 (8.70ms, 92.7MB)
// 테스트 8 〉	통과 (8.62ms, 79.1MB)
// 테스트 9 〉	통과 (8.68ms, 77.9MB)
// 테스트 10 〉	통과 (8.72ms, 75.4MB)
