import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        // [-20, -15], [-18, -13], [-14, -5], [-5, -3]
        for (int[] route : routes) {
            if (route[0] > camera) {
                camera = route[1];
                ++answer;
            }
        }

        return answer;
    }
}