import java.util.Arrays;
import java.util.Scanner;

public class Main2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0];
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if () {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }

}
