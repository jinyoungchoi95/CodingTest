import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj14002 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        String[] input = br.readLine().split(" ");
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(input[i]);
        }
        dp[0] = 1;

        int max_i = 0;
        int max_count = dp[max_i];
        int max_value = 0;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(num[j] < num[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(dp[i] > max_count){
                max_i = i;
                max_count = dp[i];
            }

        }
        System.out.println(max_count);

        Stack<Integer> stack = new Stack<>();
        stack.push(max_i);
        max_count--;
        while(max_count>=1){
            for(int i=max_i; i>=0; i--){
                if(dp[i]==max_count && num[i]<num[max_i]){
                    stack.push(i);
                    max_i = i;
                    max_count--;
                    break;
                }
            }
        }


        while(!stack.isEmpty()){
            System.out.printf("%d ", num[stack.pop()]);
        }
    }

}