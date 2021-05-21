import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]) - 1;
        int b = Integer.parseInt(input[2]) - 1;
        int count = 1;
        while(true) {
            if(a/2==b/2) break;
            a/=2;
            b/=2;
            count++;
        }
        System.out.println(count);
    }
}
