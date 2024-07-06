import java.util.*;
public class BJ1238_파티 {

    static class Node {
        int index;
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static int n;
    static List<List<Node>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            graph.get(start).add(new Node(end, dist));
        }

        int answer = Integer.MIN_VALUE;
        int[] toHome = dijkstra(x);

        for(int i = 1; i <= n; i++) {
            if(i == x) continue;
            int[] toParty = dijkstra(i);

            answer = Math.max(answer, toHome[i] + toParty[x]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int currNode = curr.index;
            int currDist = curr.weight;

            if(currDist > dist[currNode]) continue;

            for(Node next : graph.get(currNode)) {
                int nextNode = next.index;
                int nextDist = next.weight;

                if(dist[nextNode] > dist[currNode] + nextDist) {
                    dist[nextNode] = dist[currNode] + nextDist;
                    pq.add(new Node(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}
