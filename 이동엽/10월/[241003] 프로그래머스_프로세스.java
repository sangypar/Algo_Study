package programmers.프로세스;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int p : priorities) {
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    if (location == i) return answer;
                }
            }
        }

        return answer;
    }
}

//테스트 1 〉	통과 (0.77ms, 73.8MB)
//테스트 2 〉	통과 (0.92ms, 78.3MB)
//테스트 3 〉	통과 (0.67ms, 71.8MB)
//테스트 4 〉	통과 (0.40ms, 77.6MB)
//테스트 5 〉	통과 (0.34ms, 75.7MB)
//테스트 6 〉	통과 (0.47ms, 71MB)
//테스트 7 〉	통과 (0.63ms, 71.2MB)
//테스트 8 〉	통과 (1.27ms, 79MB)
//테스트 9 〉	통과 (0.57ms, 97.1MB)
//테스트 10 〉	통과 (0.50ms, 87MB)
//테스트 11 〉	통과 (0.88ms, 72.8MB)
//테스트 12 〉	통과 (0.40ms, 80.4MB)
//테스트 13 〉	통과 (0.70ms, 78.4MB)
//테스트 14 〉	통과 (0.47ms, 75MB)
//테스트 15 〉	통과 (0.45ms, 74.1MB)
//테스트 16 〉	통과 (0.60ms, 73.5MB)
//테스트 17 〉	통과 (0.69ms, 75.6MB)
//테스트 18 〉	통과 (0.45ms, 75.9MB)
//테스트 19 〉	통과 (0.85ms, 74.9MB)
//테스트 20 〉	통과 (0.59ms, 76MB)