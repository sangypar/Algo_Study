// 못품

import java.util.*;

public class SWEA_원자소멸시뮬레이션 {

    static int energy;
    static int[][] map;
    static List<int[]> atoms;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            map = new int[2002][2002];
            atoms = new ArrayList<>();

            int n = sc.nextInt();

            for(int i = 0; i < n; i++) {
                int r = sc.nextInt() + 1000;
                int c = sc.nextInt() + 1000;
                int d = sc.nextInt();
                int v = sc.nextInt();
                map[r][c] = v;

                atoms.add(new int[] {r, c, d, v});
            }

            energy = 0;
            move();

            System.out.println("#" + "tc" + " " + energy);

        }
    }

    public static void move() {
        while(!atoms.isEmpty()) {
            for(int[] atom : atoms) {
                // 에너지가 없다? 그럼 충돌했었던 원자임
                if(map[atom[0]][atom[1]] == 0) {
                    atoms.remove(atom);
                }

                int nr = atom[0] + dr[atom[2]];
                int nc = atom[1] + dc[atom[2]];

                // 경계 밖이면 나가리
                if(nr < 0 || nr > 2000 || nc < 0 || nc > 2000) {
                    map[atom[0]][atom[1]] = 0;
                    atoms.remove(atom);

                // 경계 안이면 이동
                } else {
                    map[nr][nc] += atom[3];
                    map[atom[0]][atom[1]] = 0;
                    atom[0] = nr;
                    atom[1] = nc;

                    // 이동했는데 기존 원자값과 다르다? 충돌한거임
                    if(map[nr][nc] != atom[3]) {
                        energy += map[nr][nc];
                        map[nr][nc] = 0;
                        atoms.remove(atom);
                    }
                }
            }
        }
    }
}
