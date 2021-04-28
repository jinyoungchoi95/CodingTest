import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj12015 {
    public static int N;
    public static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> dp = new ArrayList<>(N);
        dp.add(0);

        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            if(dp.get(dp.size()-1) < now) {
                dp.add(now);
            }
            else {
                int min = 0;
                int max = dp.size()-1;
                while(min < max) {
                    int mid = (min + max) / 2;

                    int next = dp.get(mid);
                    if(now <= next) {
                        max = mid;
                    }
                    else{
                        min = mid+1;
                    }
                }
                dp.set(max, now);
            }
        }

        System.out.println(dp.size() - 1);
    }
}
