import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2581 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        boolean[] num = new boolean[n+1];
        Arrays.fill(num, true);
        num[0] = num[1] = false;
        for(int i=2; i<=Math.sqrt(n); i++){
            for(int j=i+i; j<=n; j+=i) {
                num[j] = false;
            }
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i=m; i<=n; i++){
            if(num[i]){
                answer += i;
                min = Math.min(min, i);
            }
        }
        if(answer>0){
            System.out.println(answer);
            System.out.println(min);
        }
        else{
            System.out.println(-1);
        }
    }
}
