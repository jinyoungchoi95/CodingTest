import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj15664 {
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
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[N];

        dfs(list, visited, -1);
        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Integer> list, boolean[] visited, int index){
        if(list.size() == M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for(int i=index+1; i<N; i++){
            if(i>0 && array[i] == before) continue;
            if(!visited[i]){
                before = array[i];
                visited[i] = true;
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(array[i]);
                dfs(tmp, visited, i);
                visited[i] = false;
            }
        }
    }
}
