import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<n; i++){
            String str = sc.next();
            if(str.equals("push_back")){
                int a = sc.nextInt();
                arr.add(a);
            }else if(str.equals("get")){
                int a = sc.nextInt();
                sb.append(arr.get(a-1)).append("\n");
            }else if(str.equals("pop_back")){
                arr.remove(arr.size()-1);
            }else{// size
                sb.append(arr.size()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
