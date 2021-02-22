import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9252 {
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
        for(int i=1; i<=input1.length(); i++){
            for(int j=1; j<=input2.length(); j++){
                if(input1.charAt(i-1) == input2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int answer = dp[input1.length()][input2.length()];
        System.out.println(answer);

        String answer_str = "";
        int x = input1.length();
        int y = input2.length();
        Stack<String> stack = new Stack<>();
        while(x>=1 && y>=1){
            if(dp[x][y]==dp[x-1][y]){
                x--;
            }
            else if(dp[x][y]==dp[x][y-1]){
                y--;
            }
            else{
                stack.push(input1.substring(x-1, x));
                x--;
                y--;
            }
        }
        while(!stack.isEmpty()){
            System.out.printf("%s", stack.pop());
        }
    }
}