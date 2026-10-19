import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int a = 0;   // A에서 아직 상대하지 않은 가장 작은 숫자의 위치

        /*
        1 3 5 7
        2 2 6 8
        */
        for (int b = 0; b < B.length; b++) {
            // B[b]가 A[a]를 이길 수 있다면?
            if (B[b] > A[a]) {
                ++answer;
                ++a;
            }
        }

        return answer;
    }
}