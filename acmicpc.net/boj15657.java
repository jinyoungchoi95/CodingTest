import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj15657 {
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

        dfs(list, 0);
        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Integer> list, int index){
        if(list.size() == M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=index; i<N; i++){
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.add(array[i]);
            dfs(tmp, i);
        }
    }
}
