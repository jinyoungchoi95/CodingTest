import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N+1];
        String[] input = br.readLine().split(" ");
        int max = 0;
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(input[i-1]);
            max += array[i];
        }

        boolean[] dp = new boolean[max+1];
        boolean[] dp_tmp = new boolean[max+1];
        for(int i=1; i<=N; i++){
            for(int j=0; j<=max; j++){
                if(dp[j]){
                    dp_tmp[Math.abs(array[i]+j)] = true;
                    dp_tmp[Math.abs(array[i]-j)] = true;
                }
            }
            dp_tmp[array[i]] = true;
            for(int j=0; j<=max; j++){
                if(dp_tmp[j]) dp[j] = true;
            }
        }


        int T = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int testcase=0; testcase<T; testcase++){
            int want = Integer.parseInt(input[testcase]);
            if(want>max || !dp[want]) System.out.printf("%s ", "N");
            else System.out.printf("%s ", "Y");

        }
    }
}
