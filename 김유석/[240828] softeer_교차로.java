import java.io.*;
import java.util.*;

public class Softeer_2_교차로 {
    static class Car {
        int id;
        int time;

        Car(int a, int b) {
            id = a;
            time = b;
        }
    }

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Arrays.fill(arr, -1);
        
        Queue<Car>[] q = new Queue[4];
        for (int i = 0; i < 4; ++i) {
            q[i] = new ArrayDeque<>();
            }
        
        for (int i = 0; i < N; ++i) {
            String[] inputs = br.readLine().split(" ");
            int dir = inputs[1].charAt(0) - 'A';
            q[dir].add(new Car(i, Integer.parseInt(inputs[0])));
        }	
        
        int currentTime = -1;
        while (true) {
            
            if (q[0].isEmpty() && q[1].isEmpty() && q[2].isEmpty() && q[3].isEmpty())
                break;

            int[] state = new int[4];
            int minTime = Integer.MAX_VALUE;
            for (int i = 0; i < 4; ++i) {
                if (!q[i].isEmpty()) {
                    int t = q[i].peek().time;
                    minTime = Math.min(t, minTime);
                    if (t <= currentTime)
                        state[i] = 1;
                }
            }
            int count = 0;
            for (int value : state)
                count += value;

            if (count == 0) {
            	//처음일때 다음 시간으로 가기
                currentTime = minTime;
            } else if (count == 4) {
                // 모든 차량이 교차로에서 대기 중 -> 교착상태
                break;
            } else {
                for (int i = 0; i < 4; ++i) {
                    // 현재 방향에서 진행 가능하며, 오른쪽은 불가능할 때
                    if (state[i] != 0 && state[(i + 3) % 4] == 0) {
                        arr[q[i].poll().id] = currentTime;
                    }
                }
                currentTime += 1;
            }
        }

        for (int i = 0; i < N; ++i)
            sb.append(arr[i]).append("\n");

        System.out.println(sb);
    }
}
