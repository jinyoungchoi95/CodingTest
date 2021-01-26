import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj15652 {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, 1);
        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Integer> list, int start){
        if(list.size()==M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.add(i);
            dfs(tmp, i);
        }
    }
}
