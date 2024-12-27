import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] todayArray = today.split("\\.");
        Map<String, Integer> map = new HashMap<>();
        int length = privacies.length;
        
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for (int i = 0; i < length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            int addYear = map.get(privacy[1]) / 12;
            int addMonth = map.get(privacy[1]) % 12;
            
            int[] deadline = new int[3];
            deadline[0] = year + addYear;
            deadline[1] = month + addMonth;
            deadline[2] = day;
            
            if (deadline[1] > 12) {
                deadline[0] += deadline[1] / 12;
                deadline[1] = deadline[1] % 12;
            }
            
            int todayYear = Integer.parseInt(todayArray[0]);
            int todayMonth = Integer.parseInt(todayArray[1]);
            int todayDay = Integer.parseInt(todayArray[2]);

            if (deadline[0] < todayYear || 
                (deadline[0] == todayYear && deadline[1] < todayMonth) || 
                (deadline[0] == todayYear && deadline[1] == todayMonth && deadline[2] <= todayDay)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (1.92ms, 73.4MB)
// 테스트 2 〉	통과 (2.11ms, 78.2MB)
// 테스트 3 〉	통과 (2.25ms, 91.8MB)
// 테스트 4 〉	통과 (1.95ms, 82MB)
// 테스트 5 〉	통과 (3.02ms, 74.2MB)
// 테스트 6 〉	통과 (3.20ms, 83.1MB)
// 테스트 7 〉	통과 (2.52ms, 83.7MB)
// 테스트 8 〉	통과 (3.89ms, 81.7MB)
// 테스트 9 〉	통과 (3.65ms, 86.2MB)
// 테스트 10 〉	통과 (2.85ms, 84.2MB)
// 테스트 11 〉	통과 (2.75ms, 91.4MB)
// 테스트 12 〉	통과 (3.13ms, 90.6MB)
// 테스트 13 〉	통과 (3.43ms, 73.1MB)
// 테스트 14 〉	통과 (3.03ms, 75.6MB)
// 테스트 15 〉	통과 (3.73ms, 76.5MB)
// 테스트 16 〉	통과 (3.21ms, 73.1MB)
// 테스트 17 〉	통과 (4.11ms, 90.3MB)
// 테스트 18 〉	통과 (3.31ms, 77.9MB)
// 테스트 19 〉	통과 (2.97ms, 89.1MB)
// 테스트 20 〉	통과 (2.95ms, 88.1MB)
