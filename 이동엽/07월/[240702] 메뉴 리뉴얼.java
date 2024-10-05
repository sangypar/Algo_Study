import java.util.*;

// 프로그래머스 lv.2 조합 + 자료구조
// dp LCS가 아니었음,,,
class Solution_메뉴리뉴얼 {
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // 맵에 넣어서 코스 순서 + 나온 횟수 기록

        for (String o : orders) {
            char[] ch = o.toCharArray();
            Arrays.sort(ch); // 순서 정렬해주기

            for (int c : course) {
                if (c > ch.length) continue;
                boolean[] sel = new boolean[ch.length];
                comb(map, ch, sel, 0, ch.length, c);
            }
        }

        for (int c : course) {
            List<String> temp = new ArrayList<>(); // 조합 저장할 리스트
            int max = 0;
            // 모든 맵을 조회
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getKey().length() == c) { // course 길이와 같으면
                    if (e.getValue() >= 2) { // 최소 2명이상 주문
                        if (e.getValue() > max) { // 최대값 갱신
                            temp.clear();
                            temp.add(e.getKey());
                            max = e.getValue();
                        } else if (e.getValue() == max) { // 최대값이면 list 담기
                            temp.add(e.getKey());
                        }
                    }
                }
            }
            answer.addAll(temp);
        }
        Collections.sort(answer);

        return answer;
    }

    public void comb(Map<String, Integer> map, char[] ch, boolean[] sel, int idx, int n, int r ) {
        if (r == 0) {
            String str = "";
            for (int i = 0; i < n; i++) {
                if (sel[i]) {
                    str += ch[i];
                }
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for (int k = idx; k < n; k++) {
            sel[k] = true;
            comb(map, ch, sel, k + 1, n, r - 1);
            sel[k] = false;
        }
    }
}

//테스트 1 〉	통과 (13.94ms, 78.6MB)
//테스트 2 〉	통과 (13.61ms, 83.9MB)
//테스트 3 〉	통과 (16.03ms, 85.3MB)
//테스트 4 〉	통과 (16.47ms, 77.1MB)
//테스트 5 〉	통과 (25.26ms, 70.2MB)
//테스트 6 〉	통과 (14.81ms, 82MB)
//테스트 7 〉	통과 (21.79ms, 73.2MB)
//테스트 8 〉	통과 (26.86ms, 88MB)
//테스트 9 〉	통과 (43.57ms, 94.9MB)
//테스트 10 〉	통과 (24.18ms, 87.2MB)
//테스트 11 〉	통과 (20.37ms, 84MB)
//테스트 12 〉	통과 (21.16ms, 83.9MB)
//테스트 13 〉	통과 (24.87ms, 85.6MB)
//테스트 14 〉	통과 (26.96ms, 79.2MB)
//테스트 15 〉	통과 (27.26ms, 75.8MB)
//테스트 16 〉	통과 (14.84ms, 79.8MB)
//테스트 17 〉	통과 (14.13ms, 78.4MB)
//테스트 18 〉	통과 (14.36ms, 80MB)
//테스트 19 〉	통과 (13.56ms, 84.7MB)
//테스트 20 〉	통과 (16.18ms, 76.7MB)