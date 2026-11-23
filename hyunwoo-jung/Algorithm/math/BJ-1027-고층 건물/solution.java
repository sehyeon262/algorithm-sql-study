import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; ++i) {
            int count = 0;

            // i에서 j가 보이는지: i부터 j 사이에 있는 건물들의 높이가 해당 좌표에서의 높이(기울기)보다 낮아야 함.
            for (int j = 0; j < N; ++j) {
                if (i == j) continue;

                // i -> j 기울기 구하기
                int a = 0;
                int b = 0;
                if (i < j) {
                    b = j;
                    a = i;
                } else {
                    b = i;
                    a = j;
                }

                boolean visible = true;
                for (int k = a + 1; k < b; ++k) {
                    long left = (long) heights[k] * (b - a);
                    long right = (long) heights[a] * (b - a) + (long) (heights[b] - heights[a]) * (k - a);
                    if (left >= right) {
                        visible = false;
                        break;
                    }
                }

                if (visible) ++count;
            }

            answer = Math.max(answer, count);
        }

        System.out.print(answer);
    }
}
