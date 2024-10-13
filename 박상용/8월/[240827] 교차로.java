import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 교차로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> A = new LinkedList<>();
		Queue<Integer> B = new LinkedList<>();
		Queue<Integer> C = new LinkedList<>();
		Queue<Integer> D = new LinkedList<>();
		Set<Integer> time = new HashSet<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char cha = st.nextToken().charAt(0);
			time.add(num);
			if(cha == 'A') {
				A.add(num);
			}else if(cha == 'B'){
				B.add(num);
			}else if(cha == 'C'){
				C.add(num);
			}else{
				D.add(num);
			}
		}
		List<Integer> timeset = new ArrayList<>(time);
		Collections.sort(timeset);
		int[] sign = new int[4];
		
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < timeset.size(); i++) {
			if(timeset.get(i)==A.peek()) {
				A.poll();
				result.add(i);
			}else if(timeset.get(i)==B.peek()) {
				B.poll();
				result.add(i);
			}else if(timeset.get(i)==C.peek()) {
				C.poll();
				result.add(i);
			}else if(timeset.get(i)==D.peek()) {
				D.poll();
				result.add(i);
			}
			
			// 접근 법이 더이상 생각 나지 않아.........
		}
		

		
	}
}
