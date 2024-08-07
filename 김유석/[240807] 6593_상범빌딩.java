import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1_26_6593_상범빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();
        
        boolean result = canTransform(S, T);
        System.out.println(result ? 1 : 0);
    }

    private static boolean canTransform(String s, String t) {
        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
                String t = new StringBuffer().reverse();
            }
        }
        return t.equals(s);
    }
}
