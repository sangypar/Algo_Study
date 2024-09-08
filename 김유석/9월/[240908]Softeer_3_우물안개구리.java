import java.io.*;
import java.util.*;
/**
 * 
정답
0.432 초	55.10 MB
2	10	정답
0.417 초	57.09 MB
3	11	정답
0.398 초	56.24 MB
4	12	정답
0.062 초	10.22 MB
5	13	정답
0.062 초	10.20 MB
6	14	정답
0.062 초	10.22 MB
7	15	정답
0.062 초	10.19 MB
8	16	정답
0.062 초	10.18 MB
9	17	정답
0.498 초	60.07 MB
10	18	정답
0.487 초	59.25 MB
11	19	정답
0.385 초	56.37 MB
12	2	정답
0.444 초	57.40 MB
13	3	정답
0.472 초	55.16 MB
14	4	정답
0.062 초	10.12 MB
15	5	정답
0.061 초	10.12 MB
16	6	정답
0.421 초	58.28 MB
17	7	정답
0.434 초	58.45 MB
18	8	정답
0.441 초	55.27 MB
19	9	정답
0.423 초	59.45 MB
 * 
 */
public class Softeer_3_우물안개구리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        int[] gym = new int[people + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= people; i++) {
            gym[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] list = new LinkedList[people + 1];
        for (int i = 1; i <= people; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a); // 양방향 그래프이므로 반대 방향도 추가합니다.
            
        }

        int cnt = 0;
        for (int i = 1; i <= people; i++) {
            boolean isLeader = true;
            for (int j = 0; j < list[i].size(); j++) {
                if (gym[i] <= gym[list[i].get(j)]) { //새로운놈이 더크면 
                    isLeader = false;
                    break;
                    
                }
            }
            if (isLeader) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
