import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1976 {
    public static int N, M;
    public static ArrayList<Integer>[] link;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        link = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            link[i] = new ArrayList<>();
        }
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                int b = Integer.parseInt(input[j-1]);
                if(b==1) union(i, j);
            }
        }
        String[] input  = br.readLine().split(" ");
        int start = parent[Integer.parseInt(input[0])];
        for(int i=1; i<input.length; i++){
            if(start != parent[Integer.parseInt(input[i])]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a>b){
            parent[a] = b;
        }
        else{
            parent[b] = a;
        }
    }
    public static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}
