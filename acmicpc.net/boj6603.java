import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj6603 {
    public static int n;
    public static int[] map;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        while(!input[0].equals("0")){
            n = Integer.parseInt(input[0]);
            map = new int[n];
            for(int i=0; i<n; i++){
                map[i] = Integer.parseInt(input[i+1]);
            }
            ArrayList<Integer> list = new ArrayList<>();
            dfs(0,list);
            sb.append("\n");
            input = br.readLine().split(" ");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int start, ArrayList<Integer> list){
        if(list.size()==6){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++){
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.add(map[i]);
            dfs(i+1, tmp);
        }
    }
}
