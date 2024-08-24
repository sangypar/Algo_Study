import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1_28_1520_내리막길 {
    private static int n;
    private static int maxSum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	int [] arr = new int[n];
    	for(int i = 0 ; i < n ; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}

    }
}
