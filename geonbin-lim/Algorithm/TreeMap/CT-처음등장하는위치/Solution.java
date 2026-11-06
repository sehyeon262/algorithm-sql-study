import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i],i+1);
            }
        }
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<Integer,Integer>> it = map.entrySet().iterator();

    
        while(it.hasNext()){
            Entry<Integer,Integer> entry = it.next();
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.print(sb);

    
    }
}
