import java.util.*;

public class SWEA_특이한자석_4013 {

    static Deque<Integer>[] magnets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int k = sc.nextInt();

            magnets = new ArrayDeque[4];

            for (int i = 0; i < 4; i++) {
                magnets[i] = new ArrayDeque<>();
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnets[i].addLast(sc.nextInt());
                }
            }

            for (int i = 0; i < k; i++) {
                int idx = sc.nextInt() - 1;
                int dir = sc.nextInt();

                effect(idx, dir);
            }

            int answer = 0;

            for (int i = 0; i < 4; i++) {
                if (magnets[i].peekFirst() == 1) {
                    answer += Math.pow(2, i);
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void effect(int idx, int dir) {
        int[] direction = new int[4];
        direction[idx] = dir;

        // 각 톱니의 회전 방향 설정
        for (int i = idx; i > 0; i--) {
            if (magnets[i].toArray(new Integer[0])[6] != magnets[i - 1].toArray(new Integer[0])[2]) {
                direction[i - 1] = -direction[i];
            } else {
                break;
            }
        }

        for (int i = idx; i < 3; i++) {
            if (magnets[i].toArray(new Integer[0])[2] != magnets[i + 1].toArray(new Integer[0])[6]) {
                direction[i + 1] = -direction[i];
            } else {
                break;
            }
        }

        // 각 톱니 회전
        for (int i = 0; i < 4; i++) {
            if (direction[i] != 0) {
                cycle(direction[i], i);
            }
        }
    }

    static void cycle(int dir, int idx) {
        if (dir == 1) {
            magnets[idx].addFirst(magnets[idx].pollLast());
        } else if (dir == -1) {
            magnets[idx].addLast(magnets[idx].pollFirst());
        }
    }
}
