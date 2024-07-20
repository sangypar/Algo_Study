import java.io.IOException;

class Solution {
    
    static int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
    
    public static void main(String[] args) throws IOException{
        solution(rectangle, 1, 3, 7, 8);
    } // main

    public static int solution(int[][] rectangle, int charX, int charY, int itemX, int itemY) {
    	
    	int ans = 0;
    	int[][] map = new int[51][51]; // 좌표값 1이상 50이하
    	
    	for (int[] rect : rectangle) {
    		
            int x1 = rect[0]; int y1 = rect[1];
            int x2 = rect[2]; int y2 = rect[3];
            
            // 테두리 사방으로 표시
    	}
    	
        return ans;
    }
}