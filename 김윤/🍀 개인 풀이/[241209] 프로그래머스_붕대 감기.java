import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int count = 0; // 연속 횟수 세기
        int index = 0; // attacks 배열 인덱스 관리
        int HP = health;
        
        for (int t = 0; t < attacks[attacks.length - 1][0] + 1; t++) {
            if (t == attacks[index][0]) {
                HP -= attacks[index][1];
                count = 0;
                index++;
                
                if (HP <= 0) return -1;
            } else {
                if (HP == health) continue;
                
                if (HP + bandage[1] >= health) HP = health;
                else HP += bandage[1];
                
                count++;
            }
            
            if (count == bandage[0] && HP < health) {
                if (HP + bandage[2] >= health) HP = health;
                else HP += bandage[2];
                
                count = 0;
            }
        }
        
    return HP;
      
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.02ms, 90MB)
// 테스트 2 〉	통과 (0.02ms, 84.8MB)
// 테스트 3 〉	통과 (0.03ms, 87.6MB)
// 테스트 4 〉	통과 (0.02ms, 72.4MB)
// 테스트 5 〉	통과 (0.02ms, 89.3MB)
// 테스트 6 〉	통과 (0.02ms, 87.1MB)
// 테스트 7 〉	통과 (0.02ms, 74.6MB)
// 테스트 8 〉	통과 (0.03ms, 72.3MB)
// 테스트 9 〉	통과 (0.03ms, 80.3MB)
// 테스트 10 〉	통과 (0.03ms, 73.5MB)
// 테스트 11 〉	통과 (0.12ms, 72.2MB)
// 테스트 12 〉	통과 (0.04ms, 86.6MB)
// 테스트 13 〉	통과 (0.05ms, 82.8MB)
// 테스트 14 〉	통과 (0.09ms, 72MB)
// 테스트 15 〉	통과 (0.07ms, 71.3MB)
// 테스트 16 〉	통과 (0.06ms, 81.7MB)
// 테스트 17 〉	통과 (0.03ms, 84.5MB)
// 테스트 18 〉	통과 (0.06ms, 76.5MB)
// 테스트 19 〉	통과 (0.07ms, 83.4MB)
// 테스트 20 〉	통과 (0.06ms, 89MB)
