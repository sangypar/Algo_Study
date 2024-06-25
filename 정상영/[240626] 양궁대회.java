import java.util.*;

/*
테스트 1 〉	통과 (0.08ms, 85.3MB)
테스트 2 〉	통과 (0.53ms, 75.9MB)
테스트 3 〉	통과 (0.55ms, 73.5MB)
테스트 4 〉	통과 (0.43ms, 75.5MB)
테스트 5 〉	통과 (0.59ms, 73.4MB)
테스트 6 〉	통과 (0.59ms, 77.6MB)
테스트 7 〉	통과 (0.38ms, 88.3MB)
테스트 8 〉	통과 (0.21ms, 74.3MB)
테스트 9 〉	통과 (0.28ms, 64.9MB)
테스트 10 〉	통과 (0.17ms, 78MB)
테스트 11 〉	통과 (0.19ms, 76.1MB)
테스트 12 〉	통과 (0.23ms, 76.3MB)
테스트 13 〉	통과 (0.59ms, 73.7MB)
테스트 14 〉	통과 (0.64ms, 81.3MB)
테스트 15 〉	통과 (0.73ms, 75MB)
테스트 16 〉	통과 (0.32ms, 74.6MB)
테스트 17 〉	통과 (0.31ms, 75.2MB)
테스트 18 〉	통과 (0.05ms, 75.2MB)
테스트 19 〉	통과 (0.04ms, 74MB)
테스트 20 〉	통과 (0.54ms, 78.5MB)
테스트 21 〉	통과 (0.53ms, 73.8MB)
테스트 22 〉	통과 (0.77ms, 70.7MB)
테스트 23 〉	통과 (0.10ms, 76.6MB)
테스트 24 〉	통과 (0.65ms, 83.2MB)
테스트 25 〉	통과 (0.57ms, 82MB)
 */

class Solution {
    
    static int maxDiff;
    static int[] apeachs, answer;
    
    public int[] solution(int n, int[] scores) {
        maxDiff = -1;
        apeachs = scores;
        answer = new int[]{-1}; // 초기 값 설정
        
        int[] lions = new int[11];
        
        dfs(lions, 0, n);
        
        return answer;
    }
    
    static void dfs(int[] lions, int idx, int arrows) {
        // basecase
        if (idx == 11) {
            lions[10] += arrows; // 남은 화살을 0점 과녁에 모두 넣음
            
            int lionScore = 0;
            int apeachScore = 0;
            
            for (int i = 0; i < 11; i++) {
                if (lions[i] > apeachs[i]) lionScore += (10 - i);
                else if (apeachs[i] > 0) apeachScore += (10 - i);
            }
            
            int diff = lionScore - apeachScore;
            
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lions.clone();
                    
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (lions[i] > answer[i]) {
                            answer = lions.clone();
                            break;
                            
                        } else if (lions[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            lions[10] -= arrows; // 상태 복원
            return;
        }
        
        // recursive 
        
        // 1. 이기기
        if (arrows > apeachs[idx]) {
            lions[idx] = apeachs[idx] + 1;
            dfs(lions, idx + 1, arrows - lions[idx]);
            lions[idx] = 0; // 상태 복원
        }
        
        // 2. 지기
        dfs(lions, idx + 1, arrows);
    }
}
