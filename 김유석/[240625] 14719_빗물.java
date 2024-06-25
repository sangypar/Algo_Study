import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon1_15_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[y];
		st = new StringTokenizer(br.readLine());
		int maxHight = Integer.MAX_VALUE;
		for(int i = 0 ; i < y ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > maxHight) {
				maxHight = arr[i];
			}
		}
		boolean isPosible = false;
		List<Integer> list = new ArrayList<>();
		int totalCnt = 0;
		for(int i = 0 ; i < x; i++) {
			for(int j = 0 ; j < y ; j++) {
				if(!list.isEmpty() ) { 
					if(arr[j] != 0){//리스트에 값이 있으면서 , 벽인경우 
						 totalCnt += list.size(); 
	                     list.clear(); // 리스트 비움		
						arr[j] -= 1; 
//						System.out.print("x : " + i+ " y : "+ j + "리스트에 값이 있으면서 벽인 경우 벽 줄임 리스트 비움"+" arr[y] = " + arr[j] +"  " );
					}
					else {//리스트에 값이 있으면서, 0인 경우 
//						System.out.print("x : " + i+ " y : "+ j + "리스트에 값이 있으면서, 0인 경우 리스트에 추가함 "+" arr[y] = " + arr[j] +"  "  );
						list.add(1);
					}
				}
				else {//리스트에 값이 업는경우 
					if(arr[j] == 0) {//리스트에 값이 없으면서 0인경우 
						if(isPosible) {
//							System.out.print("x : " + i+ " y : "+ j + "리스트에 값이 없으면서 0인 경우 리스트에 추가함"+" arr[y] = " + arr[j] +"  " );
							list.add(1);
						}
					}
					else{//리스트에 값이 없으면서 벽인 경우
						isPosible = true;
						arr[j] -= 1;
//						System.out.print("x : " + i+ " y : "+ j + "리스트에 값이 없으면서 벽인 경우 벽 줄임" + " arr[y] = " + arr[j] +"  "  );
					}
				}
				
			}
//			System.out.println();
//			System.out.println("한줄 종료 현재 totalCnt = " + totalCnt );
			list.clear();
			isPosible = false;
		}
		System.out.println(totalCnt);
		
		
	}
}
