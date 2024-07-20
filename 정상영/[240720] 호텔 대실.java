/*
테스트 1 〉	통과 (0.21ms, 86.5MB)
테스트 2 〉	통과 (2.07ms, 73.9MB)
테스트 3 〉	통과 (7.61ms, 81.3MB)
테스트 4 〉	통과 (4.67ms, 79.9MB)
테스트 5 〉	통과 (0.10ms, 73.8MB)
테스트 6 〉	통과 (3.78ms, 82.3MB)
테스트 7 〉	통과 (3.95ms, 82.2MB)
테스트 8 〉	통과 (3.87ms, 80MB)
테스트 9 〉	통과 (2.32ms, 78.2MB)
테스트 10 〉	통과 (3.20ms, 85.5MB)
테스트 11 〉	통과 (8.10ms, 80.2MB)
테스트 12 〉	통과 (5.08ms, 83.7MB)
테스트 13 〉	통과 (1.28ms, 76.2MB)
테스트 14 〉	통과 (2.93ms, 75.8MB)
테스트 15 〉	통과 (5.13ms, 82.7MB)
테스트 16 〉	통과 (2.33ms, 77.2MB)
테스트 17 〉	통과 (5.31ms, 87.2MB)
테스트 18 〉	통과 (2.65ms, 86.2MB)
테스트 19 〉	통과 (2.93ms, 83MB)
*/

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        
        int[] reservation = new int[23 * 60 + 59 + 10];
        
        for(int i = 0; i < book_time.length; i++) {
            String start = book_time[i][0];
            String end = book_time[i][1];
            
            int startTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
            int endTime = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5));
            
            for(int j = startTime; j < endTime + 10; j++) {
                reservation[j]++;
            }
        }
        
        for(int i = 0; i < reservation.length; i++) {
            answer = Math.max(answer, reservation[i]);
        }
        
        return answer;
    }
}
