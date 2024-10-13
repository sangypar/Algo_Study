import java.util.List;

/**
 * 테스트 1 〉	통과 (0.11ms, 71.5MB)
테스트 2 〉	통과 (0.11ms, 77.7MB)
테스트 3 〉	통과 (0.13ms, 77MB)
테스트 4 〉	통과 (0.06ms, 78MB)
테스트 5 〉	통과 (0.12ms, 72.5MB)
테스트 6 〉	통과 (0.09ms, 75.4MB)
테스트 7 〉	통과 (0.66ms, 75.5MB)
테스트 8 〉	통과 (9.21ms, 84MB)
테스트 9 〉	통과 (23.37ms, 80.3MB)
테스트 10 〉	통과 (24.40ms, 81.5MB)
테스트 11 〉	통과 (1.87ms, 86.9MB)
테스트 12 〉	통과 (4.21ms, 77.1MB)
테스트 13 〉	통과 (16.39ms, 82.9MB)
테스트 14 〉	통과 (21.04ms, 81MB)
테스트 15 〉	통과 (8.68ms, 81.7MB)
테스트 16 〉	통과 (236.37ms, 85.4MB)
테스트 17 〉	통과 (4016.69ms, 99.3MB)
테스트 18 〉	통과 (23.34ms, 95.8MB)
테스트 19 〉	통과 (811.84ms, 99.5MB)
테스트 20 〉	통과 (1072.02ms, 91.5MB)
 */
public class Programmers_9_택배배달과수거하기 {

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        long result = solution(cap, n, deliveries, pickups);
        System.out.println(result);  
    }

    private static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int deliveryLocation = n - 1; 
        int pickupLocation = n - 1;

        while (deliveryLocation >= 0 || pickupLocation >= 0) {
            // 현재 트럭의 적재 상태 초기화
            int truckDelivery = 0;
            int truckPickup = 0;

            // 가장 먼 지점부터 배달할 물품이 있는 곳 탐색
            while (deliveryLocation >= 0 && deliveries[deliveryLocation] == 0) {
                deliveryLocation--;
            }

            // 가장 먼 지점부터 수거할 물품이 있는 곳 탐색
            while (pickupLocation >= 0 && pickups[pickupLocation] == 0) {
                pickupLocation--;
            }

            // 현재 탐색된 가장 먼 지점 계산
            int farHouse = Math.max(deliveryLocation, pickupLocation);

            if (farHouse < 0) {
                break;
            }

            // 해당 지점까지 왕복 거리 계산
            totalDistance += (farHouse + 1) * 2;

            // 배달 처리
            for (int i = farHouse; i >= 0; i--) {
                if (truckDelivery + deliveries[i] <= cap) {
                    truckDelivery += deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= (cap - truckDelivery);
                    truckDelivery = cap;
                    break;
                }
            }
            List<E>
            // 수거 처리
            for (int i = farHouse; i >= 0; i--) {
                if (truckPickup + pickups[i] <= cap) {
                    truckPickup += pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= (cap - truckPickup);
                    truckPickup = cap;
                    break;
                }
            }
        }

        return totalDistance;
    }
}
