import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1300 {
    public static int N, k;
    public static int[][] A;
    public static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int min = 1;
        int max = k;
        int answer = 0;
        while(min<=max){
            int mid = (max+min)/2;
            int count = 0;
            for(int i=1; i<=N; i++){
                count += Math.min(mid/i, N);
            }
            if(count>=k){
                answer = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
