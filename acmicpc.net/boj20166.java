import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj20166 {
    public static int N, M, K;
    public static char[][] array;
    public static int count;
    public static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static HashMap<String, Integer> save;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        array = new char[N][M];
        save = new HashMap<>();
        for(int i=0; i<N; i++){
            String input2 = br.readLine();
            for(int j=0; j<M; j++){
                array[i][j] = input2.charAt(j);
            }
        }

        for(int case_count=0; case_count<K; case_count++){
            String wanted = br.readLine();
            count = 0;
            if(save.containsKey(wanted)){
                System.out.println(save.get(wanted));
                continue;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    dfs(wanted, i, j, 0);
                }
            }
            System.out.println(count);
            save.put(wanted, count);
        }
    }
    public static void dfs(String wanted, int x, int y, int want_val){
        char c = wanted.charAt(want_val);
        if(x<0){
            x+=N;
        }
        else if(x>=N){
            x-=N;
        }

        if(y<0){
            y+=M;
        }
        else if(y>=M){
            y-=M;
        }
        if(c == array[x][y]){
            if(want_val == wanted.length()-1){
                count++;
                return;
            }
            for(int i=0; i<dx.length; i++){
                if(want_val+1 >= wanted.length()){
                    return;
                }
                dfs(wanted, x+dx[i], y+dy[i], want_val+1);
            }
        }
        return;
    }
}