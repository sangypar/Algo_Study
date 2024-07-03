/*
테스트 1 〉	통과 (1.52ms, 78.1MB)
테스트 2 〉	통과 (1.34ms, 75.4MB)
테스트 3 〉	통과 (1.09ms, 74.8MB)
테스트 4 〉	통과 (1.26ms, 73.8MB)
테스트 5 〉	통과 (1.15ms, 73MB)
테스트 6 〉	통과 (1.64ms, 73.7MB)
테스트 7 〉	통과 (1.47ms, 77.2MB)
테스트 8 〉	통과 (11.66ms, 90.7MB)
테스트 9 〉	통과 (5.36ms, 82.2MB)
테스트 10 〉	통과 (7.47ms, 72.3MB)
테스트 11 〉	통과 (7.43ms, 85.8MB)
테스트 12 〉	통과 (7.42ms, 70.2MB)
테스트 13 〉	통과 (14.41ms, 81.6MB)
테스트 14 〉	통과 (10.04ms, 85.4MB)
테스트 15 〉	통과 (16.59ms, 93.3MB)
테스트 16 〉	통과 (9.02ms, 84.1MB)
테스트 17 〉	통과 (13.83ms, 90.2MB)
테스트 18 〉	통과 (20.59ms, 89.7MB)
테스트 19 〉	통과 (9.82ms, 81MB)
테스트 20 〉	통과 (13.73ms, 91.2MB)
*/

/*
1. 손님이 주문한 단품 메뉴 조합을 오름차순으로 정렬
2. 단품 메뉴 조합을 2부터 메뉴 조합 전체 길이까지 부분 집합 찾기
3. Map에 해당 조합이 있으면 value + 1, 없으면 value 1로 Map에 넣기
4. 전체 Map을 순회하면서 key값의 length가 course 배열의 원소와 같다면 최댓값 비교해서 정답 List에 넣기
5. 정답 List 정렬해서 답 출력
*/

import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    static List<String> answer;
    static boolean[] visited;
    
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            
            for(int j = 2; j <= tmp.length; j++) {
                visited = new boolean[tmp.length];
                comb(tmp, j, 0, 0);
            }
        }
        
        for(int i = 0; i < course.length; i++) {
            int courseLength = course[i];
            Stack<String> stack = new Stack<>();
            int maxValue = 2;
            
            for(String key : map.keySet()) {
                if(key.length() == courseLength) {
                    if(map.get(key) > maxValue) {
                        stack.clear();
                        stack.push(key);
                        maxValue = map.get(key);
                        
                    } else if(map.get(key) == maxValue) {
                        stack.push(key);
                    }
                }
            }
            
            while(!stack.isEmpty()) {
                answer.add(stack.pop());
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    static void comb(char[] arr, int cnt, int start, int idx) {
        // basecase
        if (idx == cnt) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    tmp.append(arr[i]);
                }
            }
            String key = tmp.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            
            return;
        }
        
        // recursive
        for(int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(arr, cnt, i + 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}
