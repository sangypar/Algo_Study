package 8월;

public import java.util.*;
import java.io.*;

public class Main {
    static int[][][] cube = new int[101][101][101];
    static int N;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static boolean isValid = true;
    static int failIdx = -1;

    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
        	
        	N = Integer.parseInt(br.readLine());
        	
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j <= N; j++) {
        			Arrays.fill(cube[i][j], 0);
        		}
        	}
        	
        	isValid = true;
        	failIdx = -1;
        	int areaSize = 0;
        	
        	ArrayList<String> points = new ArrayList<>();
        	while (points.size() < N) {
        		String[] input = br.readLine().split(" ");
        		for (String point : input) {
        			points.add(point);
        			if (points.size() == N)
        				break;
        		}
        	}
     
        	String[] firstPoint = points.get(0).split(",");
        	int firstX = Integer.parseInt(firstPoint[0]);
        	int firstY = Integer.parseInt(firstPoint[1]);
        	int firstZ = Integer.parseInt(firstPoint[2]);
        	cube[firstX][firstY][firstZ] = 1;	// 첫 번째 큐브는 항상 유효
        	
        	for (int i = 1; i < N; i++) {
        		String[] pt = points.get(i).split(",");
        		int x = Integer.parseInt(pt[0]);
        		int y = Integer.parseInt(pt[1]);
        		int z = Integer.parseInt(pt[2]);
        		
        		if (!isConnected(x, y, z)) {
        			isValid = false;
        			failIdx = i + 1;  // i는 0부터 시작
        			break;
        		}
        		cube[x][y][z] = 1;
        	}
        	
        	if (!isValid) {
        		sb.append("NO ").append(failIdx).append("\n");
//        		System.out.println("NO " + failIdx);
        		continue;
        	}
        	
        	for (int x = 0; x < N; x++) {
        		for (int y = 0; y < N; y++) {
        			for (int z = 0; z < N; z++) {
        				if (cube[x][y][z] == 1) {
        					areaSize += 6;
        					
        					// 인접 큐브가 있는 경우 areaSize--
        					for (int k = 0; k < 6; k++) {
        						int nx = x + dx[k];
        						int ny = y + dy[k];
        						int nz = z + dz[k];
        						
        						if (checkBounds(nx, ny, nz) && cube[nx][ny][nz] == 1) {
        							areaSize--;
        						}
        					}
        				}
        			}
        		}
        	}
        	sb.append(areaSize).append("\n");
//        	System.out.println(areaSize);
        }
        System.out.println(sb);
    }

    // 기존 큐브와 연결되는 큐브인지 확인
    static boolean isConnected(int x, int y, int z) {
        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];
            if (checkBounds(nx, ny, nz) && cube[nx][ny][nz] == 1) {
                return true;
            }
        }
        return false;
    }

    static boolean checkBounds(int x, int y, int z) {
        return x >= 0 && x < N && y >= 0 && y < N && z >= 0 && z < N;
    }
} {
  
}
