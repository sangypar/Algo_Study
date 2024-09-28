package programmers.기능개발;

import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            int work = 100 - progresses[i];
            int workday = work / speeds[i];
            if (work % speeds[i] != 0) {
                workday += 1;
            }
            days[i] = workday;
        }

        List<Integer> answer = new ArrayList<>();
        int max = days[0];
        int cnt = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= max) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                max = days[i];
            }
        }
        answer.add(cnt);

        return answer;
    }
}

//테스트 1 〉	통과 (0.02ms, 79.4MB)
//테스트 2 〉	통과 (0.04ms, 78.3MB)
//테스트 3 〉	통과 (0.05ms, 75.1MB)
//테스트 4 〉	통과 (0.04ms, 75.4MB)
//테스트 5 〉	통과 (0.03ms, 72.8MB)
//테스트 6 〉	통과 (0.03ms, 75.6MB)
//테스트 7 〉	통과 (0.03ms, 74.6MB)
//테스트 8 〉	통과 (0.03ms, 73.3MB)
//테스트 9 〉	통과 (0.03ms, 77MB)
//테스트 10 〉	통과 (0.06ms, 74.6MB)
//테스트 11 〉	통과 (0.03ms, 74.7MB)