/*
테스트 1 〉	통과 (1.07ms, 75.9MB)
테스트 2 〉	통과 (1.08ms, 77.6MB)
테스트 3 〉	통과 (1.84ms, 77.9MB)
테스트 4 〉	통과 (1.38ms, 73.9MB)
테스트 5 〉	통과 (2.16ms, 73.7MB)
테스트 6 〉	통과 (2.05ms, 77.5MB)
테스트 7 〉	통과 (5.53ms, 78.2MB)
테스트 8 〉	통과 (6.01ms, 85.1MB)
테스트 9 〉	통과 (2.07ms, 82.9MB)
테스트 10 〉	통과 (21.29ms, 82.3MB)
테스트 11 〉	통과 (5.72ms, 78.8MB)
테스트 12 〉	통과 (6.65ms, 84.9MB)
테스트 13 〉	통과 (2.06ms, 72.1MB)
테스트 14 〉	통과 (1.64ms, 83.3MB)
테스트 15 〉	통과 (1.14ms, 80MB)
테스트 16 〉	통과 (1.33ms, 84.8MB)
*/

import java.util.*;

class Solution {
    public Integer[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int[] inTime = new int[10000]; // 입차 시간을 저장할 배열
        int[] totalTime = new int[10000]; // 총 주차 시간을 저장할 배열
        boolean[] inParking = new boolean[10000]; // 주차 여부를 저장할 배열
        int[] finalFee = new int[10000]; // 최종 주차 요금을 저장할 배열
        
        Arrays.fill(finalFee, -1); // 주차비가 있는지 확인하기 위해 -1로 설정
        Arrays.fill(inTime, -1); // 초기화를 위해 -1로 설정
        
        for (String record : records) {
            String[] input = record.split(" ");
            int time = Integer.parseInt(input[0].substring(0, 2)) * 60 + Integer.parseInt(input[0].substring(3, 5));
            int carNum = Integer.parseInt(input[1]);
            String action = input[2];
            
            if (action.equals("IN")) {
                inTime[carNum] = time;
                inParking[carNum] = true;
                
            } else { // OUT
                int parkedTime = time - inTime[carNum];
                totalTime[carNum] += parkedTime;
                inTime[carNum] = -1; // 출차 시 입차 시간 초기화
                inParking[carNum] = false;
            }
        }
        
        // 입차 후 출차 기록이 없는 차량 처리 (23:59 출차 간주)
        for (int i = 0; i < inTime.length; i++) {
            if (inParking[i]) {
                int parkedTime = (23 * 60 + 59) - inTime[i];
                totalTime[i] += parkedTime;
            }
        }
        
        // 요금 계산
        for (int i = 0; i < totalTime.length; i++) {
            if (totalTime[i] > 0) {
                int fee = fees[1];
                if (totalTime[i] > fees[0]) {
                    fee += Math.ceil((double)(totalTime[i] - fees[0]) / fees[2]) * fees[3];
                }
                finalFee[i] = fee;
            }
        }
        
        // 낮은 차 번호부터 낼 요금 있으면 List에 추가
        for (int i = 0; i < finalFee.length; i++) {
            if(finalFee[i] != -1) {
                answer.add(finalFee[i]);
            }
        }
        
        return answer.toArray(new Integer[0]);
    }
}
