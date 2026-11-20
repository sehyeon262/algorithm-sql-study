import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Character> li = new LinkedList<>();
        String str = st.nextToken();
        for(int i = 0; i<n;i++){
            li.add(str.charAt(i));
        }
        // Please write your code here.
        ListIterator<Character> it = li.listIterator(li.size());
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if(str.charAt(0)=='L'){ // 앞으로 이동
                if(it.hasPrevious()) it.previous();
            }else if(str.charAt(0)=='P'){ // 뒤에 숫자 추가 
                str = st.nextToken();
                it.add(str.charAt(0));
            }else if(str.charAt(0)=='R'){ // 뒤로 이동
                if(it.hasNext()) it.next();
            }else{ // 바로뒤에 있는 빵 제거 
                if(it.hasNext()){
                    it.next();
                    it.remove();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : li){
            sb.append(c);
        }
        System.out.print(sb);
    }
}
