import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];

        Map<Long,Long> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0L)+1);
        }
        // Please write your code here.
        long result = 0L;

        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(int i = 0; i<keys.size(); i++){
           


            for(int j = i ; j<keys.size() ; j++){
            long x = keys.get(i);




            long b = k-x;
                long y = keys.get(j);
     
                long z = b-y;
                
                if (z < y) continue;
                
                if(map.containsKey(z)) {
                    long aa = map.getOrDefault(x,0l);
                    long bb = map.getOrDefault(y,0l);
                    long cc = map.getOrDefault(z,0l);

                    if(aa > 0 && bb > 0 && cc > 0 ){
                        if(x==y&&y==z){
                            result += aa*(aa-1)*(aa-2)/6;
                        }else if(x==y){
                            result += aa*(aa-1)/2*cc;
                        }else if(y==z){
                            result += bb*(bb-1)/2*aa;
                        }else{
                            result += aa*bb*cc; 
                        }
                    }

                }else{
                    continue;
                }



            }

        }

        System.out.print(result);

        // 분할 해서 ? 2개로 생각하는거지 그리고 하나의 N을 분할하는
    }
}


// K 

// x , y , z 가 있는데 y+z 를 b 라고 하고 x를 a 라 하자 
// a 가 정해지면 b의 값도 정해짐 

// 또 이제 b를 본다 b를 다시 두 수의 합으로 정의하고 

// 이제 b를 두 수의 합 구하듯이 하면 
// a 일때 경우의수가 정해짐 

// a 가 고정일 때 모든 경우의수를 구했으므로 
// 후에 a가 나와도 구할 필요는 없다

// 반면 b를 구성한 y , z 는 어떻게 해야하는가 ?
// 수많은 조합들이 있을거다 
// if b 가 7이라면 1,6   2,5   3,4    

// K  가 8이고 a가 1이었을 때를 가정해보면 
// 미리 a의 개수와  임의의 y z 개수를 알고 있으므로  a 가 정해졌을 때 그 a에 대한 경우의 수는 다 구할 수 있지만 

//a  가 4 이었다면 b 가 4 이고  2,2 라는 새로운 조합이 나온다 
// 그렇다면 그 조합을 이미 한 조합이라고 기록을 한다면 할 수 있지 않을까? 이러면 이미 한 조합은 건너뛰고 
// 새로운 조합을 할 수 있다 .

// 그 조합의 기록을 어떻게 해야할까  ?
// 4,1,3 3,1,4 다 같은 조합이다 

// 즉 a가 4일 때를 먼저했을 때 
// 후에 a가 3일 때 1,4 조합을 넘어가야한다 .

// 따라서 어떤 조합을 구했다면 정렬 후 그냥 앞에 숫자를 했는지만 검색하면 될거 같은데 ? 
