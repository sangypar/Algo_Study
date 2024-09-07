import java.util.*;

public class Main2825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            char[] z = str.toCharArray();
            Set<Character> set = new HashSet<>();
            for (char ch : z) {
                set.add(ch);
            }

            List<Character> list = new ArrayList<>(set);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (char ch

                    : list) {
                sb.append(ch);
            }
            String key = sb.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int cnt = 0;
        for (int c : map.values()) {
            if (c > 1) {
                cnt += c * (c - 1) / 2;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
