import java.util.*;

public class BJ12904_A와B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String target = sc.nextLine();

        // t를 s로 만드는게 더 빠름
        while(target.length() > str.length()) {

            // 마지막이 A면 빼기
            if(target.charAt(target.length() - 1) == 'A') {
                target = target.substring(0, target.length() - 1);

            // 마지막이 B면 빼고 뒤집기
            } else if(target.charAt(target.length() - 1) == 'B'){
                String tmp = "";

                for(int i = target.length() - 2; i >= 0; i--) {
                    tmp += target.charAt(i);
                }

                target = tmp;
            }
        }

        System.out.println(target.equals(str) ? 1 : 0);
    }
}

