import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < T.length(); i++) {
            list.add(T.charAt(i));
        }
        // S -> T가 아닌 T -> S만들기
        while (S.length() < list.size()) {
            if (list.get(list.size() - 1) == 'A') {
                list.remove(list.size() - 1); // 끝이 A면 A 삭제
            } else {
                list.remove(list.size() - 1); // 끝이 B면 B 삭제후
                Collections.reverse(list); // 뒤집기
            }
        }
        String temp = "";
        for (char l : list) {
            temp += l;
        }

        System.out.println(S.equals(temp) ? 1 : 0);
        sc.close();
    }
}
