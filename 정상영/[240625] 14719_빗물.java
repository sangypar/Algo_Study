import java.util.Scanner;

public class BJ14719_빗물 {
    
    static int h, w, answer;
    static int[] heights;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        h = sc.nextInt();
        w = sc.nextInt();
        
        heights = new int[w];
        
        for (int i = 0; i < w; i++) {
            heights[i] = sc.nextInt();
        }
        
        answer = 0;
        int left = 0;
        int right = w - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        
        // 좌우 포인터가 만날 때 까지 
        while (left < right) {
        	// 왼쪽보다 오른쪽이 높다면
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                answer += leftMax - heights[left];
            
            // 왼쪽이 높다면 
            } else {
                right--;
                rightMax = Math.max(rightMax, heights[right]);
                answer += rightMax - heights[right];
            }
        }
        
        System.out.println(answer);
    }
}
