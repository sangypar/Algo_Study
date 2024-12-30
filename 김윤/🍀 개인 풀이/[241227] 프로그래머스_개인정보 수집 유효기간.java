import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
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
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            answer[index++] = iterator.next();
        }

        return answer;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.11ms, 74.3MB)
// 테스트 2 〉	통과 (0.22ms, 87.3MB)
// 테스트 3 〉	통과 (0.16ms, 76.7MB)
// 테스트 4 〉	통과 (0.17ms, 82.8MB)
// 테스트 5 〉	통과 (0.33ms, 79.6MB)
// 테스트 6 〉	통과 (0.37ms, 82.4MB)
// 테스트 7 〉	통과 (0.27ms, 75.7MB)
// 테스트 8 〉	통과 (0.36ms, 79.4MB)
// 테스트 9 〉	통과 (0.62ms, 73.6MB)
// 테스트 10 〉	통과 (0.78ms, 86.4MB)
// 테스트 11 〉	통과 (0.70ms, 72.8MB)
// 테스트 12 〉	통과 (0.84ms, 72.9MB)
// 테스트 13 〉	통과 (1.41ms, 72.6MB)
// 테스트 14 〉	통과 (0.76ms, 71.8MB)
// 테스트 15 〉	통과 (0.63ms, 79.6MB)
// 테스트 16 〉	통과 (1.13ms, 83.1MB)
// 테스트 17 〉	통과 (0.96ms, 89.1MB)
// 테스트 18 〉	통과 (1.10ms, 74.1MB)
// 테스트 19 〉	통과 (1.11ms, 81.3MB)
// 테스트 20 〉	통과 (1.42ms, 78.7MB)
