import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        if(input1.length()<input2.length()){
            String tmp = input1;
            input1 = input2;
            input2 = tmp;
        }

        int[][] dp = new int[input1.length()+1][input2.length()+1];
        int answer = 0;
        for(int i=1; i<=input1.length(); i++){
            for(int j=1; j<=input2.length(); j++){
                if(input1.charAt(i-1) == input2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}