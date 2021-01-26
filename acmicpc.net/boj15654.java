import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj15654 {
    public static int N, M;
    public static int[] array;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        array = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(input[i]);
        }
        boolean[] visited = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        dfs(list, visited);

        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Integer> list, boolean[] visited){
        if(list.size()==M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(array[i]);
                dfs(tmp, visited);
                visited[i] = false;
            }
        }
    }
}
