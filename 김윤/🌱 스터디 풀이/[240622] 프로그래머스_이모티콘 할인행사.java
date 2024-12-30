// 몰라서 검색했어요...
class Solution {
    int members = 0; // 최대 회원 수
    int revenue = 0; // 최대 수익
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] arr = new int[emoticons.length];
        
        combination(arr, 0, users, emoticons);
        
        answer[0] = members;
        answer[1] = revenue;
        
        return answer;
    }
    
    // 할인되는 경우의 수 중복조합
    public void combination(int[] arr, int start, int[][] users, int[] emoticons) {
        if (start == arr.length) {
            calculate(arr, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            arr[start] = i;
            combination(arr, start+1, users, emoticons);
        } 
    }
    
    // 회원과 수익 계산
    public void calculate(int[] arr, int[][] users, int[] emoticons) {
        int count = 0; // 회원 수
        int earning = 0; // 수익
        
        for (int[] user : users) {
            int discount = user[0];
            int price = user[1];
            int sum = 0;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= discount) {
                    sum += (emoticons[i] / 100) * (100 - arr[i]);
                }
            }
            
            // 구입비가 price보다 높으면 가입, 낮다면 수익 올리기
            if (sum >= price) {
                count++;
            } else {
                earning += sum;
            }
        }
        
        if (count > members) {
            members = count;
            revenue = earning;
            return;
        } else if (count == members) {
            if (revenue < earning) {
                revenue = earning;
            }
        }
    }
}