/*
테스트 1 〉	통과 (0.09ms, 77.5MB)
테스트 2 〉	통과 (0.13ms, 72.9MB)
테스트 3 〉	통과 (0.08ms, 76.7MB)
테스트 4 〉	통과 (0.14ms, 72.4MB)
테스트 5 〉	통과 (0.11ms, 72.6MB)
테스트 6 〉	통과 (0.07ms, 75MB)
테스트 7 〉	통과 (0.76ms, 74.9MB)
테스트 8 〉	통과 (13.96ms, 80.3MB)
테스트 9 〉	통과 (21.24ms, 78.3MB)
테스트 10 〉	통과 (40.24ms, 83.7MB)
테스트 11 〉	통과 (2.62ms, 80.4MB)
테스트 12 〉	통과 (3.80ms, 80.6MB)
테스트 13 〉	통과 (21.13ms, 81.5MB)
테스트 14 〉	통과 (15.07ms, 77.6MB)
테스트 15 〉	통과 (10.45ms, 95.8MB)
테스트 16 〉	통과 (184.20ms, 85.4MB)
테스트 17 〉	통과 (9342.22ms, 86.3MB)
테스트 18 〉	통과 (22.71ms, 92MB)
테스트 19 〉	통과 (1842.48ms, 92.1MB)
테스트 20 〉	통과 (2960.55ms, 90.5MB)
*/

import java.util.*;

class Solution {
    
    static int[] deli, pick;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        deli = Arrays.copyOf(deliveries, n);
        pick = Arrays.copyOf(pickups, n);
        
        int last = n - 1;
        long dist = 0;
        
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
