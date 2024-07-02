import java.util.*;

public class BJ5972_택배배송 {
	
	static int n, m;
	static int[] dist;
	static List<List<int[]>> Node;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		dist = new int[n+1];
		Node = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
			Node.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			Node.get(a).add(new int[]{b, c});
			Node.get(b).add(new int[]{a, c});
		}
		
		dijkstra(1);
		
		System.out.println(dist[n]);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDist = curr[1];
			
			if(currDist > dist[currNode]) continue;
			
			for(int i = 0; i < Node.get(currNode).size(); i++) {
				int nextNode = Node.get(currNode).get(i)[0];
				int nextDist = Node.get(currNode).get(i)[1];
				
				if(dist[nextNode] > dist[currNode] + nextDist) {
					dist[nextNode] = dist[currNode] + nextDist;
					pq.add(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		
	}
}
