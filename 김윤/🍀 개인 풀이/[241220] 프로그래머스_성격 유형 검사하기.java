import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] array = {"R", "T", "C", "F", "J", "M", "A", "N"};
        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
        String answer = "";
        int length = survey.length;
        
        for (int l = 0; l < length; l++) {
            String left = survey[l].split("")[0];
            String right = survey[l].split("")[1];
            int score = choices[l] - 4;
            
            if (score < 0) {
                int old = map.get(left);
                map.replace(left, old + Math.abs(score));
            } else if (score > 0) {
                int old = map.get(right);
                map.replace(right, old + Math.abs(score));
            }
        }
        
        for (int i = 0; i < 8; i += 2) {
            if (map.get(array[i]) >= map.get(array[i+1])) {
                answer += array[i];
            } else {
                answer += array[i+1];
            } 
        }
        
        return answer;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (1.18ms, 83.3MB)
// 테스트 2 〉	통과 (1.49ms, 86.1MB)
// 테스트 3 〉	통과 (1.55ms, 78.7MB)
// 테스트 4 〉	통과 (1.46ms, 81.8MB)
// 테스트 5 〉	통과 (1.50ms, 75.4MB)
// 테스트 6 〉	통과 (1.62ms, 90.8MB)
// 테스트 7 〉	통과 (2.09ms, 91.8MB)
// 테스트 8 〉	통과 (2.66ms, 81.2MB)
// 테스트 9 〉	통과 (3.89ms, 75.5MB)
// 테스트 10 〉	통과 (6.14ms, 76.6MB)
// 테스트 11 〉	통과 (3.44ms, 90.6MB)
// 테스트 12 〉	통과 (8.63ms, 95.7MB)
// 테스트 13 〉	통과 (11.69ms, 88.8MB)
// 테스트 14 〉	통과 (10.44ms, 92MB)
// 테스트 15 〉	통과 (9.13ms, 91.3MB)
// 테스트 16 〉	통과 (11.45ms, 75.5MB)
// 테스트 17 〉	통과 (19.49ms, 93.2MB)
// 테스트 18 〉	통과 (17.34ms, 76.4MB)
// 테스트 19 〉	통과 (9.89ms, 90.8MB)
// 테스트 20 〉	통과 (12.95ms, 91.5MB)
