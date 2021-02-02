import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class boj16722 {
    public static info[] map = new info[10];
    public static HashSet<String> hashset = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<=9; i++){
            String[] input = br.readLine().split(" ");
            map[i] = new info(input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
        }
        find_all();
        int answer = 0;
        int T = Integer.parseInt(br.readLine());
        boolean get = true;
        for(int t=0; t<T; t++){
            String input = br.readLine();
            if(input.charAt(0)=='H'){
                char[] array = {input.charAt(2), input.charAt(4), input.charAt(6)};
                Arrays.sort(array);
                String call = array[0] + " " + array[1] + " " + array[2];
                if(hashset.contains(call)){
                    answer++;
                    hashset.remove(call);
                }
                else{
                    answer--;
                }
            }
            else{
                if(hashset.isEmpty() && get){
                    answer += 3;
                    get = false;
                }
                else{
                    answer--;
                }
            }
        }
        System.out.println(answer);
    }
    public static void find_all(){
        for(int i=1; i<=7; i++){
            for(int j=i+1; j<=8; j++){
                for(int k=j+1; k<=9; k++){
                    if(check(i,j,k)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(i + " " + j + " " + k);
                        hashset.add(sb.toString());
                    }
                }
            }
        }
    }
    public static boolean check(int i, int j, int k){
        char a = map[i].x;
        char b = map[j].x;
        char c = map[k].x;
        if((a==b && b!=c) || (a==c && c!=b) || (b==c && c!=a)) return false;

        a = map[i].y;
        b = map[j].y;
        c = map[k].y;
        if((a==b && b!=c) || (a==c && c!=b) || (b==c && c!=a)) return false;

        a = map[i].z;
        b = map[j].z;
        c = map[k].z;
        if((a==b && b!=c) || (a==c && c!=b) || (b==c && c!=a)) return false;

        return true;
    }

    public static class info{
        char x;
        char y;
        char z;
        public info(char x, char y, char z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
