import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2023 {
    public static int n;
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs("");
        System.out.println(sb.toString());
    }
    public static void dfs(String num){
        if(num.length() == n) {
            sb.append(num + "\n");
            return;
        }

        for(int i=1; i<=9; i++){
            if(check(Integer.parseInt(num + i))){
                dfs(num + i);
            }
        }
    }
    public static boolean check(int num) {
        if(num==1) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}