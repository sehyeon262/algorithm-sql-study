import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String,Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            int a = map.getOrDefault(sortedWord,0);
            max = Math.max(max,a+1);
            map.put(sortedWord,a+1);

        }

        System.out.print(max);

        // Please write your code here.
    }
}
