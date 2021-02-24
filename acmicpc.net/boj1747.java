import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[1004001];
        Arrays.fill(num, true);
        num[0] = num[1] = false;
        for(int i=2; i*i<=1004000/2; i++){
            if(num[i]){
                for(int j=i+i; j<=1004000; j+=i){
                    num[j] = false;
                }
            }
        }
        for(int i=0; i<N; i++){
            num[i] = false;
        }
        for(int i=N; i<=1004000; i++){
            if(num[i] && check(i)){
                System.out.println(i);
                return;
            }
        }
    }
    public static boolean check(int n){
        String input = String.valueOf(n);
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)) return false;
        }
        return true;
    }
}