/**
        테스트 1 〉	통과 (0.10ms, 74.7MB)
테스트 2 〉	통과 (0.10ms, 73.6MB)
테스트 3 〉	통과 (0.12ms, 74.9MB)
테스트 4 〉	통과 (0.11ms, 73.8MB)
테스트 5 〉	통과 (0.09ms, 74.8MB)
테스트 6 〉	통과 (0.08ms, 70.2MB)
테스트 7 〉	통과 (0.10ms, 71.5MB)
테스트 8 〉	통과 (0.06ms, 73.5MB)
테스트 9 〉	통과 (0.17ms, 77.5MB)
테스트 10 〉	통과 (0.32ms, 72.4MB)
테스트 11 〉	통과 (0.28ms, 77.7MB)
테스트 12 〉	통과 (1.50ms, 74.1MB)
테스트 13 〉	통과 (0.45ms, 83.2MB)
테스트 14 〉	통과 (0.15ms, 74.5MB)
테스트 15 〉	통과 (0.15ms, 76MB)
테스트 16 〉	통과 (0.13ms, 72.3MB)
테스트 17 〉	통과 (0.10ms, 77.7MB)
테스트 18 〉	통과 (5.92ms, 81.8MB)
테스트 19 〉	통과 (1.88ms, 76.1MB)
테스트 20 〉	통과 (5.10ms, 74MB)
테스트 21 〉	통과 (3.20ms, 71.6MB)
테스트 22 〉	통과 (2.05ms, 65.6MB)
테스트 23 〉	통과 (0.16ms, 73.6MB)
테스트 24 〉	통과 (1.55ms, 72.5MB)
테스트 25 〉	통과 (4.88ms, 75.1MB)
테스트 26 〉	통과 (3.85ms, 74.5MB)
테스트 27 〉	통과 (0.46ms, 72.8MB)
테스트 28 〉	통과 (0.63ms, 78.6MB)
 */
import java.util.*;

class Solution {
    List<Integer> answer = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int n = relation.length; // 테이블의 행(row) 개수, 값 갯수 
        int m = relation[0].length; // 테이블의 열(column) 개수, 속성 갯수 
        
        /**
         * 1 << m 은 2^m을 의미, 즉 m개의 열에 대해 가능한 모든 조합의 수
         * 3의 조합  001 -> 100 -> 8
         * 4의 조합 0001 -> 1000 -> 16
         * 5의 조합00001 -> 10000-> 32 
         */
        for (int i = 1; i < (1 << m); i++) {  
            Set<String> set = new HashSet<>(); // 중복을 방지하기 위한 Set
            
            // N번째행의
            for (int j = 0; j < n; j++) {
                StringBuilder temp = new StringBuilder();
                //M번째 열에 대한 고려
                for (int k = 0; k < m; k++) {
                    // i & (1 << k)는 i의 k번째 비트가 1인지 확인
                    // i가 101이면, 0번째와 2번째 열을 선택하는 것
                    if ((i & (1 << k)) > 0) {
                        // k번째 열을 선택했다면, 해당 열의 데이터를 temp에 추가
                        temp.append(relation[j][k]);
                    }
                }
                // 해당 조합에 대한 데이터를 Set에 추가 (중복 제거 목적)
                set.add(temp.toString());
            }
            // 만약 set의 크기가 n과 같다면, 이 조합은 유일성(중복 없음)을 만족함
            if (set.size() == n && check(i)) {
                // 유일성 & 최소성 조건을 만족하면 후보키 후보에 추가
                answer.add(i);
            }
        }
        // 후보키의 개수를 반환
        return answer.size();
    }
    
    // 최소성 검사: i가 이전에 나온 후보키 j의 부분집합이면 false 반환
    boolean check(int i) {
        for (int j : answer) {
            // i & j == j 이면, j는 i의 부분집합임을 의미
            if ((i & j) == j) return false;
            //011 & 010 = 010
            //USER_ID 
            /**
             * USER_ID || NAME || AGE 
             *   1         유석    25
             *   2         동엽    26
             *   3         이서    30
             */
        }
        return true;
    }
}
