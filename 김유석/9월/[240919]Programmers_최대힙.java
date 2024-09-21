import java.util.*;

class Solution {

    public long solution(int n, int[] works) {
        // 우선순위 큐를 사용해 작업량을 큰 값부터 정렬 (최대 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 작업량을 우선순위 큐에 모두 추가
        for (int work : works) {
            pq.add(work);
        }
        
        // n번 동안 작업량을 줄임
        while (n > 0) {
            // 가장 큰 작업량을 꺼내서 1 줄임
            int maxWork = pq.poll();
            
            // 작업량이 0보다 크다면 줄임
            if (maxWork > 0) {
                maxWork--;
            }
            
            // 줄인 작업량을 다시 큐에 넣음
            pq.add(maxWork);
            
            // 남은 n 감소
            n--;
        }

        // 남은 작업량의 제곱합 계산
        long result = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            result += (long) Math.pow(work, 2);  // 작업량의 제곱을 더함
        }
        
        return result;  // 결과 반환
    }
}
