import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_우물안개구리 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        List<Integer>[] friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1; // 인덱스 맞추기
            int b = sc.nextInt() - 1;
            friends[a].add(b);
            friends[b].add(a);
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            boolean isBest = true;
            for (int f : friends[i]) {
                if (weights[i] <= weights[f]) {
                    isBest = false;
                    break;
                }
            }
            if (isBest) {
                cnt++;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
/*
1 1정답
0.819초	63.42MB
2 10정답
0.755초	63.52MB
3 11정답
0.745초	63.50MB
4 12정답
0.106초	11.89MB
5 13정답
0.110초	11.99MB
6 14정답
0.108초	11.96MB
7 15정답
0.109초	11.96MB
8 16정답
0.112초	11.99MB
9 17정답
0.773초	64.74MB
10 18정답
0.829초	68.09MB
11 19정답
0.741초	63.20MB
12 2정답
0.790초	63.84MB
13 3정답
0.761초	63.88MB
14 4정답
0.106초	11.89MB
15 5정답
0.109초	11.99MB
16 6정답
0.840초	66.88MB
17 7정답
0.779초	63.45MB
18 8정답
0.812초	63.77MB
19 9정답
0.722초	63.77MB
*/
