import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준1717_집합의표현
class Main {
	
	static int[] parent; // 각 원소의 부모를 명시하는 배열
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
        int n = Integer.parseInt(st.nextToken());   // n + 1개의 집합
        int m = Integer.parseInt(st.nextToken());   // m개의 연산 수행
        
        // parent 배열 초기화
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
        	parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int c = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	switch (c) {
			case 0: // a와 b가 포함되어 있는 두 집합을 합치기
				union(a, b);
				break;
			case 1: // 두 원소가 같은 집합에 포함되어 있는지 확인
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
				break;
			}
        }
        
        System.out.println(sb);
	}

	// 두 원소가 같은 집합에 포함되어 있는지 확인
	private static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		
		// parent와 원소 번호가 다르다면 재귀
		return parent[n] = find(parent[n]);
	}

	// a, b가 포함되어 있는 두 집합 유니온
	private static void union(int a, int b) {
		
		// 1. 각 원소의 부모 찾기
		a = find(a);
		b = find(b);
		
		// 2-1. 이미 같은 집합에 속한 경우: 유니온 불가능 > return
		if (a == b)
			return;
		
		// 2-2. 번호가 작은 쪽이 부모가 되도록 합치기
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}