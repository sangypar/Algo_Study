import java.util.*;

public class BJ1717_집합의표현 {
	
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parents = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			int input = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			switch(input) {
			case 0:
				union(a, b);
				break;
				
			case 1:
				if(find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				break;
			}
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parents[b] = a;
	}

	static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
}
