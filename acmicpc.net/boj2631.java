import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int answer = 1;
        dp[0] = 1;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(num[j]<num[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(N - answer);
    }
}
