class Solution {
    public int solution(String s) {
        int min = s.length();
        
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;
            
            for (int i = step; i < s.length(); i += step) {
                String part = s.substring(i, Math.min(i + step, s.length()));
                
                if (prev.equals(part)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = part;
                    count = 1;
                }
            }
            
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            min  = Math.min(min, sb.length());
        }
        
        return min;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.12ms, 91.1MB)
// 테스트 2 〉	통과 (0.40ms, 77.3MB)
// 테스트 3 〉	통과 (0.22ms, 95.3MB)
// 테스트 4 〉	통과 (0.10ms, 85.9MB)
// 테스트 5 〉	통과 (0.02ms, 70.9MB)
// 테스트 6 〉	통과 (0.08ms, 86.5MB)
// 테스트 7 〉	통과 (0.71ms, 87.3MB)
// 테스트 8 〉	통과 (0.46ms, 80.2MB)
// 테스트 9 〉	통과 (0.68ms, 85.1MB)
// 테스트 10 〉	통과 (3.67ms, 73.9MB)
// 테스트 11 〉	통과 (0.14ms, 69MB)
// 테스트 12 〉	통과 (0.12ms, 80MB)
// 테스트 13 〉	통과 (0.17ms, 90.4MB)
// 테스트 14 〉	통과 (0.94ms, 85.6MB)
// 테스트 15 〉	통과 (0.15ms, 76.8MB)
// 테스트 16 〉	통과 (0.05ms, 84.5MB)
// 테스트 17 〉	통과 (1.64ms, 76MB)
// 테스트 18 〉	통과 (0.92ms, 76.8MB)
// 테스트 19 〉	통과 (1.11ms, 85.7MB)
// 테스트 20 〉	통과 (3.68ms, 88.8MB)
// 테스트 21 〉	통과 (3.29ms, 71.3MB)
// 테스트 22 〉	통과 (3.57ms, 75.2MB)
// 테스트 23 〉	통과 (2.63ms, 93.3MB)
// 테스트 24 〉	통과 (2.54ms, 83.9MB)
// 테스트 25 〉	통과 (2.85ms, 88MB)
// 테스트 26 〉	통과 (2.75ms, 89MB)
// 테스트 27 〉	통과 (2.74ms, 84.8MB)
// 테스트 28 〉	통과 (0.06ms, 77.2MB)
// 테스트 29 〉	통과 (0.08ms, 72.6MB)
// 테스트 30 〉	통과 (0.16ms, 85.5MB)
// 테스트 31 〉	통과 (1.68ms, 71.6MB)
