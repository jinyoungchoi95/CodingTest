import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj2624 {
    public static int T;
    public static Coin[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int coinCase = Integer.parseInt(br.readLine());
        coins = new Coin
                [coinCase];
        for(int i=0; i<coinCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins[i] = new Coin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(coins, new Comparator<Coin>() {
            @Override
            public int compare(Coin o1, Coin o2) {
                return o1.value - o2.value;
            }
        });

        int[] dp = new int[T+1];
        dp[0] = 1;

        for(int i=0; i<coinCase; i++){
            int coin = coins[i].value;
            for(int j=T; j>=coin; j--) {
                for(int k=1; k<=coins[i].count; k++){
                    if(j-coin*k<0) break;
                    dp[j] += dp[j-coin*k];
                }
            }
        }
        System.out.println(dp[T]);

    }
    public static class Coin {
        int value;
        int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}