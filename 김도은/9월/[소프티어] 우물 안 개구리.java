import java.io.*;
import java.util.*;

public class Main {

    static boolean[] top;
    static int[] weight;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //회원 수
        int M = Integer.parseInt(st.nextToken()); //친분관계 수

        weight = new int[N+1]; //역기 무게
        top = new boolean[N+1]; //내가 최고!
        st = new StringTokenizer(br.readLine());
        
        for(int n = 1; n < N+1; n++) {
            weight[n] = Integer.parseInt(st.nextToken());//역기 입력 완
            top[n] = true; //자기가 최고
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            union(A, B); //합쳐주세용
        }

        int count = 0;
        
        for(int n = 1; n < N+1; n++) {
            if(top[n]) {
                count++;
            }
        }

        System.out.println(count);
        
    }

    public static void union(int A, int B) {
            if(weight[A] > weight[B]) {
                top[B] = false; //A무게가 더 크면 A가 짱
            } else if(weight[A] < weight[B]) {
                top[A] = false; //B무게가 더 크면 B가 짱
            } else {
                //같을 때는 둘다 짱 아님
                top[A] = top[B] = false;
            }
    }
}

// 1	1	정답
// 0.343 초	41.38 MB
// 2	10	정답
// 0.307 초	38.71 MB
// 3	11	정답
// 0.291 초	38.32 MB
// 4	12	정답
// 0.068 초	10.06 MB
// 5	13	정답
// 0.069 초	10.06 MB
// 6	14	정답
// 0.069 초	10.07 MB
// 7	15	정답
// 0.062 초	10.07 MB
// 8	16	정답
// 0.070 초	10.07 MB
// 9	17	정답
// 0.347 초	41.23 MB
// 10	18	정답
// 0.326 초	41.53 MB
// 11	19	정답
// 0.370 초	41.09 MB
// 12	2	정답
// 0.327 초	40.88 MB
// 13	3	정답
// 0.328 초	41.07 MB
// 14	4	정답
// 0.069 초	10.17 MB
// 15	5	정답
// 0.070 초	10.17 MB
// 16	6	정답
// 0.324 초	41.46 MB
// 17	7	정답
// 0.331 초	40.61 MB
// 18	8	정답
// 0.351 초	40.95 MB
// 19	9	정답
// 0.304 초	39.33 MB
