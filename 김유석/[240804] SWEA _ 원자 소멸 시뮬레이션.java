import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Autom {
    int x;
    int y;
    int dir;
    int e;

    public Autom(int x, int y, int dir, int e) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.e = e;
    }
}

public class Swea_2_원자소멸시뮬레이션 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); 

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine()); 

            List<Autom> automList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) + 1000;
                int y = Integer.parseInt(st.nextToken()) + 1000;
                int dir = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                automList.add(new Autom(x, y, dir, e));
            }

            int result = 0;


            for (int i = 0; i < automList.size(); i++) {
                Autom a1 = automList.get(i);
                for (int j = i + 1; j < automList.size(); j++) {
                    Autom a2 = automList.get(j);


                    if (a1.y == a2.y) {
                        if ((a1.dir == 2 && a2.dir == 3 ) || (a1.dir == 3 && a2.dir == 2 )) {
                            result += a1.e + a2.e;
                        }
                    }


                    if (a1.x == a2.x) {
                        if ((a1.dir == 0 && a2.dir == 1 ) || (a1.dir == 1 && a2.dir == 0 )) {
                            result += a1.e + a2.e;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
