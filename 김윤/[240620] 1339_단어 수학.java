package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 단어 수학
public class Main_1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 단어 개수
        String[] words = new String[N]; // 단어를 담는 배열
        Map<Character, Integer> importance = new HashMap<>();

        // 단어 입력 받기
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 알파벳 중요도 계산
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                importance.put(c, importance.getOrDefault(c, 0) + (int) Math.pow(10, length - 1 - i));
            }
        }

        // 중요도 배열 생성 및 정렬
        int[] alphabet = new int[26];
        for (Map.Entry<Character, Integer> entry : importance.entrySet()) {
            alphabet[entry.getKey() - 'A'] = entry.getValue();
        }
        
        // 내림차순 정렬
        Arrays.sort(alphabet);

        // 숫자 할당
        int num = 9;
        int answer = 0;
        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) break;
            answer += alphabet[i] * num--;
        }

        System.out.println(answer);
	}
	
}
