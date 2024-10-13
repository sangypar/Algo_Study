import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Softeer_성적평가2 {
    static class Grade implements Comparable<Grade> {
        int index;
        int score;

        Grade(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Grade o) {
            return o.score - this.score; // 내림차순 정렬
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][n];
        int[][] result = new int[4][n];

        // 각 대회의 성적 입력 및 순위 계산
        for (int i = 0; i < 3; i++) {
            List<Grade> gradeList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                gradeList.add(new Grade(j, arr[i][j]));
            }

            // 리스트를 점수 기준으로 내림차순 정렬
            Collections.sort(gradeList);

            int rank = 1;
            result[i][gradeList.get(0).index] = rank;

            for (int k = 1; k < gradeList.size(); k++) {
                if (gradeList.get(k).score == gradeList.get(k - 1).score) {
                    result[i][gradeList.get(k).index] = result[i][gradeList.get(k - 1).index];
                } else {
                    result[i][gradeList.get(k).index] = k + 1;
                }
            }
        }

        // 각 학생의 총 점수를 계산하여 result[3][j]에 저장
        List<Grade> totalList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int sumScore = 0;
            for (int i = 0; i < 3; i++) {
                sumScore += arr[i][j];
            }
            totalList.add(new Grade(j, sumScore));
        }

        // 총 점수를 기준으로 내림차순 정렬
        Collections.sort(totalList);

        int rank = 1;
        result[3][totalList.get(0).index] = rank;

        for (int k = 1; k < totalList.size(); k++) {
            if (totalList.get(k).score == totalList.get(k - 1).score) {
                result[3][totalList.get(k).index] = result[3][totalList.get(k - 1).index];
            } else {
                result[3][totalList.get(k).index] = k + 1;
            }
        }

        // result 배열 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
