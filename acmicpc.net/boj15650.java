import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj15650 {
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, visited, 0);
    }
    public static void dfs(ArrayList<Integer> list, boolean[] visited, int start){
        if(list.size() == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(i+1);
                dfs(tmp, visited, i+1);
                visited[i] = false;
            }
        }
    }
}
