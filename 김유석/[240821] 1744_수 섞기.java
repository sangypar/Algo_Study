import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekJoon1_26_1744_수묶기 {
    private static int n;
    private static int maxSum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬 (내림차순으로 정렬하여 양수부터 처리)
        Arrays.sort(arr, Collections.reverseOrder());

        PriorityQueue<Integer> minQ = new PriorityQueue<>(); // 음수 처리용 (오름차순)
        int idx = 0;
        int zeroCount = 0; // 0의 개수를 카운트

        // 양수 처리
        while (idx < n && arr[idx] > 1) {
            if (idx + 1 < n && arr[idx + 1] > 1) {
                maxSum += arr[idx] * arr[idx + 1];
                idx += 2;
            } else {
                maxSum += arr[idx];
                idx++;
            }
        }

        // 1 처리 (곱하는 것보다 더하는 것이 유리)
        while (idx < n && arr[idx] == 1) {
            maxSum += arr[idx];
            idx++;
        }

        // 음수와 0 처리 (뒤에서부터 남은 값들을 처리)
        for (int i = n - 1; i >= idx; i--) {
            if (arr[i] == 0) {
                zeroCount++; // 0의 개수를 카운트
            } else if (arr[i] < 0) {
                minQ.add(arr[i]);
            }
        }

        // 음수 묶기
        while (!minQ.isEmpty()) {
            int first = minQ.poll();
            if (!minQ.isEmpty()) {
                int second = minQ.poll();
                maxSum += first * second; // 음수끼리 곱함
            } else {
                if (zeroCount > 0) {
                    zeroCount--; // 남은 음수를 0과 곱함
                } else {
                    maxSum += first; // 0이 없으면 남은 음수를 더함
                }
            }
        }

        System.out.println(maxSum);
    }
}
