import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            if(str.equals("find")){
                sb.append(set.contains(a)).append("\n");
            }else if(str.equals("add")){
                set.add(a);
            }else{ // remove 
                set.remove(a);
            }
        }
        System.out.print(sb);

        
    }
}
