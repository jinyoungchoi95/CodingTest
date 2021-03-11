import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj14888 {
    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] map;
    public static int[] cal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cal = new int[4];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i=0; i<4; i++){
            cal[i] = Integer.parseInt(input[i]);
        }
        dfs(1, map[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int index, int count){
        if(index==N){
            max = Math.max(max, count);
            min = Math.min(min, count);
            return;
        }

        if(cal[0]!=0){
            cal[0]--;
            dfs(index+1, count+map[index]);
            cal[0]++;
        }
        if(cal[1]!=0){
            cal[1]--;
            dfs(index+1, count-map[index]);
            cal[1]++;
        }
        if(cal[2]!=0){
            cal[2]--;
            dfs(index+1, count*map[index]);
            cal[2]++;
        }
        if(cal[3]!=0){
            cal[3]--;
            dfs(index+1, count/map[index]);
            cal[3]++;
        }
    }

}
