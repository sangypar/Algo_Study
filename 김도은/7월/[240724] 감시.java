import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class 감시_15683 {

    static class CCTV {
        int num; //시시티비 번호
        int r, c; //위치

        CCTV(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }
    
    //델타배열
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static int N, M;
    static int[][] office;
    static List<CCTV> cctvList;
    static int[] sel;
    static int[][] tmp;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];

        cctvList = new ArrayList<>(); //시시티비 배열

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                office[r][c] = Integer.parseInt(st.nextToken());
                
                if(office[r][c] != 0 && office[r][c] != 6) {
                    cctvList.add(new CCTV(office[r][c], r, c)); //시시티비로 추가해줘잉
                }
            }
        } //input 완
        
        sel = new int[cctvList.size()]; //순열방향 담는 배열
        permutation(0, cctvList.size()); //순열시작

        System.out.println(answer);
    }
    
    public static void permutation(int depth, int num) {
        if(depth == num) {
            //꽉찼다면?
            tmp = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    tmp[i][j] = office[i][j];
                }
            }//임시배열 생성
            
            for (int i = 0; i < cctvList.size(); i++) {
                makeDirection(cctvList.get(i), sel[i]);
            } //각 cctv마다 방향을 설정해주고
            
            findAnswer(); //다 체크한 후 맹점찾기
            
            return;
        }
        
        for(int i = 0; i < 4; i++){
            sel[depth] = i;
            permutation(depth + 1, num);
        } //순열
    }

    public static void makeDirection(CCTV cctv, int dir) {
        int num = cctv.num;

        //각 시시티비 별로 체크해야할 방향
        if(num == 1) {
            if(dir == 0) check(cctv, 0);
            else if(dir==1) check(cctv, 1);
            else if(dir==2) check(cctv, 2);
            else if(dir==3) check(cctv, 3);
        }else if(num == 2){
            if(dir ==0 || dir == 2) {
                check(cctv,0);
                check(cctv, 2);
            } else {
                check(cctv, 1);
                check(cctv,3);
            }
        }else if(num == 3){
            if(dir == 0){
                check(cctv, 0);
                check(cctv, 1);
            } else if (dir == 1){
                check(cctv,1);
                check(cctv,2);
            } else if (dir == 2) {
                check(cctv, 2);
                check(cctv, 3);
            } else if(dir == 3) {
                check(cctv, 3);
                check(cctv, 0);
            }
        }else if(num == 4){
            if(dir == 0){
                check(cctv,0);
                check(cctv,1);
                check(cctv,3);
            } else if(dir == 1){
                check(cctv, 0);
                check(cctv, 1);
                check(cctv, 2);
            } else if(dir == 2){
                check(cctv, 1);
                check(cctv, 2);
                check(cctv, 3);
            } else if(dir == 3){
                check(cctv, 0);
                check(cctv, 2);
                check(cctv, 3);
            }
        }else if(num == 5){
            check(cctv, 0);
            check(cctv, 1);
            check(cctv, 2);
            check(cctv, 3);
        }
    }

    public static void check(CCTV cctv, int dir) {
        Queue<CCTV> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        queue.add(cctv);
        visit[cctv.r][cctv.c] = true;

        while(!queue.isEmpty()) {
            int nr = queue.peek().r + dr[dir];
            int nc = queue.poll().c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M || tmp[nr][nc] == 6) {
                break;
            } //범위벗어나면 멈추기

            if(tmp[nr][nc] == 0) {
                tmp[nr][nc] = -1;
                queue.add(new CCTV(cctv.num, nr, nc));
            } else {
                queue.add(new CCTV(tmp[nr][nc], nr, nc));
            }
        }
    }

    public static void findAnswer() {
        int cnt = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(tmp[r][c] == 0){
                    cnt++;
                }
            }
        } //돌면서 체크
        answer = Math.min(cnt, answer);
    }
}
