import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3687 {
    public static long[] mindp = new long[101];
    public static String[] maxdp = new String[101];
    public static String[] startNum = {"1", "7", "4", "2", "0", "8"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //maxdp
        maxdp[2] = "1";
        maxdp[3] = "7";
        for(int i=4; i<=100; i++){
            if(i%2 == 0){
                maxdp[i] = maxdp[i-2] + "1";
            }
            else{
                maxdp[i] = "7" + maxdp[i-1].substring(1);
            }
        }

        //mindp
        Arrays.fill(mindp, Long.MAX_VALUE);
        mindp[2] = 1;
        mindp[3] = 7;
        mindp[4] = 4;
        mindp[5] = 2;
        mindp[6] = 6;
        mindp[7] = 8;
        mindp[8] = 10;

        for(int i=9; i<=100; i++){
            for(int j=0; j<6; j++){
                mindp[i] = Math.min(mindp[i], Long.parseLong(mindp[i-j-2] + startNum[j]));
            }
        }


        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++){
            int input = Integer.parseInt(br.readLine());
            System.out.println(mindp[input] + " " + maxdp[input]);
        }

    }
}