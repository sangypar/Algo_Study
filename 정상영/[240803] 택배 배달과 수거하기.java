/*
오답임
테스트 1 〉	통과 (0.04ms, 76.7MB)
테스트 2 〉	통과 (0.03ms, 79.3MB)
테스트 3 〉	통과 (0.04ms, 82.6MB)
테스트 4 〉	통과 (0.03ms, 73.8MB)
테스트 5 〉	통과 (0.05ms, 72.6MB)
테스트 6 〉	통과 (0.04ms, 75.5MB)
테스트 7 〉	통과 (0.42ms, 77.9MB)
테스트 8 〉	통과 (9.06ms, 69.1MB)
테스트 9 〉	통과 (25.69ms, 82.9MB)
테스트 10 〉	통과 (27.41ms, 88.6MB)
테스트 11 〉	통과 (2.01ms, 80.5MB)
테스트 12 〉	통과 (2.20ms, 77.1MB)
테스트 13 〉	통과 (19.38ms, 85.2MB)
테스트 14 〉	통과 (43.09ms, 86.2MB)
테스트 15 〉	통과 (17.20ms, 80MB)
테스트 16 〉	실패 (214.17ms, 87.4MB)
테스트 17 〉	실패 (5843.86ms, 87.9MB)
테스트 18 〉	실패 (21.95ms, 98.3MB)
테스트 19 〉	실패 (2204.09ms, 86.8MB)
테스트 20 〉	실패 (2198.74ms, 100MB)
*/

import java.util.*;

class Solution {
    
    static int[] deli, pick;
    
    public int solution(int cap, int n, int[] deliveries, int[] pickups) {
        deli = Arrays.copyOf(deliveries, n);
        pick = Arrays.copyOf(pickups, n);
        
        int last = n - 1;
        int dist = 0;
        
        while(!isDone(n)) {
            // 마지막 지점 찾기
            for(int i = last; i >= 0; i--) {
                if(deli[i] > 0 || pick[i] > 0) {
                    last = i;
                    break;
                }
            }
            
            int deliBag = cap;
            int pickBag = cap;
            
            // 배달
            for(int i = last; i >= 0; i--) {
                if (deliBag <= 0) break;
                if (deli[i] > 0) {
                    if (deli[i] <= deliBag) {
                        deliBag -= deli[i];
                        deli[i] = 0;
                    } else {
                        deli[i] -= deliBag;
                        deliBag = 0;
                    }
                }
            }
            
            // 픽업
            for(int i = last; i >= 0; i--) {
                if (pickBag <= 0) break;
                if (pick[i] > 0) {
                    if (pick[i] <= pickBag) {
                        pickBag -= pick[i];
                        pick[i] = 0;
                    } else {
                        pick[i] -= pickBag;
                        pickBag = 0;
                    }
                }
            }
            
            dist += (last + 1) * 2;
        }
        
        return dist;
    }
    
    public static boolean isDone(int n) {
        for(int i = 0; i < n; i++) {
            if(deli[i] > 0 || pick[i] > 0) return false;
        }
        return true;
    }
}

