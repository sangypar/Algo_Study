import java.util.*;

class Solution {
    
    static int num = 0;     // 이모티콘 플러스 가입자
	  static int amount = 0;  // 판매액
    
    public int[] solution(int[][] users, int[] emoticons) {
      int[] answer = new int[2];
      
      int[] arr = new int[emoticons.length];
		
		comb(arr, 0, users, emoticons);
        
		answer[0] = num;
		answer[1] = amount;
		
        return answer;
    }
    
    private static void comb(int[] arr, int start, int[][] users, int[] emoticons) {
		
		if (start == arr.length) {
			calc(arr, users, emoticons);
			return;
		}
		
		for (int i = 1; i <= 4; i++) {
			arr[start] = 10 * i;
			comb(arr, start + 1, users, emoticons);
		}
	}

	private static void calc(int[] arr, int[][] users, int[] emoticons) {
		
		int cnt = 0;
		int profit = 0;
		
		for (int i = 0; i < users.length; i++) {
			int standard = users[i][0];
			int price = users[i][1];
			int sum = 0;
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] >= standard) {
					sum += (emoticons[j] / 100) * (100 - arr[j]);
				}
			}
			
			if (sum >= price) 
				cnt++;
			else
				profit += sum;
		}
		
		if (cnt > num) {
			num = cnt;
			amount = profit;
			return;
		} else if (cnt == num && amount < profit) {
			amount = profit;
		}
	}
}