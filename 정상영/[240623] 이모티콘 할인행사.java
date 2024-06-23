/*
테스트 1 〉	통과 (0.03ms, 78.4MB)
테스트 2 〉	통과 (0.06ms, 72.9MB)
테스트 3 〉	통과 (0.12ms, 76.6MB)
테스트 4 〉	통과 (0.47ms, 67.5MB)
테스트 5 〉	통과 (1.45ms, 73.5MB)
테스트 6 〉	통과 (0.51ms, 72.3MB)
테스트 7 〉	통과 (2.53ms, 78.4MB)
테스트 8 〉	통과 (1.06ms, 73.9MB)
테스트 9 〉	통과 (5.82ms, 72.8MB)
테스트 10 〉	통과 (3.93ms, 77.4MB)
테스트 11 〉	통과 (22.10ms, 82.5MB)
테스트 12 〉	통과 (10.74ms, 75.7MB)
테스트 13 〉	통과 (42.71ms, 73.1MB)
테스트 14 〉	통과 (42.13ms, 75.4MB)
테스트 15 〉	통과 (5.87ms, 76.4MB)
테스트 16 〉	통과 (6.85ms, 84.5MB)
테스트 17 〉	통과 (0.11ms, 81MB)
테스트 18 〉	통과 (3.45ms, 77MB)
테스트 19 〉	통과 (0.03ms, 79.2MB)
테스트 20 〉	통과 (0.03ms, 82.1MB)
*/

// 박상용 코드 참고

class Solution {
    
    static int len, plus, profit;
    static int[] discountRate;
    
    public int[] solution(int[][] users, int[] emoticons) {
        len = emoticons.length;
        discountRate = new int[len];
        comb(0, users, emoticons);
        
        int[] answer = {plus, profit};
        return answer;
    }
    
    static void comb(int idx, int[][] users, int[] emoticons) {
        // basecase
        if(idx == len) {
            int currPlus = 0;
            int currProfit = 0;
            
            for(int[] user : users) {
                // 현재 할인율로 유저가 구매하는 금액
                int currUserCost = 0;
                
                for(int i = 0; i < len; i++) {
                    if(discountRate[i] >= user[0]) currUserCost += emoticons[i] * (100-discountRate[i]) / 100;
                }
                
                if(currUserCost >= user[1]) currPlus++;
                else currProfit += currUserCost;
            }
            
            if(currPlus > plus) {
                plus = currPlus;
                profit = currProfit;
              
            } else if(currPlus == plus && currProfit > profit) {
                profit = currProfit;
            }
            
            return;
        }
        
        // recursive
        for(int per = 10; per <= 40; per += 10) {
            discountRate[idx] = per;
            comb(idx + 1, users, emoticons);
        }
    }
}
