import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			// double[] : { 만나는데 걸리는 시간(1초 or 0.5초), i, j }
			PriorityQueue<double[]> PQ = new PriorityQueue<>(new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if (o1[0] < o2[0])
						return -1;
					else if (o1[0] > o2[0])
						return 1;
					else if (o1[1] != o2[1])
						return (int)(o1[1] - o2[1]);
					else if (o1[2] != o2[2])
						return (int)(o1[2] - o2[2]);
					
					return 0;
				}
			});
			
			ArrayList<int[]> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());	// 방향 (상0, 하1, 좌2, 우3)
				int e = Integer.parseInt(st.nextToken());	// 보유 에너지
				list.add(new int[] {y, x, d, e});
			}
			
			for (int i = 0; i < N - 1; i++) {
				int[] a = list.get(i);
				
				// 방향(d) 기준으로 switch
				switch (a[2]) {
				case 0: // 상
					for (int j = i + 1; j < N; j++) {
						int[] b = list.get(j);
						
						// 현재 노드가 아래에서 위로 이동: y좌표 더 작은 값
						if (a[0] > b[0]) {
							// 1. 정면 충돌 && column 일치
							if (b[2] == 1 && a[1] == b[1]) {
								// 정면 충돌은 0.5초
								PQ.add(new double[] {(a[0] - b[0] / 2.0), i, j});
							} // 2. 90도 충돌(좌)
							else if (b[2] == 2 && a[0] - b[0] == a[1] - b[1]) {
								PQ.add(new double[] {a[0] - b[0], i, j});
							} // 3. 90도 충돌(우)
							else if (b[2] == 3 && a[0] - b[0] == a[1] - b[1]) {
								PQ.add(new double[] {a[0] - b[0], i, j});
							}
						}
					}
					break;
				case 1: // 하
					for(int j = i + 1; j < N; ++j){
                        int[] b = list.get(j);
                        // 현재 노드가 위에서 아래로 이동: y좌표 더 큰 값
                        if(a[0] < b[0]){
                        	// 1. 정면 충돌
                            if (b[2] == 0 && b[1] == a[1]){
                                PQ.add(new double[]{(b[0] - a[0]) / 2.0, i, j});
                            } // 2. 90도 충돌(좌)
                            else if (b[2] == 2 && b[0] - a[0] == b[1] - a[1]){
                                PQ.add(new double[]{b[0] - a[0], i, j});
                            } // 3. 90도 충돌(우)
                            else if (b[2] == 3 && b[0] - a[0] == a[1] - b[1]){
                            	PQ.add(new double[]{b[0] - a[0], i, j});
                            }
                        }
					}
					break;
				case 2: // 좌
					for(int j = i + 1; j < N; ++j){
                        int[] b = list.get(j);
                        // 현재 노드가 우에서 좌로 이동: x좌표 더 작은 값
                        if(a[1] > b[1]) {
                            if (b[2] == 3 && a[0] == b[0]){
                            	PQ.add(new double[]{(a[1] - b[1]) / 2.0, i, j});
                            } else if (b[2] == 0 && b[0] - a[0] == a[1] - b[1]){
                            	PQ.add(new double[]{a[1] - b[1], i, j});
                            } else if (b[2] == 1 && a[0] - b[0] == a[1] - b[1]){
                            	PQ.add(new double[]{a[1] - b[1], i, j});
                            }
                        }
					}
					break;
				case 3: // 우
					for(int j = i + 1; j < N; ++j){
                        int[] b = list.get(j);
                        // 현재 노드가 좌에서 우로 이동: x좌표 더 큰 값
                        if(a[1] < b[1]){
                            if (b[2] == 2 && a[0] == b[0]){
                            	PQ.add(new double[]{(b[1] - a[1]) / 2.0, i, j});
                            } else if (b[2] == 0 && b[0] - a[0] == b[1] - a[1]){
                            	PQ.add(new double[]{b[1] - a[1], i, j});
                            } else if (b[2] == 1 && a[0] - b[0] == b[1] - a[1]){
                            	PQ.add(new double[]{b[1] - a[1], i, j});
                            }
                        }
                    }
					break;
				}
			}
			
			double[] check = new double[N];
			
			while(!PQ.isEmpty()){
                
				double[] temp = PQ.poll();
                
				// 아직 연결되지 않은 선: 두 선 모두 시간 기록
                if (check[(int)temp[1]] == 0 && check[(int)temp[2]] == 0) {
                    check[(int)temp[1]] = temp[0];
                    check[(int)temp[2]] = temp[0];
                } else if (check[(int)temp[1]] == temp[0]) {
                    check[(int)temp[2]] = temp[0];
                }
            }
			
            int ans = 0;
            for(int i = 0; i < N; i++){
                if(check[i] > 0){
                	ans += list.get(i)[3];
                }
            }
			System.out.printf("#%d %d\n", t, ans);
		}	// TC
	}
}