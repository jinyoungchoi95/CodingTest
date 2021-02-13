import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();

        int[][][] dp = new int[input1.length()+1][input2.length()+1][input3.length()+1];
        for(int i=1; i<=input1.length(); i++){
            for(int j=1; j<=input2.length(); j++){
                for(int k=1; k<=input3.length(); k++){
                    if(input1.charAt(i-1)==input2.charAt(j-1) && input2.charAt(j-1)==input3.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        System.out.println(dp[input1.length()][input2.length()][input3.length()]);
    }

}