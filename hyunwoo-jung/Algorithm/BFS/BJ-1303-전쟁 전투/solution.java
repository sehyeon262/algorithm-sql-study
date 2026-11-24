package 전쟁전투_1303;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            String input = br.readLine();

            for (int j = 0; j < M; ++j) {
                map[i][j] = input.charAt(j);
            }
        }

        int whitePower = 0;
        int bluePower = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (visited[i][j]) continue;

                if (map[i][j] == 'W') whitePower += calPower('W', i, j);
                if (map[i][j] == 'B') bluePower += calPower('B', i, j);
            }
        }

        System.out.print(whitePower + " " + bluePower);
    }

    private static int calPower(char team, int r, int c) {
        int power = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;

            for (int d = 0; d < 4; ++d) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] != team) continue;

                if (map[nr][nc] == team) q.offer(new Point(nr, nc));
                visited[nr][nc] = true;
                ++power;
            }
        }

        return power * power;
    }
}
