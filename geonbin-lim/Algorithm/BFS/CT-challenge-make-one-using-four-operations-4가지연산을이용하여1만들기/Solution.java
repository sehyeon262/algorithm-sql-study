import java.util.*;

class State{
    int val ;
    int time ;
    State(int val, int time){
        this.val = val;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        // isVistied 가 있어야 할 거 같음 첫번째 도착한 숫자가 최소로 갈 수 있는 숫자임이 확실함 넣는 순서 때문에
        // 근데 set으로 대체 isVisited 를 백만개 선언 하는거 보디 나은거 같기도 ? 
        // 물어보니까 아니랍니다 boolean 배열이 속도도 빠르고 메모리 효율도 좋다 set은 Integer로 오토박싱하고 해시테이블 구성을 위한 노드 객체들이 추가로 생성돼서 훨씬 더많은 메모리
        // 내가 set 그럼에도 더 낫다고 생각한건 혹여나 1000000 을 초과 하는 수가 더 빠를수도 있기 때문이라 생각해서 그냥 
        // 쉽게 set 하자한건데 그것도 수학적으로 초과하는게 더 빠르기 힘들다네.
        Set<Integer> set = new HashSet<>();
        ArrayDeque<State> q = new ArrayDeque<>();
        q.add(new State(n,0));
        bfs(q, set);
        System.out.println(min);



    }


    static int min = Integer.MAX_VALUE;

    static void bfs(ArrayDeque<State> q, Set<Integer> set){
        while(!q.isEmpty()){
            State st = q.poll();
            if(st.val==1){
                min = Math.min(min, st.time);
                return;
            }

            if(st.val%3==0&&st.val/3>0&&!set.contains(st.val/3)) {
                set.add(st.val/3);
                q.add(new State(st.val/3,st.time+1));
            }
            if(st.val%2==0&&st.val/2>0&&!set.contains(st.val/2)){
                set.add(st.val/2);
                q.add(new State(st.val/2,st.time+1));
            }

            if(!set.contains(st.val+1)) { 
                q.add(new State(st.val+1,st.time+1));
                set.add(st.val+1);
            }
            if(!set.contains(st.val-1)) { 
                q.add(new State(st.val-1,st.time+1));
                set.add(st.val-1);
            }
        }
    }


}
