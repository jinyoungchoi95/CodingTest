import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        boolean[] num = new boolean[N+1];
        int count = 0;

        for(int i=2; i<=N; i++){
            num[i] = true;
        }

        for(int i=2; i<=N; i++){
            for(int j=i; j<=N; j+=i) {
                if(!num[j]) continue;

                num[j] = false;
                count++;
                if(count==K) {
                    System.out.println(j);
                }
            }
        }
    }
}
