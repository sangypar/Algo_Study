import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> lineA = new LinkedList<>();
    static Queue<Integer> lineB = new LinkedList<>();
    static Queue<Integer> lineC = new LinkedList<>();
    static Queue<Integer> lineD = new LinkedList<>();
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sc.nextLine();

        answer = new int[n];
        Arrays.fill(answer, -1);

        int[] inputTime = new int[n];
        char[] inputLine = new char[n];

        for(int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            inputTime[i] = Integer.parseInt(tmp[0]);
            inputLine[i] = tmp[1].charAt(0);
        }

        int currIdx = 0;
        int currTime = inputTime[0];

        while (currIdx < n || !allLinesEmpty()) {
            while (currIdx < n && inputTime[currIdx] == currTime) {
                switch (inputLine[currIdx]) {
                    case 'A': lineA.add(currIdx); break;
                    case 'B': lineB.add(currIdx); break;
                    case 'C': lineC.add(currIdx); break;
                    case 'D': lineD.add(currIdx); break;
                }
                currIdx++;
            }

            if (isDeadlock()) break;

            while(!allLinesEmpty() || (currIdx < n && currTime < inputTime[currIdx])) {
                passCars(currTime++);
            }

            if(currIdx < n) currTime = inputTime[currIdx];
        }

        for (int t : answer) {
            sb.append(t).append("\n");
        }

        System.out.println(sb);
    }

    static boolean allLinesEmpty() {
        return lineA.isEmpty() && lineB.isEmpty() && lineC.isEmpty() && lineD.isEmpty();
    }

    static boolean isDeadlock() {
        return !lineA.isEmpty() && !lineB.isEmpty() && !lineC.isEmpty() && !lineD.isEmpty();
    }

    static void passCars(int currTime) {
        boolean[] hasCar = new boolean[]{!lineA.isEmpty(), !lineB.isEmpty(), !lineC.isEmpty(), !lineD.isEmpty()};
        if (!hasCar[0] && hasCar[1]) answer[lineB.poll()] = currTime;
        if (!hasCar[1] && hasCar[2]) answer[lineC.poll()] = currTime;
        if (!hasCar[2] && hasCar[3]) answer[lineD.poll()] = currTime;
        if (!hasCar[3] && hasCar[0]) answer[lineA.poll()] = currTime;
    }
}
