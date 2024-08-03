class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;
        
        for (int i = n-1; i >= 0; i--) {
            deliver += deliveries[i];
            pickup += pickups[i];
            
            while (deliver > 0 || pickup > 0) {
                deliver -= cap;
                pickup -= cap;
                answer += (i + 1) * 2;
            }         
        }        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.10ms, 71.1MB)
// 테스트 2 〉	통과 (0.07ms, 76.9MB)
// 테스트 3 〉	통과 (0.05ms, 82MB)
// 테스트 4 〉	통과 (0.07ms, 75.3MB)
// 테스트 5 〉	통과 (0.06ms, 78.5MB)
// 테스트 6 〉	통과 (0.06ms, 77.2MB)
// 테스트 7 〉	통과 (0.13ms, 78.1MB)
// 테스트 8 〉	통과 (0.14ms, 78.7MB)
// 테스트 9 〉	통과 (0.63ms, 76.3MB)
// 테스트 10 〉	통과 (0.59ms, 73.5MB)
// 테스트 11 〉	통과 (0.25ms, 76.4MB)
// 테스트 12 〉	통과 (0.28ms, 76.3MB)
// 테스트 13 〉	통과 (0.24ms, 82.6MB)
// 테스트 14 〉	통과 (0.25ms, 79.2MB)
// 테스트 15 〉	통과 (3.61ms, 100MB)
// 테스트 16 〉	통과 (9.35ms, 92.6MB)
// 테스트 17 〉	통과 (4.26ms, 90.1MB)
// 테스트 18 〉	통과 (4.10ms, 82.5MB)
// 테스트 19 〉	통과 (2.69ms, 86.7MB)
// 테스트 20 〉	통과 (2.86ms, 93.8MB)
