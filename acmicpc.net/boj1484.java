import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int now = 1;
        int record = 1;
        int max = 100000;

        boolean answer = false;
        while(record <= max){
            int compare = now*now - record*record;
            if(compare == G){
                answer = true;
                System.out.println(now);
            }

            if(compare <= G) now++;
            else record++;
        }
        if(!answer) System.out.println(-1);
    }
}
