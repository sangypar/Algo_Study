package programmers.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total / height; height++) {
            if (total % height == 0) {
                int width = total / height;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }
}

//테스트 1 〉	통과 (0.02ms, 71.2MB)
//테스트 2 〉	통과 (0.01ms, 72.2MB)
//테스트 3 〉	통과 (0.07ms, 75.2MB)
//테스트 4 〉	통과 (0.03ms, 74.7MB)
//테스트 5 〉	통과 (0.01ms, 72.2MB)
//테스트 6 〉	통과 (0.02ms, 77.5MB)
//테스트 7 〉	통과 (0.05ms, 75.7MB)
//테스트 8 〉	통과 (0.03ms, 78.9MB)
//테스트 9 〉	통과 (0.04ms, 84.4MB)
//테스트 10 〉	통과 (0.03ms, 78.6MB)
//테스트 11 〉	통과 (0.02ms, 75.3MB)
//테스트 12 〉	통과 (0.03ms, 76.3MB)
//테스트 13 〉	통과 (0.02ms, 72.8MB)