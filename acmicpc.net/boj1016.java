import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1016 {
    public static long min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        min = Long.parseLong(input[0]);
        max = Long.parseLong(input[1]);

        boolean[] num = new boolean[(int) (max-min+1)];

        for(long i = 2; i <= Math.sqrt(max); i++){
            long power = i * i;

            long start = min % power == 0 ? min / power : (min / power) + 1;
            for(long j = start; power * j <= max; j++){
                num[(int)((j * power) - min)] = true;
            }
        }

        int answer = 0;
        for(int i=0; i<num.length; i++){
            if(!num[i]) answer++;
        }
        System.out.println(answer);
    }
}
