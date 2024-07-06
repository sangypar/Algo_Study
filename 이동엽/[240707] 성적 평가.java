import java.util.*;

public class Main_성적평가 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] score = new int[n];
        int[] sum = new int[n];
        int[] sortedScore = new int[n];
        int[] sortedSum = new int[n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                score[j] = num;
                sum[j] += num;
                sortedScore[j] = num;
                sortedSum[j] += num;
            }

            Arrays.sort(sortedScore);

            for (int j = 0; j < n; j++) {
                sb.append(n + 1 - binarySearch(sortedScore, score[j]) + " ");
            }
            sb.append("\n");
        }

        Arrays.sort(sortedSum);

        for (int i = 0; i < n; i++) {
           sb.append(n + 1 - binarySearch(sortedSum, sum[i]) + " ");
        }
        System.out.println(sb);
        sc.close();
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

//1	01-123	정답
//0.151 초	14.72 MB
//2	02-123	정답
//0.149 초	14.74 MB
//3	03-123	정답
//0.147 초	14.80 MB
//4	04-123	정답
//0.146 초	14.82 MB
//5	05-123	정답
//0.132 초	12.61 MB
//6	06-123	정답
//0.146 초	14.84 MB
//7	07-123	정답
//0.144 초	14.80 MB
//8	08-123	정답
//0.145 초	14.80 MB
//9	09-123	정답
//0.149 초	14.80 MB
//10	10-123	정답
//0.145 초	14.81 MB
//11	11-23	정답
//0.227 초	17.69 MB
//12	12-23	정답
//0.250 초	18.68 MB
//13	13-23	정답
//0.195 초	16.61 MB
//14	14-23	정답
//0.212 초	17.93 MB
//15	15-23	정답
//0.215 초	17.71 MB
//16	16-23	정답
//0.232 초	18.30 MB
//17	17-23	정답
//0.235 초	18.69 MB
//18	18-23	정답
//0.215 초	17.91 MB
//19	19-23	정답
//0.208 초	17.21 MB
//20	20-23	정답
//0.232 초	18.37 MB
//21	21-3	정답
//0.977 초	57.28 MB
//22	22-3	정답
//1.007 초	58.36 MB
//23	23-3	정답
//0.548 초	53.11 MB
//24	24-3	정답
//1.033 초	58.92 MB
//25	25-3	정답
//0.995 초	58.36 MB
//26	26-3	정답
//0.876 초	57.95 MB
//27	27-3	정답
//1.087 초	58.15 MB
//28	28-3	정답
//1.039 초	58.05 MB
//29	29-3	정답
//1.044 초	59.36 MB
//30	30-3	정답
//1.036 초	58.27 MB
