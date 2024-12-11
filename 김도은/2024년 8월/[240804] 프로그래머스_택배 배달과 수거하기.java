class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
       long answer = 0;

		while (true) {

			// 둘다 비어있으면 멈췃
			if (check(deliveries, pickups)) {
				break;
			}

			int deliveryIndex = findLastIndex(deliveries);
			int pickupIndex = findLastIndex(pickups);

			int distance = Math.max(deliveryIndex, pickupIndex); //둘중 더 큰애로
			
			answer += distance * 2;
			
			deliver(deliveries, cap);
			pickUp(pickups, cap);

		}

		return answer;
    }
    
    private static void pickUp(int[] pickups, int cap) {
		
        int nowCap = cap;
        
        for (int i = pickups.length - 1; i >= 0; i--) {
        	
            if (pickups[i] == 0) continue;
            
            if (nowCap >= pickups[i]) {
                nowCap -= pickups[i];
                pickups[i] = 0;
            } else {
                pickups[i] -= nowCap;
                nowCap = 0;
                break;
            }
        }
		
	}

	private static void deliver(int[] deliveries, int cap) {
		int nowCap = cap;
		
		   for (int i = deliveries.length - 1; i >= 0; i--) {
			   
	            if (deliveries[i] == 0) continue;
	            
	            if (nowCap >= deliveries[i]) {
	                nowCap -= deliveries[i];
	                deliveries[i] = 0;
	            } else {
	                deliveries[i] -= nowCap;
	                nowCap = 0;
	                break;
	            }
	        }
	}

	private static int findLastIndex(int[] arr) {
		
		for(int j = arr.length-1; j >= 0; j--) {
			if(arr[j] > 0) return j+1;
		}
		
		return -1;
	}

	private static boolean check(int[] deliveries, int[] pickups) {

		for (int i = 0; i < deliveries.length; i++) {
			if (deliveries[i] != 0)
				return false;
		}

		for (int j = 0; j < pickups.length; j++) {
			if (pickups[j] != 0)
				return false;
		}

		return true;
	}

}

// 테스트 1 〉	통과 (0.15ms, 75.4MB)
// 테스트 2 〉	통과 (0.08ms, 72.2MB)
// 테스트 3 〉	통과 (0.13ms, 82.7MB)
// 테스트 4 〉	통과 (0.06ms, 74MB)
// 테스트 5 〉	통과 (0.13ms, 77.9MB)
// 테스트 6 〉	통과 (0.14ms, 76.9MB)
// 테스트 7 〉	통과 (5.00ms, 78.7MB)
// 테스트 8 〉	통과 (9.75ms, 82.5MB)
// 테스트 9 〉	통과 (51.41ms, 91.6MB)
// 테스트 10 〉	통과 (51.80ms, 77.3MB)
// 테스트 11 〉	통과 (16.08ms, 81.6MB)
// 테스트 12 〉	통과 (15.79ms, 76.7MB)
// 테스트 13 〉	통과 (18.57ms, 78MB)
// 테스트 14 〉	통과 (20.58ms, 76.8MB)
// 테스트 15 〉	통과 (236.13ms, 84.5MB)
// 테스트 16 〉	실패 (시간 초과)
// 테스트 17 〉	실패 (시간 초과)
// 테스트 18 〉	통과 (3556.11ms, 102MB)
// 테스트 19 〉	통과 (3946.63ms, 85.2MB)
// 테스트 20 〉	통과 (6141.46ms, 95.8MB)
// 채점 결과
// 정확성: 90.0
// 합계: 90.0 / 100.0
