import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_8_1717_집합의표현2 {
	/*
	 1.자기자신을 가르키기
	 2.부모가 겹치는지 확인하기
	 3.합치기
	 */

    private static int[] parent;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

       parent = new int[n+1];
       
       for(int i = 1 ; i <=n ;i++) {
    	   parent[i] = i;
       }
       for(int i = 0 ; i < m ; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   int command = Integer.parseInt(st.nextToken());
    	   int a = Integer.parseInt(st.nextToken());
    	   int b= Integer.parseInt(st.nextToken());
    	   
    	   switch (command) {
    	   case 0:
    		   union(a,b);
    		   break;
    	   case 1:	
    		   if(find(a) == find(b)) {
    			   System.out.println("YES");
    		   }else {
    			   System.out.println("NO");
    		   }
    		   break;
		
       }
        
    }
}

	private static int find(int a) {
		if(a==parent[a]) {
			return a;
		}else {
			return parent[a] =find(parent[a]);
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB] = rootA; 
		}
		
	}
}
