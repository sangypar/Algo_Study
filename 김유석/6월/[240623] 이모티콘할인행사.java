import java.util.*;

public class Programmers_4_이모티콘할인행사2 {
    private static int emoticonsNum;
    private static int userNum;
    private static int[] promotion = {10, 20, 30, 40};
    private static int maxSubscriber = 0;	
    private static int maxSale = 0;

    private static int[] solution(int[][] users, int[] emoticons) {
        emoticonsNum = emoticons.length;
        userNum = users.length;
        int[] selectedPro = new int[emoticonsNum];
        findOptimal(0, selectedPro, users, emoticons);
        return new int[]{maxSubscriber, maxSale};
    }

    private static void findOptimal(int depth, int[] selectedPro, int[][] users, int[] emoticons) {
        if (depth == emoticonsNum) { // 모든 이모티콘 할인 적용 완료
            int[] tmpSum = new int[userNum];
            int tmpSubscribe = 0;
            int totalSale = 0;

            for (int i = 0; i < userNum; i++) { // 각 사용자에 대해
                for (int j = 0; j < emoticonsNum; j++) { // 각 이모티콘에 대해
                    if (promotion[selectedPro[j]] >= users[i][0]) { // 할인이 사용자의 기준보다 크거나 같다면
                        tmpSum[i] += emoticons[j] * (100 - promotion[selectedPro[j]]) / 100;
                    }
                }
                if (tmpSum[i] >= users[i][1]) { // 사용자가 구매한 총 금액이 기준을 넘으면 구독
                    tmpSum[i] = 0;
                    tmpSubscribe++;
                } else {
                    totalSale += tmpSum[i];
                }
            }

            if (tmpSubscribe > maxSubscriber || (tmpSubscribe == maxSubscriber && totalSale > maxSale)) {
                maxSubscriber = tmpSubscribe;
                maxSale = totalSale;
            }
            return;
        }

        for (int i = 0; i < 4; i++) { // 4개의 프로모션 할인율 적용
            selectedPro[depth] = i;
            findOptimal(depth + 1, selectedPro, users, emoticons);
        }
    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        int[] result = solution(users, emoticons);
        System.out.println("Max Subscribers: " + result[0]);
        System.out.println("Max Sales: " + result[1]);
    }
}
/*
 * 테스트 1 〉	통과 (0.03ms, 72.9MB)
테스트 2 〉	통과 (0.04ms, 77.8MB)
테스트 3 〉	통과 (0.14ms, 83.2MB)
테스트 4 〉	통과 (0.57ms, 79.6MB)
테스트 5 〉	통과 (1.12ms, 74MB)
테스트 6 〉	통과 (0.66ms, 75.1MB)
테스트 7 〉	통과 (2.82ms, 80.2MB)
테스트 8 〉	통과 (1.56ms, 79.2MB)
테스트 9 〉	통과 (7.54ms, 78.9MB)
테스트 10 〉	통과 (3.19ms, 77.9MB)
테스트 11 〉	통과 (30.51ms, 81MB)
테스트 12 〉	통과 (11.79ms, 79MB)
테스트 13 〉	통과 (55.21ms, 112MB)
테스트 14 〉	통과 (54.60ms, 96.2MB)
테스트 15 〉	통과 (7.06ms, 79.4MB)
테스트 16 〉	통과 (11.23ms, 88MB)
테스트 17 〉	통과 (0.15ms, 76.5MB)
테스트 18 〉	통과 (2.28ms, 81MB)
테스트 19 〉	통과 (0.03ms, 76MB)
테스트 20 〉	통과 (0.03ms, 73.3MB)
*/
