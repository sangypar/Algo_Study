// 몰라서 검색했어요...
import java.util.*;

class Solution {
    static HashMap<String, Integer> stringMap;
    
    public String[] solution(String[] orders, int[] course) {
        // 1. orders의 값을 char 배열로 바꾸어 각 글자마다 정렬 : 정렬하지 않으면 3번 케이스의 XW와 WX가 다른 조합으로 계산됨
        // 2. 가능한 조합 전부 만들고 각 조합이 사용되는 값 HashMap에 삽입
        // 3. 최댓값을 가지는 조합을 찾아 반환

        // orders의 값 char 배열로 바꾸어 각 글자마다 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] ca = orders[i].toCharArray();
            Arrays.sort(ca);
            orders[i] = String.valueOf(ca);
        }

        stringMap = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();

        // 가능한 조합 전부 만들기
        for (int c : course) {
            for (int i = 0; i < orders.length; i++) {
                combination(orders[i], "", c);
            }
            // 만든 조합이 하나라도 있다면
            if (!stringMap.isEmpty()) {
                // 최댓값을 구하기 위한 ArrayList
                ArrayList<Integer> maxList = new ArrayList<>(stringMap.values());
                int max = Collections.max(maxList);
                // 코스 요리의 구성은 최소 2가지 이상이르모
                if (max > 1) {
                    for(String key : stringMap.keySet()) {
                        if(stringMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
            }
            // 다음 크기의 조합을 만들기 위해 map clear
            stringMap.clear();
        }

        // answerList에 있는 값 answer 배열에 삽입
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        // 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }
    
    // 조합을 구하는 메서드
    static void combination(String order, String com, int courseNum) {
        // 재귀 탈출 조건
        if (com.length() == courseNum) {
            stringMap.put(com, stringMap.getOrDefault(com, 0) + 1);
            return;
        }
        // 실행 조건
        for (int i = 0; i < order.length(); i++) {
            combination(order.substring(i + 1), com + order.charAt(i), courseNum);
        }
    }
}