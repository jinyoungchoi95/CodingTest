import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int[] top = new int[H+1];
        int[] bot = new int[H+1];
        for(int i=0; i<N/2; i++){
            bot[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }
        int[] top_sum = new int[H+1];
        int[] bot_sum = new int[H+1];
        for(int i=1; i<=H; i++){
            top_sum[i] = top_sum[i-1] + top[i];
            bot_sum[i] = bot_sum[i-1] + bot[i];
        }
        int min = N;
        int count = 0;

        for(int i=1; i<=H; i++){
            int tmp = 0;
            tmp += bot_sum[H] - bot_sum[i-1];
            tmp += top_sum[H] - top_sum[H-i];

            if(tmp<min){
                min = tmp;
                count = 1;
            }
            else if(tmp==min){
                count++;
            }
        }
        System.out.printf("%d %d", min, count);

    }
}