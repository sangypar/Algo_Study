package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			Map<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for (int n = 0; n < N; n++)  {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String kind = st.nextToken();
				
				map.put(kind, map.containsKey(kind) ? map.get(kind) + 1 : 1);
			}
			
			int result = 1;
			
			for (int value : map.values()) {
				result *= (value + 1);
			}
			
			System.out.println(result - 1);
		}
	}
	
}
