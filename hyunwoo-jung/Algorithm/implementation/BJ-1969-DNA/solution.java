import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] counts;
    static String[] DNAs;

    static char[] nucs = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[M][4];
        DNAs = new String[N];
        for (int i = 0; i < N; ++i) {
            DNAs[i] = br.readLine();
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                String DNA = DNAs[i];
                char nuc = DNA.charAt(j);

                ++counts[j]["ACGT".indexOf(nuc)];
            }
        }

        StringBuilder sb = new StringBuilder();
        int distance = 0;

        for (int j = 0; j < M; ++j) {
            int max = 0, number = 0;
            for (int k = 0; k < 4; ++k) {
                if (counts[j][k] > max) {
                    max = counts[j][k];
                    number = k;
                }
            }
            sb.append(nucs[number]);
            distance += N - max;
        }

        sb.append('\n').append(distance);
        System.out.print(sb);
    }
}
