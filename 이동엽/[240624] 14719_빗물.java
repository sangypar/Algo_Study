import java.util.Scanner;

// 백준 골드V, 빗물
// 시뮬레이션
// 메모리 : 13,888KB, 시간 : 152ms
public class Main_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] world = new int[w];
        for (int i = 0; i < w; i++) {
            world[i] = sc.nextInt();
        }

        int sum = 0;
        // 각 열마다 빗물을 계산
        for (int i = 1; i < w - 1; i++) {
            int leftMax = findMax(world, 0, i); // 현재 열의 왼쪽에서 가장 높은 블록 높이
            int rightMax = findMax(world, i + 1, w); // 현재 열의 오른쪽에서 가장 높은 블록 높이

            // 현재 위치에서 빗물이 고이는 양 계산
            int temp = Math.min(leftMax, rightMax) - world[i];
            if (temp > 0) {
                sum += temp;
            }
        }

        System.out.println(sum);
        sc.close();
    }

    // 배열에서 start부터 end-1까지의 최댓값을 찾는 메서드
    private static int findMax(int[] world, int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, world[i]);
        }
        return max;
    }
}