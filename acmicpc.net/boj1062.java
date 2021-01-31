import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1062 {
    public static int N,K;
    public static int answer = 0;
    public static int[] map;
    public static ArrayList<Integer> default_val = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        map = new int[N];
        for(int i=0; i<N; i++){
            String word = br.readLine();
            map[i] = add_map(word);
        }
        if(K<5){
            System.out.println(0);
            return;
        }
        else if(K==26){
            System.out.println(N);
            return;
        }
        K-=5;
        int saved = make_save();
        dfs(0, saved,1);
        System.out.println(answer);

    }
    public static int add_map(String input){
        input = input.substring(4, input.length()-4);
        int result = 0;
        for(int i=0; i<input.length(); i++){
            result = result | (1<<(input.charAt(i)-'a'));
        }
        return result;
    }
    public static void dfs(int count, int save, int start){
        if(count==K){
            int value = 0;
            for(int i=0; i<N; i++){
                if(map[i] == (map[i] & save)){
                    value++;
                }
            }
            answer = Math.max(answer, value);
            return;
        }

        for(int i=start; i<26; i++){
            if(default_val.contains(i)) continue;
            dfs(count+1, save | 1<<i, i+1);
        }
    }
    public static int make_save(){
        int result = 0;

        default_val.add(0);
        default_val.add(2);
        default_val.add(8);
        default_val.add(13);
        default_val.add(19);
        for(int i=0; i<default_val.size(); i++){
            result = result | 1<<default_val.get(i);
        }
        return result;
    }




}
