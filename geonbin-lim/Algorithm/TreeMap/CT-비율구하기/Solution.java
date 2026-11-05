import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        Map<String,Integer> map = new TreeMap<>();



        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // Please write your code here.
        Iterator<Entry<String,Integer>> it = map.entrySet().iterator();

        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            Entry<String,Integer> entry = it.next();
            double ratio = (double) entry.getValue()/ n * 100;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f",ratio)).append("\n");
        }
        System.out.print(sb);

    }
}
