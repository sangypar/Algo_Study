import java.util.*;

public class Programmers_2_큰수만들기 {
    public static void main(String[] args) {
        String number = "12345678";
        int k = 2;
        String result = solution(number, k);
        System.out.println	(result); // Expected output: "94"
    }

    private static String solution(String number, int k) {
        char arr[] = new char[number.length()];
        
        for(int i = 0; i< number.length() ; i++){
            arr[i] = number.charAt(i); //string number 찢어서 arr[i]에 삽입 
        }
        
        char result[] = new char[number.length() - k]; //결과 배열 
        
        int start = 0;
        int end = k;
        
        for(int i = 0 ; i < result.length ; i++) {
            char maxNumber = '0';
            for(int j = start ; j <= end ; j++) { //뺄놈고르기 
                if(maxNumber < arr[j]) { 
                    maxNumber = arr[j];
                    start = j + 1;
                }
            }
            result[i] = maxNumber;
            end++;
        }

        return new String(result);
    }
}
