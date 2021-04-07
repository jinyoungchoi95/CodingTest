import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1253 {
    public static int N;
    public static long[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(A);

        int answer = 0;
        for(int i=0; i<N; i++){
            if(findIndex(i)) answer++;
        }
        System.out.println(answer);
    }
    public static boolean findIndex(int index){
        int min = 0;
        int max = N-1;
        while(min < max){
            if(min == index){
                min++;
                continue;
            }
            if(max == index){
                max--;
                continue;
            }

            long result = A[min] + A[max];
            if(result == A[index]) return true;

            if(result < A[index]){
                min++;
            }
            else{
                max--;
            }
        }
        return false;
    }
}
