import java.util.*;

class Solution {
    static List<String> answer = new ArrayList<>();
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = new String(order);
        }
        
        for (int c : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() >= c) combination(order, "", 0, c);
            }
            
            int max = 2;
            for (int count : map.values()) {
                max = Math.max(max, count);
            }
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) answer.add(entry.getKey());
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    void combination(String order, String current, int index, int length) {
        if (current.length() == length) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        if (index >= order.length()) return;
        
        combination(order, current + order.charAt(index), index + 1, length);
        combination(order, current, index + 1, length);
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (14.72ms, 75.4MB)
// 테스트 2 〉	통과 (15.48ms, 88.1MB)
// 테스트 3 〉	통과 (11.06ms, 77.9MB)
// 테스트 4 〉	통과 (16.41ms, 73.2MB)
// 테스트 5 〉	통과 (16.25ms, 85.6MB)
// 테스트 6 〉	통과 (23.92ms, 75.9MB)
// 테스트 7 〉	통과 (16.58ms, 87.8MB)
// 테스트 8 〉	통과 (20.79ms, 90.1MB)
// 테스트 9 〉	통과 (29.38ms, 93.5MB)
// 테스트 10 〉	통과 (30.35ms, 81MB)
// 테스트 11 〉	통과 (19.94ms, 91.4MB)
// 테스트 12 〉	통과 (23.10ms, 98MB)
// 테스트 13 〉	통과 (29.48ms, 95.5MB)
// 테스트 14 〉	통과 (22.41ms, 81MB)
// 테스트 15 〉	통과 (24.69ms, 82.8MB)
// 테스트 16 〉	통과 (23.45ms, 93.4MB)
// 테스트 17 〉	통과 (24.47ms, 86.3MB)
// 테스트 18 〉	통과 (26.05ms, 78.7MB)
// 테스트 19 〉	통과 (19.22ms, 96.1MB)
// 테스트 20 〉	통과 (24.63ms, 100MB)
