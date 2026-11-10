import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] arr = s.split("-");
        System.out.println(arr[0] + '-' + arr[2] + '-' + arr[1]);
    }
}
