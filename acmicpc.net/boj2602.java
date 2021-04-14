import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2602 {
    public static String input, angel, devil;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        angel = br.readLine();
        devil = br.readLine();

        int[][][] dp = new int[2][angel.length()][input.length()];
        if(angel.charAt(0) == input.charAt(0)) dp[0][0][0] = 1;
        if(devil.charAt(0) == input.charAt(0)) dp[1][0][0] = 1;

        for(int i=1; i<angel.length(); i++){
            if(angel.charAt(i) == input.charAt(0)){
                dp[0][i][0] = 1;
            }
            dp[0][i][0] += dp[0][i-1][0];
            if(devil.charAt(i) == input.charAt(0)){
                dp[1][i][0] = 1;
            }
            dp[1][i][0] += dp[1][i-1][0];

            for(int j=1; j<input.length(); j++){
                dp[0][i][j] = dp[0][i-1][j];
                dp[1][i][j] = dp[1][i-1][j];
                if(angel.charAt(i) == input.charAt(j)) dp[0][i][j] += dp[1][i-1][j-1];
                if(devil.charAt(i) == input.charAt(j)) dp[1][i][j] += dp[0][i-1][j-1];
            }
        }
        System.out.println(dp[0][angel.length()-1][input.length()-1] + dp[1][angel.length()-1][input.length()-1]);
    }
}