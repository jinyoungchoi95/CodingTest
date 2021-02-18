import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11054 {
    public static int[] dp;
    public static int[] array;
    public static int answer;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        array = new int[N+1];
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(input[i-1]);
        }

        dp = new int[N+1];
        dp[1] = 1;
        answer = 0;
        for(int i=1; i<=N; i++){
            LIS(i);
        }
        System.out.println(answer);

    }
    public static void LIS(int point){
        for(int i=1; i<=point; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        for(int i=point+1; i<=N; i++){
            dp[i] = 1;
            for(int j=point; j<i; j++){
                if(array[i] < array[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
    }
}