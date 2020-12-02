import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11066 {
    public static int[] page, sum;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testcase=0; testcase<T; testcase++){
            int K = Integer.parseInt(br.readLine());
            page = new int[K+1];
            sum = new int[K+1];
            dp = new int[K+1][K+1];
            String[] input = br.readLine().split(" ");
            for(int i=1; i<=K; i++){
                page[i] = Integer.parseInt(input[i-1]);
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                if(i!=1){
                    sum[i] = sum[i-1] + page[i];
                }
                else{
                    sum[i] = page[i];
                }
            }
            System.out.println(find(1,K));

        }
    }
    public static int find(int x, int y){
        if(x==y){
            return 0;
        }
        if(y==x+1){
            return page[x]+page[y];
        }
        if(dp[x][y] != Integer.MAX_VALUE){
            return dp[x][y];
        }

        for(int i=x; i<y; i++){
            int value = find(x,i) + find(i+1,y) + sum[y] - sum[x-1];
            dp[x][y] = Math.min(dp[x][y], value);
        }
        return dp[x][y];
    }
}
