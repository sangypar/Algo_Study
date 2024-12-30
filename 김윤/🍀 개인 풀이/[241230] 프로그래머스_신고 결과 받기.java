import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
            count.put(id, 0);
            mail.put(id, 0);
        }
        
        for (String r : report) {
            String[] part = r.split(" ");
            String reporter = part[0];
            String reported = part[1];
            
            if (reports.get(reporter).add(reported)) {
                count.put(reported, count.get(reported) + 1);
            }
        }

        for (String reported : count.keySet()) {
            if (count.get(reported) >= k) {
                for (String reporter : id_list) {
                    if (reports.get(reporter).contains(reported)) {
                        mail.put(reporter, mail.get(reporter) + 1);
                    }
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }
        
        return answer;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.19ms, 77.6MB)
// 테스트 2 〉	통과 (0.21ms, 81.7MB)
// 테스트 3 〉	통과 (262.22ms, 157MB)
// 테스트 4 〉	통과 (0.32ms, 81.4MB)
// 테스트 5 〉	통과 (0.30ms, 84MB)
// 테스트 6 〉	통과 (4.95ms, 74.3MB)
// 테스트 7 〉	통과 (5.51ms, 83.6MB)
// 테스트 8 〉	통과 (9.33ms, 105MB)
// 테스트 9 〉	통과 (89.08ms, 140MB)
// 테스트 10 〉	통과 (66.42ms, 136MB)
// 테스트 11 〉	통과 (179.88ms, 176MB)
// 테스트 12 〉	통과 (4.24ms, 74.2MB)
// 테스트 13 〉	통과 (1.25ms, 73.6MB)
// 테스트 14 〉	통과 (126.13ms, 145MB)
// 테스트 15 〉	통과 (125.57ms, 170MB)
// 테스트 16 〉	통과 (1.16ms, 77.8MB)
// 테스트 17 〉	통과 (1.30ms, 74.4MB)
// 테스트 18 〉	통과 (3.17ms, 86MB)
// 테스트 19 〉	통과 (4.39ms, 73.9MB)
// 테스트 20 〉	통과 (148.64ms, 135MB)
// 테스트 21 〉	통과 (191.29ms, 158MB)
// 테스트 22 〉	통과 (0.14ms, 86.3MB)
// 테스트 23 〉	통과 (0.16ms, 85.2MB)
// 테스트 24 〉	통과 (0.20ms, 83.5MB)
