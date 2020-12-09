import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2467 {
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
        long min = Long.MAX_VALUE;
        int a = start;
        int b = end;
        while(start<end){
            long sum = num[start] + num[end];
            if(Math.abs(sum) < Math.abs(min)){
                min = sum;
                a = start;
                b = end;
            }

            if(sum<0){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.printf("%d %d", num[a], num[b]);
    }
}
