import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_softeer_우물안개구리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(arr[num1-1] > arr[num2-1]) {
				tmp[num2-1] = -1;
			}else if(arr[num1-1] < arr[num2-1]) { 
				tmp[num1-1] = -1;
			}else {
				tmp[num1-1] = -1;
				tmp[num2-1] = -1;
			}
		}
		int result = 0;
		for(int i = 0; i<N; i++) {
			if(tmp[i] == 0)
				result++;
		}
		System.out.println(result);
		
	}
}
