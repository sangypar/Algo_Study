import java.util.*;
/*
 * 테스트 1 〉	통과 (4.16ms, 74.1MB)
테스트 2 〉	통과 (2.50ms, 79.7MB)
테스트 3 〉	통과 (1.96ms, 78.1MB)
테스트 4 〉	통과 (2.33ms, 80.4MB)
테스트 5 〉	통과 (4.15ms, 85.3MB)
테스트 6 〉	통과 (4.12ms, 88.3MB)
테스트 7 〉	통과 (21.89ms, 82.8MB)
테스트 8 〉	통과 (11.80ms, 81.4MB)
테스트 9 〉	통과 (3.08ms, 77.7MB)
테스트 10 〉	통과 (18.75ms, 87.5MB)
테스트 11 〉	통과 (11.83ms, 79.6MB)
테스트 12 〉	통과 (8.18ms, 81.7MB)
테스트 13 〉	통과 (2.51ms, 75.4MB)
테스트 14 〉	통과 (2.72ms, 78.8MB)
테스트 15 〉	통과 (2.35ms, 78.4MB)
테스트 16 〉	통과 (1.99ms, 73.1MB)
 */
public class Programmers_6_주차요금계산3 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위시간, 단위요금
        String[] record = {
            "05:34 5961 IN", "06:00 0000 IN",
            "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN",
            "19:09 0148 OUT", "22:59 5961 IN",
            "23:00 5961 OUT"
        };
        int[] result = solution(fees, record);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static int inCnt = 0;

    public static int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        List<carManager>[] carList = new LinkedList[10000];
        for (int i = 0; i < 10000; i++) {
            carList[i] = new LinkedList<>();
        }

        Set<Integer> carNumbers = new HashSet<>();
        
        for (String record : records) {
            String[] splited = record.split(" ");
            String time = splited[0];
            String[] timeMin = time.split(":");
            // 시간 계산
            int min = Integer.parseInt(timeMin[0]) * 60 + Integer.parseInt(timeMin[1]);
            int carNum = Integer.parseInt(splited[1]);
            String isInOUT = splited[2];

            carList[carNum].add(new carManager(min, isInOUT.equals("IN")));
            carNumbers.add(carNum);
        }

        List<Integer> carNumberList = new ArrayList<>(carNumbers);
        Collections.sort(carNumberList);
        int[] answer = new int[carNumberList.size()];

        for (int i = 0; i < carNumberList.size(); i++) {
            int nowCarNum = carNumberList.get(i);
            List<carManager> history = carList[nowCarNum];
            int totalMinutes = 0;
            for (int j = 0; j < history.size(); j++) {
                carManager car = history.get(j);
                if (car.isIn) { //24시 까지 있었던것으로 간주  
                	//2번 안들어왔으면 false -> 24시 간주 초기화
                	//2번 들어왔으면 true  -> 아웃타임 초기화
                    int outTime = (j + 1 < history.size() && !history.get(j + 1).isIn) ? history.get(j + 1).time : 23 * 60 + 59;
                    totalMinutes += (outTime - car.time); 
                }
            }

            // 요금 계산
            if (totalMinutes <= basicTime) {
                answer[i] = basicFee;
            } else {
                answer[i] = basicFee + (int) Math.ceil((totalMinutes - basicTime) / (double) unitTime) * unitFee;
            }
        }

        return answer;
    }

    static class carManager {
        int time;
        boolean isIn;

        public carManager(int time, boolean isIn) {
            this.time = time;
            this.isIn = isIn;
        }
    }
}
