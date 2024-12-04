package baekjoon;

import java.util.HashSet;
import java.util.Set;

public class Main_4673_셀프넘버 {
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= 10000; i++) {
			int sum = i;
			int temp = i;
			
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			
			if (sum <= 10000) set.add(sum);
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (!set.contains(i)) System.out.println(i);
		}
	}
	
}
