import java.io.*;
import java.util.*;

public class Main2708 {
    static int[][] directions = {
            {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}
    };
    static List<int[]> cubes;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int P = Integer.parseInt(br.readLine());
            cubes = new ArrayList<>();
            visited = new HashSet<>();

            for (int i = 0; i < (P + 7) / 8; i++) {
                String[] str = br.readLine().split(" ");
                for (String s : str) {
                    String[] cube = s.split(",");
                    int x = Integer.parseInt(cube[0]);
                    int y = Integer.parseInt(cube[1]);
                    int z = Integer.parseInt(cube[2]);
                    cubes.add(new int[]{x, y, z});
                }
            }

            if (isPolyCube(P)) {
                int surfaceArea = calculateSurfaceArea();
                sb.append(surfaceArea).append("\n");
            } else {
                sb.append("NO ").append(findInvalidCube()).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static boolean isPolyCube(int P) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(cubes.get(0));
        visited.add(toString(cubes.get(0)));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : directions) {
                int[] neighbor = new int[] {
                        current[0] + dir[0],
                        current[1] + dir[1],
                        current[2] + dir[2]
                };
                if (cubesContains(neighbor) && !visited.contains(toString(neighbor))) {
                    queue.add(neighbor);
                    visited.add(toString(neighbor));
                }
            }
        }

        return visited.size() == cubes.size();
    }

    static int calculateSurfaceArea() {
        int totalSurfaceArea = 0;

        for (int[] cube : cubes) {
            int surface = 6;

            for (int[] dir : directions) {
                int[] neighbor = new int[] {
                        cube[0] + dir[0],
                        cube[1] + dir[1],
                        cube[2] + dir[2]
                };

                if (cubesContains(neighbor)) {
                    surface--;
                }
            }

            totalSurfaceArea += surface;
        }

        return totalSurfaceArea;
    }

    static boolean cubesContains(int[] cube) {
        for (int[] c : cubes) {
            if (Arrays.equals(c, cube)) return true;
        }
        return false;
    }

    static String toString(int[] cube) {
        return cube[0] + "," + cube[1] + "," + cube[2];
    }

    static int findInvalidCube() {
        for (int i = 0; i < cubes.size(); i++) {
            if (!visited.contains(toString(cubes.get(i)))) {
                return i + 1;
            }
        }
        return -1;
    }
}
