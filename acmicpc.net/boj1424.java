import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1424 {
    public static int N, L, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int answer = 0;
        int max = ((C-L)/(L+1)) + 1;
        if(max % 13 == 0) max--;
        answer = N / max;
        int remain = N % max;
        if(remain == 0){
            System.out.println(answer);
            return;
        }
        else if(remain % 13 != 0){
            System.out.println(answer+1);
        }
        else{
            int time = L + (L+1)*remain;
            if(max%13==1){
                time += (L+1)*2;
                if(time<=C) System.out.println(answer+1);
                else System.out.println(answer+2);
            }
            else{
                time += (L+1);
                if(time<=C) System.out.println(answer+1);
                else System.out.println(answer+2);
            }
        }
    }
}
