import java.util.*;

public class Solution_특이한자석 {

    static int[][] mag = new int[4][8];
    static int[][] check = {{0}, {0, 1}, {1, 2}, {2}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int k = sc.nextInt(); // 회전 횟수

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    mag[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < k; i++) {
                int num = sc.nextInt();
                int dir = sc.nextInt(); // 회전 방향 : 1 = 시계 / -1 = 반시계
                turn(num, dir);
            }

            int score = 0;
            for (int i = 0; i < 4; i++) {
                score += mag[i][0] * Math.pow(2, i);
            }

            sb.append("#" + tc + " " + score).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

    // 돌기
    static void turn(int num, int dir) {
        int[] spins = new int[4];
        spins[num - 1] = dir;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{num, dir});

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int n = curr[0];
            int r = curr[1];

            for (int c : check[n - 1]) {
                if (mag[c][2] != mag[c + 1][6]) {
                    if (spins[c] == 0) {
                        stack.push(new int[]{c + 1, -r});
                        spins[c] = -r;
                    } else if (spins[c + 1] == 0) {
                        stack.push(new int[]{c + 2, -r});
                        spins[c + 1] = -r;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (spins[i] == 1) {
                turnR(i);
            } else if (spins[i] == -1) {
                turnL(i);
            }
        }
    }

    // 오른쪽으로 돌기
    static void turnR(int idx) {
        int temp = mag[idx][7];
        for (int i = 7; i > 0; i--) {
            mag[idx][i] = mag[idx][i - 1];
        }
        mag[idx][0] = temp;
    }

    // 왼쪽으로 돌기
    static void turnL(int idx) {
        int temp = mag[idx][0];
        for (int i = 0; i < 7; i++) {
            mag[idx][i] = mag[idx][i + 1];
        }
        mag[idx][7] = temp;
    }
}