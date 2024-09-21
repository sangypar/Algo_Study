import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int now = 0;
        int end = 0;
        int idx = 0;
        int fin = 0;

        while (fin < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= now) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] temp = pq.poll();
                now += temp[1];
                end += now - temp[0];
                fin++;
            } else {
                now = jobs[idx][0];
            }

        }

        return end / jobs.length;
    }
}

//테스트 1 〉	통과 (2.37ms, 75.2MB)
//테스트 2 〉	통과 (3.56ms, 81.2MB)
//테스트 3 〉	통과 (2.01ms, 72.3MB)
//테스트 4 〉	통과 (1.92ms, 77.8MB)
//테스트 5 〉	통과 (2.85ms, 78.2MB)
//테스트 6 〉	통과 (1.00ms, 70.4MB)
//테스트 7 〉	통과 (2.04ms, 74.4MB)
//테스트 8 〉	통과 (1.74ms, 77.3MB)
//테스트 9 〉	통과 (1.55ms, 77.3MB)
//테스트 10 〉	통과 (3.41ms, 75.3MB)
//테스트 11 〉	통과 (1.07ms, 73.1MB)
//테스트 12 〉	통과 (1.01ms, 80.9MB)
//테스트 13 〉	통과 (1.48ms, 74MB)
//테스트 14 〉	통과 (1.32ms, 77.6MB)
//테스트 15 〉	통과 (1.00ms, 77.9MB)
//테스트 16 〉	통과 (1.52ms, 95.1MB)
//테스트 17 〉	통과 (1.42ms, 76.1MB)
//테스트 18 〉	통과 (1.14ms, 75.4MB)
//테스트 19 〉	통과 (1.03ms, 76.1MB)
//테스트 20 〉	통과 (1.01ms, 83.7MB)