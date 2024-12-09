import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // 최소 숙련도
        int right = Integer.MIN_VALUE;
        
        for (int value : diffs) {
            right = Math.max(right, value);
        }
        
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (checkComplete(diffs, times, mid, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean checkComplete(int[] diffs, int[] times, int level, long limit) {
        long sum = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                sum += (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                sum += times[i];
            }
            
            if (sum > limit) return false;
        }
        
        return sum <= limit;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.05ms, 76.5MB)
// 테스트 2 〉	통과 (0.03ms, 75.5MB)
// 테스트 3 〉	통과 (0.03ms, 82.4MB)
// 테스트 4 〉	통과 (0.04ms, 75.7MB)
// 테스트 5 〉	통과 (0.07ms, 82MB)
// 테스트 6 〉	통과 (0.04ms, 81.7MB)
// 테스트 7 〉	통과 (0.04ms, 70MB)
// 테스트 8 〉	통과 (0.68ms, 79.3MB)
// 테스트 9 〉	통과 (0.76ms, 75.9MB)
// 테스트 10 〉	통과 (0.83ms, 77.1MB)
// 테스트 11 〉	통과 (1.41ms, 80.4MB)
// 테스트 12 〉	통과 (1.19ms, 81.2MB)
// 테스트 13 〉	통과 (0.77ms, 84.6MB)
// 테스트 14 〉	통과 (0.75ms, 84.1MB)
// 테스트 15 〉	통과 (27.09ms, 116MB)
// 테스트 16 〉	통과 (68.11ms, 119MB)
// 테스트 17 〉	통과 (24.18ms, 117MB)
// 테스트 18 〉	통과 (35.67ms, 122MB)
// 테스트 19 〉	통과 (42.40ms, 133MB)
// 테스트 20 〉	통과 (14.67ms, 118MB)
// 테스트 21 〉	통과 (35.71ms, 127MB)
