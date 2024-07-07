import java.io.*;
import java.util.*;

public class Softeer_성적평가 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[][] arr = new int[4][3001];
        int[] acc = new int[n];
        int[][] scores = new int[4][n];
        int[][] result = new int[4][n];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++) {
                int input = sc.nextInt();
                scores[i][j] = input;
                arr[i][input]++;
                acc[j] += input;
            }
        }

        for(int i = 0; i < n; i++) {
            scores[3][i] = acc[i];
            arr[3][acc[i]]++;
        }

        Map<Integer, Integer>[] map = new HashMap[4];
        for(int i = 0; i < 4; i++) {
            map[i] = new HashMap<>();
        }

        for(int i = 0; i < 4; i++) {
            int rank = 1;
            for(int j = 3000; j >= 0; j--) {
                if(arr[i][j] > 0) {
                    for(int k = 0; k < arr[i][j]; k++) {
                        map[i].put(j, rank);
                    }
                    rank += arr[i][j];
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = map[i].get(scores[i][j]);
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
