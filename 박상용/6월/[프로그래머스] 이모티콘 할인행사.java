class Solution {
	static int plus, cost, len; // 결과값(서비스 가입자/ 판매액), 이모티콘 개수 
	static int[] arr; // 이모티콘 할인율 담는 배열
	
    public int[] solution(int[][] users, int[] emoticons) {
    	len = emoticons.length;
    	arr = new int[len];
    	comb(0, users, emoticons); // 조합으로 풀기
    	int[] answer = {plus, cost}; // 출력
        return answer;
    }

	private void comb(int i, int[][] users, int[] emoticons) {
		   if (i == len) { // 종료 조건
			   int tmpplus = 0;
			   int tmpcost = 0;
			   for(int[] user : users) { // 한 유저마다 할인율 적용해서 계산
				   int usercost = 0;
				   for(int j = 0; j < len; j++) {
					   if(arr[j] >= user[0]) {
						   usercost += emoticons[j] / 100 * (100-arr[j]);
					   }
				   }
				   if(usercost >= user[1]) // 기준 가격 이상시 플러스 가입
					   tmpplus++;
				   else
					   tmpcost += usercost;
			   }
			   if(tmpplus > plus) { // 1번 목표 달성시 갱신
				   plus = tmpplus;
				   cost = tmpcost;
			   }else if(tmpplus == plus) 
				   cost = Math.max(cost, tmpcost);
	            return;
	        }
	        
	        for (int j = 10; j <= 40; j += 10) {
	            arr[i] = j;
	            comb(i+1, users, emoticons);
	        }
	}

	
}