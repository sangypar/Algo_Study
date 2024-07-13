import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    
    static int N;
    static int[][] map;
    static int max;
    static List<Point>[] wormHole;
    
    public static void main(String[] args) throws IOException{
        
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         int TC = Integer.parseInt(br.readLine());
         
         List<Point> startPoint;
         
         for (int t = 1; t <= TC; t++) {
             
             N = Integer.parseInt(br.readLine());
             map = new int[N][N];
             max = Integer.MIN_VALUE;
             
             startPoint = new ArrayList<>();
             wormHole = new ArrayList[11];
             
             for (int i = 0; i < 11; i++) {
                 wormHole[i] = new ArrayList<>();
             }
             
             // 게임판 입력
             // -1: 블랙홀, 0: 빈공간, 1~5: 블록, 6~10: 웜홀
             for (int i = 0; i < N; i++) {
                 
                 st = new StringTokenizer(br.readLine());
                 
                 for (int j = 0; j < N; j++) {
                     map[i][j] = Integer.parseInt(st.nextToken());
                     
                     if (map[i][j] == 0) {
                         startPoint.add(new Point(i, j));
                     } else if (map[i][j] >= 6) {
                         wormHole[map[i][j]].add(new Point(i, j));
                     }
                 }
             }
             
             for (Point start : startPoint) {
//            	 System.out.printf("Point (%d, %d)\n", start.x, start.y);
                 move(start);
             }
             
             System.out.printf("#%d %d\n", t, max);
         }
    } // main

    private static void move(Point start) {
        
        int[] dx = { -1, 0, 1, 0 };    // 상 좌 하 우
        int[] dy = { 0, -1, 0, 1 };
        
        
        for (int dir = 0; dir < 4; dir++) {
            
            int d = dir;
            int score = 0;
            int x = start.x;
            int y = start.y;
            
            while (true) {
                
                int nx = x + dx[d];
                int ny = y + dy[d];
                
//                System.out.printf("x = %d, y = %d, dir = %d\n", x, y, dir);
                
                // 웜홀: 반대편 웜홀로 빠져나옴
                if (checkBounds(nx, ny) && map[nx][ny] >= 6) {
                    for (int i = 0; i < 2; i++) {
                        Point p = wormHole[map[nx][ny]].get(i);
                        if (p.x == nx && p.y == ny) {
                            switch (i) {
                            case 0:
                                x = wormHole[map[nx][ny]].get(1).x;
                                y = wormHole[map[nx][ny]].get(1).y;
                                nx = x + dx[d];
                                ny = y + dy[d];
                                break;
                            case 1:
                                x = wormHole[map[nx][ny]].get(0).x;
                                y = wormHole[map[nx][ny]].get(0).y;
                                nx = x + dx[d];
                                ny = y + dy[d];
                                break;
                            }
                            break;
                        }
                    }
                }
                
                // 벽을 만나는 경우: 반대 방향으로 돌아옴
                if (!checkBounds(nx, ny)) {
                	d = (d + 2) % 4;
                	nx = x;
                	ny = y;
                	score++;
                }
                
                // 웜홀: 반대편 웜홀로 빠져나옴
                if (checkBounds(nx, ny) && map[nx][ny] >= 6) {
                    for (int i = 0; i < 2; i++) {
                        Point p = wormHole[map[nx][ny]].get(i);
                        if (p.x == nx && p.y == ny) {
                            switch (i) {
                            case 0:
                                x = wormHole[map[nx][ny]].get(1).x;
                                y = wormHole[map[nx][ny]].get(1).y;
                                nx = x + dx[d];
                                ny = y + dy[d];
                                break;
                            case 1:
                                x = wormHole[map[nx][ny]].get(0).x;
                                y = wormHole[map[nx][ny]].get(0).y;
                                nx = x + dx[d];
                                ny = y + dy[d];
                                break;
                            }
                            break;
                        }
                    } 
                    
                    
                }
                
                // 블록
                if (map[nx][ny] >= 1 && map[nx][ny] <= 5) {
                    
                    score++;
                    
                    switch (map[nx][ny]) {
                    case 1:
                        // 하 -> 우 or 좌 -> 상
                        if (x <= nx && y >= ny) {
                            if (d == 2)
                                d = 3;
                            else
                                d = 0;
                            x = nx; y = ny;
                        } else {
                        	d = (d + 2) % 4;
                        }
                        break;
                    case 2:
                        // 상 -> 우 or 좌 -> 하
                        if (x >= nx && y >= ny) {
                            if (d == 0)
                                d = 3;
                            else
                                d = 2;
                            x = nx; y = ny;
                        } else {
                        	d = (d + 2) % 4;
                        }
                        break;
                    case 3:
                        // 우 -> 하 or 상 -> 좌
                        if (x >= nx && y <= ny) {
                            if (d == 3)
                                d = 2;
                            else
                                d = 1;
                            x = nx; y = ny;
                        } else {
                        	d = (d + 2) % 4;
                        }
                        break;
                    case 4:
                        // 우 -> 상 or 하 -> 좌
                        if (x <= nx && y <= ny) {
                            if (d == 3)
                                d = 0;
                            else
                                d = 1;
                            x = nx; y = ny;
                        } else {
                        	d = (d + 2) % 4;
                        }
                        break;
                    case 5:
                    	d = (d + 2) % 4;
                    	x = nx;
                    	y = ny;
                    	break;
                    } // switch문
                    
                } // 블록 if문
                
                // 블랙홀 or 출발 위치로 돌아온 경우: 게임 종료
                if ((nx == start.x && ny == start.y) || (map[nx][ny] == -1)) {
                	break;
                }
                
                // 아무 장애물도 만나지 않는 경우: 직진
                x = nx;
                y = ny;
            } // while문
            
            if (score > max)
                max = score;
            
        } // 4방향 for문
    } // move

    private static boolean checkBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}