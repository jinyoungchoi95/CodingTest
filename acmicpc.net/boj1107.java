import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1107 {
    public static int N, M;
    public static boolean[] broken = new boolean[10];
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            broken[Integer.parseInt(input[i])] = true;
        }

        answer = Math.abs(N - 100);
        for(int i=0; i<=1000000; i++){
            String num = String.valueOf(i);
            int len = num.length();

            boolean check = false;
            for(int j=0; j<len; j++){
                if(broken[num.charAt(j) - '0']){
                    check = true;
                    break;
                }
            }
            if(!check){
                int min = Math.abs(N-i)+len;
                answer = Math.min(min, answer);
            }
        }
        System.out.println(answer);

    }
}
