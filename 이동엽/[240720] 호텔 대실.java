class Solution {
    public int solution(String[][] book_time) {

        int[] using = new int[1450];

        for (String[] b : book_time) {
            int inTime = Integer.parseInt(b[0].substring(0, 2)) * 60 + Integer.parseInt(b[0].substring(3, 5));
            int outTime = Integer.parseInt(b[1].substring(0, 2)) * 60 + Integer.parseInt(b[1].substring(3, 5));

            using[inTime] += 1;
            using[outTime + 10] -= 1;
        }

        int answer = 0;
        for (int i = 1; i < 1450; i++) {
            using[i] += using[i - 1];
            answer = Math.max(using[i], answer);
        }

        return answer;
    }
}

//테스트 1 〉	통과 (0.24ms, 80.6MB)
//테스트 2 〉	통과 (0.80ms, 78.7MB)
//테스트 3 〉	통과 (2.30ms, 88.9MB)
//테스트 4 〉	통과 (2.15ms, 83MB)
//테스트 5 〉	통과 (0.14ms, 71.8MB)
//테스트 6 〉	통과 (1.56ms, 78.7MB)
//테스트 7 〉	통과 (1.59ms, 79.6MB)
//테스트 8 〉	통과 (1.32ms, 76.8MB)
//테스트 9 〉	통과 (1.27ms, 73.4MB)
//테스트 10 〉	통과 (1.64ms, 78.6MB)
//테스트 11 〉	통과 (1.75ms, 78.3MB)
//테스트 12 〉	통과 (2.63ms, 83.8MB)
//테스트 13 〉	통과 (0.76ms, 74.5MB)
//테스트 14 〉	통과 (1.39ms, 69.1MB)
//테스트 15 〉	통과 (1.45ms, 78.2MB)
//테스트 16 〉	통과 (0.80ms, 69.2MB)
//테스트 17 〉	통과 (1.58ms, 76.1MB)
//테스트 18 〉	통과 (1.24ms, 80.2MB)
//테스트 19 〉	통과 (2.10ms, 79MB)