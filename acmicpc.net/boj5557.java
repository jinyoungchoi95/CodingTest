import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5557 {
    public static int[] num;
    public static int N;
    public static long answer = 0;
    public static int want = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N-1];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N-1; i++){
            num[i] = Integer.parseInt(input[i]);
        }
        want = Integer.parseInt(input[N-1]);

        long[][] dp = new long[N-1][21];
        dp[0][num[0]] = 1;

        for(int i=1; i<N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]>0){
                    int plus = j + num[i];
                    int minus = j - num[i];
                    if(check(plus)){
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(check(minus)){
                        dp[i][minus] += dp[i-1][j];
                    }

                }
            }
        }
        answer = dp[N-2][want];
        System.out.println(answer);
    }
    public static boolean check(int num){
        if(num<=20 && num>=0){
            return true;
        }
        return false;
    }


}
