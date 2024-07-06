import java.util.*;

public class Main_1238 {
    static int n, m, x;
    static ArrayList<Node>[] list;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        dist = new int[n + 1][n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 987654321);
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int w = sc.nextInt();
            list[start].add(new Node(end, w));
        }

        for (int i = 1; i <= n; i++) {
            djistra(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i][x] + dist[x][i]);
        }

        System.out.println(max);
        sc.close();
    }

    public static void djistra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int curr = n.city;

            if (visited[curr]) continue;
            visited[curr] = true;

            for (Node l : list[curr]) {
                int next = l.city;
                int weight = l.w;

                if (dist[start][next] > dist[start][curr] + weight) {
                    dist[start][next] = dist[start][curr] + weight;
                    pq.add(new Node(next, dist[start][next]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int city, w;

    Node(int city, int w) {
        this.city = city;
        this.w = w;
    }

    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
