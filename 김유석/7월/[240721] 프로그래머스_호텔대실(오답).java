import java.util.*;
/**
 * 테스트 1 〉	통과 (0.58ms, 72.3MB)
테스트 2 〉	실패 (3.59ms, 85.8MB)
테스트 3 〉	실패 (13.65ms, 88.3MB)
테스트 4 〉	실패 (6.10ms, 92.3MB)
테스트 5 〉	통과 (0.59ms, 83.7MB)
테스트 6 〉	실패 (9.05ms, 77MB)
테스트 7 〉	실패 (13.93ms, 88.1MB)
테스트 8 〉	실패 (5.33ms, 73.1MB)
테스트 9 〉	실패 (3.54ms, 81.6MB)
테스트 10 〉	실패 (8.48ms, 88MB)
테스트 11 〉	실패 (11.77ms, 73.6MB)
테스트 12 〉	실패 (9.98ms, 79.2MB)
테스트 13 〉	실패 (2.96ms, 70.5MB)
테스트 14 〉	실패 (16.12ms, 68.5MB)
테스트 15 〉	실패 (11.65ms, 76MB)
테스트 16 〉	실패 (5.05ms, 80.8MB)
테스트 17 〉	실패 (10.02ms, 83.4MB)
테스트 18 〉	실패 (11.81ms, 72.6MB)
테스트 19 〉	통과 (14.83ms, 89.5MB
 */
public class Programmers_8_호텔대실 {

    private static String [][] book_time;

    public static void main(String[] args) {
        book_time = new String[][] {
            {"15:00", "17:00"}, 
            {"16:40", "18:20"},
            {"14:20", "15:20"}, 
            {"14:10", "19:20"}, 
            {"18:20", "21:20"}
        };
        int result = solution(book_time);
        System.out.println(result);
    }

    static int solution(String [][] book_time) {
        int customerNum = book_time.length; // 손님의 수 
        List<timeTable> customer = new ArrayList<>();

        for (int i = 0; i < customerNum; i++) {
            String[] in = book_time[i][0].split(":"); 
            String[] out = book_time[i][1].split(":");
            int startTime = (Integer.parseInt(in[0]) * 60) + Integer.parseInt(in[1]);
            int outTime = (Integer.parseInt(out[0]) * 60) + Integer.parseInt(out[1]) + 10;
            customer.add(new timeTable(startTime, outTime));
        }

        // 퇴실 시간 기준으로 정렬
        Collections.sort(customer);

        int roomCnt = 0;
        boolean[] handled = new boolean[customerNum];

        for (int i = 0; i < customerNum; i++) {
            if (!handled[i]) {//배정안된 손님 
                handled[i] = true; //손님 배정 
                roomCnt++;
                int standard = customer.get(i).lastTime;
                for (int j = i + 1; j < customerNum; j++) {
                    if (!handled[j] && standard <= customer.get(j).startTime) {
                        handled[j] = true;
                        standard = customer.get(j).lastTime;
                    }
                }
            }
        }

        return roomCnt;
    }

    static class timeTable implements Comparable<timeTable> {
        int startTime;
        int lastTime;

        public timeTable(int startTime, int lastTime) {
            this.startTime = startTime;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(timeTable o) {
            return this.lastTime - o.lastTime;
        }
    }
}
