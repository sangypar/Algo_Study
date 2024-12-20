package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] calculate = input.split("-");
		
		int len = calculate.length;
		
		int[] answer = new int[len];
		
		for(int i = 0; i < len; i++) {
			String[] arr = calculate[i].contains("+") ? calculate[i].split("\\+") : new String[] {calculate[i]};
			
			int num = 0;
			
			for(int j = 0; j < arr.length; j++) {
				num += Integer.parseInt(arr[j]);
			}
			
			answer[i] = num;
		}
		
		int min = answer[0];
		
		for(int i = 1; i < len; i++) {
			min -= answer[i];
		}
		
		System.out.println(min);
	}
}
