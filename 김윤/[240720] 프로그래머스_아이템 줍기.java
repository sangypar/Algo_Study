import java.util.*;

class Solution {
    
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[51][51];
    
        // 테두리를 제외한 다른 부분은 0으로 초기화 (내부로 들어가지 못하기)
        // 도형이 안쪽으로 들어갔다 나올 경우 어떻게 처리...?
    }
}
