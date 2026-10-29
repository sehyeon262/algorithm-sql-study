import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        Map<Long,Integer> mapAB = new HashMap<>();
        int result = 0;



        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            D[i] = sc.nextLong();
        }
        // Please write your code here.

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                mapAB.put(A[i]+B[j],mapAB.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int key = mapAB.getOrDefault(-1*(C[i]+D[j]),0);
                if(key!=0){
                    result += key;     
                }
            }
        }





        
        System.out.print(result);

    }

}


// ----------------------백 트래킹으로 풀 수 없음 시간 초과------------------------------------
// 최종 값은 0 
// mapA 에서 하나를 정하면 0-a = b 
// 그럼 mapb mapc mapd 를 합쳐서 b가 나와야 한다 . 
// 각 구역에서 하나만 뽑는다 . 

// 세 수의 합처럼 정렬이 필요할까? 이건 0이 돼야 하는데 

// 최악의 경우 5000*5000*5000*5000 = 625,000,000,000,000
// 그렇다면 백트래킹을 하면 괜찮을까 ? 

// 각 리스트를 정렬을 했다고 가정하자 
// 맨 앞이 음수일수도 있고 양수 일수도 있다
// 만약 양수였다고 치자 그럼 0+a 는 양수 일것이고 세수의 합이 -a 여야 한다 .
// 근데 -a 가 각 리스트 b,c,d의 최댓값의 합보다 크면 무조건 안되므로 넘어 갈 수 있다 .
// 그전에 양수 음수를 굳이 생각할 이유가 있을까 양수든 음수든 -a의 형태이고 
// N이 1일 때 9 -3 -2  -3 // -9 3 2 3 이  두 예시를 둔다면 // 양수 음수를 구분할 필요가 있어보인다 
// 만약 0 + a 의 결과가 양수라면 남은 리스트의 최솟값의 합이 - a 보다 크다면 애초에 안되는 것이다.
// 반대로 0 + a 의 결과가 음수라면 남은 리스트의 최댓값이 합이 a 보다 작으면 안되는 것이다. 

// 두번째 리스트를 순회하면서 뭔가 결정지을 수 있는게 있을까 ? 
// ------------------------------------------------------------------
