import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14921 {
    public static int N, answer;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = N-1;
        answer = A[end] + A[start];
        while(start < end){
            int sum = A[start] + A[end];
            if(sum == 0){
                answer = 0;
                break;
            }

            if(Math.abs(sum) < Math.abs(answer)){
                answer = sum;
            }

            if(sum < 0) start++;
            else end--;
        }
        System.out.println(answer);
    }
}
