import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] heights = new int[W];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int lt = 0;
		int rt = W - 1;
		int leftMax = heights[lt];
		int rightMax = heights[rt];

		while (lt <= rt) {
			
			if (leftMax <= rightMax) {
				if (heights[lt] >= leftMax) {
					leftMax = heights[lt];
				} else {
					ans += leftMax - heights[lt];
				}
				
				lt++;
			} else {
				if (heights[rt] >= rightMax) {
					rightMax = heights[rt];
				} else {
					ans += rightMax - heights[rt];
				}
				
				rt--;
			}
		}

		System.out.println(ans);
	}
}