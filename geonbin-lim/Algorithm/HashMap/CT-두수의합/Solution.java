import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> isVisited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

 
        
        int result = 0;

        for(int i = 0 ; i<n; i++){
            int a = arr[i];
            int b = k - a;

            if(isVisited.getOrDefault(a,0)>=1) continue;
            isVisited.put(a,1);
            isVisited.put(b,1);

            int k1 = map.getOrDefault(a,0);
            int k2 = map.getOrDefault(b,0);

            if(a==b){
                int c = map.getOrDefault(a,0);
                if(c>1){ // 2개 이상 있을 경우만
                    result += c*(c-1)/2;
                }
            }
            else if(k1>0 && k2>0){
                result += k1*k2;
            }

            a++;
        }
        // Please write your code here.
        System.out.print(result);
    }


}
