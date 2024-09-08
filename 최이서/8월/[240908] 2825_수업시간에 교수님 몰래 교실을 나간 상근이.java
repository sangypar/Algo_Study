import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        
    	int[] bitMasks = new int[N];
        
        // 비트마스크로 변환
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            bitMasks[i] = getBitMask(num);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((bitMasks[i] & bitMasks[j]) != 0) { // AND 연산
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    
    public static int getBitMask(int num) {
    	int mask = 0; // 비트가 저장될 변수
    	while (num > 0) {
    		int digit = num % 10; // 마지막 자리 숫자 추출
    		
    		// 1. digit을 비트마스킹
    		// 2. mask에 해당 비트마스킹 결과를 OR 연산으로 포함
    		mask |= (1 << digit);
    		
    		num /= 10;			  // 마지막 자릿수 제거
    	}
    	return mask;
    }
}