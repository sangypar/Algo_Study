import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Magnet {
    int[] poles;
    int front;

    public Magnet() {
        poles = new int[8];
        front = 0;
    }

    public int getIdx(int idx) {
        return ((idx % 8) + 8) % 8;
    }

    public int get(int target) {
        int targetIdx = getIdx(this.front + target);
        return poles[targetIdx];
    }

    public void rotate(int direction) {
        front = getIdx(front - direction);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int K = Integer.parseInt(br.readLine());
            Magnet[] magnets = new Magnet[5];

            // 자석 정보 입력 (0: N극, 1: S극)
            for (int i = 1; i <= 4; i++) {
                magnets[i] = new Magnet();
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i].poles[j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전 정보 (1: 시계방향, -1: 반시계방향)
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 회전시키려는 자석의 번호
                int d = Integer.parseInt(st.nextToken()); // 회전방향

                boolean[] willRotate = new boolean[5];
                int[] directions = new int[5];

                willRotate[n] = true;
                directions[n] = d;

                // 왼쪽 자석 회전 여부 확인
                for (int i = n; i > 1; i--) {
                    if (magnets[i].get(-2) != magnets[i - 1].get(2)) {
                        willRotate[i - 1] = true;
                        directions[i - 1] = -directions[i];
                    } else {
                        break;
                    }
                }

                // 오른쪽 자석 회전 여부 확인
                for (int i = n; i < 4; i++) {
                    if (magnets[i].get(2) != magnets[i + 1].get(-2)) {
                        willRotate[i + 1] = true;
                        directions[i + 1] = -directions[i];
                    } else {
                        break;
                    }
                }

                // 자석 회전
                for (int i = 1; i <= 4; i++) {
                    if (willRotate[i]) {
                        magnets[i].rotate(directions[i]);
                    }
                }
            }

            // 점수 계산
            int score = 0;
            for (int i = 1; i <= 4; i++) {
                if (magnets[i].get(0) == 1) {
                    score += Math.pow(2, i - 1);
                }
            }

            System.out.println("#" + t + " " + score);
        }
    }
}