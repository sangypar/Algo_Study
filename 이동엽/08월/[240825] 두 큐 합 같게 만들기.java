import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        for (int q : queue1) {
            q1.add(q);
            sum1 += q;
        }

        long sum2 = 0;
        for (int q : queue2) {
            q2.add(q);
            sum2 += q;
        }

        if (sum1 + sum2 % 2 == 1) {
            return -1; // 홀수이면 못나눔
        }

        int cnt = 0;
        int limit = 3 * queue1.length; // 2로하니까 1번 테케 터져서 3으로 하니까 됐음(?)

        while (cnt <= limit) {
            if (sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (sum1 < sum2) {
                int temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
            } else {
                return cnt;
            }
            cnt++;
        }
        return -1;
    } // method
} // class

//테스트 1 〉	통과 (0.12ms, 73.6MB)
//테스트 2 〉	통과 (0.10ms, 75.5MB)
//테스트 3 〉	통과 (0.11ms, 73.6MB)
//테스트 4 〉	통과 (0.13ms, 73.5MB)
//테스트 5 〉	통과 (0.26ms, 71.1MB)
//테스트 6 〉	통과 (0.42ms, 78.7MB)
//테스트 7 〉	통과 (0.28ms, 71.6MB)
//테스트 8 〉	통과 (0.67ms, 69.8MB)
//테스트 9 〉	통과 (0.87ms, 77.9MB)
//테스트 10 〉	통과 (0.87ms, 72.4MB)
//테스트 11 〉	통과 (17.69ms, 105MB)
//테스트 12 〉	통과 (9.48ms, 82.2MB)
//테스트 13 〉	통과 (11.88ms, 82MB)
//테스트 14 〉	통과 (9.68ms, 92.4MB)
//테스트 15 〉	통과 (11.72ms, 95.4MB)
//테스트 16 〉	통과 (14.80ms, 106MB)
//테스트 17 〉	통과 (11.79ms, 105MB)
//테스트 18 〉	통과 (72.83ms, 160MB)
//테스트 19 〉	통과 (75.98ms, 142MB)
//테스트 20 〉	통과 (75.31ms, 138MB)
//테스트 21 〉	통과 (74.18ms, 148MB)
//테스트 22 〉	통과 (83.23ms, 150MB)
//테스트 23 〉	통과 (80.49ms, 149MB)
//테스트 24 〉	통과 (92.49ms, 151MB)
//테스트 25 〉	통과 (0.49ms, 82.9MB)
//테스트 26 〉	통과 (0.21ms, 77.8MB)
//테스트 27 〉	통과 (0.22ms, 76.2MB)
//테스트 28 〉	통과 (51.36ms, 109MB)
//테스트 29 〉	통과 (2.18ms, 79.1MB)
//테스트 30 〉	통과 (45.94ms, 121MB)