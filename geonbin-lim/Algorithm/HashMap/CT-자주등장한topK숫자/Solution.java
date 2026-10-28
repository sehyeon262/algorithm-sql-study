import java.util.*;

class Num implements Comparable<Num>{
    long val;
    int cnt;
    Num(long val, int cnt){
        this.val = val;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Num o){
        if(this.cnt==o.cnt) return Long.compare(o.val,this.val);
        return Long.compare(o.cnt,this.cnt);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Long[] arr = new Long[n];

        PriorityQueue<Num> pq = new PriorityQueue<>();

        Map<Long,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // Please write your code here.
        for(Long a : map.keySet()){
            pq.add(new Num(a,map.get(a)));           
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()&&k>0){
            Num num = pq.poll();
            sb.append(num.val).append(" ");
            k--;
        }
        System.out.print(sb);
    }
}
