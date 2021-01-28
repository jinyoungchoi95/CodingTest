import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class boj1525 {
    public static HashMap<Integer, Integer> hashmap = new HashMap<>();
    public static int answer = -1;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int start = 0;
        for(int i=0; i<3; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                n = Integer.parseInt(input[j]);
                if(n==0) n = 9;
                start = (start*10) + n;
            }
        }
        hashmap.put(start, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int answer = -1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();

            if(hashmap.containsKey(123456789)){
                answer = hashmap.get(123456789);
                break;
            }

            String t = String.valueOf(tmp);
            int zero_index = t.indexOf("9");
            int x = zero_index/3;
            int y = zero_index%3;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=3 || ny>=3){
                    continue;
                }

                StringBuilder sb = new StringBuilder(t);
                int want_index = nx*3 + ny;
                sb.setCharAt(zero_index, sb.charAt(want_index));
                sb.setCharAt(want_index, '9');
                int num = Integer.parseInt(sb.toString());
                if(!hashmap.containsKey(num)){
                    hashmap.put(num, hashmap.get(tmp)+1);
                    queue.add(num);
                }
            }
        }
        System.out.println(answer);

    }

}
