import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션_5648 {

	static class Atom {
		int x, y, energy, dir;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}

	// 좌표에서의 세상 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map = new int[4002][4002];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); // 원자개수

			List<Atom> list = new ArrayList<>();

			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());

				list.add(new Atom(x, y, dir, energy));
				map[x][y] = energy;
			} // 입력완

			int sum = 0;

			while (!list.isEmpty()) {
				
				for (int i = 0; i < list.size(); i++) {
					Atom a = list.get(i);
					
					map[a.x][a.y] = 0; //해당위치 E 없애고
					
					a.x += dx[a.dir];
					a.y += dy[a.dir]; //이동
					
					//만나는게 없어서 나간거임
					if (a.x > 4000 || a.x < 0 || a.y > 4000 || a.y < 0) {
						list.remove(i);
						i--;
						continue;
					}
					
					map[a.x][a.y] += a.energy; //나간게 아니라면 해당 map에 에너지 더해줘
				}
				
				//제거되는거 제거하고
				for (int i = 0; i < list.size(); i++) {
					Atom a = list.get(i);
					
					//해당 위치가 본인의 위치랑 에너지가 다르다면?
					if (map[a.x][a.y] != a.energy) {
						sum += map[a.x][a.y];
						map[a.x][a.y] = 0;
						list.remove(i);
						i--;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		} // 테케끝

		System.out.println(sb);
	} // main끝
}

/*
 * 
 * 아래 풀이는 세개 이상의 분자가 충돌할 경우를 고려하지 못헀다!!!!
 * 
 */
//	private static void check(List<Atom> list) {
//
//		int size = list.size();
//		boolean found = false;
//
//		for (int i = 0; i < size - 1; i++) {
//			Atom one = list.get(i);
//
//			// 가장 가까운 원자 쌍을 찾기 위한 변수들
//			Atom closestOne = one;
//			Atom closestTwo = null;
//			int minDistance = Integer.MAX_VALUE;
//
//			for (int j = i + 1; j < size; j++) {
//				Atom two = list.get(j);
//
//				// x 또는 y 좌표중에 하나가 같다면
//				if (one.x == two.x || one.y == two.y) {
//					// 방향 체크해서 반대방향인지
//					if (checkDir(one, two)) {
//
//						int distance = Math.abs(one.x - two.x) + Math.abs(one.y - two.y);
//
//						// 짧은 거리가 생긴될때마다 one, tow 바뀜
//						if (distance < minDistance) {
//							closestTwo = two;
//							minDistance = distance;
//							found = true;
//						}
//					}
//				}
//
//			} // two
//			
//			if (closestTwo != null) {
//				sum += closestOne.energy + closestTwo.energy;
//				
//				list.remove(closestTwo);
//				list.remove(closestOne);
//				
//				size -= 2; // 리스트 크기 업데이트
//				i--; // 리스트 크기가 줄어들었으므로 인덱스 보정
//				found = true;
//			}
//		} // one
//	}
//
//	private static boolean checkDir(Atom one, Atom two) {
//
//		if ((one.dir == 0 && two.dir == 1) || (one.dir == 1 && two.dir == 0) || (one.dir == 2 && two.dir == 3)
//				|| (one.dir == 3 && two.dir == 2)) {
//			return true;
//		}
//
//		return false;
//	}
//}
