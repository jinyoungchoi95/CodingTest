import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1929 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        boolean[] num = new boolean[m+1];
        Arrays.fill(num, true);
        num[0] = num[1] = false;
        for(int i=2; i<Math.sqrt(m); i++){
            for(int j=i+i; j<=m; j+=i) {
                num[j] = false;
            }
        }
        for(int i=n; i<=m; i++){
            if(num[i]) System.out.println(i);
        }
    }
}
