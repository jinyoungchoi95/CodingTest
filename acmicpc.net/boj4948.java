import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] num = new boolean[123457*2];
        Arrays.fill(num, true);
        num[0] = num[1] = false;
        for(int i=2; i<Math.sqrt(num.length); i++){
            for(int j=i+i; j<num.length; j+=i){
                num[j] = false;
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            int count = 0;
            for(int i=n+1; i<=2*n; i++){
                if(num[i]) count++;
            }
            System.out.println(count);
        }
    }
}
