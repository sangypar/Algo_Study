import java.util.*;

public class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, String> inTime = new HashMap<>();
        
        for (String record : records) {
            String[] details = record.split(" ");
            String time = details[0];
            String carNumber = details[1];
            String status = details[2];
            
            if (status.equals("IN")) {
                inTime.put(carNumber, time);
            } else {
                String in = inTime.remove(carNumber);
                int duration = calculateMinutes(in, time);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + duration);
            }
        }
        
        for (String carNumber : inTime.keySet()) {
            String in = inTime.get(carNumber);
            int duration = calculateMinutes(in, "23:59");
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + duration);
        }
        
        List<String> carNumbers = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNumbers);
        
        int[] result = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int time = parkingTime.get(carNumber);
            result[i] = calculateFee(fees, time);
        }
        
        return result;
    }
    
    private int calculateMinutes(String in, String out) {
        String[] inParts = in.split(":");
        String[] outParts = out.split(":");
        
        int inHour = Integer.parseInt(inParts[0]);
        int inMinute = Integer.parseInt(inParts[1]);
        int outHour = Integer.parseInt(outParts[0]);
        int outMinute = Integer.parseInt(outParts[1]);
        
        return (outHour * 60 + outMinute) - (inHour * 60 + inMinute);
    }
    
    private int calculateFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (time <= basicTime) {
            return basicFee;
        } else {
            int extraTime = time - basicTime;
            int extraUnits = (int) Math.ceil((double) extraTime / unitTime);
            return basicFee + extraUnits * unitFee;
        }
    }
}

// 테스트 1 〉	통과 (0.63ms, 78.2MB)
// 테스트 2 〉	통과 (0.48ms, 74.6MB)
// 테스트 3 〉	통과 (0.71ms, 77.3MB)
// 테스트 4 〉	통과 (1.29ms, 79.4MB)
// 테스트 5 〉	통과 (2.38ms, 78.5MB)
// 테스트 6 〉	통과 (2.30ms, 82.3MB)
// 테스트 7 〉	통과 (7.74ms, 80.6MB)
// 테스트 8 〉	통과 (5.02ms, 78.4MB)
// 테스트 9 〉	통과 (2.13ms, 74.9MB)
// 테스트 10 〉	통과 (5.97ms, 82.3MB)
// 테스트 11 〉	통과 (7.98ms, 70.7MB)
// 테스트 12 〉	통과 (7.77ms, 79.1MB)
// 테스트 13 〉	통과 (0.82ms, 67MB)
// 테스트 14 〉	통과 (0.78ms, 75.9MB)
// 테스트 15 〉	통과 (0.46ms, 80.2MB)
// 테스트 16 〉	통과 (0.31ms, 77.1MB)