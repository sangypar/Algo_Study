import java.util.*;

// 알파벳 별로 가중치 부여
// 가중치 높은 순으로 9에서 내려가면서 더하기 

public class BJ1339_단어수학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] apb = new int[26];
		
		for(int i = 0; i < n; i++) {
			char[] input = sc.next().toCharArray();
			
			// 알파벳 별 자릿수에 따른 가중치 부여
			for(int j = 0; j < input.length; j++) {
				apb[(input[j] - 65)] += Math.pow(10, input.length - j - 1);
			}
		}
		
		// 가중치 높은 순으로 9부터 곱하면서 누적합하기 
		boolean[] used = new boolean[26];
		int ans = 0;
		
		for(int i = 9; i >= 0; i--) {
			int max = -1;
			int maxIdx = -1;
			
			for(int j = 0; j < 26; j++) {
				if(apb[j] > max && !used[j]) {
					max = apb[j];
					maxIdx =j;
				}
			}
			used[maxIdx] = true;
			ans += max * i;
		}
		
		System.out.println(ans);
	}
}
