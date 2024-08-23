import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	
	int num;	// position
	int time;	// value

	public Point(int num, int time) {
		this.num = num;
		this.time = time;
	}

	@Override
	public int compareTo(Point o) {
		return this.time - o.time;
	}
}

public class Main {
    public static void main(String[] args) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());	// N명의 학생
        int M = Integer.parseInt(st.nextToken());	// M개의 단방향 도로
        int X = Integer.parseInt(st.nextToken());	// X번 마을(집결지)
        
        List<List<Point>> map = new ArrayList<>();
        int[][] distance = new int[N+1][N+1];
        
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            Arrays.fill(distance[i], 987654321);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            
            map.get(A).add(new Point(B, T));
        }
        
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++)
            BFS(i, distance, map);

        //최대 소요시간 구하기
        for (int i = 1; i <= N; i++){
            int d = distance[i][X] + distance[X][i];
            ans = Math.max(ans, d);
        }
        
        System.out.println(ans);
    }
    
    // 시작 구역에서 다른 구역으로 가는 최단 거리 탐색
    static void BFS(int start, int[][] distance, List<List<Point>> map){
    	
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(start, 0));
        distance[start][start] = 0;	
        
        while(!PQ.isEmpty()){
        	
        	Point p = PQ.poll();
        	
            for(Point next : map.get(p.num)){
            	
                int ntPoint = p.time + next.time;
                
                //이동하려는 지역이 최단 거리일 때
                if(distance[start][next.num] > ntPoint){
                    distance[start][next.num] = ntPoint;
                    PQ.add(new Point(next.num, ntPoint));
                }
            }
        }
    }
}