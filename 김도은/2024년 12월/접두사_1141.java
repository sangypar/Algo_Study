package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 접두사_1141 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr= new String[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = br.readLine();
		} //입력 완료
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
		    public int compare(String a, String b) {
		        // 문자열 길이를 기준으로 정렬
		        if (a.length() != b.length()) {
		            return a.length() - b.length(); // 길이가 짧은 순서로 정렬
		        }
		        
		        // 길이가 같으면 사전순 정렬
		        return a.compareTo(b);
		    }
		});
		
		int count = N;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[j].startsWith(arr[i])) {
					count--;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
