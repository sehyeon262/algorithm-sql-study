import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new TreeMap<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            String cmd = sc.next();
            if(cmd.equals("add")){
                int k = sc.nextInt();
                int v = sc.nextInt();

                map.put(k,v);


            }else if(cmd.equals("find")){
                int k = sc.nextInt();
                if(map.containsKey(k)){
                    sb.append(map.get(k)).append("\n");
                }else{
                    sb.append("None").append("\n");
                }
                
                
            }else if(cmd.equals("remove")){
                int k = sc.nextInt();
                map.remove(k);
            }else{
                if(map.isEmpty()){
                    sb.append("None").append("\n");
                }else{
                    Iterator<Entry<Integer,Integer>> it = map.entrySet().iterator();

                    while(it.hasNext()){
                        Entry<Integer,Integer> entry = it.next();
                        sb.append(entry.getValue()).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
        
    }
}
