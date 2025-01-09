package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108_통계학 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		// 산술평균
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += array[i];
		}
		
		System.out.println(Math.round(sum / N));
		
		// 중앙값
		System.out.println(array[N/2]);
		
		// 최빈값
		Map<Integer, Integer> mode = new HashMap<>();
		for (int i = 0; i < N; i++) {
			mode.put(array[i], mode.getOrDefault(array[i], 0) + 1);
		}
		
		int maxFrequency = 0;
		for (int value : mode.values()) {
			maxFrequency = Math.max(value, maxFrequency);
		}
		
		List<Integer> modeList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : mode.entrySet()) {
			if (entry.getValue() == maxFrequency) {
				modeList.add(entry.getKey());
			}
		}
		
		Collections.sort(modeList);
		
		if (modeList.size() > 1) System.out.println(modeList.get(1));
		else System.out.println(modeList.get(0));
		
		// 범위
		System.out.println(array[N-1] - array[0]);
	}
	
}
