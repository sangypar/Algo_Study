import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1_23_1238_파티 {
    static class Node implements Comparable<Node>{
        int to;
        int w;
        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, w));
        }

        int Maxresult = Integer.MIN_VALUE;
        for(int i = 1; i <= V; i++) {
            int[] result = dijkstra(i, adj, V);
            int[] reverseResult = dijkstra(goal, adj, V);

            Maxresult = Math.max(Maxresult, result[goal] + reverseResult[i]);
        }
        System.out.println(Maxresult);
    }

    private static int[] dijkstra(int start, List<Node>[] adj, int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            for(Node next : adj[current.to]) {
                if(dist[next.to] > dist[current.to] + next.w) {
                    dist[next.to] = dist[current.to] + next.w;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
