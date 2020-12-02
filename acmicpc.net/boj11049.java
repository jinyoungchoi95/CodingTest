import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11049 {
    public static int[][] array, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new int[N][2];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(find(0,N-1));

    }
    public static int find(int x, int y){
        if(x==y){
            return 0;
        }
        if(dp[x][y] != Integer.MAX_VALUE){
            return dp[x][y];
        }
        for(int i=x; i<y; i++){
            int value = find(x,i) + find(i+1,y) + array[x][0] * array[i][1] * array[y][1];
            dp[x][y] = Math.min(dp[x][y], value);
        }
        return dp[x][y];
    }
}
