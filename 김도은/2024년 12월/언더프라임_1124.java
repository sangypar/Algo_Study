package baekjoon_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 언더프라임_1124 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[B + 1];
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		
		for (int i = 2; i * i <= B; i++) {
		   if (prime[i]) {
		       for (int j = i * i; j <= B; j += i) {
			           prime[j] = false;
			   }
	       }
		}
		
		int[] primeCount = new int[B+1];
		
		for (int i = 2; i <= B; i++) {
		    int number = i;
		    
		    //2가 여러번 나눠질 수도 있기 대문에 while로 돌림
		    for (int p = 2; p <= Math.sqrt(number); p++) {
		        while (number % p == 0) {
		            primeCount[i]++;
		            number /= p;
		        }
		    }
		    
		    if (number > 1) {
		        primeCount[i]++;
		    }
		}
		
		int count = 0;
		
		for(int i = A; i <= B; i++) {
			if(isPrime(primeCount[i])) count++;
		}
		
		System.out.println(count);
	}

	private static boolean isPrime(int b) {
		
		if (b <= 1) return false;
		
	    for (int i = 2; i <= Math.sqrt(b); i++) {
	        if (b % i == 0) return false;
	    }
	    
	    return true;
	}
}
