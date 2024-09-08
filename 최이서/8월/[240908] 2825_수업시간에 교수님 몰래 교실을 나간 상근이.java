import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bitCntList = new int[1024];	// 10개(0~9)의 비트

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            int temp = 0;
            for (char bitNum : num.toCharArray()) {
                temp |= (1 << (bitNum - '0'));
            }
            bitCntList[temp]++;
        }

        long ans = 0;
        for (int k = 1; k < 1024; k++) {
            for (int t = k; t < 1024; t++) {
                if (k == t) {
                    if (bitCntList[k] >= 2) {
                    	// 같은 비트마스크 값을 가진 숫자: 그 중 2개를 선택하는 조합의 수 계산
                    	ans += (long) bitCntList[k] * (bitCntList[k] - 1) / 2;
                    }
                } else {
                    if (bitCntList[k] != 0 && bitCntList[t] != 0) {
                    	// 다른 숫자: 
                        if ((k & t) > 0) {
                        	ans += (long) bitCntList[k] * bitCntList[t];
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}