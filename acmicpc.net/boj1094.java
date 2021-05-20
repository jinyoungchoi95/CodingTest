import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result=0;
        int len = 64;
        int cnt=0;
        int end = num;
        while(true) {
            if(num==64) {
                cnt++;
                break;
            }
            len = len/2;

            if(num>=len) {
                result += len;
                cnt++;
                if(end==result)
                {
                    break;
                }
                num = num - len;
            }
        }
        System.out.println(cnt);
    }
}
