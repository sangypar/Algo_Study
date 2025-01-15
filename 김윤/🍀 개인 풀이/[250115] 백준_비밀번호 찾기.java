package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17219_비밀번호찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> map = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int n = 0; n < N; n++) {
			String temp = br.readLine();
			
			String site = temp.split(" ")[0]; 
			String password = temp.split(" ")[1];
			map.put(site, password);
		}
		
		for (int m = 0; m < M; m++) {
			String site = br.readLine();
			System.out.println(map.get(site));
		}
	}
	
}
