import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 1744_수 묶기
public class Main {
	
	static int sum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		sum = 0;
		
		List<Integer> positive = new ArrayList<>();	// 양수
		List<Integer> negative = new ArrayList<>();	// 음수
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num <= 0) {
				negative.add(num);
			} else if (num == 1) {	// 1에 대한 처리가 양수에 대한 처리보다 먼저
				sum++;
			} else if (num > 0) {
				positive.add(num);
			}
		}
		
		Collections.sort(positive, Comparator.reverseOrder());
		Collections.sort(negative);
		
//		System.out.println(positive);
//		System.out.println(negative);
		
		calcSum(positive);
		calcSum(negative);
		System.out.println(sum);
	}

	private static void calcSum(List<Integer> list) {
		
		int idx = 0;
		
		for (int i = 0; i < list.size() / 2; i++) {
			sum += list.get(idx) * list.get(idx + 1);
			idx += 2;
		}
		
		// 홀수 처리: 하나 남은 요소 더해주기
		if (list.size() % 2 != 0) {
			sum += list.get(list.size() - 1);
		}
	}
}
