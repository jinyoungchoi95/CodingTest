import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] num = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            num[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(num);
        int start = 0;
        int end = N-1;

        long sum;
        long min = Long.MAX_VALUE;
        int min_i = start;
        int max_i = end;
        while(start<end){
            sum = num[start] + num[end];

            if(Math.abs(sum) < Math.abs(min)){
                min = sum;
                min_i = start;
                max_i = end;
            }

            if(sum<0){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.printf("%d %d", num[min_i], num[max_i]);

    }
}
