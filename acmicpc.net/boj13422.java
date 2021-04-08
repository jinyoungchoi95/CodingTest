import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj13422 {
    public static int N, M, K;
    public static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++){
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            house = new int[N];
            input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                house[i] = Integer.parseInt(input[i]);
            }
            int start = 0;
            int end = M - 1;
            int sum = 0;
            for(int i=0; i<=end; i++){
                sum += house[i];
            }

            int answer = 0;
            while(start < N) {
                if(sum<K) answer++;

                sum -= house[start++];
                end++;
                if(N == M && end ==N) break;
                end %= N;
                sum += house[end];
            }
            System.out.println(answer);
        }
    }
}
