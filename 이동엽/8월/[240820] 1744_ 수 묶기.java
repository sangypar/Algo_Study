import java.util.*;

// 12,948 KB
// 96 ms
public class Main1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> pos = new ArrayList<>(); // 양수
        List<Integer> neg = new ArrayList<>(); // 음수
        int sum = 0;
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp > 1) {
                pos.add(temp);
            } else if (temp == 1) {
                sum += temp;
            } else if (temp < 0) {
                neg.add(temp);
            } else { // 0
                hasZero = true;
            }
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        for (int i = 0; i < pos.size(); i += 2) {
            if (i + 1 < pos.size()) {
                sum += pos.get(i) * pos.get(i + 1);
            } else {
                sum += pos.get(i);
            }
        }

        for (int i = 0; i < neg.size(); i += 2) {
            if (i + 1 < neg.size()) {
                sum += neg.get(i) * neg.get(i + 1);
            } else {
                if (!hasZero) { // 0 없으면 그냥 더함
                    sum += neg.get(i);
                } // 0 있으면 젤 작은 음수 * 0
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
