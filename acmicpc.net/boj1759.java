import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj1759 {
    public static int L, C;
    public static char[] map;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[C];
        input = br.readLine().split(" ");
        for(int i=0; i<C; i++){
            map[i] = input[i].charAt(0);
        }
        Arrays.sort(map);
        ArrayList<Character> list = new ArrayList<>();
        dfs(list, 0, 0, 0);
        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Character> list, int index, int vow, int con){
        if(list.size()==L){
            if(vow<1 || con<2) return;
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
            }
            sb.append("\n");
            return;
        }

        for(int i=index; i<C; i++){
            ArrayList<Character> tmp = new ArrayList<>(list);
            tmp.add(map[i]);
            if(check(map[i])) dfs(tmp, i+1, vow+1, con);
            else dfs(tmp, i+1, vow, con+1);
        }
    }
    public static boolean check(char c){
        if(c == 'a' || c== 'e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}