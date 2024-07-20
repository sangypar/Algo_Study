import java.util.*;

/**
 * 테스트 1 〉	통과 (3.65ms, 74.8MB)
테스트 2 〉	통과 (7.69ms, 82.9MB)
테스트 3 〉	통과 (7.86ms, 79.4MB)
테스트 4 〉	통과 (8.76ms, 79.9MB)
테스트 5 〉	통과 (2.17ms, 74.5MB)
테스트 6 〉	통과 (8.37ms, 86.7MB)
테스트 7 〉	통과 (8.32ms, 78.7MB)
테스트 8 〉	통과 (6.22ms, 75.7MB)
테스트 9 〉	통과 (6.89ms, 85.8MB)
테스트 10 〉	통과 (8.25ms, 88.4MB)
테스트 11 〉	통과 (10.42ms, 75.7MB)
테스트 12 〉	통과 (10.87ms, 76MB)
테스트 13 〉	통과 (4.55ms, 76.2MB)
테스트 14 〉	통과 (8.71ms, 86.2MB)
테스트 15 〉	통과 (10.08ms, 79.3MB)
테스트 16 〉	통과 (6.05ms, 81.7MB)
테스트 17 〉	통과 (7.74ms, 86.4MB)
테스트 18 〉	통과 (10.52ms, 89.6MB)
테스트 19 〉	통과 (9.05ms, 78.1MB)
 */
public class Programmers_8_호텔대실2 {
	
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

        // 시작 시간 기준으로 정렬
        Collections.sort(customer, Comparator.comparingInt(o -> o.startTime));

        // 우선순위 큐를 사용하여 각 방의 퇴실 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (timeTable t : customer) {
            if (!pq.isEmpty() && pq.peek() <= t.startTime) {
                pq.poll(); // 기존 방을 재사용
            }
            pq.add(t.lastTime); // 새로운 방을 사용하거나 기존 방의 퇴실 시간을 갱신
        }

        return pq.size(); // 필요한 방의 최소 개수
    }

    static class timeTable {
        int startTime;
        int lastTime;

        public timeTable(int startTime, int lastTime) {
            this.startTime = startTime;
            this.lastTime = lastTime;
        }
    }
}
