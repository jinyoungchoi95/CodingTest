import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2230 {
    public static int N, M;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int start = 0;
        int end = 1;
        while(end < N) {
            int sub = A[end] - A[start];
            if(sub < M) {
                end++;
                continue;
            }

            if(sub == M) {
                answer = M;
                break;
            }
            answer = Math.min(answer, sub);
            start++;
        }
        System.out.println(answer);
    }
}
