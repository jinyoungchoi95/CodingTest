import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long old = (y*100)/x;

        if(old >= 99) {
            System.out.println(-1);
        }
        else{
            long min = 1;
            long max = 1000000000;

            while(min<=max) {
                long mid = (max + min) / 2;

                long compare = (y+mid) * 100 / (x+mid);
                if(compare - old >= 1){
                    max = mid - 1;
                }
                else{
                    min = mid + 1;
                }
            }
            System.out.println(min);
        }

    }
}
