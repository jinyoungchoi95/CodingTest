import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] map = new int[11];
        map[1] = 1;
        map[2] = 2;
        map[3] = 4;
        for(int i=4; i<=10; i++){
            map[i] = map[i-1] + map[i-2] + map[i-3];
        }
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(map[n]);
        }
    }
}
