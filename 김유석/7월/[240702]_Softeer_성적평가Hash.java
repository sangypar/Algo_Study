import java.io.*;
import java.util.*;

public class Softeer_성적평가4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[4][3001]; // 각 점수별 학생 수와 누적합 계산을 위한 배열, 총점 최대 3000까지 커버
        int[] acc = new int[n];
        int[][] scores = new int[4][n]; // 학생별 점수를 저장할 배열 (3과목 + 누적합)
        int[][] result = new int[4][n]; // 결과 랭크를 저장할 배열

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                scores[i][j] = tmp; // 학생별 점수 저장
                arr[i][tmp]++; // 각 점수의 학생 수 증가
                acc[j] += tmp; // 학생별 누적 합 계산
            }
        }

        for (int j = 0; j < n; j++) {
            scores[3][j] = acc[j]; // 누적 합계를 scores의 네 번째 과목으로 저장
            arr[3][acc[j]]++; // 누적 합계의 학생 수 증가
        }

        Map<Integer, Integer>[] map = new HashMap[4]; // 점수별 랭크를 저장할 맵 배열
        for (int i = 0; i < 4; i++) {
            map[i] = new HashMap<>();
        }

        // 각 과목별 랭킹 계산
        for (int i = 0; i < 4; i++) {
            int rank = 1;
            for (int j = 3000; j >= 0; j--) { // 배열 크기를 3000까지 커버
                if (arr[i][j] > 0) {
                    for (int k = 0; k < arr[i][j]; k++) {
                        map[i].put(j, rank); // j점수의 랭크 저장
                    }
                    rank += arr[i][j]; // 동일 점수의 학생 수만큼 랭크 증가
                }
            }
        }

        // 각 학생의 과목별 랭크 결과 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = map[i].get(scores[i][j]);
            }
        }

        // 결과 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
