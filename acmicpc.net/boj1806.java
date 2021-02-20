import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int[] num = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        long len = N+1;

        while(true){
            if(sum>=S){
                sum -= num[start++];
                len = Math.min(len, end-start+1);
            }
            else if(end>=N){
                break;
            }
            else if(sum<S){
                sum += num[end++];
            }
        }
        if(len==N+1) System.out.println(0);
        else System.out.println(len);
    }
}