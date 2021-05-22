import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(input[i]);
        }

        int first = num[0];
        for(int i=1; i<n; i++){
            int gcd = gcd(first, num[i]);
            System.out.println(first/gcd + "/" + num[i]/gcd);
        }
    }
    public static int gcd(int a, int b) {
        int tmp;

        while(b!=0){
            tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
