import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class boj10423 {
    public static int N, M, K;
    public static int[] map;
    public static ArrayList<index> link = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new int[N+1];
        for(int i=1; i<=N; i++){
            map[i] = i;
        }
        input = br.readLine().split(" ");
        for(int i=0; i<K; i++){
            map[Integer.parseInt(input[i])] = -1;
        }
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);
            link.add(new index(a,b,v));
        }
        Collections.sort(link, new Comparator<index>() {
            @Override
            public int compare(index o1, index o2) {
                return o1.value - o2.value;
            }
        });
        int answer = 0;
        for(int i=0; i<link.size(); i++){
            index tmp = link.get(i);

            if(find_parent(tmp.x) != find_parent(tmp.y)){
                answer += tmp.value;
                union(tmp.x, tmp.y);

                if(check_all()) break;
            }
        }
        System.out.println(answer);

    }
    public static void union(int x, int y){
        x = map[x];
        y = map[y];
        if(x!=y){
            if(x==-1){
                map[y] = x;
            }
            else if(y==-1){
                map[x] = y;
            }
            else{
                map[y] = x;
            }
        }
    }
    public static boolean check_all(){
        for(int i=0; i<=N; i++){
            if(map[i]!=-1) return false;
        }
        return true;
    }
    public static int find_parent(int index){
        if(map[index]==-1) return -1;
        if(map[index]==index) return index;

        return map[index] = find_parent(map[index]);
    }
    public static class index{
        int x;
        int y;
        int value;;
        public index(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

}
