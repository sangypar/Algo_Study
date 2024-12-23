package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //나무의 수
		int M = Integer.parseInt(st.nextToken()); //나무의 길이
		
		int[] tree = new int[N]; //나무의 높이
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0; //최대 나무 높이
		
		for(int n = 0; n < N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, tree[n]);
		}
		
		int min = 0;
		
		while(min < max) {

			int mid = (min + max) / 2;
			long sum = 0;
			
			for(int n = 0; n < N; n++) {
				if(tree[n] - mid <= 0) continue;
				
				sum += tree[n] - mid;
			}
			
			if(sum < M) {
				max = mid; //왼쪽 탐색
			} else {
				min = mid + 1; //오른쪽 탐색
			}
		}
		
		System.out.println(min - 1);
		
	}
}
