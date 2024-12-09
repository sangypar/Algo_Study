import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String str = pos; // 시작점
        String[] time = str.split(":");
        int minute = Integer.parseInt(time[0]);
        int second = Integer.parseInt(time[1]);
        
        time = op_start.split(":");
        int start_min = Integer.parseInt(time[0]);
        int start_sec = Integer.parseInt(time[1]);
        
        time = op_end.split(":");
        int end_min = Integer.parseInt(time[0]);
        int end_sec = Integer.parseInt(time[1]);
        
        time = video_len.split(":");
        int len_min = Integer.parseInt(time[0]);
        int len_sec = Integer.parseInt(time[1]);
        
        if (minute > start_min || (minute == start_min && second >= start_sec)) {
            if (minute < end_min || (minute == end_min && second <= end_sec)) {
                minute = end_min;
                second = end_sec;
            }
        }
        
        for (int t = 0; t < commands.length; t++) {
            if (commands[t].equals("prev")) {
                if (second >= 10) {
                    second -= 10;
                } else {
                    if (minute == 0) {
                        minute = 0;
                        second = 0;
                    } else {
                        minute -= 1;
                        second += 50;
                    }
                }
            } else {
                if (second >= 50) {
                    minute += 1;
                    second -= 50;
                } else {
                    second += 10;
                }
                
                if (minute > len_min || (minute == len_min && second > len_sec)) {
                    minute = len_min;
                    second = len_sec;
                }
            }
            
            if (minute > start_min || (minute == start_min && second >= start_sec)) {
            if (minute < end_min || (minute == end_min && second <= end_sec)) {
                minute = end_min;
                second = end_sec;
            }
        }
        }
        
        if (minute < 10 && second < 10) {
            str = "0" + minute + ":" + "0" + second;
        } else if (minute < 10) {
            str = "0" + minute + ":" + second;
        } else if (second < 10) {
            str = minute + ":" + "0" + second;
        } else {
            str = minute + ":" + second;
        }
        
        return str;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (8.01ms, 108MB)
// 테스트 2 〉	통과 (6.93ms, 86MB)
// 테스트 3 〉	통과 (8.13ms, 79.9MB)
// 테스트 4 〉	통과 (6.94ms, 77.8MB)
// 테스트 5 〉	통과 (7.51ms, 76.7MB)
// 테스트 6 〉	통과 (8.06ms, 90.2MB)
// 테스트 7 〉	통과 (7.88ms, 74.7MB)
// 테스트 8 〉	통과 (7.96ms, 86.6MB)
// 테스트 9 〉	통과 (7.10ms, 87.5MB)
// 테스트 10 〉	통과 (8.34ms, 77.8MB)
// 테스트 11 〉	통과 (7.23ms, 89.9MB)
// 테스트 12 〉	통과 (7.58ms, 79.1MB)
// 테스트 13 〉	통과 (6.63ms, 86.7MB)
// 테스트 14 〉	통과 (8.09ms, 83.3MB)
