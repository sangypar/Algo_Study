import java.util.*;

// 프로그래머스 Lv.2 주차 요금 계산
class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int baseTime = fees[0]; // 기본시간
        int baseFee = fees[1]; // 기본 요금
        int perTime = fees[2]; // 단위 시간
        int perFee = fees[3]; // 단위 요금

        Map<String, Integer> car = new HashMap<>(); // 주차장 출입을 관리할 Hashmap : 검색 성능이 좋음
        Map<String, Integer> parked = new TreeMap<>(); // 주차장 이용 시간을 관리할 Treemap : 정렬되는 map

        for (String r : records) {
            String[] str = r.split(" ");
            String time = str[0];
            String carNumber = str[1];
            String status = str[2];

            int minutes = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);

            if (status.equals("IN")) {
                car.put(carNumber, minutes);
            } else { // "OUT"
                int enter = car.remove(carNumber);
                int duration = minutes - enter;

                parked.put(carNumber, parked.getOrDefault(carNumber, 0) + duration); // 주차장 이용 시간
            }
        }

        for (Map.Entry<String, Integer> c : car.entrySet()) {
            int duration = 60 * 23 + 59 - c.getValue();
            String carNumber = c.getKey();

            parked.put(carNumber, parked.getOrDefault(carNumber, 0) + duration);
        }

        for (Map.Entry<String, Integer> p : parked.entrySet()) {
            int fee = 0;
            int duration = p.getValue();

            if (duration <= baseTime) {
                fee = baseFee;
            } else {
                fee = baseFee + (int) Math.ceil((double) (duration - baseTime) / perTime) * perFee;
            }

            answer.add(fee);
        }

        return answer;
    }

}

//테스트 1 〉	통과 (0.68ms, 72.7MB)
//테스트 2 〉	통과 (0.61ms, 76MB)
//테스트 3 〉	통과 (0.73ms, 72.4MB)
//테스트 4 〉	통과 (1.11ms, 72.9MB)
//테스트 5 〉	통과 (2.38ms, 76.6MB)
//테스트 6 〉	통과 (2.25ms, 74.4MB)
//테스트 7 〉	통과 (7.93ms, 86.1MB)
//테스트 8 〉	통과 (5.73ms, 79.8MB)
//테스트 9 〉	통과 (4.11ms, 78.9MB)
//테스트 10 〉	통과 (8.79ms, 77.3MB)
//테스트 11 〉	통과 (9.41ms, 76.2MB)
//테스트 12 〉	통과 (12.06ms, 87.4MB)
//테스트 13 〉	통과 (0.95ms, 77.9MB)
//테스트 14 〉	통과 (0.73ms, 77.6MB)
//테스트 15 〉	통과 (0.50ms, 76.2MB)
//테스트 16 〉	통과 (0.41ms, 74.7MB)