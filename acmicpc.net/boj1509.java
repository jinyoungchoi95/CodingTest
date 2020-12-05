import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        char[] array = new char[len+1];
        for(int i=1; i<=len; i++) {
            array[i] = input.charAt(i - 1);
        }
        boolean[][] pelin = new boolean[len+1][len+1];
        for(int i=1; i<=len; i++){
            pelin[i][i] = true;
        }
        for(int i=1; i<len; i++){
            if(array[i]==array[i+1]) {
                pelin[i][i + 1] = true;
            }
        }
        for(int i=3; i<=len; i++){
            for(int j=1; j<=len-i+1; j++){
                int end = i+j-1;
                if(array[j]==array[end]){
                    if(pelin[j+1][end-1]){
                        pelin[j][end] = true;
                    }
                }
            }
        }

        int[] dp = new int[len+1];
        for(int i=1; i<=len; i++){
            for(int j=1; j<=i; j++){
                if(pelin[j][i]){
                    if(dp[i]==0 || dp[i]>dp[j-1]+1){
                        dp[i] = dp[j-1] +1;
                    }
                }
            }
        }
        System.out.println(dp[len]);
    }
}
