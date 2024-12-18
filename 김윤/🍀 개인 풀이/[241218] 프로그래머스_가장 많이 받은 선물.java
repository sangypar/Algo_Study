import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];
        
        for (String str : gifts) {
            String[] cur = str.split(" ");
            index[map.get(cur[0])]++;
            index[map.get(cur[1])]--;
            record[map.get(cur[0])][map.get(cur[1])]++;
        }
        
        int answer = 0;
        
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (record[i][j] > record[j][i]) count++;
                else if (record[i][j] == record[j][i] && index[i] > index[j]) count++;
            }
            
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.30ms, 77.4MB)
// 테스트 2 〉	통과 (0.21ms, 73.1MB)
// 테스트 3 〉	통과 (0.54ms, 71MB)
// 테스트 4 〉	통과 (0.35ms, 91.1MB)
// 테스트 5 〉	통과 (3.27ms, 91.5MB)
// 테스트 6 〉	통과 (0.48ms, 85.7MB)
// 테스트 7 〉	통과 (1.78ms, 75.8MB)
// 테스트 8 〉	통과 (1.88ms, 76.1MB)
// 테스트 9 〉	통과 (5.79ms, 88.5MB)
// 테스트 10 〉	통과 (5.62ms, 76.9MB)
// 테스트 11 〉	통과 (7.80ms, 85.1MB)
// 테스트 12 〉	통과 (7.01ms, 90.4MB)
// 테스트 13 〉	통과 (10.28ms, 94.7MB)
// 테스트 14 〉	통과 (14.72ms, 90MB)
// 테스트 15 〉	통과 (15.37ms, 91.1MB)
// 테스트 16 〉	통과 (16.53ms, 105MB)
// 테스트 17 〉	통과 (0.27ms, 80.7MB)
// 테스트 18 〉	통과 (6.07ms, 92.1MB)
// 테스트 19 〉	통과 (10.18ms, 109MB)
// 테스트 20 〉	통과 (3.75ms, 77.7MB)
