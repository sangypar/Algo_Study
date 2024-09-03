import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] weights = new int[n+1];

        for(int i = 1; i <= n; i++) {
            weights[i] = sc.nextInt();
        }

        boolean[] isBest = new boolean[n+1];
        Arrays.fill(isBest, true);

        for(int i = 0; i < m; i++) {
            int me = sc.nextInt();
            int friend = sc.nextInt();

            int myWeight = weights[me];
            int friendWeight = weights[friend];

            // 내가 더 잘치면 친구 탈락 
            if(myWeight > friendWeight) isBest[friend] = false;
            // 친구가 더 잘치면 나 탈락
            else if(myWeight < friendWeight) isBest[me] = false;
            // 동점이면 둘 다 탈락
            else {
                isBest[friend] = false;
                isBest[me] = false;
            }
        }

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(isBest[i]) answer++;
        }

        System.out.println(answer);
    }
}

/*
1	1	정답
0.658 초	50.84 MB
2	10	정답
0.636 초	50.99 MB
3	11	정답
0.604 초	50.94 MB
4	12	정답
0.115 초	11.93 MB
5	13	정답
0.117 초	11.96 MB
6	14	정답
0.114 초	11.96 MB
7	15	정답
0.112 초	11.93 MB
8	16	정답
0.119 초	11.94 MB
9	17	정답
0.665 초	51.16 MB
10	18	정답
0.671 초	51.05 MB
11	19	정답
0.653 초	50.89 MB
12	2	정답
0.668 초	51.02 MB
13	3	정답
0.640 초	51.05 MB
14	4	정답
0.110 초	11.83 MB
15	5	정답
0.110 초	11.93 MB
16	6	정답
0.685 초	53.97 MB
17	7	정답
0.689 초	54.05 MB
18	8	정답
0.732 초	54.12 MB
19	9	정답
0.580 초	50.98 MB
*/
